package com.example.c0773839_w2020_mad3125_fp.Util;

public class ObjectManager {
    private static ObjectManager single_instance = null;



    private ObjectManager()
    {

    }

    public static ObjectManager getInstance()
    {
        if (single_instance == null)
            single_instance = new ObjectManager();

        return single_instance;
    }



    
}
