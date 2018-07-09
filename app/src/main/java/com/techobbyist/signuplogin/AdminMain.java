package com.techobbyist.signuplogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Junior on 4/12/16.
 */

public class AdminMain  extends ActionBarActivity {
    private Button btn_us;
    private Button btn_ben;
    private Button btn_sal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        btn_us = (Button)findViewById(R.id.btn_us);
        btn_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ver_us();
            }
        });

        btn_ben = (Button)findViewById(R.id.btn_ben);
        btn_ben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ver_ben();
            }
        });


        btn_sal=(Button)findViewById(R.id.btn_sal);
        btn_sal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actLogin= new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(actLogin);
            }
        });

    }

    public void ver_ben(){

        startActivity(new Intent(AdminMain.this,Admin_ben.class));
    }


    public void ver_us(){

        startActivity(new Intent(this, Admin_us.class));

        //startActivity(new Intent(AdminMain.this,Admin_us.class));
        //finish();

    }


}
