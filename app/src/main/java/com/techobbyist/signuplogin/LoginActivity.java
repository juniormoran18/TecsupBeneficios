package com.techobbyist.signuplogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button login, register,salir;
    private EditText etEmail, etPass;
    private DbHelper db;
    private Session session, session1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DbHelper(this);
       // session = new Session(this);
       // session1= new Session(this);

        login = (Button)findViewById(R.id.btnLogin);
        register = (Button)findViewById(R.id.btnReg);
        salir= (Button)findViewById(R.id.btnSalir3);

        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
        salir.setOnClickListener(this);

      /*  if(session.loggedin()){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
        */


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogin:
                login();
                break;

            case R.id.btnReg:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;

            case R.id.btnSalir3:

                System.exit(0);
                Toast.makeText(this, "Saliendo",Toast.LENGTH_SHORT).show();
            default:

        }
    }

    private void login(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
        String ti1="alumno";
        String ti2="profesor";
        String ti3="administrativo";


        if(db.getUser(email,pass)){

           // session.setLoggedin(true);

            Toast.makeText(this, "Tipo:"+db.getTipo(email),Toast.LENGTH_SHORT).show();


            if(db.getTipo(email).equals(ti1)){
               // session.setLoggedin(true);

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();

            }else if(db.getTipo(email).equals(ti2)){

               //session1.setLoggedin(true);

                startActivity(new Intent(LoginActivity.this, MainActivity1.class));
               finish();


            }else if(db.getTipo(email).equals(ti3)){

                //session.setLoggedin(true);

                startActivity(new Intent(LoginActivity.this,MainActivity2.class));
                finish();

            }else if(db.getAD(email).equals("administrador")){

                //session.setLoggedin(true);

                startActivity(new Intent(LoginActivity.this,AdminMain.class));
                finish();

            }


        }else{
            Toast.makeText(getApplicationContext(), "Incorrecto email/password",Toast.LENGTH_SHORT).show();
        }
    }


}
