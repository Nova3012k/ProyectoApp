package com.example.proyectoapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectoapp.R;

public class BienvenidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bienvenida);

    }

    public void register(View view) {
        startActivity(new Intent(BienvenidaActivity.this, RegistrarseActivity.class));
    }

    public void Login(View view) {
        startActivity(new Intent(BienvenidaActivity.this, LoginActivity.class));
    }
}