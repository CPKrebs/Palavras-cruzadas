package com.example.palavrascruzadas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private java.util.ArrayList<BD_Class_AUX> ArrayList;

    public CustomAdapter(Context context, ArrayList<BD_Class_AUX> ArrayList) {

        this.context = context;
        this.ArrayList = ArrayList;
    }


    @Override
    public int getCount() {
        return ArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return ArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ArrayList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {
            holder = new Holder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lista, null, true);

            holder.Id = (TextView) convertView.findViewById(R.id.txt1);
            holder.Login = (TextView) convertView.findViewById(R.id.txt2);
            holder.Email = (TextView) convertView.findViewById(R.id.txt3);
            holder.Ponto = (TextView) convertView.findViewById(R.id.txt4);


            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (Holder)convertView.getTag();
        }

        holder.Id.setText("Identificador: "+ArrayList.get(position).getUID());
        holder.Login.setText("Login: "+ArrayList.get(position).getLOGIN());
        holder.Email.setText("Email: "+ArrayList.get(position).getEMAIL());
        holder.Ponto.setText("Pontos: "+ArrayList.get(position).getPONTO());

        return convertView;

    }

    public class Holder {

        TextView Id, Login, Email, Ponto;
    }
}
