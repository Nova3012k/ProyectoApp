package com.example.proyectoapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;


public class RegistrarseActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editText2;
    private EditText editText4; // Campo para la contraseña
    private ImageButton visibilidadContraseña; // Botón para mostrar/ocultar contraseña
    private boolean isPasswordVisible = false; // Estado inicial de visibilidad de la contraseña

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText4 = findViewById(R.id.editText4);
        visibilidadContraseña = findViewById(R.id.visibilidadContraseña);

        // Filtro para letras con acentos y caracteres especiales
        InputFilter filterOnlyLettersWithAccents = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    char c = source.charAt(i);
                    // Permitir solo letras, letras con acentos y espacios
                    if (!Character.isLetter(c) && c != ' ' && c != 'ñ' && c != 'Ñ' &&
                            !(c >= '\u00C0' && c <= '\u017F')) { // Rango de caracteres acentuados
                        return ""; // Rechaza caracteres no válidos
                    }
                }
                return null; // Acepta caracteres válidos
            }
        };

        // Asigna el filtro al EditText de nombre y apellido
        editText.setFilters(new InputFilter[]{filterOnlyLettersWithAccents});
        editText2.setFilters(new InputFilter[]{filterOnlyLettersWithAccents});

        // Configura el botón para alternar visibilidad de la contraseña
        visibilidadContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    // Ocultar contraseña
                    editText4.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    visibilidadContraseña.setImageResource(R.drawable.baseline_remove_red_eye_24);
                } else {
                    // Mostrar contraseña
                    editText4.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    visibilidadContraseña.setImageResource(R.drawable.baseline_remove_red_eye_24);
                }
                isPasswordVisible = !isPasswordVisible; // Alternar estado
                editText4.setSelection(editText4.length()); // Mantener cursor al final
            }
        });
    }
    public void register(View view) {
        startActivity(new Intent(RegistrarseActivity.this, LoginActivity.class));
    }

    public void Login(View view) {
        startActivity(new Intent(RegistrarseActivity.this, LoginActivity.class));


    }
}
