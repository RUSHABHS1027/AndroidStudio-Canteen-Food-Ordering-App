package com.example.j052_tee_mad;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_2 extends AppCompatActivity {

    TextView welcomeTextView;
    Spinner menuSpinner;
    ImageView menuItemImageView;
    Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        welcomeTextView = findViewById(R.id.welcomeTextView);
        menuSpinner = findViewById(R.id.menuSpinner);
        menuItemImageView = findViewById(R.id.menuItemImageView);
        orderButton = findViewById(R.id.orderButton);

        String name = getIntent().getStringExtra("NAME");
        welcomeTextView.setText("HELLO " + name +  " what would you like to order today?");

        String[] menuItems = {"Select Item","Idli","Punjabi Thali","Samosa","Springroll"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, menuItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menuSpinner.setAdapter(adapter);

        menuSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        menuItemImageView.setImageResource(R.drawable.idli);
                        break;
                    case 2:
                        menuItemImageView.setImageResource(R.drawable.punjabithali);
                        break;
                    case 3:
                        menuItemImageView.setImageResource(R.drawable.samosa);
                        break;
                    case 4:
                        menuItemImageView.setImageResource(R.drawable.springroll);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItem = menuSpinner.getSelectedItem().toString();
                if (!selectedItem.equals("Select Item")) {
                    Toast.makeText(Activity_2.this, "Order successfully placed for " + selectedItem, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Activity_2.this, "Please select an item to order", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}