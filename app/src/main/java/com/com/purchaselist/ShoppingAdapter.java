package com.com.purchaselist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;

public class ShoppingAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<String> items;
    public ShoppingAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shopping,
                    parent, false);
        }
    //inflate (или «раздувание») в Android — это процесс превращения XML-файла разметки
        // в реальные объекты интерфейса (View) в коде Java/Kotlin
        TextView tvItemName = convertView.findViewById(R.id.tvItemName);
        ImageButton btnDeleteItem = convertView.findViewById(R.id.btnDeleteItem);

        tvItemName.setText(items.get(position));

        btnDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
