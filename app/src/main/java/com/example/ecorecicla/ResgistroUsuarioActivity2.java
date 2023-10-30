package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResgistroUsuarioActivity2 extends AppCompatActivity {

    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro_usuario2);

        registrar=findViewById(R.id.buttonRegist);

        Intent inicio= new Intent(getApplicationContext(), InicioSesionActivity.class);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(inicio);
            }
        });
    }
}