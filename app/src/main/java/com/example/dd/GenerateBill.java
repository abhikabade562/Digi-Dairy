package com.example.dd;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GenerateBill extends AppCompatActivity{

    EditText name,bill,contact,cusid;
    Spinner type;
    TextView special;
    Button addButton;
    Long it;
    static ArrayList<Long> eid = new ArrayList<Long>();
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    boolean check = false;
    boolean check1 = true;
    //ArrayList<Employee> E = new ArrayList<Employee>();
    String e;
    String p;


    private ListView listView;
    DatabaseReference mDatabase;
   // IngredientsListAdapter ingredientsListAdapter;
    private ArrayList<Item> items = new ArrayList<>();
   // private ArrayList<IngredientRow> ingredients = new ArrayList<>();
    private ArrayList<String> notifications1 = new ArrayList<>();
    private ArrayList<String> notifications2 = new ArrayList<>();

    int idz = 0;
    private FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generate);

        bill=findViewById(R.id.Bill);
        name = (EditText) findViewById(R.id.AddEmployeeName300);
        type = (Spinner) findViewById(R.id.DropDownMenu300);
        contact = (EditText) findViewById(R.id.contact);
        cusid = (EditText) findViewById(R.id.AddEmployeePassword300);
        // specialty = (EditText) findViewById(R.id.AddSpeciality300);
      //  salary = (EditText) findViewById(R.id.AddEmployeeEmail300);
        //  special = (TextView) findViewById(R.id.specialityLabel300);
        addButton = (Button) findViewById(R.id.AddNewEmployeeButton300);
//        type.setOnItemSelectedListener(
//                new AdapterView.OnItemSelectedListener() {
//                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                        String selectedItem = parent.getItemAtPosition(position).toString();
//                        if (selectedItem.equals("Chef") || selectedItem.equals("Head Chef")) {
//                            specialty.setEnabled(true);
//                            specialty.setInputType(InputType.TYPE_CLASS_TEXT);
//                            specialty.setFocusable(true);
//                            specialty.setFocusableInTouchMode(true);
//
//                            special.setEnabled(true);
//                        } else {
//                            specialty.setEnabled(false);
//                            specialty.setInputType(InputType.TYPE_NULL);
//                            specialty.setFocusable(false);
//
//                            special.setEnabled(false);
//                        }
//                        if (selectedItem.equals("Hall Manager") || selectedItem.equals("Head Chef")) {
//                            email.setEnabled(true);
//                            email.setInputType(InputType.TYPE_CLASS_TEXT);
//                            email.setFocusable(true);
//                            email.setFocusableInTouchMode(true);
//
//                            password.setEnabled(true);
//                            password.setInputType(InputType.TYPE_CLASS_TEXT);
//                            password.setFocusable(true);
//                            password.setFocusableInTouchMode(true);
//                            check = true;
//
//                            //special.setEnabled(true);
////                        } else {
//                            email.setEnabled(false);
//                            email.setInputType(InputType.TYPE_NULL);
//                            email.setFocusable(false);
//
//                            password.setEnabled(false);
//                            password.setInputType(InputType.TYPE_NULL);
//                            password.setFocusable(false);
//
//                            //special.setEnabled(false);
//                        }
//                    }
//
//                    public void onNothingSelected(AdapterView<?> parent) {
//
//                    }
//                });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String specialtyText = "";
                boolean go = true;


                if (name.getText().toString().length() <= 0) {
                    name.setError("Name is Required");
                    go = false;
                }
                if (contact.getText().toString().length() <= 0 && (type.getSelectedItem().toString().equals("Head Chef") || type.getSelectedItem().toString().equals("Hall Manager"))) {
                    contact.setError("Email Address is Required");
                    go = false;
                    //check= true;
                }
                if (cusid.getText().toString().length() <= 0 && (type.getSelectedItem().toString().equals("Head Chef") || type.getSelectedItem().toString().equals("Hall Manager"))) {
                    cusid.setError("Password is Required");
                    go = false;
                }
                if (bill.getText().toString().length() > 0 && Integer.parseInt(bill.getText().toString()) < 1) {
                    bill.setError("Salary must be greater than 0");
                    go = false;
                }

                if (go) {

                    DatabaseReference reference;
                    reference = FirebaseDatabase.getInstance().getReference();
                    reference.child("user").child("BILL").child(name.getText().toString()).setValue("contact no " + contact.getText().toString() + "\ncustomer ID" + cusid.getText().toString() + "\nBILL" + bill.getText().toString());


                }
            }
        });
    }
}
