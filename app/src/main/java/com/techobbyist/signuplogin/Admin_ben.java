package com.techobbyist.signuplogin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by Junior on 4/12/16.
 */

public class Admin_ben extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_ben);


        DbHelper dbHandler;

        dbHandler = new DbHelper(this, null, null, 1);

        SQLiteDatabase db = dbHandler.getWritableDatabase();

        Cursor cursor1 = dbHandler.listarbeneficios();

        ListView lvlitems1 = (ListView) findViewById(R.id.lvitems1);
        lvlitems1.setTextFilterEnabled(true);

        final TodoCursorAdapter1 todoAdapter1 = new TodoCursorAdapter1(this, cursor1);
        lvlitems1.setAdapter(todoAdapter1);

    }

    private void add(){
        startActivity(new Intent(Admin_ben.this, RegisterActivity.class));
        finish();

    }
}
