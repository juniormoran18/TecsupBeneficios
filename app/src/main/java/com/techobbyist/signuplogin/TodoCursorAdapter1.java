package com.techobbyist.signuplogin;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Junior on 5/12/16.
 */

public class TodoCursorAdapter1 extends CursorAdapter {


    public TodoCursorAdapter1(Context context, Cursor cursor) {

        super(context,cursor, 1);

       // super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_ben, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView id1txt = (TextView) view.findViewById(R.id.id1_txt);
        TextView nombre1txt=(TextView) view.findViewById(R.id.nombre1_txt);

        TextView descripciontxt=(TextView) view.findViewById(R.id.descripcion_txt);

        TextView ocupacion1txt = (TextView) view.findViewById(R.id.ocupacion1_txt);


        // Extraccion de las propiedades del cursor


        int txtid1    = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        String txtnombre1=cursor.getString(cursor.getColumnIndexOrThrow("nombre"));

        String txtdescripcion=cursor.getString(cursor.getColumnIndexOrThrow("descripcion"));


        String txtocupacion1=cursor.getString(cursor.getColumnIndexOrThrow("ocupacion"));


        id1txt.setText(String.valueOf(txtid1));

        nombre1txt.setText(String.valueOf(txtnombre1));
        descripciontxt.setText(String.valueOf(txtdescripcion));
        ocupacion1txt.setText(txtocupacion1);


    }

}



