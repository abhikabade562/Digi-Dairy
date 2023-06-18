package com.example.dd;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class KeepNote extends AppCompatActivity{

    Spinner days;
    String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keepnote);
        // days = (Spinner) findViewById(R.id.SelectDayDropDown301);

    }

    public void onClickReg13(View v) {
        selectedItem = days.getSelectedItem().toString();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("EndOfWeek").setValue(selectedItem);
        Toast.makeText(KeepNote.this, "Set End of Child Successful.", Toast.LENGTH_SHORT).show();

    }
}
