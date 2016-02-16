package com.example.oscar.myambu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class primera_pantalla extends AppCompatActivity {
boolean flag1 = true;
    private Button btn_ir_a_segunda;
//HOLA MUNDO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla);
        btn_ir_a_segunda = (Button)findViewById(R.id.btn_ir_asegunda_pantalla);
        btn_ir_a_segunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(primera_pantalla.this, segunda_pantalla.class);
                            startActivity(intent);


            }
        });

    }



    }
