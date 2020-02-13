package com.immigration.Fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {

   SharedPreferences sharedpreferences;
   private LinearLayout point_cal_lay,profile_lay,blog_lay,expert_query_lay;
   private String csv;

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

      csv = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyCsvFile.csv");

      blog_lay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

            /*CSVWriter writer = null;
            try {
               writer = new CSVWriter(new FileWriter(csv));

               List<String[]> data = new ArrayList<String[]>();
               data.add(new String[]{"Country", "Capital"});
               data.add(new String[]{"India", "New Delhi"});
               data.add(new String[]{"United States", "Washington D.C"});
               data.add(new String[]{"Germany", "Berlin"});

               writer.writeAll(data); // data is adding to csv

               writer.close();
               callRead();
            } catch (IOException e) {
               e.printStackTrace();
            }*/

            loadFragment(new HomeFragment());
            /*try {
               exportEmailInCSV();
            } catch (IOException e) {
               e.printStackTrace();
            }*/
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

   private void callRead() {
      Intent emailIntent = new Intent(Intent.ACTION_SEND);
      emailIntent.setType("text/plain");
      emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"email@example.com"});
      emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject here");
      emailIntent.putExtra(Intent.EXTRA_TEXT, "body text");

      File file = new File(csv);
      Uri uri = Uri.fromFile(file);
      emailIntent.putExtra(Intent.EXTRA_STREAM, uri);
      startActivity(Intent.createChooser(emailIntent, "Pick an Email provider"));
   }

   private void loadFragment(Fragment fragment) {
      // load fragment
      FragmentTransaction transaction = getFragmentManager().beginTransaction();
      transaction.replace(R.id.container, fragment);
      transaction.addToBackStack(null);
      transaction.commit();
   }

   public void exportEmailInCSV() throws IOException {
      {

         File folder = new File(Environment.getExternalStorageDirectory()
                 + "/Folder");

         boolean var = false;
         if (!folder.exists())
            var = folder.mkdir();

         System.out.println("" + var);


         final String filename = folder.toString() + "/" + "Test.csv";

         // show waiting screen
         CharSequence contentTitle = getString(R.string.app_name);
         final ProgressDialog progDailog = ProgressDialog.show(
                 getContext(), contentTitle, "even geduld aub...",
                 true);//please wait
         final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {




            }
         };

         new Thread() {
            public void run() {
               try {

                  FileWriter fw = new FileWriter(filename);

//                  Cursor cursor = db.selectAll();

                  fw.append("No");
                  fw.append(',');

                  fw.append("code");
                  fw.append(',');

                  fw.append("nr");
                  fw.append(',');

                  fw.append("Orde");
                  fw.append(',');

                  fw.append("Da");
                  fw.append(',');

                  fw.append("Date");
                  fw.append(',');

                  fw.append("Leverancier");
                  fw.append(',');

                  fw.append("Baaln");
                  fw.append(',');

                  fw.append("asd");
                  fw.append(',');

                  fw.append("Kwaliteit");
                  fw.append(',');

                  fw.append("asd");
                  fw.append(',');

                  fw.append('\n');

                  /*if (cursor.moveToFirst()) {
                     do {
                        fw.append(cursor.getString(0));
                        fw.append(',');

                        fw.append(cursor.getString(1));
                        fw.append(',');

                        fw.append(cursor.getString(2));
                        fw.append(',');

                        fw.append(cursor.getString(3));
                        fw.append(',');

                        fw.append(cursor.getString(4));
                        fw.append(',');

                        fw.append(cursor.getString(5));
                        fw.append(',');

                        fw.append(cursor.getString(6));
                        fw.append(',');

                        fw.append(cursor.getString(7));
                        fw.append(',');

                        fw.append(cursor.getString(8));
                        fw.append(',');

                        fw.append(cursor.getString(9));
                        fw.append(',');

                        fw.append(cursor.getString(10));
                        fw.append(',');

                        fw.append('\n');

                     } while (cursor.moveToNext());
                  }
                  if (cursor != null && !cursor.isClosed()) {
                     cursor.close();
                  }*/

                  // fw.flush();
                  fw.close();

               } catch (Exception e) {
               }
               handler.sendEmptyMessage(0);
               progDailog.dismiss();
            }
         }.start();

      }

   }
}