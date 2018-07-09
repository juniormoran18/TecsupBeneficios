package com.techobbyist.signuplogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button reg;
    private TextView tvLogin;
    private EditText etEmail, etPass,etNombre, etApellido;
    private Spinner etOcup;
    private DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DbHelper(this);
        reg = (Button)findViewById(R.id.btnReg);
        tvLogin = (TextView)findViewById(R.id.tvLogin);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);
        etNombre = (EditText)findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etOcup = (Spinner) findViewById(R.id.etOcup);
        reg.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

        String[] ocup = new String[]{"Ocupacion","alumno","profesor","administrativo"};

        ArrayAdapter<String> dataOcup=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ocup);
        etOcup.setAdapter(dataOcup);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnReg:
                register();
                break;
            case R.id.tvLogin:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
                break;
            default:

        }
    }

    private void register(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
        String nom = etNombre.getText().toString();
        String ape = etApellido.getText().toString();
        String ocup = etOcup.getSelectedItem().toString();
        if(email.isEmpty() && pass.isEmpty()){
            displayToast("Username/password field empty");
        }else{
            db.addUser(email,pass,nom,ape,ocup);
            displayToast("Usuario registrado");
            finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
