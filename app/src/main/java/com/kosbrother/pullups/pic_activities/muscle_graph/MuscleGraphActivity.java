package com.kosbrother.pullups.pic_activities.muscle_graph;

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

public class MuscleGraphActivity extends ActionBarActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_graph);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(getString(R.string.title_activity_muscle_graph));

        setViewPagerAndSlidingTab();
    }

    private void setViewPagerAndSlidingTab() {
        String[] tabContents = getResources().getStringArray(R.array.MuscleSections);
        TypedArray muscles = getResources().obtainTypedArray(R.array.muscles);
        TypedArray musclesInfos = getResources().obtainTypedArray(R.array.musclesInfos);

        PicPagerAdapter adapter = new PicPagerAdapter(getSupportFragmentManager(),tabContents,muscles,musclesInfos);

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
