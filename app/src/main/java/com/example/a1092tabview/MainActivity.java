package com.example.a1092tabview;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.example.a1092tabview.Fragment.Page1;
import com.example.a1092tabview.Fragment.Page2;
import com.example.a1092tabview.Fragment.Page3;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1, tab2, tab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        tab1 = findViewById(R.id.Tab1);
        tab2 = findViewById(R.id.Tab2);
        tab3 = findViewById(R.id.Tab3);

        // 使Tab 盡可能充滿
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        // 傳參數總共有幾個長度
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        // 設定 Adapter
        viewPager.setAdapter(myAdapter);

        // 設定 TabLayOut 點擊是要跳到哪個 Item
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            // 被選到
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
//                tabLayout.getTabAt(tab.getPosition()).select();
            }
            // Tab 沒有被選到
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            // Tab 重複選到
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // 如果沒有＋的話，當我點擊 Do 的 Tab的話，他底下的白色線就不會產生變化。
        // ViewPager 當他更改時會觸發
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            // 當滾動當前頁面時
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            // 當選擇新頁面時，呼叫此方法。
            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();
            }
            // 滾動狀態更改時調用。對於發現用戶何時開始拖動，何時自動將分頁器穩定到當前頁面或頁面何時完全停止/空閒非常有用。
            // 詳細請看 https://developer.android.com/reference/kotlin/androidx/viewpager/widget/ViewPager.OnPageChangeListener
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}