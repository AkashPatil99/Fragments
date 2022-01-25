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

public class DateFragment extends Fragment {

    private static String ARG_STRING = "arg_string";

    public static DateFragment newInstance(String string) {
        DateFragment fragment = new DateFragment();

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

        Log.d("Fragments : ", "onViewCreated: DateFragment Fragment");
        Toast.makeText(getContext(),"show Date Fragment",Toast.LENGTH_SHORT).show();

        view.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
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
        Log.d("Fragments : ", "onCreate: DateFragment Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("Fragments : ", "onPause: DateFragment Fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragments : ", "onStop: DateFragment Fragment");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("Fragments : ", "onAttach: DateFragment Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragments : ", "onDestroyView: DateFragment Fragment");
        Toast.makeText(getContext(),"hiding Date Fragment",Toast.LENGTH_SHORT).show();

    }
}
