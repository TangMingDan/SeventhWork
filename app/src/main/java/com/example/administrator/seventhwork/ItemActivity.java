package com.example.administrator.seventhwork;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {
    ArrayList<String> itemNames = new ArrayList<>();
    List<Item> itemList = new ArrayList<>();
    TextView toolbar_item;
    static Intent intent = null;
    public static void actionStart(Context context, ArrayList<String> itemList){
        if(intent == null){
            intent = new Intent(context,ItemActivity.class);
            intent.putStringArrayListExtra("itemList",itemList);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlist);
        Toast.makeText(ItemActivity.this,"加载成功",Toast.LENGTH_SHORT).show();
        Intent intent = getIntent();
        itemNames = intent.getStringArrayListExtra("itemList");
        initData();
        toolbar_item = findViewById(R.id.txt_toobar_item);
        toolbar_item.setTypeface(Typeface.createFromAsset(getAssets(),"font/hwxk.ttf"));
        RecyclerView recyclerView = findViewById(R.id.item_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);
        for (int i = 0; i < itemNames.size(); i++) {
            Log.d("11111",itemNames.get(i));
        }
    }
    private void initData() {
        itemList = new ArrayList<>();
        for (int i = 0; i < itemNames.size(); i++) {
            Item item = new Item(itemNames.get(i),"第" + (i + 1) + "册书籍");
            Log.d("11111",item.getName());
            itemList.add(item);
        }
    }
}
