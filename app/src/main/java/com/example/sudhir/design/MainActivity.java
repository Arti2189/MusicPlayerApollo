package com.example.sudhir.design;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    public Button navigation_home;
    public Button navigation_dashboard;
    public Button navigation_notifications;
    public Button songs;

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

    public void init(){
        navigation_home = (Button)findViewById(R.id.navigation_home);
        navigation_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this,navigation_home.class);
                     startActivity(toy);
            }
        });

        navigation_dashboard = (Button)findViewById(R.id.navigation_dashboard);
        navigation_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this,navigation_dashboard.class);
                 startActivity(toy);
            }
        });

        navigation_notifications = (Button)findViewById(R.id.navigation_dashboard);
        navigation_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this,navigation_notifications.class);
                startActivity(toy);
            }
        });

        songs = (Button)findViewById(R.id.songs);
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(MainActivity.this,songs.class);
                 startActivity(toy);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        init();
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
