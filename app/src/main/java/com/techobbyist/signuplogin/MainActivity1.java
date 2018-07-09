package com.techobbyist.signuplogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Junior on 30/11/16.
 */
public class MainActivity1  extends AppCompatActivity {

    private Button btnLogout1;
    //private Session session1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


        /*session1 = new Session(this);
        if(!session1.loggedin()){
            logout1();
        }*/
        btnLogout1 = (Button)findViewById(R.id.btnLogout1);
        btnLogout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout1();
            }
        });
    }

    private void logout1(){
        //session1.setLoggedin(false);

        startActivity(new Intent(MainActivity1.this,ArrayComplejo1.class));
        finish();

    }
}
