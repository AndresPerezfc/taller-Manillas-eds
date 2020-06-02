package com.example.manillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton rdCuero, rdCuerda, rdMartillo, rdAncla, rdOro, rdNiquel, rdPlata;
    private EditText cantidad;
    private TextView resultado;
    private String [] monedas;
    private Spinner combo_monedas;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdCuero = findViewById(R.id.rdCuero);
        rdCuerda = findViewById(R.id.rdCuerda);
        rdMartillo = findViewById(R.id.rdMartillo);
        rdAncla = findViewById(R.id.rdAncla);
        rdOro = findViewById(R.id.rdOro);
        rdNiquel = findViewById(R.id.rdNiquel);
        rdPlata = findViewById(R.id.rdPlata);
        cantidad = findViewById(R.id.txtcantidad);

        resultado = findViewById(R.id.txtResultado);


        combo_monedas = findViewById(R.id.cmbMoneda);
        monedas = getResources().getStringArray(R.array.monedas);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, monedas);
        combo_monedas.setAdapter(adapter);

    }

    public void calcular(View v){

        int op, divisa=1, cant;
        cant = Integer.parseInt(cantidad.getText().toString());

        float material = 0, tipo = 0, dije = 0;
        int res;

        op = combo_monedas.getSelectedItemPosition();

        if( rdCuero.isChecked()){
            material = (float)(100.0/3.0);
        }else if(rdCuerda.isChecked()){
            material = (float)(70.0/3.0);
        }

        if( rdMartillo.isChecked()){
            dije = (float)(100.0/3.0);
        }else if(rdAncla.isChecked()){
            dije = (float)(160.0/3.0);
        }

        if( rdOro.isChecked()){
            tipo = (float)(100.0/3.0);
        }else if(rdNiquel.isChecked()){
            tipo = (float)(10.0/3.0);
        }else if(rdPlata.isChecked()){
            tipo = (float)(40.0/3.0);
        }

        switch(op){
            case 0:
                divisa = 1;
                break;
            case 1:
                divisa = 3200;
                break;
        }

        if(rdCuerda.isChecked() && rdMartillo.isChecked() && rdNiquel.isChecked()){
            resultado.setText("50");
        }else{
            res = (int)(material + dije + tipo);
            resultado.setText("$" + res*divisa*cant);
        }

    }




}
