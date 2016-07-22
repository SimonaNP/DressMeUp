//package com.qkikakiood.dressmeup.Adapters;
//
//import android.app.Activity;
//import android.graphics.Bitmap;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.qkikakiood.dressmeup.R;
//
//import java.util.Collections;
//import java.util.List;
//
////package com.qkikakiood.dressmeup.Adapters;
////
////import android.app.Activity;
////import android.graphics.Bitmap;
////import android.support.v7.widget.RecyclerView;
////import android.view.LayoutInflater;
////import android.view.View;
////import android.view.ViewGroup;
////
//////import com.qkikakiood.dressmeup.OnTapListener;
////import com.qkikakiood.dressmeup.R;
////
////import java.util.Collection;
////import java.util.Collections;
////import java.util.List;
////
/////**
//// * Created by PC1 on 19.7.2016 г..
//// */
//public class PhotoAdapter extends RecyclerView.Adapter<SetViewHolder> {
//    private Activity activity;
//    List<Bitmap> bitmaps = Collections.emptyList();
//
//    public PhotoAdapter(Activity activity, List<Bitmap> bitmaps){
//        this.activity = activity;
//        this.bitmaps =bitmaps;
//    }
////    private OnTapListener onTapListener;
//    @Override
//    public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,parent, false);
//        return new SetViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(PhotoAdapter.SetViewHolder holder, int position) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,parent, false);
//        return new SetViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(SetViewHolder holder, final int position) {
//    holder.itemView.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            if(onTapListener!=null){
//                onTapListener.onTapView(position);
//            }
//        }
//    });
//    }
//
//    @Override
//    public PhotoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(PhotoAdapter.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return bitmaps.size();
//    }
//
//    public void setOnTapListener(OnTapListener onTapListener){
//        this.onTapListener = onTapListener;
//    }
////    public class ViewHolder extends RecyclerView.ViewHolder{
////        ImageView imageView;
////
////        public ViewHolder(View itemView) {
////            super(itemView);
////            imageView = (ImageView) itemView.findViewById(R.id.img_view);
////        }
////    }
//
//}
