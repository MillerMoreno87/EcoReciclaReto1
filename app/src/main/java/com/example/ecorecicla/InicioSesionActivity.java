package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InicioSesionActivity extends AppCompatActivity {

    Button ingresar;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        ingresar=findViewById(R.id.buttonIngre);
        register=findViewById(R.id.textViewRegister);


        Intent home= new Intent(getApplicationContext(),
                HomeActivity2.class);

        Intent registrarUsuario= new Intent(getApplicationContext(),
                ResgistroUsuarioActivity2.class);



        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(home);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registrarUsuario);
            }
        });

    }
}