package com.example.orbitsong.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orbitsong.MainActivity;
import com.example.orbitsong.R;
import com.example.orbitsong.api.ApiClient;
import com.example.orbitsong.api.ApiService;
import com.example.orbitsong.models.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InicioSesionActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private EditText etEmail, etContrasena;
    private Button btnIngresar;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        // Inicializar vistas
        initViews();

        // Inicializar API service
        apiService = ApiClient.getApiService();

        // Configurar listeners
        setupListeners();
    }

    private void initViews() {
        // Asegúrate de que estos IDs coincidan con tu layout XML
        etEmail = findViewById(R.id.activityorbitsong_et_usuariocorreo); // Cambia por tu ID real
        etContrasena = findViewById(R.id.activityorbitsong_et_contrasena); // Cambia por tu ID real
        btnIngresar = findViewById(R.id.activityorbitsong_btn_ingresar); // Cambia por tu ID real
    }

    private void setupListeners() {
        btnIngresar.setOnClickListener(v -> realizarLogin());
    }

    private void realizarLogin() {
        String email = etEmail.getText().toString().trim();
        String contrasena = etContrasena.getText().toString().trim();

        // Validaciones básicas
        if (email.isEmpty()) {
            etEmail.setError("Ingresa tu email");
            etEmail.requestFocus();
            return;
        }

        if (contrasena.isEmpty()) {
            etContrasena.setError("Ingresa tu contraseña");
            etContrasena.requestFocus();
            return;
        }

        // Deshabilitar botón mientras se procesa
        btnIngresar.setEnabled(false);
        btnIngresar.setText("Ingresando...");

        // Realizar llamada a la API
        Call<Usuario> call = apiService.login(email, contrasena);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                // Rehabilitar botón
                btnIngresar.setEnabled(true);
                btnIngresar.setText("INGRESAR");

                if (response.isSuccessful() && response.body() != null) {
                    Usuario usuario = response.body();

                    // Login exitoso
                    Toast.makeText(InicioSesionActivity.this,
                            "¡Bienvenido " + usuario.getNombre() + "!",
                            Toast.LENGTH_SHORT).show();

                    // Ir a la siguiente actividad (MainActivity u otra)
                    Intent intent = new Intent(InicioSesionActivity.this, GeneroActivity.class);
                    // Pasar datos del usuario a la siguiente actividad
                    intent.putExtra("usuario_id", usuario.getId());
                    intent.putExtra("usuario_nombre", usuario.getNombre());
                    intent.putExtra("usuario_email", usuario.getEmail());

                    startActivity(intent);
                    finish(); // Cerrar esta actividad

                } else {
                    // Error de autenticación
                    if (response.code() == 401) {
                        Toast.makeText(InicioSesionActivity.this,
                                "Email o contraseña incorrectos",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(InicioSesionActivity.this,
                                "Error en el servidor. Código: " + response.code(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                // Rehabilitar botón
                btnIngresar.setEnabled(true);
                btnIngresar.setText("INGRESAR");

                // Error de conexión
                Log.e("LoginError", "Error de conexión: " + t.getMessage());
                Toast.makeText(InicioSesionActivity.this,
                        "Error de conexión. Verifica tu internet y que la API esté funcionando.",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onclickRegistrarse(View view){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
}