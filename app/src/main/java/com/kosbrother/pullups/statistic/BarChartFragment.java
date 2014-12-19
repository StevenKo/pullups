package com.kosbrother.pullups.statistic;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.OnChartValueSelectedListener;
import com.github.mikephil.charting.interfaces.OnDrawListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Legend;
import com.github.mikephil.charting.utils.XLabels;
import com.github.mikephil.charting.utils.YLabels;
import com.kosbrother.pullups.R;

import java.util.ArrayList;


public class BarChartFragment extends Fragment implements OnChartValueSelectedListener,OnDrawListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private BarChart mChart;
    protected String[] mMonths = new String[] {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"
    };

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BarChartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BarChartFragment newInstance(String param1, String param2) {
        BarChartFragment fragment = new BarChartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BarChartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View chartFragment = inflater.inflate(R.layout.fragment_bar_chart, container, false);

        mChart = (BarChart) chartFragment.findViewById(R.id.chart1);
        mChart.setOnChartValueSelectedListener(this);


        // enable the drawing of values
        mChart.setDrawYValues(true);

        mChart.setDrawValueAboveBar(true);


        mChart.setDescription("這是一個測試");


        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart.setMaxVisibleValueCount(5);


        // disable 3D
        mChart.set3DEnabled(false);


        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(true);


        // draw shadows for each bar that show the maximum value
        // mChart.setDrawBarShadow(true);


        mChart.setUnit(" €");

        // mChart.setDrawXLabels(false);


        mChart.setDrawGridBackground(false);
        mChart.setDrawHorizontalGrid(true);
        mChart.setDrawVerticalGrid(false);
        // mChart.setDrawYLabels(false);


        // sets the text size of the values inside the chart
        mChart.setValueTextSize(10);


        mChart.setDrawBorder(true);
        mChart.setBorderPositions(new BarLineChartBase.BorderPosition[] {BarLineChartBase.BorderPosition.LEFT,
                BarLineChartBase.BorderPosition.RIGHT});


        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");


        XLabels xl = mChart.getXLabels();
        xl.setPosition(XLabels.XLabelPosition.TOP);
        xl.setCenterXLabelText(true);
        xl.setTypeface(tf);


        YLabels yl = mChart.getYLabels();
        yl.setTypeface(tf);
        yl.setLabelCount(28);
        yl.setPosition(YLabels.YLabelPosition.BOTH_SIDED);


        mChart.setValueTypeface(tf);


        setData(12, 50);





        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setFormSize(8f);
        l.setXEntrySpace(4f);

        mChart.animateY(2500);

        return chartFragment;
    }

    private void setData(int count, float range) {


        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            xVals.add(mMonths[i % 12]);
        }


        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();


        for (int i = 0; i < count; i++) {
            float mult = (range + 1);
            float val = (float) (Math.random() * mult);
            yVals1.add(new BarEntry(val, i));
        }


        BarDataSet set1 = new BarDataSet(yVals1, "DataSet");
        set1.setBarSpacePercent(35f);
        set1.setColors(ColorTemplate.VORDIPLOM_COLORS);

        BarDataSet set2 = new BarDataSet(yVals1, "DataSet2");
        set1.setBarSpacePercent(85f);


        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);
        dataSets.add(set2);


        BarData data = new BarData(xVals, dataSets);


        mChart.setData(data);
    }


    @Override
    public void onValueSelected(Entry entry, int i) {

    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void onEntryAdded(Entry entry) {

    }

    @Override
    public void onEntryMoved(Entry entry) {

    }

    @Override
    public void onDrawFinished(DataSet dataSet) {

    }
}
