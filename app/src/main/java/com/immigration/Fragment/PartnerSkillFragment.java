package com.immigration.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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

public class PartnerSkillFragment extends Fragment {

   private RelativeLayout partner_skill_page;
   private TextView partner_skill_rate_title;
   private TextView per_txt;
   private TextView nxt_txt;
   private CheckBox One_partner,Two_partner,Three_partner;
   private RelativeLayout with_partner_layout;

   private RadioGroup radioPartner_skill;
   private RadioButton radioPartner_skillYes,radioPartner_skillNo;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_partner_skill, container, false);

      partner_skill_page = view.findViewById(R.id.partner_skill_page);

      partner_skill_rate_title = view.findViewById(R.id.partner_skill_rate_title);

      per_txt = view.findViewById(R.id.per_txt);
      nxt_txt = view.findViewById(R.id.nxt_txt);

      radioPartner_skill = view.findViewById(R.id.radioPartner_skill);
      radioPartner_skillYes = view.findViewById(R.id.radioPartner_skillYes);
      radioPartner_skillNo = view.findViewById(R.id.radioPartner_skillNo);

      One_partner = view.findViewById(R.id.onePartner);
      Two_partner = view.findViewById(R.id.twoPartner);
      Three_partner = view.findViewById(R.id.threePartner);

      with_partner_layout = view.findViewById(R.id.with_partner_layout);

      partner_skill_rate_title.setText("");

      with_partner_layout.setVisibility(View.INVISIBLE);

      radioPartner_skillYes.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radioPartner_skill.getCheckedRadioButtonId();
            Log.e("Bhanu-Yes", String.valueOf(selectedId));
            partner_skill_rate_title.setText("Score : "+ 65);
            with_partner_layout.setVisibility(View.INVISIBLE);
         }
      });

      radioPartner_skillNo.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            int selectedId = radioPartner_skill.getCheckedRadioButtonId();
            Log.e("Bhanu-No", String.valueOf(selectedId));
            partner_skill_rate_title.setText("Score : "+ 60);
            with_partner_layout.setVisibility(View.VISIBLE);
         }
      });

      per_txt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            per_txt.setBackgroundResource(R.drawable.selected_round);
            nxt_txt.setBackgroundResource(R.drawable.button_round);
            Bundle bundle=new Bundle();
            bundle.putString("SCORE", partner_skill_rate_title.getText().toString());
            Fragment fragment = new AustralianWorkExperienceFragment();
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
            int totalamount=0;
            StringBuilder result=new StringBuilder();
            result.append("Selected Items:");
            if(One_partner.isChecked()){
               result.append("1");
//                totalamount+=100;
            }
            if(Two_partner.isChecked()){
               result.append("2");
            }
            if(Three_partner.isChecked()){
               result.append("3");
            }
//            result.append("\nTotal: "+totalamount+"Rs");
            //Displaying the message on the toast
//            Toast.makeText(getContext(), result.toString(), Toast.LENGTH_LONG).show();

            per_txt.setBackgroundResource(R.drawable.button_round);
            nxt_txt.setBackgroundResource(R.drawable.selected_round);
            Fragment fragment = new DesignedLanguageFragment();
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