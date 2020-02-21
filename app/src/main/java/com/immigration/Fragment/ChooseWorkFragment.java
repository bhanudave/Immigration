package com.immigration.Fragment;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.immigration.R;

public class ChooseWorkFragment extends Fragment {

   private RelativeLayout partner_skill_page;
   private TextView choose_work_rate_title;
   private TextView per_txt;
   private TextView nxt_txt;
   private TextView selected_profile_txt;
   private TextView select_profile_txt;
   private LinearLayout pre_post_layout;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_choose_work, container, false);

      partner_skill_page = view.findViewById(R.id.partner_skill_page);

      choose_work_rate_title = view.findViewById(R.id.choose_work_rate_title);

      selected_profile_txt = view.findViewById(R.id.selected_profile_txt);

      per_txt = view.findViewById(R.id.per_txt);
      nxt_txt = view.findViewById(R.id.nxt_txt);

      select_profile_txt = view.findViewById(R.id.select_profile_txt);

      pre_post_layout = view.findViewById(R.id.pre_post_layout);

      String Message = getArguments().getString("TITLE");

      if (Message.equalsIgnoreCase("CHOOSE")) {
         pre_post_layout.setVisibility(View.INVISIBLE);
      }

      choose_work_rate_title.setText("");

      per_txt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            per_txt.setBackgroundResource(R.drawable.selected_round);
            nxt_txt.setBackgroundResource(R.drawable.button_round);
            Bundle bundle=new Bundle();
            bundle.putString("SCORE", choose_work_rate_title.getText().toString());
            Fragment fragment = new DesignedLanguageFragment();
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
         @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
         @Override
         public void onClick(View v) {
            if (selected_profile_txt.getText().toString().equalsIgnoreCase("")) {
               Toast.makeText(getContext(),"Please Select Choose Work!",0).show();
            } else {
               per_txt.setBackgroundResource(R.drawable.button_round);
               nxt_txt.setBackgroundResource(R.drawable.selected_round);
               Fragment fragment = new ReportViewFragment();
               FragmentManager fragmentManager = getFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               fragmentTransaction.replace(R.id.container, fragment);
               fragmentTransaction.addToBackStack(null);
               fragmentTransaction.commit();
            }
         }
      });

      select_profile_txt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
            builderSingle.setIcon(R.drawable.app_logo);
            builderSingle.setTitle("Select Work:-");

            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice);
            arrayAdapter.add("Programing Language");
            arrayAdapter.add("Software Developer");
            arrayAdapter.add("Software Testing");
            arrayAdapter.add("UI Designing");
            arrayAdapter.add("Video Editor");
            arrayAdapter.add("Audio Editor");
            arrayAdapter.add("Web Site Developer");
            arrayAdapter.add("Mobile App Developer");
            arrayAdapter.add("Cleaner");
            arrayAdapter.add("Office Boy");
            arrayAdapter.add("Back Office Work");
            arrayAdapter.add("Fount Office Work ");
            arrayAdapter.add("Banking Sector");
            arrayAdapter.add("Business Marketing");
            arrayAdapter.add("Education");
            arrayAdapter.add("Job Work");

            builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
               }
            });

            builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                  String strName = arrayAdapter.getItem(which);
                  AlertDialog.Builder builderInner = new AlertDialog.Builder(getContext());
                  builderInner.setMessage(strName);
                  builderInner.setTitle("Your Selected Item is");
                  builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog,int which) {
                        selected_profile_txt.setText(strName);
                        dialog.dismiss();
                     }
                  });
                  builderInner.show();
               }
            });
            builderSingle.show();
         }
      });

      return view;
   }
}