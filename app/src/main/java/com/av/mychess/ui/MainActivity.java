package com.av.mychess.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.av.mychess.R;
import com.av.mychess.editor.EditorActivity;
import com.av.mychess.localGame.LocalGameActivity;

public class MainActivity extends AppCompatActivity {

    Button localGameButton, editorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //localGameButton:
        localGameButton = findViewById(R.id.local_game_button);
        localGameButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, LocalGameActivity.class);
            //todo: pass board info
            //todo: pass game type
            startActivity(intent);
        });

        //editor button:
        editorButton =  findViewById(R.id.board_editor_button);
        editorButton.setOnClickListener(v ->{
            Intent intent = new Intent(this, EditorActivity.class);
            //todo: optional loading of an existing board.
            startActivity(intent);
        });

        //todo rest of buttons.
        //todo


    }
}