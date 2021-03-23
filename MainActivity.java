package com.example.demo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        btnAdd=findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {
            DBHelper helper=new DBHelper(MainActivity.this, null, null, 1);
            EmployeeData data=new EmployeeData(etName.getText().toString());
            long id=helper.add(data);
            data.setId(id);
            Toast.makeText(MainActivity.this, Long.toString(id), Toast.LENGTH_SHORT).show();
        });
    }
}