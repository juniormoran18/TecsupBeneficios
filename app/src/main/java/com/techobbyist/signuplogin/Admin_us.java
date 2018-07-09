package com.techobbyist.signuplogin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

/**
 * Created by Junior on 4/12/16.
 */

public class Admin_us extends ActionBarActivity {

    //private Button btnAgregar;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_users);



        //btnAgregar = (Button)findViewById(R.id.btn_add);

        DbHelper dbHandler;

        dbHandler = new DbHelper(this, null, null, 1);

        SQLiteDatabase db = dbHandler.getWritableDatabase();
        Cursor cursor = dbHandler.listarpersonas();

        ListView lvlitems = (ListView) findViewById(R.id.lvitems);
        lvlitems.setTextFilterEnabled(true);

        final TodoCursorAdapter todoAdapter = new TodoCursorAdapter(this, cursor);
        lvlitems.setAdapter(todoAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add:
                //metodoAdd()
                Intent actRegister = new Intent(this,RegisterActivity.class);
                startActivity(actRegister);
                finish();
                return true;
            case R.id.search:
                //metodoSearch()
                return true;
            case R.id.edit:
                //metodoEdit()
                Intent actModificar = new Intent(this,PreModificar.class);
                startActivity(actModificar);
                finish();
                return true;
            case R.id.delete:
                //metodoDelete()
                Intent actEliminar = new Intent(this,EliminarActivity.class);
                startActivity(actEliminar);
                finish();
                return true;
            case R.id.action_settings:
                //metodoSettings()
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    /*public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_add:
                add();
                break;
            default:

        }
    }
*/

    private void add(){
        startActivity(new Intent(Admin_us.this, RegisterActivity.class));
        finish();

    }




    }

