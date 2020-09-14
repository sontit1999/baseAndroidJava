package com.example.basejavaandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.basejavaandroid.databinding.ActivityMainBinding;
import com.example.basejavaandroid.testbase.BottomSheetDemo;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    BottomSheetDemo bottomSheetDemo = new BottomSheetDemo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 bottomSheetDemo.show(getSupportFragmentManager(),bottomSheetDemo.getTag());
            }
        });
        bottomSheetDemo.setListener(new BottomSheetDemo.SheetCallback() {
            @Override
            public void onCLickCamrera() {
                Toast.makeText(MainActivity.this, "Click camera", Toast.LENGTH_SHORT).show();
            }
        });
    }

}