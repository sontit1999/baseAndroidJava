package com.example.basejavaandroid;

import androidx.lifecycle.MutableLiveData;

import com.example.basejavaandroid.base.BaseViewmodel;

public class MainViewModel extends BaseViewmodel {
    MutableLiveData<String> textMain = new MutableLiveData<>();

    public MutableLiveData<String> getText() {
        return textMain;
    }
    public void upadateText(String textNew){
        textMain.postValue(textNew);
    }
}
