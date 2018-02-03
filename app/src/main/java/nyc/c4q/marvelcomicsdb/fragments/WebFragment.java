package nyc.c4q.marvelcomicsdb.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import nyc.c4q.marvelcomicsdb.R;

public class WebFragment extends Fragment {
    private View rootView;
    private WebView webView;

    public WebFragment() {
        //Empty Constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_web, container, false);

        Bundle bundle = getArguments();

        webView = rootView.findViewById(R.id.broswer);
        webView.loadUrl(bundle.getString("webpage"));

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        return rootView;
    }
}
