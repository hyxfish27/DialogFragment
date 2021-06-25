package com.vickyhuang.dialogfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



public class MainFragment extends Fragment implements MyCustomDialog.OnInputSelected {

    private static final String TAG = "MainFragment";


    @Override
    public void sendInput(String input) {
        Log.d(TAG, "sendInput: found incoming input: " + input);

        mInputDisplay.setText(input);
    }

    private Button mOpenDialog;
    public TextView mInputDisplay;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mOpenDialog = view.findViewById(R.id.openDialog);
        mInputDisplay = view.findViewById(R.id.inputDisplay);

        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: open dialog");

                MyCustomDialog dialog = new MyCustomDialog();
                dialog.setTargetFragment(MainFragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");
            }
        });

        return view;
    }

}
