package com.dmitry.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView plList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plList = findViewById(R.id.tv_pl_list);

        String[] names = {"Java", "Python", "JavaScript", "C++", "C", "C#",
                "Swift", "Go", "Lisp", "Rust", "Dart", "Ruby"};

        plList.setText("");
        for(String s: names) {
            plList.append(s + "\n");
        }
    }
}
