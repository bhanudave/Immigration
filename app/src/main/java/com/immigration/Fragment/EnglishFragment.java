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

public class EnglishFragment extends Fragment {

   private RelativeLayout english_page;
   private LinearLayout english_less_lay, english_comp_lay, english_proficient_lay, english_sup_lay;
   private TextView english_rate_title;
   private TextView per_txt;
   private TextView nxt_txt;
   private TextView english_language_ability_txtx;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_english, container, false);

      english_less_lay = view.findViewById(R.id.english_less_lay);
      english_comp_lay = view.findViewById(R.id.english_comp_lay);
      english_proficient_lay = view.findViewById(R.id.english_proficient_lay);
      english_sup_lay = view.findViewById(R.id.english_sup_lay);

      english_page = view.findViewById(R.id.english_page);

      english_rate_title = view.findViewById(R.id.english_rate_title);

      english_language_ability_txtx = view.findViewById(R.id.english_language_ability_txtx);

      per_txt = view.findViewById(R.id.per_txt);
      nxt_txt = view.findViewById(R.id.nxt_txt);

      english_rate_title.setText("");

      english_less_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            english_less_lay.setBackgroundResource(R.drawable.selected_round);
            english_comp_lay.setBackgroundResource(R.drawable.button_round);
            english_proficient_lay.setBackgroundResource(R.drawable.button_round);
            english_sup_lay.setBackgroundResource(R.drawable.button_round);
            english_rate_title.setText("Score : "+ 40);
            english_language_ability_txtx.setText(R.string.comp_select);
            english_language_ability_txtx.setVisibility(View.INVISIBLE);
         }
      });

      english_comp_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            english_less_lay.setBackgroundResource(R.drawable.button_round);
            english_comp_lay.setBackgroundResource(R.drawable.selected_round);
            english_proficient_lay.setBackgroundResource(R.drawable.button_round);
            english_sup_lay.setBackgroundResource(R.drawable.button_round);
            english_rate_title.setText("Score : "+ 35);
            english_language_ability_txtx.setText(R.string.comp_select);
            english_language_ability_txtx.setVisibility(View.VISIBLE);
         }
      });

      english_proficient_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            english_less_lay.setBackgroundResource(R.drawable.button_round);
            english_comp_lay.setBackgroundResource(R.drawable.button_round);
            english_proficient_lay.setBackgroundResource(R.drawable.selected_round);
            english_sup_lay.setBackgroundResource(R.drawable.button_round);
            english_rate_title.setText("Score : "+ 30);
            english_language_ability_txtx.setText(R.string.prof_select);
            english_language_ability_txtx.setVisibility(View.VISIBLE);
         }
      });

      english_sup_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            english_less_lay.setBackgroundResource(R.drawable.button_round);
            english_comp_lay.setBackgroundResource(R.drawable.button_round);
            english_proficient_lay.setBackgroundResource(R.drawable.button_round);
            english_sup_lay.setBackgroundResource(R.drawable.selected_round);
            english_rate_title.setText("Score : "+ 25);
            english_language_ability_txtx.setText(R.string.super_select);
            english_language_ability_txtx.setVisibility(View.VISIBLE);
         }
      });

      per_txt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            per_txt.setBackgroundResource(R.drawable.selected_round);
            nxt_txt.setBackgroundResource(R.drawable.button_round);
            Bundle bundle=new Bundle();
            bundle.putString("SCORE", english_rate_title.getText().toString());
            Fragment fragment = new WorkExperienceFragment();
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
            Fragment fragment = new AustralianEducationFragment();
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