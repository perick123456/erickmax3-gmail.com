package com.example.seccion_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        //datos a mostrar, podria venir desde base de datos o web services!
        names = new ArrayList<>();
        names.add("Alejandro"); // posicion 0
        names.add("Fernando");  // 1
        names.add("Rubén");     // 2
        names.add("Santiago");  // 3
        names.add("Alejandro"); // posicion 0
        names.add("Fernando");  // 1
        names.add("Rubén");     // 2
        names.add("Santiago");  // 3
        names.add("Alejandro"); // posicion 0
        names.add("Fernando");  // 1
        names.add("Rubén");     // 2
        names.add("Santiago");  // 3
        names.add("Alejandro"); // posicion 0
        names.add("Fernando");  // 1
        names.add("Rubén");     // 2
        names.add("Santiago");  // 3
        names.add("Alejandro"); // posicion 0
        names.add("Fernando");  // 1
        names.add("Rubén");     // 2
        names.add("Santiago");  // 3
        names.add("Alejandro"); // posicion 0
        names.add("Fernando");  // 1
        names.add("Rubén");     // 2
        names.add("Santiago");  // 3


        //creamos un adaptador, es decir una forma de mostrar los datos, estructura de visualización
        // que luego se renderizara
        //requiere un layout android o personlizado

        //adaptadpr con layout androit :  simple_list_item1
    //    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        //conectar el listview con el adaptador creado
    //    listView.setAdapter(adapter);

        //Manejar eventos de click sobre un Item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Desde qui podriamos enlazar a otros activities para proporcionar info exclusiva del item clickado
                Toast.makeText(ListActivity.this, "Clicked " + names.get(position), Toast.LENGTH_SHORT).show();

            }
        });

        //Enlazamos con nuestro adaptador personalizado
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, names);
        listView.setAdapter(myAdapter);



    }
}

