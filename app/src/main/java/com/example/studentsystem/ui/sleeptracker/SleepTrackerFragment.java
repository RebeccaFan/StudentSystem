package com.example.studentsystem.ui.sleeptracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.studentsystem.R;

public class SleepTrackerFragment extends Fragment {

    private SleepTrackerViewModel sleepTrackerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sleepTrackerViewModel =
                ViewModelProviders.of(this).get(SleepTrackerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sleeptracker, container, false);
        final TextView textView = root.findViewById(R.id.text_sleeptracker);
        sleepTrackerViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}