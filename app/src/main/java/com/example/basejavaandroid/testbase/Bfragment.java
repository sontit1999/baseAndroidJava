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
import com.example.basejavaandroid.databinding.FragBBinding;

public class Bfragment extends BaseFragment<FragBBinding,Aviewmodel> {
    @Override
    public Class<Aviewmodel> getViewmodel() {
        return Aviewmodel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_b;
    }

    @Override
    public void setBindingViewmodel() {
        Log.d("sondz","on createView view Frag B");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("sondz","on create Frag B");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("sondz","on DestroyView view Frag B");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("sondz","on Destroy Frag B");
    }

    @Override
    public void ViewCreated() {
        MainActivity activity = (MainActivity) getActivity();
        activity.getViewModel().getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textView2.setText(s);
                Log.d("sondz","callback fragment B " + s);
            }
        });
        binding.edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainViewModel mainViewModel =  ((MainActivity) getActivity()).getViewModel();
                mainViewModel.upadateText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


}
