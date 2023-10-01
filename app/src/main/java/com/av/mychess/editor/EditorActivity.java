package com.av.mychess.editor;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;
import com.av.mychess.R;
import com.av.mychess.ui.reusable.PiecesBoxFragment;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EditorActivity extends AppCompatActivity implements PiecesBoxFragment.IResultPieceTypeReceiver {
    private ImageButton changeColorButton, deleteButton;
    private PiecesBoxFragment piecesBoxFragment;
    private EditorChessBoardFragment chessBoardFragment;
    private PlayerColor mColor = PlayerColor.White;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_editor);

        //pieces box fragment:
        FragmentManager fragmentManager = getSupportFragmentManager();
        piecesBoxFragment = (PiecesBoxFragment) fragmentManager.findFragmentById(R.id.pieces_box);
        chessBoardFragment = (EditorChessBoardFragment) fragmentManager.findFragmentById(R.id.board_fragment);
        piecesBoxFragment.setPieceSelectedListener(this);

        //changeColor button:
        changeColorButton = findViewById(R.id.changeColor_button);
        changeColorButton.setOnClickListener(v -> {
            PlayerColor newColor = mColor == PlayerColor.White ? PlayerColor.Black : PlayerColor.White;
            mColor = newColor;

            //set the opposite color to the button:
            int iconId = mColor == PlayerColor.White ? R.drawable.b_pawn : R.drawable.w_pawn;
            changeColorButton.setImageResource(iconId);

            //set color to all of the pieces:
            piecesBoxFragment.setColor(newColor);
        });

        //delete button:
        deleteButton = findViewById(R.id.trash_button);
        deleteButton.setImageResource(android.R.drawable.ic_menu_delete);
        deleteButton.setOnClickListener(v -> {
            for (Vector2D location : chessBoardFragment.getSelectedLocations()) {
                EditorChessCellView cellView = (EditorChessCellView) chessBoardFragment.getCell(location);
                cellView.setPiece(null);
            }
        });
    }

    public PlayerColor getColor() {
        return mColor;
    }

    @Override
    public void onPieceSelected(@NonNull Class<IChessPiece> piece) {
        //todo: save to viewmodel.
        for (Vector2D location : chessBoardFragment.getSelectedLocations()) {
            try {
                Constructor<IChessPiece> constructor = piece.getDeclaredConstructor(PlayerColor.class);

                // Create a new instance using the constructor
                IChessPiece instance = (IChessPiece) constructor.newInstance(mColor);
                ((EditorChessCellView) chessBoardFragment.getCell(location)).setPiece(instance);

                // Now you have a new instance of MyClass
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }
}
