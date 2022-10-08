package com.example.bnm_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SignUpNext extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private DatePickerDialog mDatePickerDialog;
    private Button mDateButton;
    Button mSubmit,msignUpSignIn;
    String mDate,mBGroup,mUsername,mEmail,mPassword,mContactno,mGender;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_next);

        initDatePicker();
        mDateButton = findViewById(R.id.signUpNextDatePicker);
        mDateButton.setText(getTodaysDate());
        mSubmit = findViewById(R.id.signUpSubmitBtn);
        msignUpSignIn = findViewById(R.id.signUpSignInBtn);

        //radio button code

        // on below line we are initializing our variables.
        radioGroup = findViewById(R.id.genderRadioGroup);

        // on below line we are adding check change listener for our radio group.
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // on below line we are getting radio button from our group.
                RadioButton radioButton = findViewById(checkedId);
                mGender = (String) radioButton.getText();
            }
        });

        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Select Blood Group");
        categories.add("A+");
        categories.add("A-");
        categories.add("B+");
        categories.add("B-");
        categories.add("O+");
        categories.add("O-");
        categories.add("AB+");
        categories.add("AB-");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        //firebase data enter
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mUsername = getIntent().getExtras().getString("UserName");
                    mEmail = getIntent().getExtras().getString("Email");
                    mPassword = getIntent().getExtras().getString("Password");
                    mContactno = getIntent().getExtras().getString("Contactno");

                if(mUsername.isEmpty() || mEmail.isEmpty() || mPassword.isEmpty() || mContactno.isEmpty() || mDate.isEmpty() || mBGroup.isEmpty() || mGender.isEmpty()){
                    Toast.makeText(SignUpNext.this, "Please Fill all Fild", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @NonNull
    private String getTodaysDate() {
        Calendar mCal = Calendar.getInstance();
        int mYear = mCal.get(Calendar.YEAR);
        int mMonth = mCal.get(Calendar.MONTH);
        mMonth =mMonth + 1;
        int mDay = mCal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(mDay, mMonth, mYear);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                 month = month + 1;
                 mDate = makeDateString(day, month, year);
                 mDateButton.setText(mDate);
            }
        };
        Calendar mCal = Calendar.getInstance();
        int mYear = mCal.get(Calendar.YEAR);
        int mMonth = mCal.get(Calendar.MONTH);
        int mDay = mCal.get(Calendar.DAY_OF_MONTH);

        int mStyle = AlertDialog.THEME_HOLO_LIGHT;
        mDatePickerDialog = new DatePickerDialog(this, mStyle, dateSetListener, mYear, mMonth, mDay);
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormate(month) + " " + day + ", " + year;
    }

    private String getMonthFormate(int month) {
        String mMonth = null;
        switch (month){
            case 1:
                mMonth = "JAN";
                break;
            case 2:
                mMonth = "FEB";
                break;
            case 3:
                mMonth = "MAR";
                break;
            case 4:
                mMonth = "APR";
                break;
            case 5:
                mMonth = "MAY";
                break;
            case 6:
                mMonth = "JUN";
                break;
            case 7:
                mMonth = "JUL";
                break;
            case 8:
                mMonth = "AUG";
                break;
            case 9:
                mMonth = "SEP";
                break;
            case 10:
                mMonth = "OCT";
                break;
            case 11:
                mMonth = "NOV";
                break;
            case 12:
                mMonth = "DEC";
                break;
            default:
                mMonth = "JAN";
                break;
        }
        return mMonth;
    }

    public void openDatePicker(View view) {
        mDatePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        mBGroup = parent.getItemAtPosition(position).toString();
    }

    public void onNothingSelected(AdapterView<?> arg0) {

    }

}