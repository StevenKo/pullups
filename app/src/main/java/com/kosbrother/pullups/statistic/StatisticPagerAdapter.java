package com.kosbrother.pullups.statistic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by steven on 12/19/14.
 */
public class StatisticPagerAdapter extends FragmentPagerAdapter {
    private String[] mTabContents;

    public StatisticPagerAdapter(FragmentManager supportFragmentManager, String[] tabContents) {
        super(supportFragmentManager);

        mTabContents = tabContents;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment kk = new Fragment();
        if (position == 0) {
            kk = BarChartFragment.newInstance("1", "test1");
        } else if (position == 1) {
            kk = RecordListFragment.newInstance("2", "test2");
        }
        return kk;
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
