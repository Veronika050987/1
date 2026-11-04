package com.com.purchaselist;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> shoppingList;
    private ShoppingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etShoppingItem = findViewById(R.id.etShoppingItem);
        Button btnAddItem = findViewById(R.id.btnAddItem);
        ListView lvShoppingList = findViewById(R.id.lvShoppingList);

        shoppingList = new ArrayList<>();
        adapter = new ShoppingAdapter(this, shoppingList);
        lvShoppingList.setAdapter(adapter);

        btnAddItem.setOnClickListener(v -> {
            String inputText = etShoppingItem.getText().toString().trim();

            if (!inputText.isEmpty()) {
                shoppingList.add(inputText);
                adapter.notifyDataSetChanged();
                etShoppingItem.setText("");
            } else {
                Toast.makeText(MainActivity.this, R.string.hint_enter_item,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
