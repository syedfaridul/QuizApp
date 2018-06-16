package com.dorvis.quizapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.dorvis.quizapp.R;
import com.dorvis.quizapp.activities.AndroidHomeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidTutorialFragment extends Fragment {
WebView webViewTutorial;
ProgressBar progressBar;

    public AndroidTutorialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_android_tutorial, container, false);
        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        webViewTutorial = (WebView)view.findViewById(R.id.webViewTutorial);
       webViewTutorial.setWebViewClient(new CustomWebViewClient());
        WebSettings webSetting = webViewTutorial.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);
        webViewTutorial.loadUrl("http://androiddorvis.blogspot.com/");
        return view;
    }

    public class CustomWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }

}
