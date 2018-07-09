package com.techobbyist.signuplogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * Created by Junior on 30/11/16.
 */
public class MainActivity2 extends AppCompatActivity {

    private Button btnLogout2;
    //private Session session1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        /*session1 = new Session(this);
        if(!session1.loggedin()){
            logout1();
        }*/
        btnLogout2 = (Button)findViewById(R.id.btnLogout2);
        btnLogout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout2();
            }
        });
    }

    private void logout2(){
        //session1.setLoggedin(false);

        startActivity(new Intent(MainActivity2.this,ArrayComplejo2.class));
        finish();

    }
}





