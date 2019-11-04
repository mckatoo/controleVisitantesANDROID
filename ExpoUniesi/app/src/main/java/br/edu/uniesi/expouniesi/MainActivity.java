package br.edu.uniesi.expouniesi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniesi.expouniesi.adapters.VisitantesAdapter;
import br.edu.uniesi.expouniesi.listViews.ListViewVisitantes;
import br.edu.uniesi.expouniesi.model.Visitantes;

public class MainActivity extends AppCompatActivity {
    private List<ListViewVisitantes> listaDeVisitantes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewVisitantes = findViewById(R.id.listViewVisitantes);
        VisitantesAdapter adapter = new VisitantesAdapter(this, getArrayListVisitantes());
        listViewVisitantes.setAdapter(adapter);

        final List<String> cursos = getArrayCursos();
        Spinner spinnerCursos = findViewById(R.id.spinnerCursos);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cursos);
        spinnerCursos.setAdapter(dataAdapter);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Selected : ", cursos.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        FloatingActionButton botao = findViewById(R.id.btnCadastrar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("[MainActivity] => ", "Cadastrando visitante...");
            }
        });
    }

    private ArrayList<ListViewVisitantes> getArrayListVisitantes() {
        final ArrayList<ListViewVisitantes> arrayList = new ArrayList<>();
        String url = "http://campus1-iesi.ddns.net:9003/visitantes";

        Ion.with(MainActivity.this)
                .load(url)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        JsonArray visitantes = result.getAsJsonArray("visitantes");

                        try {
                            for (int i = 0; i < visitantes.size(); i++) {
                                JsonObject visitante = visitantes.get(i).getAsJsonObject();
                                Visitantes v = new Visitantes();
                                arrayList.add(
                                        new ListViewVisitantes(
                                                visitante.get("nome").getAsString(),
                                                visitante.get("email").getAsString(),
                                                visitante.get("whatsapp").getAsString()
                                        ));
                            }
                        } catch (Exception ex) {
                            Toast.makeText(MainActivity.this, "Ops! Erro ao listar Visitantes.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return arrayList;
    }

    private List<String> getArrayCursos() {
        final List<String> cursos = new ArrayList<String>();
        String url = "http://campus1-iesi.ddns.net:9003/cursos";

        Ion.with(MainActivity.this)
                .load(url)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        JsonArray jsonArray = result.getAsJsonArray("cursos");
                        try {
                            for (int i = 0; i < jsonArray.size(); i++) {
                                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                                cursos.add(jsonObject.get("curso").toString());
                            }
                        } catch (Exception ex) {
                            Toast.makeText(MainActivity.this, "Ops! Erro ao listar Cursos.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return cursos;
    }
}
