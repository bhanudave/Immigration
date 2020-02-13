package com.immigration.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.immigration.R;

public class AustralianWorkExperienceFragment extends Fragment {

   private RelativeLayout australian_work_experience_page;
   private LinearLayout australian_work_experience8_lay, australian_work_experience5_lay,
           australian_work_experience3_lay, australian_work_experience1_lay,australian_work_experienceless1_lay;
   private TextView australian_work_experience_rate_title;
   private TextView per_txt;
   private TextView nxt_txt;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_australian_work_exprience, container, false);

      australian_work_experience8_lay = view.findViewById(R.id.australian_work_experience8_lay);
      australian_work_experience5_lay = view.findViewById(R.id.australian_work_experience5_lay);
      australian_work_experience3_lay = view.findViewById(R.id.australian_work_experience3_lay);
      australian_work_experience1_lay = view.findViewById(R.id.australian_work_experience1_lay);
      australian_work_experienceless1_lay = view.findViewById(R.id.australian_work_experienceless1_lay);

      australian_work_experience_page = view.findViewById(R.id.australian_work_experience_page);

      australian_work_experience_rate_title = view.findViewById(R.id.australian_work_experience_rate_title);

      per_txt = view.findViewById(R.id.per_txt);
      nxt_txt = view.findViewById(R.id.nxt_txt);

      australian_work_experience_rate_title.setText("");

      australian_work_experience8_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            australian_work_experience8_lay.setBackgroundResource(R.drawable.selected_round);
            australian_work_experience5_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience3_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience1_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experienceless1_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience_rate_title.setText("Score : "+ 80);
         }
      });

      australian_work_experience5_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            australian_work_experience8_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience5_lay.setBackgroundResource(R.drawable.selected_round);
            australian_work_experience3_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience1_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experienceless1_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience_rate_title.setText("Score : "+ 75);
         }
      });

      australian_work_experience3_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            australian_work_experience8_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience5_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience3_lay.setBackgroundResource(R.drawable.selected_round);
            australian_work_experience1_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experienceless1_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience_rate_title.setText("Score : "+ 70);
         }
      });

      australian_work_experience1_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            australian_work_experience8_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience5_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience3_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience1_lay.setBackgroundResource(R.drawable.selected_round);
            australian_work_experienceless1_lay.setBackgroundResource(R.drawable.selected_round);
            australian_work_experience_rate_title.setText("Score : "+ 65);
         }
      });

      australian_work_experience1_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            australian_work_experience8_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience5_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience3_lay.setBackgroundResource(R.drawable.button_round);
            australian_work_experience1_lay.setBackgroundResource(R.drawable.selected_round);
            australian_work_experienceless1_lay.setBackgroundResource(R.drawable.selected_round);
            australian_work_experience_rate_title.setText("Score : "+ 60);
         }
      });

      per_txt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            per_txt.setBackgroundResource(R.drawable.selected_round);
            nxt_txt.setBackgroundResource(R.drawable.button_round);
            Bundle bundle=new Bundle();
            bundle.putString("SCORE", australian_work_experience_rate_title.getText().toString());
            Fragment fragment = new AustralianEducationFragment();
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
            Fragment fragment = new PartnerSkillFragment();
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