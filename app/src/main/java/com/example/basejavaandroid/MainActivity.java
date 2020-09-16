package com.example.basejavaandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.basejavaandroid.base.BaseActivity;
import com.example.basejavaandroid.base.BasePagerAdapter;
import com.example.basejavaandroid.databinding.ActivityMainBinding;
import com.example.basejavaandroid.testbase.Afragment;
import com.example.basejavaandroid.testbase.Bfragment;
import com.example.basejavaandroid.testbase.BottomSheetDemo;
import com.example.basejavaandroid.testbase.Cfragment;


public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> {
    BasePagerAdapter adapter ;
    BottomSheetDemo bottomSheetDemo = new BottomSheetDemo();

    private void setupViewPageAndTablayout() {
        adapter = new BasePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Afragment(),"A");
        adapter.addFragment(new Bfragment(),"B");
        adapter.addFragment(new Cfragment(),"C");
        binding.pager.setAdapter(adapter);
        binding.tablayout.setupWithViewPager(binding.pager);
    }

    private void event() {

        bottomSheetDemo.setListener(new BottomSheetDemo.SheetCallback() {
            @Override
            public void onCLickCamrera() {
                Toast.makeText(MainActivity.this, "Click camera", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public Class<MainViewModel> getViewmodel() {
        return MainViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void setBindingViewmodel() {
          setupViewPageAndTablayout();
    }
    public MainViewModel getViewModel(){
        return viewmodel;
    }
}