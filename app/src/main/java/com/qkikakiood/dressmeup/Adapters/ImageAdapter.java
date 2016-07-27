package com.qkikakiood.dressmeup.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qkikakiood.dressmeup.R;
import com.qkikakiood.dressmeup.cmn.Cloth;

import java.util.Collections;
import java.util.List;

/**
 * Created by a on 25.7.2016 г..
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    List<Cloth> list = Collections.emptyList();
    Context context;

    public ImageAdapter(List<Cloth> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ImageAdapter.ViewHolder viewHolder, int position) {
        viewHolder.image.setImageBitmap(list.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.CardView);
            image = (ImageView) itemView.findViewById(R.id.img_view);
        }
    }
}
