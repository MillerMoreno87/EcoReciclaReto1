package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecorecicla.Modelos.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class InicioSesionActivity extends AppCompatActivity {

    Button ingresar;
    TextView register;

    EditText user,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        ingresar=findViewById(R.id.buttonIngre);
        register=findViewById(R.id.textViewRegister);
        user=findViewById(R.id.eTxtUser);
        password=findViewById(R.id.eTxtPassword);


        Intent home= new Intent(getApplicationContext(),
                HomeActivity2.class);
        Intent registrarUsuario= new Intent(getApplicationContext(),
                ResgistroUsuarioActivity2.class);


        File fileUser= new File(getFilesDir(),"user.txt");
        ArrayList<User> users= listUser(fileUser);


        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean state= false;
                if(user.getText().toString().isEmpty() ||
                        password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),
                            "Los campos deben estar diligenciados",Toast.LENGTH_LONG).show();
                }else{
                    String userLogin= user.getText().toString();
                    for (User i:users){
                        if (i.getName().equals(userLogin) ||
                                i.getEmail().equals(userLogin)){
                            state=true;
                            if (i.getPassword().equals(password.getText().toString())){
                                home.putExtra("idUser",i.getId());
                                startActivity(home);
                                break;
                            }else{
                                Toast.makeText(getApplicationContext(),
                                        "La contraseña es incorrecta",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    if (!state){
                        Toast.makeText(getApplicationContext(),
                                "Usuario no registrado",Toast.LENGTH_LONG).show();
                    }

                }

            }

        });



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(registrarUsuario);
            }
        });

    }

    public ArrayList<User> listUser(File data){
        ArrayList<User> list= new ArrayList<>();

        try {
            FileReader reader= new FileReader(data);
            BufferedReader bufferedReader= new BufferedReader(reader);
            String user;

            while ((user=bufferedReader.readLine())!=null){
                String[] userData= user.split(",");
                String id= userData[0];
                String name= userData[1];
                String email=userData[2];
                String password= userData[3];

                User userObject= new User(id,name,email,password);
                list.add(userObject);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }


}