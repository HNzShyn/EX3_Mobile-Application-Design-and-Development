package com.example.ex3;

public class ContactEntry {
    public static final String TABLE_NAME = "contactsss";
    public static final String COLUMN_ID = "contact_id";
    public static final String COLUMN_NAME = "contact_name";
    public static final String COLUMN_DOB = "contact_dob";
    public static final String COLUMN_PHONE = "contact_phone";
    public static final String COLUMN_EMAIL = "contact_email";
    public static final String COLUMN_IMAGE = "image";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ("
                    + COLUMN_IMAGE + " BLOB, "
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_NAME + " TEXT, "
                    + COLUMN_DOB + " TEXT, "
                    + COLUMN_PHONE + " TEXT, "
                    + COLUMN_EMAIL + " TEXT"
                    + ")";

}
