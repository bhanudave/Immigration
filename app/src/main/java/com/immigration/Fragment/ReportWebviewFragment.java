package com.immigration.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.immigration.R;

public class ReportWebviewFragment extends Fragment {

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_webbiew, container, false);

      WebView myWebView = (WebView) view.findViewById(R.id.webview);
      WebSettings webSettings = myWebView.getSettings();
      webSettings.setJavaScriptEnabled(true);
      myWebView.loadUrl("https://aspiresquare.com/");  //http://www.example.com

      return view;
   }
}