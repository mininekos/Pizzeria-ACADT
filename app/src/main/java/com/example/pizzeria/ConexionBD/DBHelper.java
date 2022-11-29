package com.example.pizzeria.ConexionBD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.pizzeria.Enums.TipoCarne;
import com.example.pizzeria.Enums.TipoIngredientes;
import com.example.pizzeria.Enums.TipoKebab;
import com.example.pizzeria.Enums.TipoSalsa;
import com.example.pizzeria.Recursos.Kebab;
import com.example.pizzeria.Recursos.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String NOMBREBBDD = "Kebab.db";

    public DBHelper(Context context) {
        super(context, NOMBREBBDD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE \"Usuario\" (\n" +
                "\t\"Nombre\"\tTEXT NOT NULL UNIQUE,\n" +
                "\t\"Email\"\tTEXT NOT NULL,\n" +
                "\t\"Contrasenna\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"Nombre\")\n" +
                ")");
        sqLiteDatabase.execSQL("CREATE TABLE \"Kebab\" (\n" +
                "\t\"Id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"Nombre\"\tTEXT,\n" +
                "\t\"Favorito\"\tINTEGER NOT NULL,\n" +
                "\t\"Salsa\"\tINTEGER NOT NULL,\n" +
                "\t\"Carne\"\tINTEGER NOT NULL,\n" +
                "\t\"Tipo\"\tINTEGER NOT NULL,\n" +
                "\t\"Precio\"\tREAL NOT NULL,\n" +
                "\t\"Id_usuario\"\tTEXT NOT NULL,\n" +
                "\tPRIMARY KEY(\"Id\" AUTOINCREMENT),\n" +
                "\tFOREIGN KEY(\"Id_usuario\") REFERENCES \"Usuario\"(\"Id\")\n" +
                ")");

        sqLiteDatabase.execSQL("CREATE TABLE \"Ingrediente\" (\n" +
                "\t\"Id_Kebab\"\tINTEGER NOT NULL,\n" +
                "\t\"Id_Ingrediente\"\tINTEGER NOT NULL,\n" +
                "\tFOREIGN KEY(\"Id_Kebab\") REFERENCES \"Kebab\"(\"Id\"),\n" +
                "\tPRIMARY KEY(\"Id_Ingrediente\")\n" +
                ")");

        ContentValues values = new ContentValues();
        values.put("Nombre","Manu");
        values.put("Email","manu@gmail.com");
        values.put("Contrasenna","1234");
        sqLiteDatabase.insert("Usuario",null,values);

        values = new ContentValues();
        values.put("Nombre","admin");
        values.put("Email","admin@gmail.com");
        values.put("Contrasenna","admin");
        sqLiteDatabase.insert("Usuario",null,values);


        System.out.println("Se creó la BBDD");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertarUsuario(Usuario usuario){
        long id=0;
        try {
            SQLiteDatabase bbdd = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Nombre",usuario.getNombre());
            values.put("Email",usuario.getEmail());
            values.put("Contrasenna",usuario.getContrasenna());
            id=bbdd.insert("Usuario",null,values);

        } catch (Exception ex){
            System.err.println("Algo falló");
        }
        return id;
    }

    public long insertarKebab(Kebab kebab, String usuario){
        long id=0;
        try {
            SQLiteDatabase bbdd = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Nombre",kebab.getNombre());
            values.put("Favorito",kebab.getFavorito());
            values.put("Salsa",kebab.getSalsa().ordinal());
            values.put("Carne",kebab.getCarne().ordinal());
            values.put("Tipo",kebab.getTipoKebab().ordinal());
            values.put("Precio",kebab.obtenerPrecio());
            values.put("Id_usuario",usuario);
            id=bbdd.insert("Kebab",null,values);

        } catch (Exception ex){
            System.err.println("Algo falló");
        }
        return id;
    }

    public long insertarIgrediente(int ingrediente,int kebab){
        long id=0;
        try {
            SQLiteDatabase bbdd = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Id_Kebab",kebab);
            values.put("Id_Ingrediente",ingrediente);
            id=bbdd.insert("Ingrediente",null,values);

        } catch (Exception ex){
            System.err.println("Algo falló");
        }
        return id;
    }

    public ArrayList<Usuario> obtnerUsuarios(){
        SQLiteDatabase bbdd = this.getWritableDatabase();
        ArrayList<Usuario> lista= new ArrayList<Usuario>();
        Cursor c = bbdd.rawQuery("Select * from Usuario",null);

        //Así podemos recorrer un cursor
        if(c.moveToFirst()){
            while(c.isAfterLast()==false){
                lista.add(new Usuario(c.getString(0),c.getString(1),c.getString(2)));
                c.moveToNext();
            }
        }
        c.close();
        return lista;
    }

    public ArrayList<Kebab> obtnerKebabs(){
        SQLiteDatabase bbdd = this.getWritableDatabase();
        ArrayList<Kebab> lista= new ArrayList<Kebab>();
        Cursor c = bbdd.rawQuery("Select * from Kebab",null);
        ArrayList<TipoIngredientes> ingredientes = new ArrayList<TipoIngredientes>();
        //Así podemos recorrer un cursor
        if(c.moveToFirst()){
            while(c.isAfterLast()==false){
                ingredientes=buscarIngredientes(c.getInt(0));
                Kebab kebab=new Kebab(c.getString(1),ingredientes,TipoKebab.values()[c.getInt(5)],
                        TipoCarne.values()[c.getInt(4)], TipoSalsa.values()[c.getInt(3)]);
                if(c.getInt(2)==1) {
                    kebab.setFavorito(true);
                }
                lista.add(kebab);
                c.moveToNext();
            }
        }
        c.close();
        return lista;
    }

    public ArrayList<TipoIngredientes> buscarIngredientes(int id){
        SQLiteDatabase bbdd = this.getWritableDatabase();
        ArrayList<TipoIngredientes> lista= new ArrayList<TipoIngredientes>();
        Cursor c = bbdd.rawQuery("Select * from Ingrediente",null);

        //Así podemos recorrer un cursor
        if(c.moveToFirst()){
            while(c.isAfterLast()==false){
                if(c.getInt(0)==id) {
                    lista.add(TipoIngredientes.values()[c.getInt(1)]);
                    c.moveToNext();
                }
            }
        }
        c.close();
        return lista;
    }

    public Boolean buscarUsuario(Usuario usuario){
        SQLiteDatabase bbdd = this.getWritableDatabase();
        Boolean esta=false;
        Cursor c = bbdd.rawQuery("Select Nombre\n" +
                "FROM Usuario\n" +
                "WHERE Nombre='"+usuario.getNombre()+"' AND Contrasenna='"+usuario.getContrasenna()+"'",null);
        String nombre="";
        if (c.moveToFirst()){
            nombre=c.getString(0);
            System.out.println(nombre+"     hola");
            System.out.println(usuario.getNombre()+"     hola");
            if(nombre.equals(usuario.getNombre())) {
                esta = true;
            }
        }
        c.close();
        return esta;

    }

}
