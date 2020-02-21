package com.immigration.Fragment;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;
import com.immigration.R;

import static com.immigration.Utills.utills.EMAIL_ADDRESS_PATTERN;

@SuppressLint("ValidFragment")
public class QueryFragment extends Fragment {

    private RelativeLayout age_page;
    private Button submit_btn;
    private EditText edtUsername, edtMobile, edtEmail, edtProfile, edtUserquery;
    private LinearLayout query_page;
    private ImageView home_icon, menu_icon;
    SharedPreferences sharedpreferences;
    private TextView query_rate_title;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_query, container, false);

        submit_btn = view.findViewById(R.id.submit_btn);

        edtUsername = view.findViewById(R.id.edtUsername);
        edtMobile = view.findViewById(R.id.edtMobile);
        edtEmail = view.findViewById(R.id.edtEmail);
        edtProfile = view.findViewById(R.id.edtProfile);
        edtUserquery = view.findViewById(R.id.edtUserquery);

        query_page = view.findViewById(R.id.query_page);

        query_rate_title = view.findViewById(R.id.query_rate_title);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUsername.getText().length() == 0) {
                    Snackbar.make(query_page, "Please enter user full name.", Snackbar.LENGTH_LONG).show();

                } else if (edtMobile.getText().length() == 0) {
                    Snackbar.make(query_page, "Please enter mobile no..", Snackbar.LENGTH_LONG).show();

                } else if (edtEmail.getText().length() == 0) {
                    Snackbar.make(query_page, "Please enter email id.", Snackbar.LENGTH_LONG).show();

                } else if (!EMAIL_ADDRESS_PATTERN.matcher(edtEmail.getText().toString()).matches()) {
                    Snackbar.make(query_page, "Please enter valid email id.", Snackbar.LENGTH_LONG).show();

                } else if (edtProfile.getText().length() == 0) {
                    Snackbar.make(query_page, "Please enter profile.", Snackbar.LENGTH_LONG).show();

                } else if (edtUserquery.getText().length() == 0) {
                    Snackbar.make(query_page, "Please fill the query.", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(query_page, "Successfully Submit.", Snackbar.LENGTH_LONG).show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Fragment fragment = new HomeFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.container, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    }, 1000);
                }
            }
        });

        return view;
    }
}