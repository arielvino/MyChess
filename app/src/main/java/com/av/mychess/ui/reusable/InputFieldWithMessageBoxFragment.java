package com.av.mychess.ui.reusable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;

import com.av.mychess.R;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class InputFieldWithMessageBoxFragment extends Fragment {


    TextView description, messageBox;
    EditText inputBox;

    public InputFieldWithMessageBoxFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_field_with_message_box, container, false);
        inputBox = view.findViewById(R.id.inputBox);
        description = view.findViewById(R.id.description_label);
        messageBox = view.findViewById(R.id.message_box);
        return view;
    }

    public String getMessage() {
        return messageBox.getText().toString();
    }

    /**
     * This method allow you to show the user info about the input he had provided.
     *
     * @param message - the message to show.
     */
    public void setMessage(@NotNull String message) {
        messageBox.setText(message);
    }

    /**
     * This method allow you to show the user info about the input he had provided.
     * Also you can specify the text color for the message.
     *
     * @param message   - the message to show.
     * @param textColor - the text color for the message.
     */
    public void setMessage(@NotNull String message, @ColorInt int textColor) {
        messageBox.setText(message);
        messageBox.setTextColor(textColor);
    }

    public String getDescription() {
        return description.getText().toString();
    }

    public void setDescription(@NotNull String description) {
        this.description.setText(description);
    }

    public String getInputString() {
        return inputBox.getText().toString();
    }

    public void enterInputString(@NotNull String input) {
        inputBox.setText(input);
    }

    @ColorInt
    public int getMessageTextColor() {
        return messageBox.getCurrentTextColor();
    }

    public void setInputHint(@NotNull String hint){
        inputBox.setHint(hint);
    }
}