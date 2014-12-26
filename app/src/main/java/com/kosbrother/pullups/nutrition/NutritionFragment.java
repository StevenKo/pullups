package com.kosbrother.pullups.nutrition;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.kosbrother.pullups.R;
import com.kosbrother.pullups.nutrition.nutrition_item.BeanContent;
import com.kosbrother.pullups.nutrition.nutrition_item.BreadContent;
import com.kosbrother.pullups.nutrition.nutrition_item.DessertContent;
import com.kosbrother.pullups.nutrition.nutrition_item.FruitContent;
import com.kosbrother.pullups.nutrition.nutrition_item.GreensContent;
import com.kosbrother.pullups.nutrition.nutrition_item.MeatContent;
import com.kosbrother.pullups.nutrition.nutrition_item.MilkProductsContent;
import com.kosbrother.pullups.nutrition.nutrition_item.NoodleContent;
import com.kosbrother.pullups.nutrition.nutrition_item.NutritionItemAdapter;
import com.kosbrother.pullups.nutrition.nutrition_item.RiceContent;
import com.kosbrother.pullups.nutrition.nutrition_item.StarchContent;
import com.kosbrother.pullups.nutrition.nutrition_item.StemContent;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class NutritionFragment extends Fragment implements AbsListView.OnItemClickListener {

    private static final String ARG_PARAM1 = "nutrition_fragment_position";
    private int fragmentPosition = 1;

    private OnFragmentInteractionListener mListener;

    private AbsListView mListView;
    private NutritionItemAdapter nutritionAdapter;

    // TODO: Rename and change types of parameters
    public static NutritionFragment newInstance(int position) {
        NutritionFragment fragment = new NutritionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NutritionFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fragmentPosition = getArguments().getInt(ARG_PARAM1,1);
        }
        switch (fragmentPosition){
            case 1:
                nutritionAdapter = new NutritionItemAdapter(getActivity(),new RiceContent(getActivity()).ITEMS);
                break;
            case 2:
                nutritionAdapter = new NutritionItemAdapter(getActivity(),new BreadContent(getActivity()).ITEMS);
                break;
            case 3:
                nutritionAdapter = new NutritionItemAdapter(getActivity(),new NoodleContent(getActivity()).ITEMS);
                break;
            case 4:
                nutritionAdapter = new NutritionItemAdapter(getActivity(),new StarchContent(getActivity()).ITEMS);
                break;
            case 5:
                nutritionAdapter = new NutritionItemAdapter(getActivity(),new MeatContent(getActivity()).ITEMS);
                break;
            case 6:
                nutritionAdapter = new NutritionItemAdapter(getActivity(),new MilkProductsContent(getActivity()).ITEMS);
                break;
            case 7:
                nutritionAdapter = new NutritionItemAdapter(getActivity(),new BeanContent(getActivity()).ITEMS);
                break;
            case 8:
                nutritionAdapter = new NutritionItemAdapter(getActivity(),new StemContent(getActivity()).ITEMS);
                break;
            case 9:
                nutritionAdapter = new NutritionItemAdapter(getActivity(),new GreensContent(getActivity()).ITEMS);
                break;
            case 10:
                nutritionAdapter = new NutritionItemAdapter(getActivity(),new FruitContent(getActivity()).ITEMS);
                break;
            case 11:
                nutritionAdapter = new NutritionItemAdapter(getActivity(),new DessertContent(getActivity()).ITEMS);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nutrition, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(nutritionAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {

        }
    }

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }

}
