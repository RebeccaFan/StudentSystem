package com.example.studentsystem.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This app is made by 2 TUD students with the goal of helping student life at college easier," +
                "and have features like timetable, BrightSpace, attendance monitoring in one app.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}