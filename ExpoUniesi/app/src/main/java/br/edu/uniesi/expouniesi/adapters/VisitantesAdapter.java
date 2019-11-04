package br.edu.uniesi.expouniesi.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import br.edu.uniesi.expouniesi.R;
import br.edu.uniesi.expouniesi.listViews.ListViewVisitantes;

public class VisitantesAdapter extends ArrayAdapter<ListViewVisitantes> {
    private Activity activity;
    private ArrayList<ListViewVisitantes> arrayList;

    public VisitantesAdapter(Activity activity, ArrayList<ListViewVisitantes> arrayList) {
        super(activity, R.layout.listview_visitantes, arrayList);
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_visitantes, parent, false);
        }

        TextView txtNome = convertView.findViewById(R.id.txtNome);
        TextView txtEmail = convertView.findViewById(R.id.txtEmail);
        TextView txtWhatsApp = convertView.findViewById(R.id.txtWhatsApp);

        txtNome.setText(arrayList.get(position).getNome());
        txtEmail.setText(arrayList.get(position).getEmail());
        txtWhatsApp.setText(arrayList.get(position).getWhatsapp());

        return convertView;
    }
}
