package com.stevenswang.app.testrotateviewpage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jason.component.rotateviewpage.ZoomOutPageTransformer;

public class MainActivity extends AppCompatActivity {
    private static final int NUM_PAGES = 5;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setBackgroundColor(Color.BLUE);
        mPagerAdapter = new ScreenSlidePagerAdapter(getFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageMargin(-50);
        mPager.setPageTransformer(true,new ZoomOutPageTransformer(mPager));
    }
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position, getCount());
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public float getPageWidth(int position) {
            return 1.0f;
        }
    }
}
