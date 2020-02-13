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

public class DesignedLanguageFragment extends Fragment {

   private RelativeLayout partner_skill_page;
   private TextView designed_language_rate_title;
   private TextView per_txt;
   private TextView nxt_txt;

   private RadioGroup radiodesigned_language;
   private RadioButton radiodesigned_languageYes,radiodesigned_languageNo;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_designed_lauguage, container, false);

      partner_skill_page = view.findViewById(R.id.partner_skill_page);

      designed_language_rate_title = view.findViewById(R.id.designed_language_rate_title);

      radiodesigned_languageYes = view.findViewById(R.id.radiodesigned_languageYes);
      radiodesigned_languageNo = view.findViewById(R.id.radiodesigned_languageNo);

      per_txt = view.findViewById(R.id.per_txt);
      nxt_txt = view.findViewById(R.id.nxt_txt);

      radiodesigned_language = (RadioGroup) view.findViewById(R.id.radiodesigned_language);

      designed_language_rate_title.setText("");

      radiodesigned_languageYes.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radiodesigned_language.getCheckedRadioButtonId();
            Log.e("Bhanu-Yes", String.valueOf(selectedId));
            designed_language_rate_title.setText("Score : "+ 70);
         }
      });

      radiodesigned_languageNo.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radiodesigned_language.getCheckedRadioButtonId();
            Log.e("Bhanu-No", String.valueOf(selectedId));
            designed_language_rate_title.setText("Score : "+ 65);
         }
      });

      per_txt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            per_txt.setBackgroundResource(R.drawable.selected_round);
            nxt_txt.setBackgroundResource(R.drawable.button_round);
            Bundle bundle=new Bundle();
            bundle.putString("SCORE", designed_language_rate_title.getText().toString());
            Fragment fragment = new PartnerSkillFragment();
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
            per_txt.setBackgroundResource(R.drawable.button_round);
            nxt_txt.setBackgroundResource(R.drawable.selected_round);
            Bundle bundle=new Bundle();
            bundle.putString("TITLE", designed_language_rate_title.getText().toString());
            Fragment fragment = new ChooseWorkFragment();
            FragmentManager fragmentManager = getFragmentManager();
            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
         }
      });

      return view;
   }
}