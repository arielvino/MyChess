package com.av.mychess.editor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.av.mychess.R;

import org.jetbrains.annotations.Nullable;

public class EditorActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_editor);


    }
}
