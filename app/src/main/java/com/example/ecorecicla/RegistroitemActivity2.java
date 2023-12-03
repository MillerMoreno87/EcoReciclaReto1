package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecorecicla.Modelos.RegsItem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class RegistroitemActivity2 extends AppCompatActivity {

    EditText month,element,quantity,price;
    Button  envReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registroitem2);

        month=findViewById(R.id.eTxRmez);
        element=findViewById(R.id.eTxpcvt);
        quantity=findViewById(R.id.eTxcntdad);
        price=findViewById(R.id.eTxprco);
        envReg=findViewById(R.id.btnenvReg);

        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");

        envReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (month.getText().toString().isEmpty() ||
                        element.getText().toString().isEmpty() ||
                        quantity.getText().toString().isEmpty() ||
                        price.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),
                            "Todos los campos deben ser diligenciados",Toast.LENGTH_LONG).show();
                }else{
                    int quantityItem= Integer.parseInt(quantity.getText().toString());
                    int priceItem= Integer.parseInt(price.getText().toString());
                    String monthItem= month.getText().toString();
                    String elementItem= element.getText().toString();
                    String serial= idUser+monthItem;
                    RegsItem regItem= new RegsItem(serial,monthItem,elementItem,idUser,quantityItem,priceItem);
                    registerItem(regItem);
                    Toast.makeText(getApplicationContext(),"Registro exitoso",
                            Toast.LENGTH_LONG).show();
                    cleanView();
                }

            }
        });

    }

    public void registerItem(RegsItem registrarI){

        File itemRegFile= new File(getFilesDir(),"RegstItems.txt");

        try {
            FileWriter writer= new FileWriter(itemRegFile,true);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            bufferedWriter.write(
                    registrarI.getSERIAL()+","+
                            registrarI.getMonth()+","+
                            registrarI.getElement()+","+
                            registrarI.getQuantity()+","+
                            registrarI.getPrice()+","+
                            registrarI.getIdUser()
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cleanView(){
        quantity.setText("");
        price.setText("");
        element.setText("");
        month.setText("");
    }



}