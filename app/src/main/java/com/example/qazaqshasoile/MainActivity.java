package com.example.qazaqshasoile;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom;
    StudyFragment studyFragment = new StudyFragment();
    TestFragment testFragment = new TestFragment();
    MenFragment menFragment = new MenFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom = findViewById(R.id.bottom_navigation_view);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,studyFragment).commit();
          bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                  switch (item.getItemId()){
                      case R.id.nav_study:
                          getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,studyFragment).commit();
                          return true;
                          case R.id.nav_quiz:
                              getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,testFragment).commit();
                  return true;
                      case R.id.nav_men:
                          getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,menFragment).commit();
                          return  true;
                  }

                  return false;
              }
          });
    }

}
