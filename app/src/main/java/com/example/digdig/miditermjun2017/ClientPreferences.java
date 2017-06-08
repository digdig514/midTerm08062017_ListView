package com.example.digdig.miditermjun2017;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digdig.miditermjun2017.model.Cities;
import com.example.digdig.miditermjun2017.model.Clients;
import com.example.digdig.miditermjun2017.model.FileClientsManagment;

import java.io.Serializable;
import java.util.ArrayList;

public class ClientPreferences extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener {

    TextView tVName, tVAddress, tVPhone;
    ImageView imageViewinfo;
    ListView listViewCities;
    Button btnReturn, btnValidate;
    ArrayList<Cities> listOfCities;
    ArrayAdapter<Cities> adapterCities;

    ArrayList<Cities> listOfCitiesPrefer;
    Clients client;

    //int carClients[]={R.drawable.alan,R.drawable.andrew,R.drawable.catherine,R.drawable.thang};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_preferences);
        initialize();
    }

    private void initialize() {
        tVName = (TextView)findViewById(R.id.textViewNameinfo);
        tVAddress = (TextView)findViewById(R.id.textViewAddressinfo);
        tVPhone = (TextView)findViewById(R.id.textViewPhoneinfo);
        imageViewinfo = (ImageView)findViewById(R.id.imageViewinfo);
        listViewCities = (ListView)findViewById(R.id.listItemMultCities);
        btnReturn = (Button)findViewById(R.id.btnreturn);
        btnValidate = (Button)findViewById(R.id.btnValidate);

        Serializable serializable = getIntent().getSerializableExtra("client");
        client = (Clients) serializable;

        tVName.setText(client.getClientName());
        tVAddress.setText(client.getClientAddress());
        tVPhone.setText(client.getClientNumber());
        imageViewinfo.setImageResource(client.getPictures());
        //imageViewinfo.setImageResource(carClients[client.getPictures()]);

        listOfCities = FileClientsManagment.readFile2(this, "cities.txt");
        adapterCities = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, listOfCities);
        listViewCities.setAdapter(adapterCities);
        listViewCities.setOnItemClickListener(this);

        btnReturn.setOnClickListener(this);
        btnValidate.setOnClickListener(this);

        listOfCitiesPrefer = new ArrayList<>();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnreturn:
                ValidateReturn();
                break;
            case R.id.btnValidate:
                ValidateClick();
                break;
        }
    }

    private void ValidateReturn() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("client", client);
        if(listOfCitiesPrefer.size() > 0) {
            setResult(Activity.RESULT_OK, intent);
        } else {
            setResult(Activity.RESULT_CANCELED, intent);
        }
        finish();
    }

    private void ValidateClick() {
     if(listOfCitiesPrefer.size() > 0) {
            client.setCityPrefer(listOfCitiesPrefer);
            Toast.makeText(this, "Cities: " + listOfCitiesPrefer, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No Selected Cities!", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CheckedTextView check = (CheckedTextView)view;
        if(check.isChecked()) {
            listOfCitiesPrefer.add(listOfCities.get(position));
        } else {
            listOfCitiesPrefer.remove(listOfCities.get(position));
        }
    }
}
