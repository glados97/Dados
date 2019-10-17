package com.ggo.tareadados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    private Button regreso;
    private ImageView[] img1=new ImageView[5];
    private TextView res1;
    private TextView res2;
    private TextView res3;
    private TextView res4;
    private TextView res5;
    private TextView res6;
    private TextView iguales;
    private TextView resultado;
    private int resID=0;
    private String[] dados ={"dado1", "dado2", "dado3", "dado4", "dado5", "dado6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);
        regreso = (Button) findViewById(R.id.regreso);
        img1[0]=(ImageView) findViewById(R.id.dado1);
        img1[1]=(ImageView) findViewById(R.id.dado2);
        img1[2]=(ImageView) findViewById(R.id.dado3);
        img1[3]=(ImageView) findViewById(R.id.dado4);
        img1[4]=(ImageView) findViewById(R.id.dado5);
        res1= (TextView) findViewById(R.id.res1);
        res2= (TextView) findViewById(R.id.res2);
        res3= (TextView) findViewById(R.id.res3);
        res4= (TextView) findViewById(R.id.res4);
        res5= (TextView) findViewById(R.id.res5);
        res6= (TextView) findViewById(R.id.res6);
        iguales = (TextView) findViewById(R.id.iguales);
        resultado= (TextView) findViewById(R.id.resultado);

        Bundle extras = getIntent().getExtras();
        int[] cantidad = extras.getIntArray("cantidad");
        //int[] dados1 = extras.getIntArray("dados1");
        //ImageView[] img = (ImageView[]) extras.getParcelableArray("dados");

        /*for(int i=0; i<5; i++) {
            resID = getResources().getIdentifier(dados[dados1[i]], "drawable", getPackageName());
            img1[i].setTag(resID);
            img[i].setImageResource(resID);
        }*/


        contar(cantidad);

    }

    public void contar(int[] cantidad){
        int total = 0;
        res1.setText(cantidad[0]+" ");
        res2.setText(cantidad[1]+" ");
        res3.setText(cantidad[2]+" ");
        res4.setText(cantidad[3]+" ");
        res5.setText(cantidad[4]+" ");
        res6.setText(cantidad[5]+" ");
        for(int i = 0 ; i<6; i++){
            int j = i+1;
            total+=cantidad[i]*(j);
            if (cantidad[i]==3) {
                total += 10;
                iguales.setText(cantidad[i]+" iguales: 10 puntos");
            }
            if (cantidad[i]==4) {
                total += 20;
                iguales.setText(cantidad[i]+" iguales: 20 puntos");
            }
            if (cantidad[i]==5) {
                total += 30;
                iguales.setText(cantidad[i]+" iguales: 30 puntos");
            }
        }
        resultado.setText(total+" puntos");
    }

    public void JuegoNuevo(View v){
        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);

    }

}
