package com.kosbrother.pullups.nutrition;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kosbrother.pullups.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NutritionIntroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NutritionIntroFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NutritionIntroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NutritionIntroFragment newInstance(String param1, String param2) {
        NutritionIntroFragment fragment = new NutritionIntroFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public NutritionIntroFragment() {
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
        View fragment = inflater.inflate(R.layout.fragment_nutrition_intro, container, false);
        TextView textInfo = (TextView) fragment.findViewById(R.id.info_text);
        textInfo.setText(Html.fromHtml(getResources().getString(R.string.nutrition_info)));

        return fragment;
    }


}
