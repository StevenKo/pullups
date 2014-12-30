package com.kosbrother.pullups.alert_setting;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.kosbrother.pullups.R;

import java.util.AbstractMap;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlertSettingActivity extends ActionBarActivity {

    private String defaultTime = "00:00";
    private final static String MONDAY = "MONDAY";
    private final static String TUESDAY = "TUESDAY";
    private final static String WEDNESDAY = "WEDNESDAY";
    private final static String THURSDAY = "THURSDAY";
    private final static String FRIDAY = "FRIDAY";
    private final static String SATURDAY = "SATURDAY";
    private final static String SUNDAY = "SUNDAY";
    private static final AbstractMap<String, Integer> ALARM_MAP = new HashMap<String, Integer>();

    private static String MONDAY_CHECK = "MONDAY_CHECK";
    private static String TUESDAY_CHECK = "TUESDAY_CHECK";
    private static String WEDNESDAY_CHECK = "WEDNESDAY_CHECK";
    private static String THURSDAY_CHECK = "THURSDAY_CHECK";
    private static String FRIDAY_CHECK = "FRIDAY_CHECK";
    private static String SATURDAY_CHECK = "SATURDAY_CHECK";
    private static String SUNDAY_CHECK = "SUNDAY_CHECK";


    static{
        ALARM_MAP.put(MONDAY,111);
        ALARM_MAP.put(TUESDAY,112);
        ALARM_MAP.put(WEDNESDAY,113);
        ALARM_MAP.put(THURSDAY,114);
        ALARM_MAP.put(FRIDAY,115);
        ALARM_MAP.put(SATURDAY,116);
        ALARM_MAP.put(SUNDAY,117);
    }

    private Toolbar mToolbar;
    private CheckBox mondayCheck;
    private CheckBox wendesdayCheck;
    private CheckBox thursdayCheck;
    private CheckBox tuesdayCheck;
    private CheckBox fridayCheck;
    private CheckBox saturdayCheck;
    private CheckBox sundayCheck;
    private RelativeLayout mondayRelativeLayout;
    private RelativeLayout tuesdayRelativeLayout;
    private RelativeLayout wendesdayRelativeLayout;
    private RelativeLayout thirsdayRelativeLayout;
    private RelativeLayout fridayRelativeLayout;
    private RelativeLayout saturdayRelativeLayout;
    private RelativeLayout sundayRelativeLayout;

    private TextView mondayTime;
    private TextView tuesdayTime;
    private TextView wendesdayTime;
    private TextView thirsdayTime;
    private TextView fridayTime;
    private TextView saturdayTime;
    private TextView sundayTime;

    private TimePickerDialog timePickerDialog;

    private String mondayString;
    private String tuesdayString;
    private String wendesdayString;
    private String thirsdayString;
    private String fridayString;
    private String saturdayString;
    private String sundayString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_setting);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(getString(R.string.title_activity_alert_setting));

        findViews();
        setTimeText();
        setcheckbox();
        setLayout();
    }

    private void setLayout() {
        setLayoutListener(mondayRelativeLayout,mondayString,MONDAY,mondayTime,mondayCheck);
        setLayoutListener(tuesdayRelativeLayout,tuesdayString,TUESDAY,tuesdayTime,tuesdayCheck);
        setLayoutListener(wendesdayRelativeLayout,wendesdayString,WEDNESDAY,wendesdayTime,wendesdayCheck);
        setLayoutListener(thirsdayRelativeLayout,thirsdayString,THURSDAY,thirsdayTime,thursdayCheck);
        setLayoutListener(fridayRelativeLayout,fridayString,FRIDAY,fridayTime,fridayCheck);
        setLayoutListener(saturdayRelativeLayout,saturdayString,SATURDAY,saturdayTime,saturdayCheck);
        setLayoutListener(sundayRelativeLayout,sundayString,SUNDAY,sundayTime,sundayCheck);
    }

    private void setcheckbox() {
        setCheckBoxListener(mondayCheck,mondayTime,mondayString,MONDAY,mondayRelativeLayout, MONDAY_CHECK);
        setCheckBoxListener(tuesdayCheck,tuesdayTime,tuesdayString,TUESDAY,tuesdayRelativeLayout, TUESDAY_CHECK);
        setCheckBoxListener(wendesdayCheck,wendesdayTime,wendesdayString,WEDNESDAY,wendesdayRelativeLayout, WEDNESDAY_CHECK);
        setCheckBoxListener(thursdayCheck,thirsdayTime,thirsdayString,THURSDAY,thirsdayRelativeLayout,THURSDAY_CHECK);
        setCheckBoxListener(fridayCheck,fridayTime,fridayString,FRIDAY,fridayRelativeLayout,FRIDAY_CHECK);
        setCheckBoxListener(saturdayCheck,saturdayTime,saturdayString,SATURDAY,saturdayRelativeLayout,SATURDAY_CHECK);
        setCheckBoxListener(sundayCheck,sundayTime,sundayString,SUNDAY,sundayRelativeLayout,SUNDAY_CHECK);

        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        mondayCheck.setChecked(prefs.getBoolean(MONDAY_CHECK, false));
        tuesdayCheck.setChecked(prefs.getBoolean(TUESDAY_CHECK,false));
        wendesdayCheck.setChecked(prefs.getBoolean(WEDNESDAY_CHECK,false));
        thursdayCheck.setChecked(prefs.getBoolean(THURSDAY_CHECK,false));
        fridayCheck.setChecked(prefs.getBoolean(FRIDAY_CHECK,false));
        saturdayCheck.setChecked(prefs.getBoolean(SATURDAY_CHECK,false));
        sundayCheck.setChecked(prefs.getBoolean(SUNDAY_CHECK,false));
    }

    private void setLayoutListener(RelativeLayout layout, final String timeString, final String pref, final TextView timeTextView,final CheckBox check) {
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(timeString,pref,timeTextView,check);
            }
        });
    }

    private void setTimeText() {
        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        mondayString = prefs.getString(MONDAY, defaultTime);
        tuesdayString = prefs.getString(TUESDAY, defaultTime);
        wendesdayString = prefs.getString(WEDNESDAY, defaultTime);
        thirsdayString = prefs.getString(THURSDAY, defaultTime);
        fridayString = prefs.getString(FRIDAY, defaultTime);
        saturdayString = prefs.getString(SATURDAY, defaultTime);
        sundayString = prefs.getString(SUNDAY, defaultTime);

        mondayTime.setText(mondayString);
        tuesdayTime.setText(tuesdayString);
        wendesdayTime.setText(wendesdayString);
        thirsdayTime.setText(thirsdayString);
        fridayTime.setText(fridayString);
        saturdayTime.setText(saturdayString);
        sundayTime.setText(sundayString);
    }

    private void showTimePickerDialog(final String timeString, final String pref, final TextView timeTxtView, final CheckBox check) {

        final SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        Pattern sPattern = Pattern.compile("^([0-9][0-9]{0,2}):([0-9][0-9]{0,2})");
        Matcher m = sPattern.matcher(timeString);
        if(m.matches()){
            timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            prefs.edit().putString(pref, String.format("%02d", hourOfDay) + ":" + String.format("%02d", minute)).commit();
                            setTimeText();
                            if(check.isChecked())
                                setAlamanager(hourOfDay,minute,pref);
                        }
                    }, Integer.parseInt(m.group(1).toString()), Integer.parseInt(m.group(2).toString()), false);

            timePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    timeTxtView.setText(timeString);
                }
            });

            timePickerDialog.show();
        }
    }

    private void setAlamanager(String time, String pref){
        Pattern sPattern = Pattern.compile("^([0-9][0-9]{0,2}):([0-9][0-9]{0,2})");
        Matcher m = sPattern.matcher(time);
        if(m.matches()){
            int hour = Integer.parseInt(m.group(1).toString());
            int minute = Integer.parseInt(m.group(2).toString());
            setAlamanager(hour, minute,pref);
        }
    }

    private void setAlamanager(int hour,int minute,String pref) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        switch(pref){
            case MONDAY:
                calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
                break;
            case TUESDAY:
                calendar.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
                break;
            case WEDNESDAY:
                calendar.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
                break;
            case THURSDAY:
                calendar.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
                break;
            case FRIDAY:
                calendar.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
                break;
            case SATURDAY:
                calendar.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
                break;
            case SUNDAY:
                calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
                break;
        }
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), ALARM_MAP.get(pref), new Intent(getApplicationContext(), AlarmReceiver.class), PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        if(System.currentTimeMillis() < calendar.getTimeInMillis()){
            am.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pi);
        }else{
            calendar.add(Calendar.DATE,7);
            am.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY*7, pi);
        }
    }

    private void cancleAlarm(String pref){
        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), ALARM_MAP.get(pref), new Intent(getApplicationContext(), AlarmReceiver.class), PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        am.cancel(pi);
    }

    private void findViews() {
        mondayCheck = (CheckBox)findViewById(R.id.monday_checkbox);
        tuesdayCheck = (CheckBox)findViewById(R.id.tuesday_checkbox);
        wendesdayCheck = (CheckBox)findViewById(R.id.wendesday_checkbox);
        thursdayCheck = (CheckBox)findViewById(R.id.thirsday_checkbox);
        fridayCheck = (CheckBox)findViewById(R.id.friday_checkbox);
        saturdayCheck = (CheckBox)findViewById(R.id.saturday_checkbox);
        sundayCheck = (CheckBox)findViewById(R.id.sunday_checkbox);

        mondayRelativeLayout = (RelativeLayout)findViewById(R.id.monday);
        tuesdayRelativeLayout = (RelativeLayout)findViewById(R.id.tuesday);
        wendesdayRelativeLayout = (RelativeLayout)findViewById(R.id.wendesday);
        thirsdayRelativeLayout = (RelativeLayout)findViewById(R.id.thirsday);
        fridayRelativeLayout = (RelativeLayout)findViewById(R.id.friday);
        saturdayRelativeLayout = (RelativeLayout)findViewById(R.id.saturday);
        sundayRelativeLayout = (RelativeLayout)findViewById(R.id.sunday);

        mondayTime = (TextView)findViewById(R.id.monday_time);
        tuesdayTime = (TextView)findViewById(R.id.tuesday_time);
        wendesdayTime = (TextView)findViewById(R.id.wendesday_time);
        thirsdayTime = (TextView)findViewById(R.id.thirsday_time);
        fridayTime = (TextView)findViewById(R.id.friday_time);
        saturdayTime = (TextView)findViewById(R.id.saturday_time);
        sundayTime = (TextView)findViewById(R.id.sunday_time);

    }

    private void setCheckBoxListener(final CheckBox check, final TextView daytime, final String timeString, final String pref, final RelativeLayout layout, final String prefCheck) {
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    layout.setBackgroundColor(getResources().getColor(R.color.selected_green));
                    setAlamanager(timeString,pref);
                    setSharePreference(prefCheck,true);
                }else {
                    layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.grid_item_selector));
                    cancleAlarm(pref);
                    setSharePreference(prefCheck,false);
                }
            }
        });
    }

    private void setSharePreference(String pref, boolean b) {
        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        prefs.edit().putBoolean(pref,b).commit();
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
