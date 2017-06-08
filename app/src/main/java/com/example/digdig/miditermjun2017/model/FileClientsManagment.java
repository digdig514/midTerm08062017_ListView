package com.example.digdig.miditermjun2017.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by digdig on 17-06-08.
 */

public class FileClientsManagment {
    public static ArrayList<Clients> readFile(Context context, String fileName)
    {
        ArrayList<Clients> listOfClients =  new ArrayList<Clients>();
        AssetManager assetManager = context.getResources().getAssets();
        try
        {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));
            BufferedReader br =  new BufferedReader(isr);
            String online;
            while ((online=br.readLine())!=null)
            {
                StringTokenizer st =  new StringTokenizer(online,",");
                //String cpicture = st.nextToken();
               // int cpicture = Integer.valueOf(st.nextToken());
                String picture = st.nextToken();
                int cpicture = context.getResources().getIdentifier(picture, "drawable", context.getPackageName());
                String cname = st.nextToken();
                String caddress = st.nextToken();
                String cphone = st.nextToken();
                Clients clients = new Clients(cpicture,cname,caddress,cphone);
                listOfClients.add(clients);
            }
            br.close();
            isr.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();;
        }
        return listOfClients;
    }
 public static ArrayList<Cities> readFile2(Context context, String fileName)
    {
        ArrayList<Cities> listOfCities =  new ArrayList<Cities>();
        AssetManager assetManager = context.getResources().getAssets();
        try
        {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));
            BufferedReader br =  new BufferedReader(isr);
            String online;
            while ((online=br.readLine())!=null)
            {
                StringTokenizer st =  new StringTokenizer(online,",");
                int cid = Integer.valueOf(st.nextToken());
                String ccountry = st.nextToken();
                String ccity1 = st.nextToken();
                Cities cities = new Cities(cid,ccountry,ccity1);
                listOfCities.add(cities);
            }
            br.close();
            isr.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();;
        }
        return listOfCities;
    }
}
