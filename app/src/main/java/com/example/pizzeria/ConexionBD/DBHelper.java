package com.example.pizzeria.ConexionBD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
                "\t\"Nombre\"\tTEXT NOT NULL,\n" +
                "\t\"Email\"\tTEXT NOT NULL,\n" +
                "\t\"Contrasenna\"\tTEXT NOT NULL,\n" +
                "\t\"Id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\tPRIMARY KEY(\"Id\" AUTOINCREMENT)\n" +
                ")");
        sqLiteDatabase.execSQL("CREATE TABLE \"Kebab\" (\n" +
                "\t\"Id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"Nombre\"\tTEXT,\n" +
                "\t\"Favorito\"\tINTEGER NOT NULL,\n" +
                "\t\"Salsa\"\tINTEGER NOT NULL,\n" +
                "\t\"Carne\"\tINTEGER NOT NULL,\n" +
                "\t\"Tipo\"\tINTEGER NOT NULL,\n" +
                "\t\"Precio\"\tREAL NOT NULL,\n" +
                "\t\"Id_usuario\"\tINTEGER NOT NULL,\n" +
                "\tPRIMARY KEY(\"Id\" AUTOINCREMENT),\n" +
                "\tFOREIGN KEY(\"Id_usuario\") REFERENCES \"Usuario\"(\"Id\")\n" +
                ")");
        sqLiteDatabase.execSQL("CREATE TABLE \"Ingrediente\" (\n" +
                "\t\"Id_Kebab\"\tINTEGER NOT NULL,\n" +
                "\t\"Id_Ingrediente\"\tINTEGER NOT NULL,\n" +
                "\tFOREIGN KEY(\"Id_Kebab\") REFERENCES \"Kebab\"(\"Id\"),\n" +
                "\tPRIMARY KEY(\"Id_Ingrediente\")\n" +
                ")");
        System.out.println("Se creó la BBDD");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertarUsuario(String usario,String email, String password){
        long id=0;
        try {
            SQLiteDatabase bbdd = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Nombre",usario);
            values.put("Email",email);
            values.put("Contrasenna",password);
            id=bbdd.insert("Usuario",null,values);
            System.out.println("Se ");
        } catch (Exception ex){
            System.err.println("Algo falló");
        }
        return id;
    }

    public long insertarKebab(String nombre,int favorito, int salsa,int carne,int tipo,double precio,int usuario){
        long id=0;
        try {
            SQLiteDatabase bbdd = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("Nombre",nombre);
            values.put("Favorito",favorito);
            values.put("Salsa",salsa);
            values.put("Carne",carne);
            values.put("Tipo",tipo);
            values.put("Precio",precio);
            values.put("Id_usuario",usuario);
            id=bbdd.insert("Kebab",null,values);
            System.out.println("Se ");
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
            System.out.println("Se ");
        } catch (Exception ex){
            System.err.println("Algo falló");
        }
        return id;
    }

    public ArrayList<Usuario> buscarUsuario(){
        SQLiteDatabase bbdd = this.getWritableDatabase();
        ArrayList<Usuario> lista= new ArrayList<Usuario>();
        Cursor c = bbdd.rawQuery("Select * from Usuario",null);

        //Así podemos recorrer un cursor
        while(c.isAfterLast()==false){
            lista.add(new Usuario(c.getString(0),c.getString(1),c.getString(2)));
            c.moveToNext();
        }

        c.close();
        return lista;
    }


}
