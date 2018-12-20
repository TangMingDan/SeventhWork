package com.example.administrator.seventhwork;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SendRequest extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<String> itemListName = new ArrayList<>();
    TextView toor_txt_troduction;
    Button sendRequest;
    Button back;
    boolean isClicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_send_request);
        toor_txt_troduction = findViewById(R.id.toor_txt_introduction);
        toor_txt_troduction.setTypeface(Typeface.createFromAsset(getAssets(),"font/hwxk.ttf"));
        sendRequest = findViewById(R.id.btn_send_requset);
        sendRequest.setTypeface(Typeface.createFromAsset(getAssets(),"font/hwxk.ttf"));
        sendRequest.setOnClickListener(this);
        back = findViewById(R.id.btn_back);
        back.setTypeface(Typeface.createFromAsset(getAssets(),"font/hwxk.ttf"));
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_send_requset){
            sendRequestWithOkHttp();
        }
        if(v.getId() == R.id.btn_back){
            finish();
        }
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://www.apiopen.top/novelSearchApi?" +
                                    "name=%E7%9B%97%E5%A2%93%E7%AC%94%E8%AE%B0").build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseJSONWithJSONObject(responseData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void parseJSONWithJSONObject(String responseData) {
        try {
            JSONObject jsonObject = new JSONObject(responseData);
            int code = jsonObject.getInt("code");
            String msg = jsonObject.getString("msg");
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                String item = (String) jsonArray.get(i);
                Log.d("11111",item);
                if(isClicked){
                    itemListName.add(item);
                }
            }
            isClicked = false;
            Log.d("11111",code + "");
            Log.d("11111",msg);
            to();
            } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void to(){
        ItemActivity.actionStart(SendRequest.this,itemListName);
    }
}
