package com.example.ex3;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<Contact> contacts;

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).
                inflate(R.layout.item_contact, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact contact = contacts.get(position);

        holder.name_details.setText(contact.getName());
        holder.dob_details.setText(contact.getDob());
        holder.phone_details.setText(contact.getPhone());
        holder.email_details.setText(contact.getEmail());

        if (contact.getImage() != null) {
            Glide.with(holder.itemView.getContext())
                    .load(contact.getImage())
                    .into(holder.imgAvatar);
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_details, dob_details, phone_details, email_details;
        ImageView imgAvatar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_details = itemView.findViewById(R.id.name_details);
            dob_details = itemView.findViewById(R.id.dob_details);
            phone_details = itemView.findViewById(R.id.phone_details);
            email_details = itemView.findViewById(R.id.email_details);

            imgAvatar = itemView.findViewById(R.id.imgAvatar);
        }
    }

    public void updateContactList(ArrayList<Contact> newContactList) {
        contacts = newContactList;
        notifyDataSetChanged();
    }

}
