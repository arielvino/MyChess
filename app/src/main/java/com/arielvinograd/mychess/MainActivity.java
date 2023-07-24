package com.arielvinograd.mychess;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button localGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //localGameButton:
        localGameButton = findViewById(R.id.local_game_button);
        localGameButton.setOnClickListener(v -> {
            //todo
        });

        //todo
    }
}