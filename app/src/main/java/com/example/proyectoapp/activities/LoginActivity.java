package com.example.proyectoapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectoapp.MainActivity;
import com.example.proyectoapp.R;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private static final String URL_LOGIN = "http://192.168.1.18/restaurant/login.php";
    private EditText editTextEmail; // Campo para el email
    private EditText editTextPassword; // Campo para la contraseña
    private ImageButton visibilidadContraseña2; // Botón para mostrar/ocultar contraseña
    private boolean isPasswordVisible = false; // Estado inicial de visibilidad de la contraseña
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editText2);
        editTextPassword = findViewById(R.id.editText3);
        visibilidadContraseña2 = findViewById(R.id.visibilidadContraseña2);

        requestQueue = Volley.newRequestQueue(this);

        // Configura el botón para alternar visibilidad de la contraseña
        visibilidadContraseña2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    // Ocultar contraseña
                    editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    visibilidadContraseña2.setImageResource(R.drawable.baseline_remove_red_eye_24);
                } else {
                    // Mostrar contraseña
                    editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    visibilidadContraseña2.setImageResource(R.drawable.baseline_remove_red_eye_24);
                }
                isPasswordVisible = !isPasswordVisible; // Alternar estado
                editTextPassword.setSelection(editTextPassword.length()); // Mantener cursor al final
            }
        });
    }

    //metodo para iniciar sesion
    public void login(View view) {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa tu email y contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        loginUser(email, password);
    }

    // Función que envía las credenciales al servidor para validarlas
    private void loginUser(final String email, final String password) {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("Login exitoso")) {
                            Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("contraseña", password);
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    public void register(View view) {
        startActivity(new Intent(LoginActivity.this, RegistrarseActivity.class));
    }

    public void mainActivity(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}
