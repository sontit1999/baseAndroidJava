package com.example.basejavaandroid.testbase;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.basejavaandroid.MainActivity;
import com.example.basejavaandroid.MainViewModel;
import com.example.basejavaandroid.R;
import com.example.basejavaandroid.base.BaseFragment;
import com.example.basejavaandroid.databinding.FragABinding;

public class Afragment extends BaseFragment<FragABinding,Aviewmodel> {
    MainViewModel mainViewModel;
    @Override
    public Class<Aviewmodel> getViewmodel() {
        return Aviewmodel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_a;
    }

    @Override
    public void setBindingViewmodel() {
        Log.d("sondz","on createView view Frag A");
    }

    @Override
    public void ViewCreated() {
        mainViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("sondz","callback fragment A: " + s);
                binding.textView.setText(s);
            }
        });
        binding.edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                  mainViewModel.upadateText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("sondz","on destroy view Frag A");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("sondz","on create  Frag A");
        MainActivity activity = (MainActivity) getActivity();
        mainViewModel = activity.getViewModel();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("sondz","on destroy Frag A");
    }
}
