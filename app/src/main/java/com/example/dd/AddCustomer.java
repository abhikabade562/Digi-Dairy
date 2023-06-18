package com.example.dd;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddCustomer extends AppCompatActivity {

    private Spinner spinner1;
    //ArrayList<Table> t = new ArrayList<Table>();
    Spinner spnStatus;
    static ArrayList<Long> eid = new ArrayList<Long>();
    EditText txtCapacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcustomer);
        txtCapacity = (EditText) findViewById(R.id.AddTableCapacity300);
//        addItemsOnSpinner();
    }

    // add items into spinner dynamically
//    public void addItemsOnSpinner() {
//
//        spinner1 = (Spinner) findViewById(R.id.TableStatusDropDown300);
//        List<String> list = new ArrayList<String>();
//        list.add("Free");
//        list.add("Booked");
//        list.add("Occupied");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner1.setAdapter(dataAdapter);
//    }

    public void btnBlick(View v) {

        boolean go = true;


        int capacity = Integer.parseInt(txtCapacity.getText().toString());

        if (txtCapacity.getText().toString().length() <= 0) {
            txtCapacity.setError("Fill name ");
            go = false;

        }

        //   int i=txtCapacity.getText().toString().length();
        //     int j=Integer.parseInt(txtCapacity.getText().toString());
        if (txtCapacity.getText().toString().length() > 0 && Integer.parseInt(txtCapacity.getText().toString()) <= 0) {
            // Toast.makeText(this, "Capacity should be greater than 0", Toast.LENGTH_SHORT).show();
            txtCapacity.setError("Capacity should be greater than 0");
            go = false;
        }


        }
    }

