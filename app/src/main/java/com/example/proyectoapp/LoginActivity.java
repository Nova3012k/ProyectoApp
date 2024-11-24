package com.example.proyectoapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText editText3; // Campo para la contraseña
    private ImageButton visibilidadContraseña2; // Botón para mostrar/ocultar contraseña
    private boolean isPasswordVisible = false; // Estado inicial de visibilidad de la contraseña

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText3 = findViewById(R.id.editText3);
        visibilidadContraseña2 = findViewById(R.id.visibilidadContraseña2);


        // Configura el botón para alternar visibilidad de la contraseña
        visibilidadContraseña2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    // Ocultar contraseña
                    editText3.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    visibilidadContraseña2.setImageResource(R.drawable.baseline_remove_red_eye_24);
                } else {
                    // Mostrar contraseña
                    editText3.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    visibilidadContraseña2.setImageResource(R.drawable.baseline_remove_red_eye_24);
                }
                isPasswordVisible = !isPasswordVisible; // Alternar estado
                editText3.setSelection(editText3.length()); // Mantener cursor al final
            }
        });

    }

    public void register(View view) {
        startActivity(new Intent(LoginActivity.this, RegistrarseActivity.class));
    }

    public void mainActivity(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
