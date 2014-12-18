package com.kosbrother.pullups.nutrition.nutrition_item;

/**
 * Created by steven on 12/18/14.
 */
public class NutritionItem {

    public int gi_value;
    public int caloric;
    public String name;

    public NutritionItem(String name, int gi_value, int caloric) {
        this.name = name;
        this.gi_value = gi_value;
        this.caloric = caloric;
    }

    @Override
    public String toString() {
        return name;
    }

}
