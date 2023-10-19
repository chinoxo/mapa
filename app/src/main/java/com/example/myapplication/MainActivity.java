package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Direccion1, Direccion2, Direccion3;
    Button Enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Direccion1 = findViewById(R.id.long1);
        Direccion2 = findViewById(R.id.long2);
        Direccion3 = findViewById(R.id.long3);
        Enviar = findViewById(R.id.btnagregar);

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dir1 = Direccion1.getText().toString();
                String dir2 = Direccion2.getText().toString();
                String dir3 = Direccion3.getText().toString();

                Intent intent = new Intent(getApplicationContext(),Mapa.class);
                intent.putExtra("direccion1", dir1.toString());
                intent.putExtra("direccion2", dir2.toString());
                intent.putExtra("direccion3", dir3.toString());
                startActivity(intent);
            }
        });
    }
}