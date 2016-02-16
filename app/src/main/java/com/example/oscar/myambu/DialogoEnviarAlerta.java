package com.example.oscar.myambu;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by oscar on 2/02/16.
 */
public class DialogoEnviarAlerta extends android.support.v4.app.DialogFragment{
    //@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setTitle("ENVIAR ALERTA")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                                                        //Pasar al Mapa
                        Intent i = new Intent(getContext(), Mi_ubicacion.class);
                        getContext().startActivity(i);
                    }
                }).setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();                    //Cerrar cuadro de dialogo
            }
        });

        return builder.create();
    }
}
