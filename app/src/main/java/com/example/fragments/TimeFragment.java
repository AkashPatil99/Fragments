package com.example.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TimeFragment extends Fragment {

    private static String ARG_STRING = "arg_string";

    public static TimeFragment newInstance(String string) {
        TimeFragment fragment = new TimeFragment();

        Bundle arguments = new Bundle(1);
        arguments.putString(ARG_STRING, string);
        fragment.setArguments(arguments);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.task1fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("Fragments : ", "onViewCreated: TimeFragment Fragment");
        Toast.makeText(getContext(),"show Time",Toast.LENGTH_SHORT).show();

        view.setBackgroundColor(getResources().getColor(R.color.design_default_color_error));
        TextView tvAnyString = view.findViewById(R.id.text1fragment);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(ARG_STRING);
            tvAnyString.setText(string);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragments : ", "onCreate: TimeFragment Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("Fragments : ", "onPause: TimeFragment Fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragments : ", "onStop: TimeFragment Fragment");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("Fragments : ", "onAttach: TimeFragment Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragments : ", "onDestroyView: TimeFragment Fragment");
        Toast.makeText(getContext(),"hiding Time Fragment",Toast.LENGTH_SHORT).show();

    }
}
