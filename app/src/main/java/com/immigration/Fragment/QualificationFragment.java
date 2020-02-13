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

public class QualificationFragment extends Fragment {


   private RelativeLayout qualification_page;
   private LinearLayout recognised_phd_lay, recognised_deg_lay, recognised_trade_lay, recognised_no_lay;
   private TextView qualification_rate_title;
   private TextView per_txt;
   private TextView nxt_txt;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_qualification, container, false);

      recognised_phd_lay = view.findViewById(R.id.recognised_phd_lay);
      recognised_deg_lay = view.findViewById(R.id.recognised_deg_lay);
      recognised_trade_lay = view.findViewById(R.id.recognised_trade_lay);
      recognised_no_lay = view.findViewById(R.id.recognised_no_lay);

      qualification_page = view.findViewById(R.id.qualification_page);

      qualification_rate_title = view.findViewById(R.id.qualification_rate_title);

      per_txt = view.findViewById(R.id.per_txt);
      nxt_txt = view.findViewById(R.id.nxt_txt);

      qualification_rate_title.setText("");

      recognised_phd_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            recognised_phd_lay.setBackgroundResource(R.drawable.selected_round);
            recognised_deg_lay.setBackgroundResource(R.drawable.button_round);
            recognised_trade_lay.setBackgroundResource(R.drawable.button_round);
            recognised_no_lay.setBackgroundResource(R.drawable.button_round);
            qualification_rate_title.setText("Score : "+ 45);
         }
      });

      recognised_deg_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            recognised_phd_lay.setBackgroundResource(R.drawable.button_round);
            recognised_deg_lay.setBackgroundResource(R.drawable.selected_round);
            recognised_trade_lay.setBackgroundResource(R.drawable.button_round);
            recognised_no_lay.setBackgroundResource(R.drawable.button_round);
            qualification_rate_title.setText("Score : "+ 40);
         }
      });

      recognised_trade_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            recognised_phd_lay.setBackgroundResource(R.drawable.button_round);
            recognised_deg_lay.setBackgroundResource(R.drawable.button_round);
            recognised_trade_lay.setBackgroundResource(R.drawable.selected_round);
            recognised_no_lay.setBackgroundResource(R.drawable.button_round);
            qualification_rate_title.setText("Score : "+ 35);
         }
      });

      recognised_no_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            recognised_phd_lay.setBackgroundResource(R.drawable.button_round);
            recognised_deg_lay.setBackgroundResource(R.drawable.button_round);
            recognised_trade_lay.setBackgroundResource(R.drawable.button_round);
            recognised_no_lay.setBackgroundResource(R.drawable.selected_round);
            qualification_rate_title.setText("Score : "+ 25);
         }
      });

      per_txt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            per_txt.setBackgroundResource(R.drawable.selected_round);
            nxt_txt.setBackgroundResource(R.drawable.button_round);
            Bundle bundle=new Bundle();
            bundle.putString("SCORE", qualification_rate_title.getText().toString());
            Fragment fragment = new AgeFragment();
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
            Fragment fragment = new WorkExperienceFragment();
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