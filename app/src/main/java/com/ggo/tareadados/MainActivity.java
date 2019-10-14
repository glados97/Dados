package com.ggo.tareadados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button lanzartodos;
    private Button lanzarselec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lanzartodos = (Button) findViewById(R.id.lanzartodos);
        lanzarselec = (Button) findViewById(R.id.lanzarselec);
    }


    public void Fin(View v){
        Intent intent = new Intent( this, Result.class);
        startActivity(intent);
    }
}
