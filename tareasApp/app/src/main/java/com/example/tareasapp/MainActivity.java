package com.example.tareasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Button btnAnadir;
    private ListView lstView;
    private EditText etxt;

    private List<String> mLista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        etxt = (EditText) findViewById(R.id.etxtNombre);
        lstView = (ListView) findViewById(R.id.txtView);
        lstView.setOnItemClickListener(this);
        btnAnadir = (Button) findViewById(R.id.btnAnadir);
    }

    public void agregar(View v) {
        String text = etxt.getText().toString().trim();
        mLista.add(text);
        etxt.getText().clear();

        customAdapter adaptador = new customAdapter(this,mLista);
        lstView.setAdapter(adaptador);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this, lstView.getItemAtPosition(i)+"Tarea completada!!", Toast.LENGTH_SHORT).show();
    }
}