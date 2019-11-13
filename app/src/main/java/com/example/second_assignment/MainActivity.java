package com.example.second_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.second_assignment.models.User;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    final List<User> users = new ArrayList<>();
    String[] userImages = {"bibek", "rijesh", "shreya", "shristi" };
    EditText etFullName, etDOB, etContact, etEmail;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale, rbOther;
    Spinner spCountry;
    Button btnSubmit;
    Button btnView;
    AutoCompleteTextView etImage;

    String fullName,gender,dob, country, email, contact, imageID;

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
        etImage = findViewById(R.id.etImage);
        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbOther = findViewById(R.id.rbOther);
        spCountry = findViewById(R.id.spCountry);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnView = findViewById(R.id.btnView);

        etDOB.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        btnView.setOnClickListener(this);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter(this, R.layout.images,userImages);
        etImage.setAdapter(stringArrayAdapter);
        etImage.setThreshold(1);
    }

    private void setSpinValue() {
        spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                country = adapterView.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Please select country", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        setSpinValue();
        fullName = etFullName.getText().toString();
        email = etEmail.getText().toString();
        dob = etDOB.getText().toString();
        contact = etContact.getText().toString();
        imageID = etImage.getText().toString();
        String uri = "@drawable/"+imageID;
        int resID = getResources().getIdentifier(uri, null, getPackageName());

        if (validate()) {
            if(v.getId() == R.id.btnSubmit){
                users.add(new User(fullName,gender,dob,country,email,contact,resID));
                Toast.makeText(this, "User has been added successfully", Toast.LENGTH_SHORT).show();
            }
        }

        if(v.getId() == R.id.etDOB){
            new DatePickerDialog(this, myDatePicker,
                    calender.get(Calendar.YEAR),
                    calender.get(Calendar.MONTH),
                    calender.get(Calendar.DAY_OF_MONTH)
            ).show();
        }

        if (v.getId() == R.id.btnView){
            Intent intent = new Intent(MainActivity.this,UserListRvActivity.class);
            intent.putExtra("allusers",(Serializable) users);
            startActivity(intent);
        }

    }

    private boolean validate() {
        if (TextUtils.isEmpty(fullName)) {
            etFullName.setError("Enter Name");
            return false;

        }
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Enter Email");
            return false;

        }

        if (TextUtils.isEmpty(dob)) {
            etDOB.setError("Enter DOB");
            return false;

        }
        if (TextUtils.isEmpty(contact)) {
            etContact.setError("Enter Phone");
            return false;

        }
        if (TextUtils.isEmpty(imageID)) {
            etEmail.setError("Enter image");
            return false;

        }
        if (TextUtils.isEmpty(country)) {
            Toast.makeText(this, "Select Country", Toast.LENGTH_SHORT).show();
            return false;

        }
        if(!TextUtils.isDigitsOnly(contact)){
            etContact.setError("Invalid Phone");
            return false;

        }
        if(TextUtils.isEmpty(gender)){
            Toast.makeText(this, "Select Gender", Toast.LENGTH_SHORT).show();
            return false;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Invalid Email");
            return false;
        }

        return true;


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        if (i == R.id.rbMale) {
            gender = "Male";
            Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.rbFemale) {
            gender = "Female";
            Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.rbOther) {
            gender = "Other";
            Toast.makeText(this, "Others", Toast.LENGTH_SHORT).show();
        }
    }
}
