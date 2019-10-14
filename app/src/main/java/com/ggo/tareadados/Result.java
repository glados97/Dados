package com.ggo.tareadados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Result extends AppCompatActivity {
    private Button regreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        regreso = (Button) findViewById(R.id.regreso);
    }
    public void JuegoNuevo(View v){
        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);
    }

}
