package com.example.a1092tabview;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.a1092tabview.Fragment.Page1;
import com.example.a1092tabview.Fragment.Page2;
import com.example.a1092tabview.Fragment.Page3;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends FragmentPagerAdapter {

    int NumPage;

    public MyAdapter(@NonNull FragmentManager fm, int NumPage) {
        super(fm);
        this.NumPage = NumPage;
    }

    // 當他現在處於第幾個 item 時，會有什麼畫面
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                return new Page1();
            }
            case 1: {
                return new Page2();
            }
            case 2: {
                return new Page3();
            }
        }
        return null;
    }

    // 這個 FragmentAdapter 有多少個 Item
    @Override
    public int getCount() {
        return NumPage;
    }
}
