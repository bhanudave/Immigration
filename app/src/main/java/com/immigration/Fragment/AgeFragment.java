package com.immigration.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.immigration.R;

@SuppressLint("ValidFragment")
public class AgeFragment extends Fragment {

   private RelativeLayout age_page;
   private LinearLayout under18_lay, between1824_lay, between2532_lay, between3339_lay, between4044_lay, more_45_lay;
   private TextView age_rate_title;
   private TextView nxt_txt;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_age, container, false);

      under18_lay = view.findViewById(R.id.under18_lay);
      between1824_lay = view.findViewById(R.id.between1824_lay);
      between2532_lay = view.findViewById(R.id.between2532_lay);
      between3339_lay = view.findViewById(R.id.between3339_lay);
      between4044_lay = view.findViewById(R.id.between4044_lay);
      more_45_lay = view.findViewById(R.id.more_45_lay);

      age_page = view.findViewById(R.id.age_page);

      age_rate_title = view.findViewById(R.id.age_rate_title);

      nxt_txt = view.findViewById(R.id.nxt_txt);

      under18_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            under18_lay.setBackgroundResource(R.drawable.selected_round);
            between1824_lay.setBackgroundResource(R.drawable.button_round);
            between2532_lay.setBackgroundResource(R.drawable.button_round);
            between3339_lay.setBackgroundResource(R.drawable.button_round);
            between4044_lay.setBackgroundResource(R.drawable.button_round);
            more_45_lay.setBackgroundResource(R.drawable.button_round);
            age_rate_title.setText("Score : " + 0);
         }
      });

      between1824_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            under18_lay.setBackgroundResource(R.drawable.button_round);
            between1824_lay.setBackgroundResource(R.drawable.selected_round);
            between2532_lay.setBackgroundResource(R.drawable.button_round);
            between3339_lay.setBackgroundResource(R.drawable.button_round);
            between4044_lay.setBackgroundResource(R.drawable.button_round);
            more_45_lay.setBackgroundResource(R.drawable.button_round);
            age_rate_title.setText("Score : " + 25);
         }
      });

      between2532_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            under18_lay.setBackgroundResource(R.drawable.button_round);
            between1824_lay.setBackgroundResource(R.drawable.button_round);
            between2532_lay.setBackgroundResource(R.drawable.selected_round);
            between3339_lay.setBackgroundResource(R.drawable.button_round);
            between4044_lay.setBackgroundResource(R.drawable.button_round);
            more_45_lay.setBackgroundResource(R.drawable.button_round);
            age_rate_title.setText("Score : " + 30);
         }
      });

      between3339_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            under18_lay.setBackgroundResource(R.drawable.button_round);
            between1824_lay.setBackgroundResource(R.drawable.button_round);
            between2532_lay.setBackgroundResource(R.drawable.button_round);
            between3339_lay.setBackgroundResource(R.drawable.selected_round);
            between4044_lay.setBackgroundResource(R.drawable.button_round);
            more_45_lay.setBackgroundResource(R.drawable.button_round);
            age_rate_title.setText("Score : " + 25);
         }
      });

      between4044_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            under18_lay.setBackgroundResource(R.drawable.button_round);
            between1824_lay.setBackgroundResource(R.drawable.button_round);
            between2532_lay.setBackgroundResource(R.drawable.button_round);
            between3339_lay.setBackgroundResource(R.drawable.button_round);
            between4044_lay.setBackgroundResource(R.drawable.selected_round);
            more_45_lay.setBackgroundResource(R.drawable.button_round);
            age_rate_title.setText("Score : " + 15);
         }
      });

      more_45_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            under18_lay.setBackgroundResource(R.drawable.button_round);
            between1824_lay.setBackgroundResource(R.drawable.button_round);
            between2532_lay.setBackgroundResource(R.drawable.button_round);
            between3339_lay.setBackgroundResource(R.drawable.button_round);
            between4044_lay.setBackgroundResource(R.drawable.button_round);
            more_45_lay.setBackgroundResource(R.drawable.selected_round);
            age_rate_title.setText("Score : " + 0);
         }
      });

      nxt_txt.setOnClickListener(new View.OnClickListener() {
         @SuppressLint("WrongConstant")
         @Override
         public void onClick(View v) {
            if (age_rate_title.getText().toString().equalsIgnoreCase("")) {
               Toast.makeText(getContext(),"Please Select Age!",0).show();
            } else {
               nxt_txt.setBackgroundResource(R.drawable.selected_round);
               Bundle bundle = new Bundle();
               bundle.putString("SCORE", age_rate_title.getText().toString());
               Fragment fragment = new QualificationFragment();
               FragmentManager fragmentManager = getFragmentManager();
               fragment.setArguments(bundle);
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.replace(R.id.container, fragment);
               fragmentTransaction.addToBackStack(null);
               fragmentTransaction.commit();
            }
         }
      });

      age_rate_title.setText("");

      return view;
   }
}