package com.not404.antifake.ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.JsonReader;

import com.not404.antifake.MainActivity;
import com.not404.antifake.QuestionAndQuery;
import com.not404.antifake.R;
import com.not404.antifake.URLtool;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class CheckClaim extends AsyncTask<String,Void,String> {
    String urlAddress;// "https://68df-2405-204-570c-d2b4-bcd8-a039-ddb1-47b5.in.ngrok.io/quicktool?claim1=";
    HttpURLConnection urlConnection;
    String claim;
    public AsyncTaskCallback callback = null;
    public HashMap<String, String> map = new HashMap<String,String>();;
    public CheckClaim(AsyncTaskCallback callback){
        this.callback=callback;
    }
    public String doInBackground(String... claim) {
        try{
            this.claim = claim[0];
            this.urlAddress = claim[1];
            String send = urlAddress + URLEncoder.encode(claim[0],"UTF-8").replace("+","%20");
            System.out.println(send);
            URL url = new URL(send);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            JsonReader read = new JsonReader(new InputStreamReader(in, "UTF-8"));
            map = (HashMap<String, String>) readMap(read);
            for (String name: map.keySet()) {
                String key = name.toString();
                String value = map.get(name);
                System.out.println("<"+key + ", " + value+">");
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            urlConnection.disconnect();
        }
    }
    public Map<String, String> readMap(JsonReader reader) throws IOException {

        Map<String, String> map = new HashMap<>();
        reader.beginObject();
        while(reader.peek().toString().equals("END_ARRAY")||reader.hasNext()) {
            String name = "END_ARRAY";
            if(!reader.peek().toString().equals("END_ARRAY"))
                 name = reader.nextName();
            //System.out.println(name);
            if(name.equals("claim"))
            name="statement";
            String value = null;
            switch(reader.peek().toString()){
                case "STRING":
                    value = reader.nextString();
                    break;
                case "BEGIN_ARRAY": {
                    reader.beginArray();
                    //System.out.println(reader.peek());
                    while (reader.peek().toString().equals("STRING")) {
                        if(value==null)
                            value=reader.nextString();
                        else
                            value=value+","+reader.nextString();
                    }
                    break;
                }
                case "END_ARRAY":
                    reader.endArray();
                    continue;
                case "BOOLEAN":
                    reader.nextBoolean();
                    break;
                case "NUMBER":
                    reader.nextLong();
                    break;
                default:
                    System.out.println(reader.peek().toString());
                    reader.skipValue();
                    break;
            }
            map.put(name, value);
        }
        reader.endObject();
        map.put("claim",claim);
        return map;
    }
    protected void onPostExecute(String a) {
//        map.put("question","Question 1");
//        map.put("statement","Joe Biden");
//        map.put("truth","Truth macha");
//        map.put("claim","I am truth macha");
        callback.onPostExecute(map);
    }

    public interface AsyncTaskCallback {
        void onPostExecute(HashMap<String,String> map);
    }
}
