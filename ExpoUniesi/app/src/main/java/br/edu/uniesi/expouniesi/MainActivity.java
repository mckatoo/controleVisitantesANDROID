package br.edu.uniesi.expouniesi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {

    protected void buscarVisitantes() {
        Log.i("[MainActivity] => ", "Carregando todos visitantes...");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewVisitantes = findViewById(R.id.listViewVisitantes);

        FloatingActionButton botao = findViewById(R.id.btnCadastrar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("[MainActivity] => ", "Cadastrando visitante...");
            }
        });
    }

    private void listarVisitantes() {
        String url = "http://localhost:8000/visitantes";

        Ion.with(MainActivity.this)
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        try {
                            for (int i = 0; i < result.size(); i++){
                                JsonObject visitante = result.get(0).getAsJsonObject();
                                Log.d("Visitante", visitante.get("nome").getAsString());
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
    }
}
