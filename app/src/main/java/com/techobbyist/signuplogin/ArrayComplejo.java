package com.techobbyist.signuplogin;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArrayComplejo extends ListActivity  {
   // private Button btnRegreso;

    private MyAdapter miadaptador=null;

    public class nodo{
        public String mTitulo;
        public String mDescripcion;
        public Integer mImagenRec;
    }

    private static ArrayList<nodo> miArray=new ArrayList<nodo>();

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        setData();
        miadaptador=new MyAdapter(this);
        setListAdapter(miadaptador);

       // btnRegreso = (Button)findViewById(R.id.btnRegreso);
        //btnRegreso.setOnClickListener(this);

    }


    protected void onListItemClick(ListView l, View v, int position, long id){

        Toast.makeText(this,miArray.get(position).mTitulo,Toast.LENGTH_SHORT).show();

    }
    private void setData(){
        miArray.clear();

        nodo minodo=new nodo();

        minodo.mTitulo=this.getResources().getString(R.string.titulo1);
        minodo.mDescripcion=this.getResources().getString(R.string.descripcion1);
        minodo.mImagenRec=R.drawable.cafe;

        miArray.add(minodo);

        //Tienda 2
        nodo minodo2=new nodo();

        minodo2.mTitulo=this.getResources().getString(R.string.titulo2);
        minodo2.mDescripcion=this.getResources().getString(R.string.descripcion2);
        minodo2.mImagenRec=R.drawable.cineplanet;

        miArray.add(minodo2);


        //Tienda 3

        nodo minodo3=new nodo();

        minodo3.mTitulo=this.getResources().getString(R.string.titulo3);
        minodo3.mDescripcion=this.getResources().getString(R.string.descripcion3);
        minodo3.mImagenRec=R.drawable.pizza;

        miArray.add(minodo3);

        //Tienda 4

        nodo minodo4=new nodo();

        minodo4.mTitulo=this.getResources().getString(R.string.titulo4);
        minodo4.mDescripcion=this.getResources().getString(R.string.descripcion4);
        minodo4.mImagenRec=R.drawable.inkafarma;

        miArray.add(minodo4);

        //Tienda 5

        nodo minodo5=new nodo();

        minodo5.mTitulo=this.getResources().getString(R.string.titulo5);
        minodo5.mDescripcion=this.getResources().getString(R.string.descripcion5);
        minodo5.mImagenRec=R.drawable.kfc;

        miArray.add(minodo5);

    }
    public static class MyAdapter extends BaseAdapter {

        private Context mContext;
        public MyAdapter(Context c){
            mContext=c;
        }

        @Override
        public int getCount() {
            return miArray.size();
        }

        @Override
        public Object getItem(int position) {
            return miArray.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view =null;
            if(convertView==null){
                LayoutInflater inflater=(LayoutInflater)mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view=inflater.inflate(R.layout.item2,null);

            }else{
                view=convertView;
            }
            ImageView img=(ImageView)view.findViewById(R.id.image);
            img.setImageDrawable(mContext.getResources().getDrawable(miArray.get(position).mImagenRec));

            TextView tTittle=(TextView)view.findViewById(R.id.title);
            tTittle.setText(miArray.get(position).mTitulo);

            TextView tdescripcion=(TextView)view.findViewById(R.id.descripcion);
            tdescripcion.setText(miArray.get(position).mDescripcion);
            return view;

        }
    }


}
