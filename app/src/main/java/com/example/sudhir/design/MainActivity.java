package com.example.sudhir.design;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;

                case R.id.songs:
                    mTextMessage.setText(R.string.songs_string);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bookmark_menu:
                Toast.makeText(this, "You have selected Bookmark Menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.speaker:
                Toast.makeText(this, "You have selected Save Menu", Toast.LENGTH_SHORT).show();
                return true;
        }

        switch (item.getItemId()){
            case R.id.downloads:
                Intent intent = new Intent(MainActivity.this,downloads.class);
                 startActivity(intent);
        }

        switch (item.getItemId()){
            case R.id.recommendations:
            Intent intent= new Intent(MainActivity.this,recommendations.class);
            startActivity(intent);
        }

        switch (item.getItemId()){
            case R.id.settings:
                Intent intent=new Intent(MainActivity.this,settings.class);
                startActivity(intent);
        }

        switch(item.getItemId()){
            case R.id.about:
                Intent intent= new Intent(MainActivity.this,about.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }
}
