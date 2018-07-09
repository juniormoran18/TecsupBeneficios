package com.techobbyist.signuplogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;


public class EliminarActivity extends ActionBarActivity {

    DbHelper dbHandler;
    EditText elimina_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        elimina_input = (EditText) findViewById(R.id.modificar_input);
        dbHandler = new DbHelper(this, null, null, 1);
    }

    public void eliminar_clicked(View view){

        dbHandler.borrarPersona(Integer.parseInt(elimina_input.getText().toString()));
        confirmacion();
        Intent actUsers=new Intent(this,Admin_us.class);
        startActivity(actUsers);
        finish();
    }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setTitle("Se ha eliminado satisfactoriamente!!!");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}
