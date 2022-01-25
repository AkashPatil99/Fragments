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

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.task1fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("Fragments : ", "onViewCreated: Default Fragment");
        Toast.makeText(getContext(),"Default fragment",Toast.LENGTH_SHORT).show();

        view.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        TextView tvAnyString = view.findViewById(R.id.text1fragment);
        tvAnyString.setText("Default Fragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragments : ", "onCreate: Default Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("Fragments : ", "onPause: Default Fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragments : ", "onStop: Default Fragment");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("Fragments : ", "onAttach: Default Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragments : ", "onDestroyView: Default Fragment");
        Toast.makeText(getContext(),"hiding Default fragment",Toast.LENGTH_SHORT).show();

    }


}
