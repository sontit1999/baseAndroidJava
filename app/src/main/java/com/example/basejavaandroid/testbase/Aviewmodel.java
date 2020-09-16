package com.example.basejavaandroid.testbase;

import androidx.lifecycle.MutableLiveData;

import com.example.basejavaandroid.base.BaseViewmodel;

public class Aviewmodel extends BaseViewmodel {
    MutableLiveData<String> text = new MutableLiveData<>("sơn tít by default");

    public MutableLiveData<String> getText() {
        return text;
    }
    public void upadateText(String textNew){
        text.postValue(textNew);
    }
}
