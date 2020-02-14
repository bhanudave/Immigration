package com.immigration.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.immigration.R;
import com.immigration.Utills.utills;

@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {

   SharedPreferences sharedpreferences;
   private LinearLayout point_cal_lay,profile_lay,blog_lay,expert_query_lay;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_home, container, false);

      sharedpreferences = getContext().getSharedPreferences(utills.MyPREFERENCES, Context.MODE_PRIVATE);

      point_cal_lay = view.findViewById(R.id.point_cal_lay);
      profile_lay = view.findViewById(R.id.profile_lay);
      blog_lay = view.findViewById(R.id.blog_lay);
      expert_query_lay = view.findViewById(R.id.expert_query_lay);

      point_cal_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            loadFragment(new AgeFragment());
         }
      });

      profile_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Bundle bundle=new Bundle();
            bundle.putString("TITLE", "CHOOSE");
            Fragment fragment = new ChooseWorkFragment();
            FragmentManager fragmentManager = getFragmentManager();
            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
         }
      });

      blog_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            loadFragment(new HomeFragment());
         }
      });

      expert_query_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            loadFragment(new QueryFragment());
         }
      });

      return view;
   }

   private void loadFragment(Fragment fragment) {
      // load fragment
      FragmentTransaction transaction = getFragmentManager().beginTransaction();
      transaction.replace(R.id.container, fragment);
      transaction.addToBackStack(null);
      transaction.commit();
   }

}