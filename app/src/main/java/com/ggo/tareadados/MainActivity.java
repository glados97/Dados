package com.ggo.tareadados;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button lanzartodos;
    private Button lanzarselec;
    private String[] dados ={"dado1", "dado2", "dado3", "dado4", "dado5", "dado6"};
    private int[] dados1=new int[5];
    private ImageView[] img=new ImageView[5];
    private CheckBox d1;
    private CheckBox d2;
    private CheckBox d3;
    private CheckBox d4;
    private CheckBox d5;

    private int oportunidad = 0;
    private int resID = 0;
    private int numero = 0;
    private int[] cantidad=new int[6];
    private String tag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lanzartodos = (Button) findViewById(R.id.lanzartodos);
        lanzarselec = (Button) findViewById(R.id.lanzarselec);

        img[0]=(ImageView) findViewById(R.id.dado1);
        img[1]=(ImageView) findViewById(R.id.dado2);
        img[2]=(ImageView) findViewById(R.id.dado3);
        img[3]=(ImageView) findViewById(R.id.dado4);
        img[4]=(ImageView) findViewById(R.id.dado5);

        d1 = (CheckBox) findViewById(R.id.d1);
        d2 = (CheckBox) findViewById(R.id.d2);
        d3 = (CheckBox) findViewById(R.id.d3);
        d4 = (CheckBox) findViewById(R.id.d4);
        d5 = (CheckBox) findViewById(R.id.d5);

        for(int i=0; i<6; i++)
            cantidad[i]=0;
    }

    public void Intento (View v){
           if (oportunidad == 1) {
               if (d1.isChecked()||d2.isChecked()||d3.isChecked()||d4.isChecked()||d5.isChecked()) {
                   if (d1.isChecked()) {
                       numero = (int) (Math.random() * 6);
                       resID = getResources().getIdentifier(dados[numero], "drawable", getPackageName());
                       img[0].setTag(resID);
                       img[0].setImageResource(resID);
                       dados1[0] = numero;
                   }

                   if (d2.isChecked()) {
                       numero = (int) (Math.random() * 6);
                       resID = getResources().getIdentifier(dados[numero], "drawable", getPackageName());
                       img[1].setTag(resID);
                       img[1].setImageResource(resID);
                       dados1[1] = numero;
                   }

                   if (d3.isChecked()) {
                       numero = (int) (Math.random() * 6);
                       resID = getResources().getIdentifier(dados[numero], "drawable", getPackageName());
                       img[2].setTag(resID);
                       img[2].setImageResource(resID);
                       dados1[2] = numero;
                   }

                   if (d4.isChecked()) {
                       numero = (int) (Math.random() * 6);
                       resID = getResources().getIdentifier(dados[numero], "drawable", getPackageName());
                       img[3].setTag(resID);
                       img[3].setImageResource(resID);
                       dados1[3] = numero;
                   }

                   if (d5.isChecked()) {
                       numero = (int) (Math.random() * 6);
                       resID = getResources().getIdentifier(dados[numero], "drawable", getPackageName());
                       img[4].setTag(resID);
                       img[4].setImageResource(resID);
                       dados1[4] = numero;
                   }

                   for (int i = 0; i < 5; i++) {
                       cantidad[(dados1[i])]++;
                       Log.d("i", String.valueOf(i));
                       Log.d("dados1", String.valueOf(dados1[i]));
                   }

                   oportunidad++;
               }
            }

        if (oportunidad == 2){
            Intent intent = new Intent( this, Result.class);
            intent.putExtra("cantidad",cantidad);
            //intent.putExtra("dados1",dados1);
            //intent.putExtra("dados",img);
            startActivity(intent);
        }
    }

    public void Alerta (View v){
        if (oportunidad == 0) {
            lanzarselec.setEnabled(true);
            d1.setEnabled(true);
            d2.setEnabled(true);
            d3.setEnabled(true);
            d4.setEnabled(true);
            d5.setEnabled(true);

            for (int i = 0; i < 5; i++){
                numero = (int) (Math.random() * 6);
                resID = getResources().getIdentifier(dados[numero], "drawable", getPackageName());
                dados1[i]=numero;
                img[i].setTag(resID);
                img[i].setImageResource(resID);
            }
            oportunidad++;
        }
            else{
            if (oportunidad == 1) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Tirar todos nuevamente")
                        .setMessage("¿Estas seguro?")
                        .setIcon(getResources().getDrawable(android.R.drawable.ic_dialog_info))
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                    for (int i = 0; i < 5; i++){
                                        numero = (int) (Math.random() * 6);
                                        resID = getResources().getIdentifier(dados[numero], "drawable", getPackageName());
                                        dados1[i]=numero;
                                        img[i].setTag(resID);
                                        img[i].setImageResource(resID);
                                        oportunidad=2;
                                    }

                                }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getBaseContext(), "No", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
        if (oportunidad == 2){
            Intent intent = new Intent( this, Result.class);
            intent.putExtra("cantidad",cantidad);
            intent.putExtra("dados1",dados1);
            intent.putExtra("dados",img);
            startActivity(intent);
        }
    }

}
