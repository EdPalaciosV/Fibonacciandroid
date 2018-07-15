package com.example.usuario.fibonacciandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adaptador;
    List<String> datos;


    int numero1 = 0;
    int numero2 = 1;
    int limit = 4000000;
    int suma=numero1+numero2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos=new ArrayList<>();
        listView=findViewById(R.id.Milistview);

        fibonacci(1);
        adaptador=new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1);
        adaptador.addAll(datos);

        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),datos.get(i),Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void fibonacci(int resultado)
    {


       // while (suma <= limit) {
         //   auxiliar = numero1;
           // numero1 = numero2;
            //numero2 = auxiliar + numero1;
            //if (numero2%2==0)
            //{

        if(resultado<limit) {
            if (suma % 2 == 0) {
                datos.add(String.valueOf(suma));
            }
            numero1 = numero2;
            numero2 = suma;
            suma = numero1 + numero2;

            fibonacci(suma);
        }

    }
}
