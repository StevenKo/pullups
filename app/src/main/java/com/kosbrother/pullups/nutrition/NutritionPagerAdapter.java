package com.kosbrother.pullups.nutrition;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by steven on 12/18/14.
 */
public class NutritionPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabContents;

    public NutritionPagerAdapter(FragmentManager fm, String[] tabContents) {
        super(fm);
        mTabContents = tabContents;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment kk;
        if (position == 0) {
            kk = NutritionIntroFragment.newInstance("1","test1");
        } else {
            kk = NutritionFragment.newInstance(position);
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
