package solutions.bugge.sporingsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class TraceActivity extends AppCompatActivity {

    WebView mWebView;
    Double testCoordsLang;
    Double testCoordsLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trace);

        mWebView = findViewById(R.id.webParcelLocationView);
        WebSettings mWebViewSettings = mWebView.getSettings();
        mWebViewSettings.setJavaScriptEnabled(true);
        testCoordsLang = 62.7385103;
        testCoordsLong = 8.1021172;
        mWebView.loadUrl("http://maps.googleapis.com/maps/api/staticmap?center=" + testCoordsLang + "," + testCoordsLong + "&zoom=14&format=png&sensor=false&size=500x500&maptype=hybrid");
    }
}
