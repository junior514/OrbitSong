package com.example.orbitsong.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.orbitsong.MainActivity;
import com.example.orbitsong.R;
import com.example.orbitsong.models.Genero;

public class GeneroActivity extends AppCompatActivity {

    public TextView textGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_genero);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
    }


    private void initViews() {
        Intent intent = getIntent();
        Genero[] generos = (Genero[]) intent.getSerializableExtra("listado_generos");
        LinearLayout contenedor = findViewById(R.id.contenedor_generos);

        if (generos != null && generos.length > 0) {
            for (Genero genero : generos) {
                // Inflar el layout de plantilla
                View itemGenero = getLayoutInflater().inflate(R.layout.item_genero, contenedor, false);

                // Referencias a los elementos
                TextView titulo = itemGenero.findViewById(R.id.texto_categoria);
                ImageView fondo = itemGenero.findViewById(R.id.bg_imagen);

                // Cambiar el nombre del género
                titulo.setText(genero.getNombre());

                // Añadir al contenedor
                contenedor.addView(itemGenero);
            }
        }
    }
}