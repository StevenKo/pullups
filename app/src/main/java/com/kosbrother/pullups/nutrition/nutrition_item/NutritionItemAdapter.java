package com.kosbrother.pullups.nutrition.nutrition_item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kosbrother.pullups.R;

import java.util.ArrayList;

/**
 * Created by steven on 12/18/14.
 */
public class NutritionItemAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NutritionItem> items;
    private LayoutInflater inflater;

    public NutritionItemAdapter(Context context,ArrayList<NutritionItem> items){
        this.context = context;
        this.items = items;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderNutritionItem viewHolder;

        if (convertView == null){
            convertView = inflater.inflate(R.layout.nutrition_item, parent, false);

            viewHolder = new ViewHolderNutritionItem();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.gi_value = (TextView) convertView.findViewById(R.id.gi_value);
            viewHolder.caloric = (TextView) convertView.findViewById(R.id.caloric);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolderNutritionItem) convertView.getTag();
        }

        NutritionItem item = items.get(position);
        if(item != null) {
            viewHolder.name.setText(item.name);
            viewHolder.gi_value.setText(" GI Value:" + item.gi_value);
            viewHolder.caloric.setText(" Caloric: " + item.caloric);
        }

        return convertView;
    }

    static class ViewHolderNutritionItem {
        TextView name;
        TextView gi_value;
        TextView caloric;
    }
}
