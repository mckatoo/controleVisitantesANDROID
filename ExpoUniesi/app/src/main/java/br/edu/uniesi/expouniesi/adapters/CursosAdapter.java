package br.edu.uniesi.expouniesi.adapters;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import br.edu.uniesi.expouniesi.R;
import br.edu.uniesi.expouniesi.listViews.ListViewCursos;

public class CursosAdapter extends ArrayAdapter<ListViewCursos> {
    private Activity activity;
    private ArrayList<ListViewCursos> arrayList;

    public CursosAdapter(Activity activity, ArrayList<ListViewCursos> arrayList) {
        super(activity, R.layout.support_simple_spinner_dropdown_item, arrayList);
        this.activity = activity;
        this.arrayList = arrayList;
    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        if (convertView == null){
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_visitantes, parent, false);
//        }
//
//        TextView txtNome = convertView.findViewById(R.id.txtNome);
//        TextView txtEmail = convertView.findViewById(R.id.txtEmail);
//        TextView txtWhatsApp = convertView.findViewById(R.id.txtWhatsApp);
//
//        txtNome.setText(arrayList.get(position).getNome());
//        txtEmail.setText(arrayList.get(position).getEmail());
//        txtWhatsApp.setText(arrayList.get(position).getWhatsapp());
//
//        return convertView;
//    }
}
