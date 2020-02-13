package com.immigration.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

   private RadioGroup radioEducation;
   private RadioButton radioYes,radioNo;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_australian_education, container, false);

      australian_education_page = view.findViewById(R.id.australian_education_page);

      australian_education_rate_title = view.findViewById(R.id.australian_education_rate_title);

      per_txt = view.findViewById(R.id.per_txt);
      nxt_txt = view.findViewById(R.id.nxt_txt);

      radioEducation = view.findViewById(R.id.radioEducation);
      radioYes = view.findViewById(R.id.radioYes);
      radioNo = view.findViewById(R.id.radioNo);

      australia_edu_yes_layout_view = view.findViewById(R.id.australia_edu_yes_layout_view);

      australia_edu_yes_layout_view.setVisibility(View.GONE);

      australian_education_rate_title.setText("");

      radioYes.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radioEducation.getCheckedRadioButtonId();
            Log.e("Bhanu-Yes", String.valueOf(selectedId));
            australian_education_rate_title.setText("Score : "+ 65);
            australia_edu_yes_layout_view.setVisibility(View.VISIBLE);
         }
      });

      radioNo.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radioEducation.getCheckedRadioButtonId();
            Log.e("Bhanu-No", String.valueOf(selectedId));
            australian_education_rate_title.setText("Score : "+ 60);
            australia_edu_yes_layout_view.setVisibility(View.GONE);
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
         @Override
         public void onClick(View v) {
            Fragment fragment = new AustralianWorkExperienceFragment();
            FragmentManager fragmentManager = getFragmentManager();
//            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
         }
      });

      return view;
   }
}