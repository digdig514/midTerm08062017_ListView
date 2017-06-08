package com.example.digdig.miditermjun2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.digdig.miditermjun2017.model.Clients;
import com.example.digdig.miditermjun2017.model.CustomClientsAdapter;
import com.example.digdig.miditermjun2017.model.FileClientsManagment;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {
ListView listViewClients;
TextView textViewMainInfo;
    ArrayList<Clients> listOfClients;
    //ArrayList<Clients> listallOfClients;
CustomClientsAdapter customClientsAdapter;
    static final int SELECTEDCITY=50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        listViewClients = (ListView) findViewById(R.id.listView);
        listOfClients = FileClientsManagment.readFile(this,"clients.txt");
        textViewMainInfo = (TextView) findViewById(R.id.textViewMainInfo);
        //listallOfClients = new ArrayList<>();
        customClientsAdapter = new CustomClientsAdapter(this,listOfClients);
        listViewClients.setAdapter(customClientsAdapter);
        listViewClients.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Clients client = listOfClients.get(position);
        Intent intent = new Intent(this, ClientPreferences.class);
        intent.putExtra("client", client);
        //startActivity(intent,SELECTEDCITY);
        startActivityForResult(intent,SELECTEDCITY);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SELECTEDCITY) {
            Serializable serializable = data.getSerializableExtra("client");
            Clients client = (Clients)serializable;
            if (resultCode == RESULT_OK) {
                textViewMainInfo.setText("Information: " + client.toString() + "\nCities: " + client.getCityPrefer());
            } else if(resultCode == RESULT_CANCELED) {
                textViewMainInfo.setText("Information: " + client.toString() + "\nNo Selected Cities.");
            }
        }
    }


}
