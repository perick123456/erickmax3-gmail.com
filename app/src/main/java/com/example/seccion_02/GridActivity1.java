package com.example.seccion_02;

import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity1 extends AppCompatActivity {

    private GridView gridView;
    private List<String> names;
    private MyAdapter myAdapter;

    private int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);


        gridView = findViewById(R.id.gridView);

        //datos a mostrar, podria venir desde base de datos o web services, API!
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



        //Manejar eventos de click sobre un Item
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Desde qui podriamos enlazar a otros activities para proporcionar info exclusiva del item clickado
                Toast.makeText(GridActivity1.this, "Clicked " + names.get(position), Toast.LENGTH_SHORT).show();

            }
        });

        //Enlazamos con nuestro adaptador personalizado
        myAdapter = new MyAdapter(this, R.layout.grid_item, names);
        gridView.setAdapter(myAdapter);


        //registrar el context menu para el gridview, asociado a onCreateContextMenu y  onContextItemSelected
        registerForContextMenu(gridView);


    }

    // Agrendo menu con opcion addItem al actionBar

    //crear menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);

        return true;

    }

    // manejar evento click sobre los item del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:

                this.names.add("Added n° " + ++counter); //agregamos un elemento al array string
                this.myAdapter.notifyDataSetChanged(); //avisamos al adaptador para que refresque

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Agregando context menu


    //Inflamos el layout del context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        //indicamos el nombre al item clickeado
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(names.get(info.position));


        inflater.inflate(R.menu.context_menu, menu);


    }

    //Manejamos eventos click del context menu, click largo, ojo!!!
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.delete_item:

                this.names.remove(info.position);//borramos un elemento al array string, clickado de nuestra lista
                this.myAdapter.notifyDataSetChanged(); //avisamos al adaptador para que refresque

                return true;

            default:
                return super.onContextItemSelected(item);

        }
    }
}
