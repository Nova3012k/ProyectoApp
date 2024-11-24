package com.example.proyectoapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHerper extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String nameData = "restaurant.db";
    public static final String tablaUsuario = "usuarios";

    public dbHerper(@Nullable Context context) {
        super(context, nameData, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + tablaUsuario + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT," +
                "email TEXT NOT NULL," +
                "contraseña TEXT NOT NULL);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
