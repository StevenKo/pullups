package com.kosbrother.pullups;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.android.slidingtab.SlidingTabLayout;
import com.kosbrother.pullups.alert_setting.AlertSettingActivity;
import com.kosbrother.pullups.auxiliary.AuxiliaryMovementsActivity;
import com.kosbrother.pullups.go_pro.GoProActivity;
import com.kosbrother.pullups.muscle_graph.MuscleGraphActivity;
import com.kosbrother.pullups.navigation.NavigationDrawerCallbacks;
import com.kosbrother.pullups.navigation.NavigationDrawerFragment;
import com.kosbrother.pullups.nutrition.NutritionActivity;
import com.kosbrother.pullups.pullups_type.PullupsTypesActivity;
import com.kosbrother.pullups.statistic.StatisticActivity;
import com.kosbrother.pullups.training_program.TrainingProgramActivity;
import com.kosbrother.pullups.warmups.WarmupsActivity;


public class IndexActivity extends ActionBarActivity implements NavigationDrawerCallbacks {

    private Toolbar mToolbar;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private String[] tabContents;
    private ViewPager pager;
    private SlidingTabLayout mSlidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        setToolBar();
        setViewPagerAndSlidingTab();
    }

    private void setViewPagerAndSlidingTab() {
        tabContents = getResources().getStringArray(R.array.indexSections);
        IndexPagerAdapter adapter = new IndexPagerAdapter(getSupportFragmentManager(),tabContents);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(pager);

    }

    private void setToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.index, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch (position){
            case 0:
                Intent statisticyIntent = new Intent(this, StatisticActivity.class);
                startActivity(statisticyIntent);
                break;
            case 1:
                Intent trainingIntent = new Intent(this, TrainingProgramActivity.class);
                startActivity(trainingIntent);
                break;
            case 2:
                Intent pullupsIntent = new Intent(this, PullupsTypesActivity.class);
                startActivity(pullupsIntent);
                break;
            case 3:
                Intent wramupsIntent = new Intent(this, WarmupsActivity.class);
                startActivity(wramupsIntent);
                break;
            case 4:
                Intent auxiliaryIntent = new Intent(this, AuxiliaryMovementsActivity.class);
                startActivity(auxiliaryIntent);
                break;
            case 5:
                Intent muscleIntent = new Intent(this, MuscleGraphActivity.class);
                startActivity(muscleIntent);
                break;
            case 6:
                Intent nutritionIntent = new Intent(this, NutritionActivity.class);
                startActivity(nutritionIntent);
                break;
            case 7:
                Intent alertIntent = new Intent(this, AlertSettingActivity.class);
                startActivity(alertIntent);
                break;
            case 8:
                Intent proIntent = new Intent(this, GoProActivity.class);
                startActivity(proIntent);
                break;
        }
        Toast.makeText(this, "Menu item selected -> " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }
}
