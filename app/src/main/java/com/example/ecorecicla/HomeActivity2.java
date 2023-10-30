package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity2 extends AppCompatActivity {

    Button regItem,stadist,recomenda;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        regItem=findViewById(R.id.buttonrItem);
        stadist=findViewById(R.id.buttonStadisti);
        recomenda=findViewById(R.id.buttonRecomenda);


        Intent registItem=new Intent(getApplicationContext(),
                RegistroitemActivity2.class);
        Intent estadistica= new Intent(getApplicationContext(),
                EstadisticasActivity2.class);
        Intent recomendacion=new Intent(getApplicationContext(),
                RecomendacionActivity2.class);


        regItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registItem);
            }
        });

        stadist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(estadistica);
            }
        });
        recomenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(recomendacion);
            }
        });
    }
}