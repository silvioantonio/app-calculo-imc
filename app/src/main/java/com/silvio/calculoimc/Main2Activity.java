package com.silvio.calculoimc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private TextView textView, textNome;
    private double valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        linearLayout = findViewById(R.id.main2);
        textView = findViewById(R.id.tx_view);
        textNome = findViewById(R.id.text_nome);
        textNome.setText(getNome());
        valor = calcular();
        textView.setText(retorno(valor));
    }

    private String getNome(){
        Intent i = getIntent();
        String[] res = i.getStringArrayExtra("informacoes");
        return res[0];
    }

    private double calcular(){
        double altura, peso, resposta;
        Intent i = getIntent();
        String[] res = i.getStringArrayExtra("informacoes");
        altura = Double.parseDouble(res[1]);
        peso = Double.parseDouble(res[2]);
        altura = altura / 100;
        resposta = peso/(altura*altura);
        return resposta;
    }

    private String retorno(double number){
        if(number<18.5){
            linearLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.b1));
            return " voçe esta abaixo do peso indicado para sua altura, procure um medico! ";
        }
        else if(number >= 18.5 && number <= 24.9){
            linearLayout.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.b2));
            return " voce esta com peso normal de acordo com sua altura";
        }
        else if(number >= 25.0 && number <= 29.9){
            linearLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.b3));
            return " voce esta com Sobrepeso de acordo com sua altura, procure um medico!";
        }
        else if(number >= 30.0 && number <= 34.9){
            linearLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.b4));
            return " voce esta com Obesidade grau 1, procure um medico por favor!";
        }
        else if(number >= 35.0 && number <= 39.9){
            linearLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.b5));
            return " voce esta com Obesidade grau 2, procure um medico urgente";
        }
        else {
            linearLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.b6));
            return " voce esta com Obesidade grau 3, procure um medico urgente";
        }
    }
}
