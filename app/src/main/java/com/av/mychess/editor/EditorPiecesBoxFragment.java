package com.av.mychess.editor;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.av.mychess.CommonStructs.PlayerColor;
import com.av.mychess.R;
import com.av.mychess.chessModel.pieces.Factory;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditorPiecesBoxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditorPiecesBoxFragment extends Fragment {

    ImageButton changeColorButton;
    GridLayout piecesHolder;
    @NotNull
    private PlayerColor mColor = PlayerColor.White;
    private ArrayList<Class> typeList = new ArrayList<>();

    public EditorPiecesBoxFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EditorPiecesBoxFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditorPiecesBoxFragment newInstance() {
        EditorPiecesBoxFragment fragment = new EditorPiecesBoxFragment();
        return fragment;
    }

    public PlayerColor getColor() {
        return mColor;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_editor_pieces_box, container, false);

        //changeColor button:
        changeColorButton = view.findViewById(R.id.changeColor_button);
        changeColorButton.setOnClickListener(v -> {
            PlayerColor newColor = mColor == PlayerColor.White ? PlayerColor.Black : PlayerColor.White;
            mColor = newColor;
            int iconId = mColor == PlayerColor.White ? R.drawable.b_pawn : R.drawable.w_pawn;
            changeColorButton.setImageResource(iconId);

            //todo:

            //change images of all pieces in the box.
        });

        piecesHolder = view.findViewById(R.id.pieces_holder);
        typeList.addAll(Factory.getPieceTypes());
        piecesHolder.setRowCount(1);
        piecesHolder.setColumnCount(typeList.size());
        piecesHolder.setForegroundGravity(Gravity.CENTER_HORIZONTAL);
        int i = 0;
        for (Class aClass : typeList) {
            String name = aClass.getName().toLowerCase();
            name = name.substring(name.lastIndexOf("."));
            String color = mColor == PlayerColor.White ? "w" : "b";
            String resName = mColor + "_" + name + ".png";
            ImageButton piece = new ImageButton(getContext());
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) getResources().getDimension(R.dimen.chess_cell_size);
            params.height = (int) getResources().getDimension(R.dimen.chess_cell_size);
            params.rowSpec = GridLayout.spec(0);
            params.columnSpec = GridLayout.spec(i);
            piece.setLayoutParams(params);
            piece.setImageResource(getContext().getResources().getIdentifier(resName, "drawable", getContext().getOpPackageName()));
            piecesHolder.addView(piece);
            i++;
        }

        return view;
    }
}