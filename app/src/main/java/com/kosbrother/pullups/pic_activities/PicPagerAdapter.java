package com.kosbrother.pullups.pic_activities;

import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by steven on 12/18/14.
 */
public class PicPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabContents;
    private TypedArray mPullupTypesPics;
    private TypedArray mPullupTypesInfos;

    public PicPagerAdapter(FragmentManager fm, String[] tabContents) {
        super(fm);
        mTabContents = tabContents;
    }

    public PicPagerAdapter(FragmentManager supportFragmentManager, String[] tabContents, TypedArray pullupTypesPics, TypedArray pullupTypesInfos) {
        super(supportFragmentManager);
        mTabContents = tabContents;
        mPullupTypesPics = pullupTypesPics;
        mPullupTypesInfos = pullupTypesInfos;
    }

    @Override
    public Fragment getItem(int position) {

        return PicFragment.newInstance(mPullupTypesPics.getResourceId(position, -1),mPullupTypesInfos.getResourceId(position, -1));
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
