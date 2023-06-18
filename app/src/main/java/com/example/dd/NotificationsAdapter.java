package com.example.dd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.ViewHolder> {

    private Context context;
    private ArrayList<NotificationClass> List;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);

            //  textView = (TextView) itemView.findViewById(R.id.ItemButton);
            //textView2 = (TextView) itemView.findViewById(R.id.t);
        }
    }

    public NotificationsAdapter(Context context, ArrayList<NotificationClass> list) {
        this.context = context;
        this.List = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.admin_notificationitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        TextView item = viewHolder.textView;
        TextView time = viewHolder.textView2;

        NotificationClass n = List.get(i);

        item.setText("Item Name: " + n.getItemName());
        time.setText(n.getTime());
    }

    @Override
    public int getItemCount() {
        return List.size();
    }
}
