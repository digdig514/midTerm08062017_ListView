package com.example.digdig.miditermjun2017.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digdig.miditermjun2017.R;

import java.util.ArrayList;

/**
 * Created by digdig on 17-06-08.
 */

public class CustomClientsAdapter extends BaseAdapter {
    private Context context;
private ArrayList<Clients> listOfClients;
   // int carClients[]={R.drawable.alan,R.drawable.andrew,R.drawable.catherine,R.drawable.thang};
    public CustomClientsAdapter(Context context, ArrayList<Clients> listOfClients) {
        this.context = context;
        this.listOfClients = listOfClients;
    }

    @Override
    public int getCount() {
        return listOfClients.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfClients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

     if (convertView ==null)
        {
            convertView = inflater.inflate(R.layout.one_element,null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.textView2);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView);


        Clients client = listOfClients.get(position);
        String clientName = client.getClientName();
        int clientPhoto = client.getPictures();
        //int clientPhoto = client.getPictures();

        textView.setText(clientName);
        imageView.setImageResource(clientPhoto);
    return convertView;
 }
}
