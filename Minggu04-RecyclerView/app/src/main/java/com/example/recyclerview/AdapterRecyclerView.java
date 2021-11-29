package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private ArrayList<ItemModel> dataItem;

    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textHead;
        TextView textSubhead;
        ImageView imageIcon;
        LinearLayoutCompat parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textHead = itemView.findViewById(R.id.text_title);
            textSubhead = itemView.findViewById(R.id.text_subtitle);
            imageIcon = itemView.findViewById(R.id.imageList);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

    AdapterRecyclerView(Context context,  ArrayList<ItemModel> dataItem) {
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.ViewHolder holder, int position) {

        TextView textHead = holder.textHead;
        TextView textSubhead = holder.textSubhead;
        ImageView imageIcon = holder.imageIcon;

        textHead.setText(dataItem.get(position).getName());
        textSubhead.setText(dataItem.get(position).getType());
        imageIcon.setImageResource(dataItem.get(position).getImage());

        holder.parentLayout.setOnClickListener(v -> {
            Toast.makeText(context, "Opening " + dataItem.get(position).getName() + "...", Toast.LENGTH_SHORT).show();

            if ( dataItem.get(position).getName().equals("WhatsApp") ) {
                context.startActivity(new Intent(context, Activity_WhatsApp.class));
            } if ( dataItem.get(position).getName().equals("Facebook") ) {
                context.startActivity(new Intent(context, Activity_Facebook.class));
            } if ( dataItem.get(position).getName().equals("Instagram") ) {
                context.startActivity(new Intent(context, Activity_Instagram.class));
            } if ( dataItem.get(position).getName().equals("YouTube") ) {
                context.startActivity(new Intent(context, Activity_YouTube.class));
            } if ( dataItem.get(position).getName().equals("TikTok") ) {
                context.startActivity(new Intent(context, Activity_TikTok.class));
            } if ( dataItem.get(position).getName().equals("Mozilla Firefox") ) {
                context.startActivity(new Intent(context, Activity_Firefox.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

}
