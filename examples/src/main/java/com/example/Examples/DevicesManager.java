package com.example.Examples;

import android.content.Context;

/**
 * Created by Eido on 09/11/2016.
 */
public class DevicesManager {
    private conte
    private static DevicesManager ourInstance = new DevicesManager();

    public static DevicesManager getInstance() {
        return ourInstance;
    }

    private DevicesManager(Context context) {
    }
}
