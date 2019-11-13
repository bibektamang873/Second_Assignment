package com.example.second_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.second_assignment.models.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etFullName, etDOB, etContact, etEmail;
    RadioGroup rgGender;
    Spinner spCountry;
    Button btnSubmit;
    Button btnView;

    String fullName,gender,dob, country, email, contact;

    List<User> userList = new ArrayList<>();

    Calendar calender = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            calender.set(Calendar.YEAR,year);
            calender.set(Calendar.MONTH,month);
            calender.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            String myDateFormat = "dd-MM-y";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myDateFormat, Locale.getDefault());
            etDOB.setText(simpleDateFormat.format(calender.getTime()));
        }
    };

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

        etDOB.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        btnView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

     if(v.getId() == R.id.etDOB){
        new DatePickerDialog(this, myDatePicker,
                calender.get(Calendar.YEAR),
                calender.get(Calendar.MONTH),
                calender.get(Calendar.DAY_OF_MONTH)
        ).show();
     }

    }
}
