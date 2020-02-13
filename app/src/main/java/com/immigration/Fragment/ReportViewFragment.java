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

public class ReportViewFragment extends Fragment {

    private RelativeLayout report_detail_page;
    private TextView profile_detail, job_description;
    private LinearLayout detail_lay, profile_details_layout, job_description_layout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report_view, container, false);

        report_detail_page = view.findViewById(R.id.report_detail_page);

        profile_detail = view.findViewById(R.id.profile_detail);
        job_description = view.findViewById(R.id.job_description);

        profile_details_layout = view.findViewById(R.id.profile_details_layout);
        job_description_layout = view.findViewById(R.id.job_description_layout);
        detail_lay = view.findViewById(R.id.detail_lay);

        profile_details_layout.setVisibility(View.VISIBLE);
        job_description_layout.setVisibility(View.GONE);

        profile_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile_details_layout.setVisibility(View.VISIBLE);
                job_description_layout.setVisibility(View.GONE);
            }
        });

        job_description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile_details_layout.setVisibility(View.GONE);
                job_description_layout.setVisibility(View.VISIBLE);
            }
        });

        detail_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ReportWebviewFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}