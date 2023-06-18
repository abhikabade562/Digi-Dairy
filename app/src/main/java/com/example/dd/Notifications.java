package com.example.dd;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import android.content.Context;
        import android.content.pm.ActivityInfo;
        import android.net.ConnectivityManager;
        import android.net.NetworkInfo;
        import android.os.Bundle;
        import android.util.Log;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.RecyclerView;


        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;

/*check notification for low threshold items in inventory on button click*/

public class Notifications extends AppCompatActivity {

    ArrayList<NotificationClass> notifications = new ArrayList<NotificationClass>();
    NotificationsAdapter notificationsAdapter;
    RecyclerView rvNotifications;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(); //firebase database ka object get kia
    DatabaseReference databaseReference = firebaseDatabase.getReference("notification"); //table lia

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);     //  Fixed Portrait orientation

        //       // rvNotifications = (RecyclerView) findViewById(R.id.NotificationsRecyclerView301);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        rvNotifications.setLayoutManager(linearLayoutManager);
//        rvNotifications.setItemAnimator(new DefaultItemAnimator());
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvNotifications.getContext(), linearLayoutManager.getOrientation());
//        rvNotifications.addItemDecoration(dividerItemDecoration);
//        rvNotifications.setHasFixedSize(true);
//        rvNotifications.setOverScrollMode(View.OVER_SCROLL_NEVER);
//
//
//
//
//        /*pupulating in recycer view from firebase*/
//        if (isNetworkAvaliable(this)) {
//            databaseReference.addValueEventListener(new ValueEventListener() {
//                com.dineout.code.Owner.NotificationClass notification;
//
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
//                        notification = dsp.getValue(NotificationClass.class);
//                        if (notification != null) {
//                            notifications.add(0, notification);
//                        }
//                    }
//                    notificationsAdapter = new NotificationsAdapter(getBaseContext(), notifications);
//                    rvNotifications.setAdapter(notificationsAdapter);
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//                    Log.d("Database Error: ", databaseError.toString());
//                }
//            });
//        } else {
//
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(getApplicationContext(), "Network not available. Turn on WIFI/4G/3G", Toast.LENGTH_LONG).show();
//                }
//            });
//        }
    }

    public static boolean isNetworkAvaliable(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED) || (connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState() == NetworkInfo.State.CONNECTED)) {
            return true;
        } else {
            return false;
        }
    }

    /*change color on "read" item name, time read*/
    /*on notification read color will be back to normal using read flag*/
    @Override
    public void onBackPressed() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            NotificationClass notification;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    notification = dsp.getValue(NotificationClass.class);
                    if (notification != null) {
                        databaseReference.child(dsp.getKey()).child("read").setValue(true);
                    }
                }
                notificationsAdapter = new NotificationsAdapter(getBaseContext(),notifications);
                rvNotifications.setAdapter(notificationsAdapter);
                databaseReference.removeEventListener(this);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Database Error: ", databaseError.toString());
            }
        });
        finish();
    }
}
