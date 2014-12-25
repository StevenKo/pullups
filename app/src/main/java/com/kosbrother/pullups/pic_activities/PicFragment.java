package com.kosbrother.pullups.pic_activities;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.kosbrother.pullups.R;

public class PicFragment extends Fragment {

    private static final String ARG_PARAM1 = "picArrayResource";
    private static final String ARG_PARAM2 = "stringResource";

    private int picArrayResourceID;
    private int stringResourceID;
    private TypedArray picTypedArray;
    private String infoText;


    public static PicFragment newInstance(int picArrayResource, int stringResource) {
        PicFragment fragment = new PicFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, picArrayResource);
        args.putInt(ARG_PARAM2, stringResource);
        fragment.setArguments(args);
        return fragment;
    }

    public PicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            picArrayResourceID = getArguments().getInt(ARG_PARAM1);
            stringResourceID = getArguments().getInt(ARG_PARAM2);
            picTypedArray = getResources().obtainTypedArray(picArrayResourceID);
            infoText = getString(stringResourceID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentLayout = inflater.inflate(R.layout.fragment_pic, container, false);
        LinearLayout picsLayout = (LinearLayout)fragmentLayout.findViewById(R.id.pics_layout);

        for(int i=0; i< picTypedArray.length();i++){
            ImageView picView = new ImageView(getActivity());
            picView.setImageResource(picTypedArray.getResourceId(i, -1));
            picView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT,1.0f));
            picsLayout.addView(picView);
        }


        TextView info = (TextView)fragmentLayout.findViewById(R.id.info_text);
        info.setText(Html.fromHtml(infoText));

        return fragmentLayout;
    }


}
