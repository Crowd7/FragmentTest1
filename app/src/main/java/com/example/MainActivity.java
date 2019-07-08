package com.example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.add(R.id.frameContent, new AFragment());
        tx.commit();
    }

    public void updateActionBarTitle(String str) {
        getSupportActionBar().setTitle(str);
    }

    @Override
    public void onBackPressed() {
        Fragment f = fm.findFragmentById(R.id.frameContent);

        if(f instanceof CFragment){
            ((CFragment)f).customBackPressed();
            return;
        }

        super.onBackPressed();
    }
}
