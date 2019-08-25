package com.silvio.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btn_calcular;
    EditText nome, altura, peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.user);
        altura = findViewById(R.id.altura);
        peso = findViewById(R.id.peso);

        btn_calcular = findViewById(R.id.btn_calcular);
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("informacoes",getInfo());
                startActivity(i);
            }
        });
    }

    public String[] getInfo(){
        String[] informacoes = new String[3];
        informacoes[0] = nome.getText().toString();
        informacoes[1] = altura.getText().toString();
        informacoes[2] = peso.getText().toString();
        return informacoes;
    }
}
