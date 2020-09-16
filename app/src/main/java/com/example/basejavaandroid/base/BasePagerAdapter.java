package com.example.basejavaandroid.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.basejavaandroid.testbase.Afragment;
import com.example.basejavaandroid.testbase.Bfragment;
import com.example.basejavaandroid.testbase.Cfragment;

import java.util.ArrayList;
import java.util.List;

public class BasePagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> listFragment = new ArrayList<>();
    List<String> listTitle = new ArrayList<>();
    public BasePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }
    public void addFragment(Fragment fragment,String titleFragment){
        listFragment.add(fragment);
        listTitle.add(titleFragment);
    }
}
