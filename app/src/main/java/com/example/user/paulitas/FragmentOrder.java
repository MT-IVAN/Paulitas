package com.example.user.paulitas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class FragmentOrder extends android.support.v4.app.Fragment {



    public FragmentOrder() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment FragmentOrder.
     */
    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_order, container, false);
    }






    Button btn;
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
         btn = (Button) getView().findViewById(R.id.button);

         btn.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                 Intent intent2 = new Intent (v.getContext(), Mapa.class);
                 startActivityForResult(intent2, 0);
             }
         });

    }




}
