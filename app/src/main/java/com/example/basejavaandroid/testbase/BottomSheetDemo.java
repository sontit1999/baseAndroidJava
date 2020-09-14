package com.example.basejavaandroid.testbase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.basejavaandroid.R;
import com.example.basejavaandroid.base.BaseBottomSheet;
import com.example.basejavaandroid.databinding.BottomsheetBinding;

public class BottomSheetDemo extends BaseBottomSheet<BottomsheetBinding> {
    public void setListener(SheetCallback listener) {
        this.listener = listener;
    }

    SheetCallback listener;
    @Override
    public int getLayoutID() {
        return R.layout.bottomsheet;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("sondz","OnCreate bottom sheet");
    }

    @Override
    public void ViewCreated() {
        Log.d("sondz","ViewCreate bottom sheet");
        binding.tvBtnAddPhotoCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    listener.onCLickCamrera();
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("sondz","destroyview bottom sheet");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("sondz","Destroy bottom sheet");
    }
    public interface SheetCallback{
        void onCLickCamrera();
    }
}
