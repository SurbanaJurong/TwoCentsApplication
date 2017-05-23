package com.mrawesome.twocents.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mrawesome.twocents.data.Dummy;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrawesome on 23/5/17.
 */

public class Utils {

    private static final String TAG = "Utils";

    public static List<Dummy> loadDummys(Context context){
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            JSONArray array = new JSONArray(loadJSONFromAsset(context, "profiles.json"));
            List<Dummy> DummyList = new ArrayList<>();
            for(int i=0;i<array.length();i++){
                Dummy Dummy = gson.fromJson(array.getString(i), Dummy.class);
                DummyList.add(Dummy);
            }
            return DummyList;
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static String loadJSONFromAsset(Context context, String jsonFileName) {
        String json;
        InputStream is;
        try {
            AssetManager manager = context.getAssets();
            Log.d(TAG,"path "+jsonFileName);
            is = manager.open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
