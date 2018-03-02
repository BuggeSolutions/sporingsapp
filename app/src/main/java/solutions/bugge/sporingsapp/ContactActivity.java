package solutions.bugge.sporingsapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.MenuItem;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    TextView phoneNumber;

    /**
     * Listener for navigation items. Starts MainActivity.
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_search:
                    startActivity(new Intent(ContactActivity.this,MainActivity.class));
                    return true;
                case R.id.navigation_contact:
                    return true;
            }
            return false;
        }
    };

    /**
     * Main method that initializes the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        phoneNumber = findViewById(R.id.txtPhoneNumberView);
        Linkify.addLinks(phoneNumber, Linkify.ALL);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
