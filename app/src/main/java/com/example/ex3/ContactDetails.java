package com.example.ex3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Contact> contacts;
    DatabaseHelper db;
    ContactAdapter adapter;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        //ActionBar
        actionBar = getSupportActionBar();
        actionBar.setTitle("Contact Details");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);

        db = new DatabaseHelper(this);

        //Get Data
        contacts = db.getContactList();

        //RecyclerView
        adapter = new ContactAdapter(this, contacts);
        adapter.updateContactList(contacts);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}