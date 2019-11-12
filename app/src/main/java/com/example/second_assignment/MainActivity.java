package com.example.second_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.second_assignment.models.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etFullName, etDOB, etContact, etEmail;
    RadioGroup rgGender;
    Spinner spCountry;
    Button btnSubmit;
    Button btnView;

    String fullName,gender,dob, country, email, contact;

    String[] countries = {"Nepal", "Bhutan", "India",
            "Srilanka", "Maldives", "Myanmar", "Pakistan", "Afghanistan"};

    List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFullName = findViewById(R.id.etFullName);
        etDOB = findViewById(R.id.etDOB);
        etContact = findViewById(R.id.etContact);
        etEmail = findViewById(R.id.etEmail);
        rgGender = findViewById(R.id.rgGender);
        spCountry = findViewById(R.id.spCountry);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnView = findViewById(R.id.btnView);

    }

}
