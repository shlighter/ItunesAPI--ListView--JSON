package com.example.shai.sadna;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.*;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import static android.content.ContentValues.TAG;


public class GetJson {

    StringBuffer returnFromServer;
    MainActivity context;

    public GetJson(Context context) {
        this.context = (MainActivity) context;
        new SendPostRequest().execute();
    }

    public class SendPostRequest extends AsyncTask<String, Void, String> {

        protected void onPreExecute(){}

        protected String doInBackground(String... arg0) {

            try {
                JSONObject jsonObj = new JSONObject();

                URL url = new URL("https://itunes.apple.com/search?term=Michael+jackson");
                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(0);
                connection.setReadTimeout(0);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(jsonObj.toString());
                out.close();
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer sb = new StringBuffer("");
                String line="";
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                in.close();
                returnFromServer = sb;

            } catch (Exception e) {
              //  returnFromServer= "error";
                System.out.println(e);
            }


            return new String(returnFromServer);
        }

        @Override
        protected void onPostExecute(String result) {


            Intent intent = new Intent(context, SongListView.class);
            intent.putExtra("json", result);
            context.startActivity(intent);

        }

    }

}

