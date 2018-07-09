package com.techobbyist.signuplogin;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ModificarActivity extends AppCompatActivity {
    DbHelper dbHandler;
    EditText etEmail, etPass, etNombre, etApellido;
    Spinner etOcup;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etOcup = (Spinner) findViewById(R.id.etOcup);
        dbHandler = new DbHelper(this, null, null, 1);

        String[] ocup = new String[]{"Ocupacion", "alumno", "profesor", "administrativo"};

        ArrayAdapter<String> dataOcup = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ocup);
        etOcup.setAdapter(dataOcup);

        Intent i = getIntent(); // gets the previously created intent
        String stringid = i.getStringExtra("id_persona");
        id = Integer.parseInt(stringid);
        Cursor c = dbHandler.personabyid(id);

        etEmail.setText(c.getString(c.getColumnIndexOrThrow("email")));
        etPass.setText(c.getString(c.getColumnIndexOrThrow("password")));
        etNombre.setText(c.getString(c.getColumnIndexOrThrow("nombre")));
        etApellido.setText(c.getString(c.getColumnIndexOrThrow("apellido")));
        final String ocupacion = (c.getString(c.getColumnIndexOrThrow("ocupacion")));

        etOcup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                etOcup.getSelectedItem().equals(ocupacion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void modificar_clicked(View view) {

        String email=etEmail.getText().toString();
        String pass=etPass.getText().toString();
        String nom=etNombre.getText().toString();
        String ap=etApellido.getText().toString();
        String ocup=etOcup.getSelectedItem().toString();
        dbHandler.updatepersona(id,email,pass,nom,ap,ocup);
        confirmacion();
        limpiarcampos();
        Intent actUsers = new Intent(this,Admin_us.class);
        startActivity(actUsers);
        finish(); //Termina la actividad y vuelve al menu principal

    }

    public void confirmacion() {

        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Se ha modificado exitosamente!");
        dlgAlert.setTitle("Agregar Persona");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    //Limpia los valores entrados para efectos de estetica
    public void limpiarcampos() {

        etEmail.setText("");
        etPass.setText("");
        etNombre.setText("");
        etApellido.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
