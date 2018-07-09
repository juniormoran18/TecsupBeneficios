package com.techobbyist.signuplogin;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Junior on 4/12/16.
 */

public class TodoCursorAdapter extends CursorAdapter{

    public TodoCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_users, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView idtxt = (TextView) view.findViewById(R.id.id_txt);
        TextView emailtxt=(TextView) view.findViewById(R.id.email_txt);
        TextView passwordtxt=(TextView) view.findViewById(R.id.password_txt);
        TextView nombretxt = (TextView) view.findViewById(R.id.nombre_txt);
        TextView apellidotxt = (TextView) view.findViewById(R.id.apellido_txt);
        TextView ocupaciontxt = (TextView) view.findViewById(R.id.ocupacion_txt);


        // Extraccion de las propiedades del cursor


        int txtid = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String txtemail=cursor.getString(cursor.getColumnIndexOrThrow("email"));
        String txtpassword=cursor.getString(cursor.getColumnIndexOrThrow("password"));
        String txtnombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
        String txtapellido = cursor.getString(cursor.getColumnIndexOrThrow("apellido"));
        String txtocupacion=cursor.getString(cursor.getColumnIndexOrThrow("ocupacion"));


        idtxt.setText(String.valueOf(txtid));
        emailtxt.setText(String.valueOf(txtemail));
        passwordtxt.setText(String.valueOf(txtpassword));
        nombretxt.setText(txtnombre);
        apellidotxt.setText(txtapellido);
        ocupaciontxt.setText(txtocupacion);


    }

}
