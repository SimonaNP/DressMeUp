//package com.qkikakiood.dressmeup;
//
//import android.annotation.TargetApi;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.graphics.Bitmap;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import com.qkikakiood.dressmeup.Adapters.PhotoAdapter;
//
//import java.util.ArrayList;
//
//public class Wardrobe extends Fragment {
//    private RecyclerView recyclerView;
//    private DatabaseHelper databaseHelper;
//    private ArrayList<Bitmap> arrayList = new ArrayList<Bitmap>();
//    private Cursor cursor;
//    private PhotoAdapter adapter;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInterfaceState){
//        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.activity_wardrobe, container,false);
//        recyclerView= (RecyclerView) viewGroup.findViewById(R.id.recycler_view);
//        loadDatabase();
//        return viewGroup;
//    }
//
//    @TargetApi(Build.VERSION_CODES.M)
//    public void loadDatabase(){
//        databaseHelper = new DatabaseHelper(getActivity());
//        try {
//            databaseHelper.checkAndCopyDatabase();
//            databaseHelper.openDatabase();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            cursor = databaseHelper.QueryData("select + from topic_voca");
//            if (cursor != null) {
//                if (cursor.moveToFirst()) do {
//                    Bitmap bitmap = null;
//                    arrayList.add(bitmap);
//                } while (cursor.moveToNext());
//            }
//        }catch(SQLException e) {
//            e.printStackTrace();
//        }
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        adapter = new PhotoAdapter(getActivity(),arrayList);
//        adapter.setOnTapListener(new OnTapListener() {
//            @Override
//            public void onTapView(int position) {
//                Toast.makeText(getContext(), "Click to " + position, Toast.LENGTH_SHORT).show();
//            }
//        });
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(adapter);
//
//    }
//
//
//}