package com.example.administrator.seventhwork;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<Item> itemList;
    private Context context;

    public MyAdapter(List<Item> itemList) {

        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = viewGroup.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item item = itemList.get(i);
        viewHolder.numTxt.setText(item.getNum());
        viewHolder.numTxt.setTypeface(Typeface.createFromAsset(context.getAssets(),"font/hwxk.ttf"));
        viewHolder.nameTxt.setText(item.getName());
        viewHolder.nameTxt.setTypeface(Typeface.createFromAsset(context.getAssets(),"font/hwxk.ttf"));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView numTxt;
        TextView nameTxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numTxt = itemView.findViewById(R.id.item_num_txt);
            nameTxt = itemView.findViewById(R.id.item_name_txt);
        }
    }
}
