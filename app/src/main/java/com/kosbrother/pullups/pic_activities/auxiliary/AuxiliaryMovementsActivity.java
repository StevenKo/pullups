package com.kosbrother.pullups.pic_activities.auxiliary;

import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android.slidingtab.SlidingTabLayout;
import com.kosbrother.pullups.R;
import com.kosbrother.pullups.pic_activities.PicPagerAdapter;

public class AuxiliaryMovementsActivity extends ActionBarActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliary_movements);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(getString(R.string.title_activity_auxiliary_movements));

        setViewPagerAndSlidingTab();
    }

    private void setViewPagerAndSlidingTab() {
        String[] tabContents = getResources().getStringArray(R.array.AuxiliarySections);
        TypedArray types = getResources().obtainTypedArray(R.array.auxiliary_types);
        TypedArray typesInfo = getResources().obtainTypedArray(R.array.auxiliary_types_infos);

        PicPagerAdapter adapter = new PicPagerAdapter(getSupportFragmentManager(),tabContents,types,typesInfo);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(pager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_statistic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                finish();
                break;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
