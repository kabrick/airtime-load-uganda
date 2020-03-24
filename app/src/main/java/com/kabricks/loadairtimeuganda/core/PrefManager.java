package com.kabricks.loadairtimeuganda.core;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    private static final String IS_FIRST_LAUNCH = "firstlaunch";
    private static final String PREF_NAME = "load_airtime_prefs";

    private SharedPreferences.Editor editor;
    private SharedPreferences pref;

    public PrefManager(Context context) {
        int PRIVATE_MODE = 0;
        Context _context = context;
        this.pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        this.editor = this.pref.edit();
    }


    public boolean isFirstLaunch(){
        return this.pref.getBoolean(IS_FIRST_LAUNCH, true);
    }

    public void setIsFirstLaunch(boolean isFirstTime){
        this.editor.putBoolean(IS_FIRST_LAUNCH, isFirstTime);
        this.editor.commit();
    }
}
