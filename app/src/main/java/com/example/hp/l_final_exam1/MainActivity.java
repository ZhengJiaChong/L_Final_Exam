package com.example.hp.l_final_exam1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.hp.l_final_exam1.ui.fragment.MeFragment;
import com.example.hp.l_final_exam1.ui.fragment.MsgFragment;
import com.example.hp.l_final_exam1.ui.fragment.NewsFragment;
import com.example.hp.l_final_exam1.ui.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,BottomNavigationBar.OnTabSelectedListener{
    private BottomNavigationBar mBottomNavigationBar;
    private List<Fragment> mFragments;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void init() {
        mFragments = new ArrayList<>();
        mFragments.add(new NewsFragment());
        mFragments.add(new VideoFragment());
        mFragments.add(new MsgFragment());
        mFragments.add(new MeFragment());
//        ...
        mViewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.nav_circle_selector,"新闻"))
                .addItem(new BottomNavigationItem(R.drawable.nav_find_selector,"视频"))
                .addItem(new BottomNavigationItem(R.drawable.nav_message_selector,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.nav_me_selector,"我的"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();
        mViewPager.addOnPageChangeListener(this);
        mBottomNavigationBar.setTabSelectedListener(this);
    }

    private void initView() {
        mBottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
        mViewPager = (ViewPager)findViewById(R.id.view_pager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
//        ...
        mBottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(int position) {
        mViewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
