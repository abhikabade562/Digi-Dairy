package com.example.dd;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddItem extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_add_item);
    }

    public void btnBlick(View v) {

        EditText name = (EditText) findViewById(R.id.AddItemName300);
        EditText price = (EditText) findViewById(R.id.AddItemPrice300);
        String name1=name.getText().toString() , price1=price.getText().toString();
       // EditText quantity = (EditText) findViewById(R.id.AddItemQuantity300);
       // EditText threshold = (EditText) findViewById((R.id.AddItemThreshold300));
        boolean go = true;
        if (name.getText().toString().length() <= 0) {
            name.setError("Name is empty");
            go = false;
        }
        if (price.getText().toString().length() <= 0) {
            price.setError("Price is empty");
            go = false;
        }

        if (price.getText().toString().length() > 0 && Integer.parseInt(price.getText().toString()) < 1) {
            price.setError("Price must be greater than 0");
            go = false;
        }

        if (go==true) {
            Item i = new Item(name1,price1);
            DatabaseReference reference ;
           reference = FirebaseDatabase.getInstance().getReference();
          // reference.child("user").child("item").setValue(new Item(name1,price1));
            //reference.child("user").child("ITEM").child(name.getText().toString()).setValue(new Item(name1,price1),1);
         Map<String,Object>up=new HashMap<>();
         up.put("name",name1);
         up.put("price",price1);


            //reference.child("user").child(name1).updateChildren("name1");
           //DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
           // ref.child("").setValue(i);
            Toast.makeText(this, "Item has been added to the Inventory", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);
            //finish this activity
        }



// Insert the user-defined object to the database


    }
}
