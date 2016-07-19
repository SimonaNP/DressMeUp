package com.qkikakiood.dressmeup.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qkikakiood.dressmeup.Item.Item;
import com.qkikakiood.dressmeup.Item.SetViewHolder;
import com.qkikakiood.dressmeup.OnTapListener;
import com.qkikakiood.dressmeup.R;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by PC1 on 19.7.2016 г..
 */
public class PhotoAdapter extends RecyclerView.Adapter<SetViewHolder> {
    private Activity activity;
    List<Item> items = Collections.emptyList();

    public PhotoAdapter(Activity activity, List<Item> items){
        this.activity = activity;
        this.items =items;
    }
    private OnTapListener onTapListener;
    @Override
    public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,parent, false);
        return new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SetViewHolder holder, final int position) {
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(onTapListener!=null){
                onTapListener.onTapView(position);
            }
        }
    });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnTapListener(OnTapListener onTapListener){
        this.onTapListener = onTapListener;
    }


}
