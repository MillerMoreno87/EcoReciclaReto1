package com.example.ecorecicla;

import static java.lang.Thread.sleep;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.Modelos.User;
import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ResgistroUsuarioActivity2 extends AppCompatActivity {

    TextInputLayout nombreCom, correo, password1, password2;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro_usuario2);

        nombreCom = findViewById(R.id.name_user);
        correo = findViewById(R.id.email_user);
        password1 = findViewById(R.id.password1_user);
        password2 = findViewById(R.id.password2_user);


        registrar = findViewById(R.id.buttonRegist);

        Intent inicio = new Intent(getApplicationContext(), InicioSesionActivity.class);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateUser()) {
                    User user = createrUser();
                    saveUser(user);
                    Toast.makeText(getApplicationContext(),
                            "Registro Exitoso", Toast.LENGTH_LONG).show();
                    try {
                        sleep(500);
                        startActivity(inicio);
                        finish();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Todos los campos deben ser diligenciados",
                            Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    public boolean validateUser() {

        boolean validate = true;
        if (nombreCom.getEditText().getText().toString().isEmpty()) {
            nombreCom.setBackgroundColor(Color.GREEN);
            validate = false;
        }
        if (correo.getEditText().getText().toString().isEmpty()) {
            correo.setBackgroundColor(Color.GREEN);
            validate = false;
        }
        if (password1.getEditText().getText().toString().isEmpty()) {
            password1.setBackgroundColor(Color.GREEN);
            validate = false;
        }
        if (password2.getEditText().getText().toString().isEmpty()) {
            password2.setBoxBackgroundColor(Color.GREEN);
            validate = false;
        }
        if (!password1.getEditText().getText().toString().equals(password2.getEditText().getText().toString())) {
            password1.setBoxBackgroundColor(Color.GREEN);
            password2.setBoxBackgroundColor(Color.GREEN);
            validate = false;
        }
        return validate;
    }

    public User createrUser() {
        String id, nomUser, correoUser, paxxword;

        nomUser = nombreCom.getEditText().getText().toString();
        id = generateID(nomUser);
        correoUser = correo.getEditText().getText().toString();
        paxxword = password1.getEditText().getText().toString();
        User user = new User(id, nomUser, correoUser, paxxword);

        return user;

    }

    public String generateID(String nombreCom) {
        String id = "";
        for (int i = 0; i < 2; i++) {
            int letra = (int) (Math.random() * nombreCom.length());
            int number = (int) (Math.random() * 200);
            id += nombreCom.charAt(letra);
            id += number;
        }
        return id;
    }

    public void saveUser(User user) {

        File fileUser = new File(getFilesDir(), "user.txt");

        try {
            FileWriter writer = new FileWriter(fileUser, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(
                    user.getId() + "," +
                            user.getName() + "," +
                            user.getEmail() + "," +
                            user.getPassword()
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}