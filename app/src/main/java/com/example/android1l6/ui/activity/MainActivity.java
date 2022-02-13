package com.example.android1l6.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android1l6.R;
import com.example.android1l6.ui.fragments.first.FirstFragment;
import com.example.android1l6.ui.fragments.second.SecondFragment;
import com.example.android1l6.ui.fragments.third.ThirdFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment, new ThirdFragment()).commit();
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment1, new SecondFragment()).commit();
        }


    }
}

