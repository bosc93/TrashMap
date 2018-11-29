package com.example.cesar.trashmap;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import com.google.android.gms.maps.model.Marker;

@SuppressLint("ValidFragment")
public class DialogTrash extends DialogFragment {
    private Marker marker;

    @SuppressLint("ValidFragment")
    public DialogTrash(Marker marker) {
        this.marker = marker;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.custom_info_contents, null))
                // Add action buttons
                .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Ajouter LatLng, nom du point et difficulté en base
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        marker.remove();
                        DialogTrash.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
