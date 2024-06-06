package com.example.j052_tee_mad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        menuButton = findViewById(R.id.menuButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                intent.putExtra("NAME", name);
                startActivity(intent);
            }
        });
    }
}
