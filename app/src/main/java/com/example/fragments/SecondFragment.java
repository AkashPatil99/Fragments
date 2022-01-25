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

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.task2fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d("Fragments : ", "onViewCreated: SecondFragment Fragment");
        Toast.makeText(getContext(),"show Second fragment",Toast.LENGTH_SHORT).show();

        view.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        TextView tvTask2 = view.findViewById(R.id.text2fragment);
        tvTask2.setText("Second Fragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragments : ", "onCreate: SecondFragment Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("Fragments : ", "onPause: SecondFragment Fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragments : ", "onStop: SecondFragment Fragment");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("Fragments : ", "onAttach: SecondFragment Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragments : ", "onDestroyView: SecondFragment Fragment");
        Toast.makeText(getContext(),"hiding Second fragment",Toast.LENGTH_SHORT).show();

    }
}
