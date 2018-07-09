package com.techobbyist.signuplogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Administrator on 5/5/2016.
 */
public class DbHelper extends SQLiteOpenHelper {
    public static final String TAG = DbHelper.class.getSimpleName();
    public static final String DB_NAME = "myapp.db";
    public static final int DB_VERSION = 1;

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "password";
    public static final String COLUMN_NOM = "nombre";
    public static final String COLUMN_APE = "apellido";
    public static final String COLUMN_OCU = "ocupacion";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PASS + " TEXT, "
            + COLUMN_NOM + " TEXT, "
            + COLUMN_APE + " TEXT, "
            + COLUMN_OCU + " TEXT);";


    /*
    create table users(
        id integer primary key autoincrement,
        email text,
        password text);
     */

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }




    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_BEN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS" + BEN_TABLE);
        onCreate(db);

    }

    /**
     * Storing user details in database
     * */
    public void addUser(String email, String password,String nombre, String apellido,String ocupacion) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASS, password);
        values.put(COLUMN_NOM, nombre);
        values.put(COLUMN_APE, apellido);
        values.put(COLUMN_OCU, ocupacion);


        long id = db.insert(USER_TABLE, null, values);
        db.close();

        Log.d(TAG, "usuario insertado" + id);
    }

    public boolean getUser(String email, String pass){
        //HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "select * from  " + USER_TABLE + " where " +
                COLUMN_EMAIL + " = " + "'"+email+"'" + " and " + COLUMN_PASS + " = " + "'"+pass+"'";


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        db.close();

        return false;
    }

    public String getTipo(String email){



        String selectQuery=" select " + " " + COLUMN_OCU +" "+ " from " + " " + USER_TABLE + " " +" where " +" "+
                COLUMN_EMAIL+ " = "+"'" + email+"'";
        /* "'" */

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c=db.rawQuery(selectQuery,null);

        c.moveToFirst();

        String columna= c.getString(0);


        return columna;

    }

    public String getAD(String email){

        String selectQuery=" select " + " " + COLUMN_OCU +" "+ " from " + " " + USER_TABLE + " " +" where " +" "+
                COLUMN_EMAIL+ " = "+"'" +email+"'";
        /* "'" */

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c=db.rawQuery(selectQuery,null);

        c.moveToFirst();

        String columna= c.getString(0);


        return columna;

    }


    //Muestra datos de la tabla para la entidad administrador

    public Cursor listarpersonas(){
        SQLiteDatabase db = getReadableDatabase();
        String query = ("SELECT * FROM " + USER_TABLE + " WHERE 1 ORDER BY " + COLUMN_APE + ";");
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }
















    //-------- para la tabla beneficios----------------



    public static final String BEN_TABLE = "beneficio";
    public static final String BEN_ID = "id";
    public static final String BEN_NOM = "nombre";
    public static final String BEN_OCU = "ocupacion";
    public static final String BEN_DES = "descripcion";
   // public static final Bitmap BEN_IMG ;

    public static final String CREATE_TABLE_BEN = "CREATE TABLE " + BEN_TABLE + "("
            + BEN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + BEN_NOM + " TEXT, "
            + BEN_OCU + " TEXT,"
            + BEN_DES + "TEXT);";

    public void addBen(String nombre, String descripcion,String ocupacion){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values1 = new ContentValues();
        values1.put(BEN_NOM,nombre);
        values1.put(BEN_DES,descripcion);
        values1.put(BEN_OCU,ocupacion);

        long id = db.insert(BEN_TABLE,null, values1);
        db.close();

        Log.d(TAG, "beneficio creado" + id);
    }

    public boolean getBen(String id){

        String selectQuery = "select * from  " + BEN_TABLE + " where " +
                BEN_ID + " = " + "'"+id+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor1 = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor1.moveToFirst();
        if (cursor1.getCount() > 0) {

            return true;
        }
        cursor1.close();
        db.close();

        return false;
    }

    public String getTipo1(String id){

        String selectQuery=" select " + " " + BEN_OCU +" "+ " from " + " " + BEN_TABLE + " " +" where " +" "+
                BEN_ID+ " = "+"'" + id +"'";
        /* "'" */

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c=db.rawQuery(selectQuery,null);

        c.moveToFirst();

        String columna= c.getString(0);


        return columna;

    }
    public Cursor listarbeneficios(){
        SQLiteDatabase db = getReadableDatabase();
        String query = ("SELECT * FROM " + BEN_TABLE + "  " + ";");
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }
    //----------------------------------------------------

    public Cursor personabyid(int id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + USER_TABLE + " WHERE " + COLUMN_ID + " = " + id + ";";
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

    public void updatepersona(int id,String email,String pass,String nom, String ap,String ocup){
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASS, pass);
        values.put(COLUMN_NOM, nom);
        values.put(COLUMN_APE, ap);
        values.put(COLUMN_OCU,ocup);
        SQLiteDatabase db = getWritableDatabase();
        db.update(USER_TABLE, values, COLUMN_ID + "= ?", new String[] { String.valueOf(id)});
        db.close();

    }

    public void borrarPersona(int persona_id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + USER_TABLE + " WHERE " + COLUMN_ID + " = " + persona_id + ";");
        db.close();
    }
}

