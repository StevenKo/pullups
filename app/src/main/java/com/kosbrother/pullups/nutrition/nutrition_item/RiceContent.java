package com.kosbrother.pullups.nutrition.nutrition_item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class RiceContent {

    public static ArrayList<NutritionItem> ITEMS = new ArrayList<NutritionItem>();
    public static Map<String, NutritionItem> ITEM_MAP = new HashMap<String, NutritionItem>();

    static {
        addItem(new NutritionItem("白米", 345,123));
        addItem(new NutritionItem("糙米", 345,123));
        addItem(new NutritionItem("白米稀飯", 345,123));
        addItem(new NutritionItem("白米", 345,123));
        addItem(new NutritionItem("糙米", 345,123));
        addItem(new NutritionItem("白米稀飯", 345,123));
        addItem(new NutritionItem("白米", 345,123));
        addItem(new NutritionItem("糙米", 345,123));
        addItem(new NutritionItem("白米稀飯", 345,123));
        addItem(new NutritionItem("白米", 345,123));
        addItem(new NutritionItem("糙米", 345,123));
        addItem(new NutritionItem("白米稀飯", 345,123));
        addItem(new NutritionItem("白米", 345,123));
        addItem(new NutritionItem("糙米", 345,123));
        addItem(new NutritionItem("白米稀飯", 345,123));
        addItem(new NutritionItem("白米", 345,123));
        addItem(new NutritionItem("糙米", 345,123));
        addItem(new NutritionItem("白米稀飯", 345,123));
    }

    private static void addItem(NutritionItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }


}
