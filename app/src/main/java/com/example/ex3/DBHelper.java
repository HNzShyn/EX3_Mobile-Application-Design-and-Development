/*
package com.example.ex3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    Context context;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contact2";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ContactEntry.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ContactEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long insertContact(Contact contact) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ContactEntry.COLUMN_NAME, contact.getName());
        values.put(ContactEntry.COLUMN_DOB, contact.getDob());
        values.put(ContactEntry.COLUMN_PHONE, contact.getPhone());
        values.put(ContactEntry.COLUMN_EMAIL, contact.getEmail());
      */
/*  values.put(ContactEntry.COLUMN_AVATAR, contact.getAvatarUri());*//*


        return database.insert(ContactEntry.TABLE_NAME, null, values);
    }

    public int updateContact(Contact contact) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ContactEntry.COLUMN_NAME, contact.getName());
        values.put(ContactEntry.COLUMN_DOB, contact.getDob());
        values.put(ContactEntry.COLUMN_PHONE, contact.getPhone());
        values.put(ContactEntry.COLUMN_EMAIL, contact.getEmail());
      */
/*  values.put(ContactEntry.COLUMN_AVATAR, contact.getAvatarUri());*//*


        String selection = ContactEntry.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(contact.getId())};

        return database.update(ContactEntry.TABLE_NAME, values, selection, selectionArgs);
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from contacts", null);
        return cursor;
    }

*/
/*    public ArrayList<Contact> getAllContact() {
        ArrayList<Contact> contacts = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + ContactEntry.TABLE_NAME + " ORDER BY "
                + ContactEntry.COLUMN_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_ID)));
                contact.setName(cursor.getString(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_NAME)));
                contact.setDob(cursor.getString(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_DOB)));
                contact.setPhone(cursor.getString(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_PHONE)));
                contact.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_EMAIL)));
                contact.setAvatarUri(cursor.getString(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_AVATAR)));

                contacts.add(contact);
            } while (cursor.moveToNext());
        }
        db.close();
        return contacts;
    }*//*


    public ArrayList<Contact> getContactList() {
        ArrayList<Contact> contactList = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();

        String[] projection = {
                ContactEntry.COLUMN_ID,
                ContactEntry.COLUMN_NAME,
                ContactEntry.COLUMN_DOB,
                ContactEntry.COLUMN_PHONE,
                ContactEntry.COLUMN_EMAIL
                */
/*ContactEntry.COLUMN_AVATAR*//*

        };

        Cursor cursor = database.query(
                ContactEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_NAME));
            String dob = cursor.getString(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_DOB));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_PHONE));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_EMAIL));
            */
/*String avatarUri = cursor.getString(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_AVATAR));*//*


            Contact contact = new Contact(id, name, dob, phone, email);
            contactList.add(contact);
        }

        cursor.close();

        return contactList;
    }
}
*/
