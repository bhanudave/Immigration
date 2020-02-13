package com.immigration.Registration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;

import com.google.android.material.snackbar.Snackbar;
import com.immigration.Main.HomeActivity;
import com.immigration.R;
import com.immigration.Utills.utills;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

public class RegistrationActivity extends Activity implements View.OnClickListener {

    private Button submit_btn;
    private EditText edtUsername, edtMobile, edtEmail, edtCountry, edtCity, edtPassword, edtUserquery;
    private LinearLayout registration_page;
    private ImageView home_icon, menu_icon;
    SharedPreferences sharedpreferences;
    private int min = 0, max = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        sharedpreferences = getSharedPreferences(utills.MyPREFERENCES, Context.MODE_PRIVATE);

        init();
    }

    private void init() {
        submit_btn = findViewById(R.id.submit_btn);

        edtUsername = findViewById(R.id.edtUsername);
        edtMobile = findViewById(R.id.edtMobile);
        edtEmail = findViewById(R.id.edtEmail);
        edtCountry = findViewById(R.id.edtCountry);
        edtCity = findViewById(R.id.edtCity);
        edtPassword = findViewById(R.id.edtPassword);
        edtUserquery = findViewById(R.id.edtUserquery);

        menu_icon = findViewById(R.id.menu_icon);
        home_icon = findViewById(R.id.home_icon);

        registration_page = findViewById(R.id.registration_page);

        submit_btn.setOnClickListener(this);
        home_icon.setOnClickListener(this);
        menu_icon.setOnClickListener(this);

        menu_icon.setVisibility(View.VISIBLE);
        home_icon.setVisibility(View.VISIBLE);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.submit_btn) {

            if (edtUsername.getText().equals("") && edtUsername.getText().equals(null) && edtUsername.getText().length() == 0) {
                Snackbar.make(registration_page, "Please enter user full name.", Snackbar.LENGTH_LONG).show();

            } else if (edtMobile.getText().equals("") && edtMobile.getText().equals(null) && edtMobile.getText().length() == 0) {
                Snackbar.make(registration_page, "Please enter mobile no..", Snackbar.LENGTH_LONG).show();

            } else if (edtEmail.getText().equals("") && edtEmail.getText().equals(null) && edtEmail.getText().length() == 0) {
                Snackbar.make(registration_page, "Please enter email id.", Snackbar.LENGTH_LONG).show();

            } else if (!EMAIL_ADDRESS_PATTERN.matcher(edtEmail.getText().toString()).matches()) {
                Snackbar.make(registration_page, "Please enter email id.", Snackbar.LENGTH_LONG).show();

            } else if (edtUserquery.getText().equals("") && edtUserquery.getText().equals(null) && edtUserquery.getText().length() == 0) {
                Snackbar.make(registration_page, "Please fill the query.", Snackbar.LENGTH_LONG).show();
            } else if (edtCountry.getText().equals("") && edtCountry.getText().equals(null) && edtCountry.getText().length() == 0) {
                Snackbar.make(registration_page, "Please enter country.", Snackbar.LENGTH_LONG).show();
            } else if (edtCity.getText().equals("") && edtCity.getText().equals(null) && edtCity.getText().length() == 0) {
                Snackbar.make(registration_page, "Please enter city.", Snackbar.LENGTH_LONG).show();
            } else if (edtPassword.getText().equals("") && edtPassword.getText().equals(null) && edtPassword.getText().length() == 0) {
                Snackbar.make(registration_page, "Please enter password.", Snackbar.LENGTH_LONG).show();
            } else if (edtPassword.getText().toString().length() < 8) {
                Snackbar.make(registration_page, "User enter 8 or more than character for password.", Snackbar.LENGTH_LONG).show();
            } else {
//                Snackbar.make(registration_page, "Successfully Submit.", Snackbar.LENGTH_LONG).show();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                int random = ThreadLocalRandom.current().nextInt(min, max);

                editor.putString(utills.ID, String.valueOf(random));
                editor.putString(utills.Name, edtUsername.getText().toString());
                editor.putString(utills.Phone, edtMobile.getText().toString());
                editor.putString(utills.Email, edtEmail.getText().toString());
                editor.commit();

                Intent i = new Intent(RegistrationActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        }

        if (v.getId() == R.id.back_arrow) {
            onBackPressed();
        }

        if (v.getId() == R.id.menu_icon) {
            Snackbar.make(registration_page, "Menu.", Snackbar.LENGTH_LONG).show();
        }

        if (v.getId() == R.id.home_icon) {
            Intent i = new Intent(RegistrationActivity.this, HomeActivity.class);
            startActivity(i);
        }
    }

    public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
                    "(" +
                    "." +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
                    ")+"
    );

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent i = new Intent(RegistrationActivity.this, HomeActivity.class);
        startActivity(i);
        finish();

    }
}
