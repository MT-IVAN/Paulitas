package com.example.user.paulitas;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;

public class PantallaCarga extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PantallaCarga.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

}
