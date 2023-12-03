package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.ecorecicla.Modelos.RegsItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class EstadisticasActivity2 extends AppCompatActivity {

    TextView mess,elemeento,caantidad,preecio;

    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas2);

        mess=findViewById(R.id.tvdataMes);
        elemeento=findViewById(R.id.tVdataElement);
        caantidad=findViewById(R.id.tVdataCantidad);
        preecio=findViewById(R.id.tVdataPrecio);
        table=findViewById(R.id.tableStadistis);

        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");

        File regist= new File(getFilesDir(),"RegstItem.txt");

        ArrayList <RegsItem> list_registt= lisRegistro(regist,idUser);
    }



    public ArrayList <RegsItem> lisRegistro(File registt,String user){
        ArrayList <RegsItem> list=new ArrayList<>();

        try {
            FileReader reader= new FileReader(registt);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String cadena;
            while ((cadena=bufferedReader.readLine())!=null){
                String [] data= cadena.split(",");
                if(data[5].equals(user)){
                    String serial= data[0];
                    String month= data[1];
                    String element= data[2];
                    int quantity= Integer.parseInt(data[3]);
                    int price= Integer.parseInt(data[4]);
                    String idUser= data[5];

                    RegsItem obj= new RegsItem(serial,month,element,idUser,quantity,price);
                    list.add(obj);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}