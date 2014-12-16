package com.kosbrother.pullups;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by steven on 12/15/14.
 */
public class IndexPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabContents;

    public IndexPagerAdapter(FragmentManager supportFragmentManager, String[] tabContents) {
        super(supportFragmentManager);

        mTabContents = tabContents;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment kk = new Fragment();
        if (position == 0) {
            kk = IndexTrainFragment.newInstance("1","test1");
        } else if (position == 1) {
            kk = IndexSummaryFragment.newInstance("2","test2");
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
