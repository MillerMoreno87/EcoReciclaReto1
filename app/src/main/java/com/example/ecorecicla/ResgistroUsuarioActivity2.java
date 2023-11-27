package com.example.ecorecicla;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.Modelos.User;

public class ResgistroUsuarioActivity2 extends AppCompatActivity {

    EditText nombreCom,correo,password;
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
            public void onClick(View view) {
                if(validateUser()){

                }else {
                    Toast.makeText(getApplicationContext(),"Todos los campos deben ser diligenciados",
                            Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    public boolean validateUser(){

       boolean validate=true;
       if(nombreCom.getEditableText().toString().isEmpty()){
           nombreCom.setBackgroundColor(Color.RED);
           validate=false;
       }
       if (correo.getEditableText().toString().isEmpty()){
           correo.setBackgroundColor(Color.RED);
           validate=false;
       }
       if (password.getEditableText().toString().isEmpty()){
            password.setBackgroundColor(Color.RED);
            validate=false;
       }
       return validate;
    }

    public User createrUser(){
        String id,nomUser,correoUser,paxxword;
        id="";
        nomUser=nombreCom.getEditableText().toString();
        correoUser=correo.getEditableText().toString();
        paxxword=password.getEditableText().toString();
        User user= new User(id,nomUser,correoUser,paxxword);

        return user;

    }
    public String generateID(String nombreCom){
        String id="";
        for ( int i=0;i<2;i++){
            int letra= (int) (Math.random()*nombreCom.length());
            int number= (int) (Math.random()*200);
            id+=nombreCom.charAt(letra);
            id+=number;
        }
        return id;
    }
}