package com.example.ex3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contact123";

    public DatabaseHelper(Context context) {
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
    public long insertContact(String name, String dob, String phone, String email, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ContactEntry.COLUMN_NAME, name);
        values.put(ContactEntry.COLUMN_DOB, dob);
        values.put(ContactEntry.COLUMN_PHONE, phone);
        values.put(ContactEntry.COLUMN_EMAIL, email);
        values.put(ContactEntry.COLUMN_IMAGE, image);
        long id = db.insert(ContactEntry.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public ArrayList<Contact> getContactList() {
        ArrayList<Contact> contactList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + ContactEntry.TABLE_NAME;
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
                contact.setImage(cursor.getBlob(cursor.getColumnIndexOrThrow(ContactEntry.COLUMN_IMAGE)));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        db.close();
        return contactList;
    }
}
