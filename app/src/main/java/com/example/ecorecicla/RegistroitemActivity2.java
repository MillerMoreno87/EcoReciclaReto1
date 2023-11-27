package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegistroitemActivity2 extends AppCompatActivity {

    EditText mess,elementoo,precioo;
    Button  envReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registroitem2);

        mess=findViewById(R.id.eTxRmez);
        elementoo=findViewById(R.id.eTxpcvt);
        precioo=findViewById(R.id.eTxprco);
        envReg=findViewById(R.id.btnenvReg);
    }
}