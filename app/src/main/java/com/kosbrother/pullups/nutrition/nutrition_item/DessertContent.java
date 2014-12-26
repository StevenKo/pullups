package com.kosbrother.pullups.nutrition.nutrition_item;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.kosbrother.pullups.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DessertContent {

    public  ArrayList<NutritionItem> ITEMS = new ArrayList<NutritionItem>();
    public  Map<String, NutritionItem> ITEM_MAP = new HashMap<String, NutritionItem>();

    public DessertContent(Context context){
        Resources resources = context.getResources();
        TypedArray rice_names = resources.obtainTypedArray(R.array.dessert_names);
        TypedArray rice_gi_value = resources.obtainTypedArray(R.array.dessert_gi_value);
        TypedArray rice_caloric = resources.obtainTypedArray(R.array.dessert_caloric);

        for(int i=0;i<rice_names.length();i++){
            addItem(new NutritionItem(rice_names.getString(i),rice_gi_value.getInt(i,0),rice_caloric.getInt(i,0)));
        }
    }

    private void addItem(NutritionItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }


}
