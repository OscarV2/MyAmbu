package com.example.oscar.myambu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class segunda_pantalla extends AppCompatActivity{

    //private Button btn_Enviar;
    //private TextView informacion;


//final Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final RadioGroup rgTiposdeEmergencia = (RadioGroup)findViewById(R.id.radioGroup2);
        final RadioGroup rgNumeroPacientes = (RadioGroup)findViewById(R.id.radioGroup);

        RadioButton rbquemaduras = (RadioButton)findViewById(R.id.rbquemadura);
        RadioButton rbcardiaco  =(RadioButton)findViewById(R.id.rb_cardio);
        RadioButton rbtransito =(RadioButton)findViewById(R.id.rb_accidente);
        RadioButton rbuno =  (RadioButton)findViewById(R.id.rb_Uno);
        RadioButton rbdos= (RadioButton)findViewById(R.id.rb_Dos);
        RadioButton rbtres= (RadioButton)findViewById(R.id.rb_Tres);
        RadioButton rbmultiples  = (RadioButton)findViewById(R.id.rb_Multiples);
        Button btn_Enviar=(Button)findViewById(R.id.btn_Enviar);
        final TextView informacion=(TextView)findViewById(R.id.textView3);






        /*
        LocationProvider Provider = locationManager.getProvider(listaProviders.get(1));
        final int precision = Provider.getAccuracy();
        final boolean Obtiene = Provider.supportsAltitude();
        final int consumo = Provider.getPowerRequirement();

        final int permiso = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);

        View.OnClickListener TE = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.
                }
            }
        }

*/


//                                            Click on boton Enviar Alerta:
        btn_Enviar.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TipoDeEmergencia = " ";
                String NumeroDePacientes= " ";
int a = rgTiposdeEmergencia.getCheckedRadioButtonId();
int b = rgNumeroPacientes.getCheckedRadioButtonId();

                switch (a){
                    case R.id.rb_accidente:
                      TipoDeEmergencia = "Accidente de Transito";
                        break;
                    case R.id.rb_cardio:
                        TipoDeEmergencia ="Accidente cardiorespiratorio";
                        break;
                    case R.id.rbquemadura:
                        TipoDeEmergencia = "Quemaduras";
                        break;
                }

                switch (b){
                    case R.id.rb_Uno:
                        NumeroDePacientes= "1 Paciente por atender";
                        break;
                    case R.id.rb_Dos:
                        NumeroDePacientes= "2 Pacientes por atender";
                        break;
                    case R.id.rb_Tres:
                        NumeroDePacientes= "3 Pacientes por atender";
                        break;
                    case R.id.rb_Multiples:
                        NumeroDePacientes= "Multiples Pacientes por atender";
                        break;
                }

                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogoEnviarAlerta dialogo = new DialogoEnviarAlerta();
                dialogo.show(fragmentManager, "tagAlerta");
informacion.setText(NumeroDePacientes + " , " + TipoDeEmergencia );
            }

                 //Pasar siguiente pantalla
                // startActivity(enviar);

        });

    }

}
