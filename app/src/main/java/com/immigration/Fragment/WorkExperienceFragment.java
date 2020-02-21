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

public class WorkExperienceFragment extends Fragment {

   private RelativeLayout work_experience_page;
   private LinearLayout work_experience8_lay, work_experience5_lay, work_experience3_lay, work_experienceless3_lay;
   private TextView work_experience_rate_title;
   private TextView per_txt;
   private TextView nxt_txt;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_work_exprience, container, false);

      work_experience8_lay = view.findViewById(R.id.work_experience8_lay);
      work_experience5_lay = view.findViewById(R.id.work_experience5_lay);
      work_experience3_lay = view.findViewById(R.id.work_experience3_lay);
      work_experienceless3_lay = view.findViewById(R.id.work_experienceless3_lay);

      work_experience_page = view.findViewById(R.id.work_experience_page);

      work_experience_rate_title = view.findViewById(R.id.work_experience_rate_title);

      per_txt = view.findViewById(R.id.per_txt);
      nxt_txt = view.findViewById(R.id.nxt_txt);

      work_experience_rate_title.setText("");

      work_experience8_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            work_experience8_lay.setBackgroundResource(R.drawable.selected_round);
            work_experience5_lay.setBackgroundResource(R.drawable.button_round);
            work_experience3_lay.setBackgroundResource(R.drawable.button_round);
            work_experienceless3_lay.setBackgroundResource(R.drawable.button_round);
            work_experience_rate_title.setText("Score : "+ 40);
         }
      });

      work_experience5_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            work_experience8_lay.setBackgroundResource(R.drawable.button_round);
            work_experience5_lay.setBackgroundResource(R.drawable.selected_round);
            work_experience3_lay.setBackgroundResource(R.drawable.button_round);
            work_experienceless3_lay.setBackgroundResource(R.drawable.button_round);
            work_experience_rate_title.setText("Score : "+ 35);
         }
      });

      work_experience3_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            work_experience8_lay.setBackgroundResource(R.drawable.button_round);
            work_experience5_lay.setBackgroundResource(R.drawable.button_round);
            work_experience3_lay.setBackgroundResource(R.drawable.selected_round);
            work_experienceless3_lay.setBackgroundResource(R.drawable.button_round);
            work_experience_rate_title.setText("Score : "+ 30);
         }
      });

      work_experienceless3_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            work_experience8_lay.setBackgroundResource(R.drawable.button_round);
            work_experience5_lay.setBackgroundResource(R.drawable.button_round);
            work_experience3_lay.setBackgroundResource(R.drawable.button_round);
            work_experienceless3_lay.setBackgroundResource(R.drawable.selected_round);
            work_experience_rate_title.setText("Score : "+ 25);
         }
      });

      per_txt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            per_txt.setBackgroundResource(R.drawable.selected_round);
            nxt_txt.setBackgroundResource(R.drawable.button_round);
            Bundle bundle=new Bundle();
            bundle.putString("SCORE", work_experience_rate_title.getText().toString());
            Fragment fragment = new QualificationFragment();
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
            if (work_experience_rate_title.getText().toString().equalsIgnoreCase("")) {
               Toast.makeText(getContext(),"Please Select Work Exprience!",0).show();
            } else {
               Fragment fragment = new EnglishFragment();
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