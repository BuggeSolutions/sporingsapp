package solutions.bugge.sporingsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class TraceActivity extends AppCompatActivity {

    WebView mWebView;
    TextView parcelLocationView;
    TextView parcelDeliveryTimeView;
    String parcelLocation;
    String parcelDeliveryTime;
    Double coordsLang;
    Double coordsLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trace);

        // Create dummy data
        Double testCoordsLang = 62.7385103;
        Double testCoordsLong = 8.1021172;
        String testParcelLocation = "Buggestranda";
        String testParcelDeliveryTime = "12:00 - 01/03/2018";

        // Set dummy data
        coordsLang = testCoordsLang;
        coordsLong = testCoordsLong;
        parcelLocation = testParcelLocation;
        parcelDeliveryTime = testParcelDeliveryTime;

        parcelLocationView = findViewById(R.id.txtLocationInfoView);
        parcelDeliveryTimeView = findViewById(R.id.txtDeliveryInforView);
        parcelLocationView.setText(parcelLocation);
        parcelDeliveryTimeView.setText(parcelDeliveryTime);

        mWebView = findViewById(R.id.webParcelLocationView);
        WebSettings mWebViewSettings = mWebView.getSettings();
        mWebViewSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("http://maps.googleapis.com/maps/api/staticmap?center=" + coordsLang + "," + coordsLong + "&zoom=14&format=png&sensor=false&size=500x500&maptype=hybrid");
    }
}
