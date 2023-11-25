package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResgistroUsuarioActivity2 extends AppCompatActivity {

    EditText nombreCom, correo, password;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro_usuario2);

        nombreCom= findViewById(R.id.editTextText2);
        correo= findViewById(R.id.editTextTextR);
        password= findViewById(R.id.editTextTextPasswordR);


        registrar=findViewById(R.id.buttonRegist);

        Intent inicio= new Intent(getApplicationContext(), InicioSesionActivity.class);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(inicio);
                System.out.println(nombreCom.getEditableText().toString()+" "+correo.getEditableText().toString()
                        +" "+password.getText().toString());
            }
        });
    }
}