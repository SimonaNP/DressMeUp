package com.example.qkikakiood.addapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qkikakiood.dressmeup.R;

public abstract class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageHolder> {
    private String[] contacts;
    public ImagesAdapter(String[] contactArray){
        this.contacts = contactArray;

    }
    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_contact,parent,false);
        ContactHolder holder = new ImageHolder(rowView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {
        String contactName = contacts[position];
        holder.txtContacts.setText(contactName);

    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }

    class ContactHolder extends RecyclerView.ViewHolder{
        TextView txtContacts;
        public ContactHolder(View itemView){
            super(itemView);
            txtContacts = (TextView) itemView.findViewById(R.id.txt_contact);
        }
    }
}