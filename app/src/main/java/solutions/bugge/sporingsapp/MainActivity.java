package solutions.bugge.sporingsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Main activity where the application start
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Listener for navigation items. Starts Contactactivity.
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_search:
                    return true;
                case R.id.navigation_contact:
                    startActivity(new Intent(MainActivity.this,ContactActivity.class));
                    return true;
            }
            return false;
        }
    };


    /**
     * Set TextField txtError
     * @param message   the error message
     */
    private void setErrorText(String message){
        TextView txtError = findViewById(R.id.txtError);
        txtError.setText(message);
    }

    /**
     * Set listener and onClick action for Button btnSearch
     */
    private void btnSearchAction(){
        ImageButton btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText txtSearch = findViewById(R.id.txtSearch);
                if (!txtSearch.getText().toString().equals("")) { // Check if the field is empty
                    int numSearch = Integer.parseInt(txtSearch.getText().toString());
                    if (numSearch < 100){
                        setErrorText("Koden din er for kort");
                    }
                    else {
                        startActivity(new Intent(MainActivity.this,MapActivity.class));
                    }
                }
                else { setErrorText("Koden din er for kort"); }

            }
        });
    }

    /**
     * Main method that initializes the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearchAction();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
