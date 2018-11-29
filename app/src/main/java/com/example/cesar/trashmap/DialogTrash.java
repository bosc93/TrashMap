package com.example.cesar.trashmap;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;

@SuppressLint("ValidFragment")
public class DialogTrash extends DialogFragment {
    private Marker marker;
    private String spinnerStr;
    private ViewGroup container;
    private DatabaseReference mDatabase;

    @SuppressLint("ValidFragment")
    public DialogTrash(Marker marker) {
        this.marker = marker;
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        final LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.custom_info_contents, null))
                // Add action buttons
                .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //Ajouter LatLng, nom du point, matériau et difficulté en base
                        View view = inflater.inflate(R.layout.custom_info_contents, container, false);
                        Spinner spinner = (Spinner) view.findViewById(R.id.difficulty);
                        spinnerStr = spinner.getSelectedItem().toString();

                        if (spinnerStr.equals("Facile")) {
                            marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                        }else if (spinnerStr.equals("Moyen")) {
                            marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
                        }else if (spinnerStr.equals("Difficile")) {
                            marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                        }
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
