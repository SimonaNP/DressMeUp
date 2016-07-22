package com.qkikakiood.dressmeup.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qkikakiood.dressmeup.R;
import com.qkikakiood.dressmeup.cmn.Cloth;

import java.util.Collections;
import java.util.List;

/**
 * Created by PC1 on 22.7.2016 г..
 */
public class Data_Adapter extends RecyclerView.Adapter<Data_Adapter.View_holder> {
    List<Cloth> list = Collections.emptyList();
    Context context;

    public Data_Adapter(List<Cloth> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Data_Adapter.View_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,parent,false);
        View_holder holder=new View_holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(Data_Adapter.View_holder holder, int position) {
        holder.image.setImageBitmap(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class View_holder extends RecyclerView.ViewHolder{
        //CardView cv;
        ImageView image;

        public View_holder(View itemView) {
            super(itemView);
            //cv = (CardView) itemView.findViewById(R.id.CardView);
            image = (ImageView) itemView.findViewById(R.id.img_view);
        }
    }
}