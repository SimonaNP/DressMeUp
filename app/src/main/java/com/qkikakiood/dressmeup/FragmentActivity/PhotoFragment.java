//package com.qkikakiood.dressmeup.FragmentActivity;
//
//import android.annotation.TargetApi;
//import android.app.Fragment;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.os.Build;
//import android.os.Bundle;
//import android.provider.ContactsContract;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.Toast;
//
//import com.qkikakiood.dressmeup.Adapters.Data_Adapter;
//import com.qkikakiood.dressmeup.Item.Item;
//import com.qkikakiood.dressmeup.R;
//import com.qkikakiood.dressmeup.database.DBHelper;
//
//import java.util.ArrayList;
//
///**
// * Created by PC1 on 19.7.2016 г..
// */
//public class PhotoFragment extends Fragment {
//    private RecyclerView recyclerView;
//    private DBHelper databaseHelper;
//    private ArrayList<Item> arrayList = new ArrayList<Item>();
//    private Cursor cursor;
//    private Data_Adapter adapter;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInterfaceState){
//        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.list_item, container,false);
//        recyclerView= (RecyclerView) viewGroup.findViewById(R.id.recycler_view);
//        loadDatabase();
//        return viewGroup;
//    }
//
//    @TargetApi(Build.VERSION_CODES.M)
//    public void loadDatabase(){
//        databaseHelper = new DBHelper(getActivity());
//        try {
//            databaseHelper.checkAndCopyDatabase();
//            databaseHelper.openDatabase();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            cursor = databaseHelper.QueryData("select + from topic_voca");
//            if (cursor != null) {
//                if (cursor.moveToFirst()) {
//                    do {
//                        Item item = new Item();
//                        arrayList.add(item);
//                    } while (cursor.moveToNext());
//                }
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
//        }
//    }
//



