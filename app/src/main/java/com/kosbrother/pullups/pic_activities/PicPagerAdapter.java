package com.kosbrother.pullups.pic_activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by steven on 12/18/14.
 */
public class PicPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabContents;

    public PicPagerAdapter(FragmentManager fm, String[] tabContents) {
        super(fm);
        mTabContents = tabContents;
    }

    @Override
    public Fragment getItem(int position) {
        return PicFragment.newInstance("2", "test2");
    }

    @Override
    public int getCount() {
        return mTabContents.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabContents[position % mTabContents.length];
    }
}
