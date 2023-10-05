package com.av.mychess.editor;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.CommonStructs.Vector2D;
import com.av.mychess.Interfaces.ModelInterfaces.IChessPiece;
import com.av.mychess.R;
import com.av.mychess.XmlFactory;
import com.av.mychess.ui.reusable.InputFieldWithMessageBoxFragment;
import com.av.mychess.ui.reusable.PiecesBoxFragment;

import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class EditorActivity extends AppCompatActivity implements PiecesBoxFragment.IResultPieceTypeReceiver {
    private ImageButton changeColorButton;
    private PiecesBoxFragment piecesBoxFragment;
    private EditorChessBoardFragment chessBoardFragment;
    private InputFieldWithMessageBoxFragment boardNameFragment;
    private PlayerColor mColor = PlayerColor.White;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_editor);

        //pieces box fragment:
        FragmentManager fragmentManager = getSupportFragmentManager();
        piecesBoxFragment = (PiecesBoxFragment) fragmentManager.findFragmentById(R.id.pieces_box);
        chessBoardFragment = (EditorChessBoardFragment) fragmentManager.findFragmentById(R.id.board_fragment);
        boardNameFragment = (InputFieldWithMessageBoxFragment) fragmentManager.findFragmentById(R.id.nameBoard_input);
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
        ImageButton deleteButton = findViewById(R.id.trash_button);
        deleteButton.setImageResource(android.R.drawable.ic_menu_delete);
        deleteButton.setOnClickListener(v -> {
            for (Vector2D location : chessBoardFragment.getSelectedLocations()) {
                EditorChessCellView cellView = (EditorChessCellView) chessBoardFragment.getCell(location);

                assert cellView != null;
                cellView.setPiece(null);
            }
        });

        //save button:
        Button saveButton = findViewById(R.id.saveBoard_button);
        saveButton.setOnClickListener(v -> {
            boardNameFragment.setMessage("");
            String boardName = boardNameFragment.getInputString();
            assert boardName != null;
            if (boardName.contentEquals("")) {
                boardNameFragment.setMessage(getString(R.string.boardName_hint), getColor(R.color.red));
                Toast.makeText(this, getString(R.string.boardName_hint), Toast.LENGTH_SHORT).show();
            } else {
                try {
                    Document xml = chessBoardFragment.getViewModel().exportAsXml();

                    //internal storage:
                    String path = getFilesDir().getAbsolutePath();

                    //create boards directory
                    path += "/" + XmlFactory.BOARDS_DIRECTORY;
                    File dir = new File(path);
                    if (!dir.exists()) {
                        if (!dir.mkdir()) {
                            throw new IOException("Can not create board directory.");
                        }
                    }

                    //create board file:
                    path += "/" + boardName + XmlFactory.BOARD_FILE_EXTENSION;
                    File boardFile = new File(path);
                    if(boardFile.exists()){
                        boardNameFragment.setMessage("Choose different name or location.", getColor(R.color.red));
                        throw new IOException("Board with the same name already exists.");
                    }
                    else {
                        XmlFactory.writeXmlToFile(xml, path);
                    }

                    Toast.makeText(this, "Board created successfully.", Toast.LENGTH_SHORT).show();
                    this.finish();
                } catch (IOException ex) {
                    Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Notice: the initialization continue on onPostCreate() method.
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        //board name input:
        if (boardNameFragment.getView() != null) {
            boardNameFragment.setDescription(getString(R.string.boardName_label));
            boardNameFragment.setInputHint(getString(R.string.boardName_hint));
        }
    }

    public PlayerColor getColor() {
        return mColor;
    }

    @Override
    public void onPieceSelected(@NonNull Class<IChessPiece> piece) {
        for (Vector2D location : chessBoardFragment.getSelectedLocations()) {
            try {
                Constructor<IChessPiece> constructor = piece.getDeclaredConstructor(PlayerColor.class);

                // Create a new instance using the constructor
                IChessPiece instance = (IChessPiece) constructor.newInstance(mColor);
                Objects.requireNonNull(chessBoardFragment.getViewModel().getCell(location)).setPiece(instance);//viewModel
                ((EditorChessCellView) Objects.requireNonNull(chessBoardFragment.getCell(location))).setPiece(instance);//view

            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }

    //prevent accidentally leaving:
    @Override
    public void onBackPressed() {
        // Show a confirmation dialog
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to leave?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    // If the user confirms, finish the activity
                    finish();
                })
                .setNegativeButton("No", null) // Do nothing if the user cancels
                .show();
    }
}
