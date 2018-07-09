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

public class ArrayComplejo1 extends ListActivity {

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
    }
    protected void onListItemClick(ListView l, View v, int position, long id){

        Toast.makeText(this,miArray.get(position).mTitulo,Toast.LENGTH_SHORT).show();

    }
    private void setData(){
        miArray.clear();

        nodo minodo6=new nodo();

        minodo6.mTitulo=this.getResources().getString(R.string.titulo6);
        minodo6.mDescripcion=this.getResources().getString(R.string.descripcion6);
        minodo6.mImagenRec=R.drawable.aura;

        miArray.add(minodo6);

        //Tienda 2
        nodo minodo7=new nodo();

        minodo7.mTitulo=this.getResources().getString(R.string.titulo7);
        minodo7.mDescripcion=this.getResources().getString(R.string.descripcion7);
        minodo7.mImagenRec=R.drawable.help;

        miArray.add(minodo7);


        //Tienda 3

        nodo minodo8=new nodo();

        minodo8.mTitulo=this.getResources().getString(R.string.titulo8);
        minodo8.mDescripcion=this.getResources().getString(R.string.descripcion8);
        minodo8.mImagenRec=R.drawable.rustica;

        miArray.add(minodo8);


        nodo minodo9=new nodo();

        minodo9.mTitulo=this.getResources().getString(R.string.titulo9);
        minodo9.mDescripcion=this.getResources().getString(R.string.descripcion9);
        minodo9.mImagenRec=R.drawable.civa;

        miArray.add(minodo9);


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
                view=inflater.inflate(R.layout.item3,null);

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
