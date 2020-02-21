package com.immigration.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.immigration.R;

public class AustralianEducationFragment extends Fragment {

   private RelativeLayout australian_education_page;
   private TextView australian_education_rate_title;
   private TextView per_txt;
   private TextView nxt_txt;
   private RelativeLayout australia_edu_yes_layout_view;

   private RadioGroup radioEducation,radiooneEducation,radiotwoEducation,radiothreeEducation;
   private RadioButton radioYes,radioNo,radioOneYes,radioOneNo,radioTwoYes,radioTwoNo,radioThreeYes,radioThreeNo;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_australian_education, container, false);

      australian_education_page = view.findViewById(R.id.australian_education_page);

      australian_education_rate_title = view.findViewById(R.id.australian_education_rate_title);

      per_txt = view.findViewById(R.id.per_txt);
      nxt_txt = view.findViewById(R.id.nxt_txt);

      radioEducation = view.findViewById(R.id.radioEducation);
      radiooneEducation = view.findViewById(R.id.radiooneEducation);
      radiotwoEducation = view.findViewById(R.id.radiotwoEducation);
      radiothreeEducation = view.findViewById(R.id.radiothreeEducation);
      radioYes = view.findViewById(R.id.radioYes);
      radioNo = view.findViewById(R.id.radioNo);
      radioOneYes = view.findViewById(R.id.radioOneYes);
      radioOneNo = view.findViewById(R.id.radioOneNo);
      radioTwoYes = view.findViewById(R.id.radioTwoYes);
      radioTwoNo = view.findViewById(R.id.radioTwoNo);
      radioThreeYes = view.findViewById(R.id.radioThreeYes);
      radioThreeNo = view.findViewById(R.id.radioThreeNo);

      australia_edu_yes_layout_view = view.findViewById(R.id.australia_edu_yes_layout_view);

      australia_edu_yes_layout_view.setVisibility(View.GONE);

      australian_education_rate_title.setText("");

      radioYes.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radioEducation.getCheckedRadioButtonId();
            Log.e("Bhanu-Yes", String.valueOf(selectedId));
            australian_education_rate_title.setText("Score : " + 65);
            australia_edu_yes_layout_view.setVisibility(View.VISIBLE);
            if(selectedId == radioYes.getId()) {
               radioYes.setChecked(true);
            } else {
               radioNo.setChecked(false);
            }
         }
      });

      radioNo.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radioEducation.getCheckedRadioButtonId();
            Log.e("Bhanu-No", String.valueOf(selectedId));
            australian_education_rate_title.setText("Score : " + 60);
            australia_edu_yes_layout_view.setVisibility(View.GONE);
            if(selectedId == radioNo.getId()) {
               radioNo.setChecked(true);
            } else {
               radioYes.setChecked(false);
            }
         }
      });


      radioOneYes.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radiooneEducation.getCheckedRadioButtonId();
            Log.e("Bhanu-Yes", String.valueOf(selectedId));
            //               australian_education_rate_title.setText("Score : " + 65);
            if(selectedId == radioOneYes.getId()) {
               radioOneYes.setChecked(true);
            } else {
               radioOneNo.setChecked(false);
            }
         }
      });

      radioOneNo.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radiooneEducation.getCheckedRadioButtonId();
            Log.e("Bhanu-No", String.valueOf(selectedId));
            //               australian_education_rate_title.setText("Score : " + 65);
            if(selectedId == radioOneNo.getId()) {
               radioOneNo.setChecked(true);
            } else {
               radioOneYes.setChecked(false);
            }
         }
      });

      radioTwoYes.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radiotwoEducation.getCheckedRadioButtonId();
            Log.e("Bhanu-Yes", String.valueOf(selectedId));
            //               australian_education_rate_title.setText("Score : " + 65);
            if(selectedId == radioTwoYes.getId()) {
               radioTwoYes.setChecked(true);
            } else {
               radioTwoNo.setChecked(false);
            }
         }
      });

      radioTwoNo.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radiotwoEducation.getCheckedRadioButtonId();
            Log.e("Bhanu-No", String.valueOf(selectedId));
            //               australian_education_rate_title.setText("Score : " + 65);
            if(selectedId == radioTwoNo.getId()) {
               radioTwoNo.setChecked(true);
            } else {
               radioTwoYes.setChecked(false);
            }
         }
      });

      radioThreeYes.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radiothreeEducation.getCheckedRadioButtonId();
            Log.e("Bhanu-Yes", String.valueOf(selectedId));
            //               australian_education_rate_title.setText("Score : " + 65);
            if(selectedId == radioThreeYes.getId()) {
               radioThreeYes.setChecked(true);
            } else {
               radioThreeNo.setChecked(false);
            }
         }
      });

      radioThreeNo.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radiothreeEducation.getCheckedRadioButtonId();
            Log.e("Bhanu-No", String.valueOf(selectedId));
            //               australian_education_rate_title.setText("Score : " + 65);
            if(selectedId == radioThreeNo.getId()) {
               radioThreeNo.setChecked(true);
            } else {
               radioThreeYes.setChecked(false);
            }
         }
      });

      per_txt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            per_txt.setBackgroundResource(R.drawable.selected_round);
            nxt_txt.setBackgroundResource(R.drawable.button_round);
            Bundle bundle=new Bundle();
            bundle.putString("SCORE", australian_education_rate_title.getText().toString());
            Fragment fragment = new EnglishFragment();
            FragmentManager fragmentManager = getFragmentManager();
            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
         }
      });

      nxt_txt.setOnClickListener(new View.OnClickListener() {
         @SuppressLint("WrongConstant")
         @Override
         public void onClick(View v) {
            if (australian_education_rate_title.getText().toString().equalsIgnoreCase("")) {
               Toast.makeText(getContext(),"Please Select Education in Australia!",0).show();
            } else {
               Fragment fragment = new AustralianWorkExperienceFragment();
               FragmentManager fragmentManager = getFragmentManager();
//            fragment.setArguments(bundle);
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.replace(R.id.container, fragment);
               fragmentTransaction.addToBackStack(null);
               fragmentTransaction.commit();
            }
         }
      });

      return view;
   }
}