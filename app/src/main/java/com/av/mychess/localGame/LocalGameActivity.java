package com.av.mychess.localGame;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.av.mychess.chessModel.Game;
import com.av.mychess.R;

import org.jetbrains.annotations.Nullable;

public class LocalGameActivity extends AppCompatActivity {
    GameChessBoardFragment board;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_local);

        //todo: get board info and game type from intent.

        //board = findViewById(R.id.board_fragment);
        //board.loadGame(new Game());



    }
}
