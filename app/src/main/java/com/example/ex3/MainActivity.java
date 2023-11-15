package com.example.ex3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private EditText edtName, edtDob, edtPhone, edtEmail;
    private ImageView imgAvatar;
    private Button btnSave, btnChooseImage, btnDetails;
    private ActionBar actionBar;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();


        findById();
        db = new DatabaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveContact();
            }
        });

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContactDetails.class));
            }
        });

        btnChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
    }

    public void findById() {
        edtName = findViewById(R.id.edtName);
        edtDob = findViewById(R.id.edtDob);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        imgAvatar = findViewById(R.id.imgAvatar);

        btnSave = findViewById(R.id.btnSave);
        btnChooseImage = findViewById(R.id.btnChooseImage);
        btnDetails = findViewById(R.id.btnDetails);
    }

    public void saveContact(){
        String name = edtName.getText().toString().trim();
        String dob = edtDob.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();

        if (name.isEmpty() || dob.isEmpty() || phone.isEmpty() || email.isEmpty() ) {
            Toast.makeText(this, "Information cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        BitmapDrawable drawable = (BitmapDrawable) imgAvatar.getDrawable();
        if (drawable == null) {
            Toast.makeText(this, "Please choose an image", Toast.LENGTH_SHORT).show();
            return;
        }

        Bitmap bitmap = drawable.getBitmap();
        byte[] imageBytes = getBytesFromBitmap(bitmap);

        long result = db.insertContact(name, dob, phone, email, imageBytes);

        if(result != -1){
            // Clear input fields and reset image
            edtName.setText("");
            edtDob.setText("");
            edtPhone.setText("");
            edtEmail.setText("");

            imgAvatar.setImageResource(R.drawable.logo);

            Toast.makeText(this, "Contact saved successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Contact saved NOT successfully", Toast.LENGTH_SHORT).show();
        }

    }
    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(imageUri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgAvatar.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
}