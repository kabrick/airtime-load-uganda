package com.kabricks.loadairtimeuganda.core;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

import com.kabricks.loadairtimeuganda.BuildConfig;

public class Util {

    public static final String DOWNLOAD_APP = "";
    public static final String WEBSITE_URL = "";

    public static void share(Context activity, String shareTitle, String shareTxt, String url) {
        try {
            Intent share = new Intent("android.intent.action.SEND");
            share.setType("text/plain");
            share.addFlags(AccessibilityNodeInfoCompat.ACTION_COLLAPSE);
            share.putExtra("android.intent.extra.SUBJECT", shareTitle);
            share.putExtra("android.intent.extra.TEXT", url);
            activity.startActivity(Intent.createChooser(share, shareTxt));
        } catch (Exception e) {
        }
    }

    public static void callUssd(Context context, String pincode, String networkcode) {
        String callstring = networkcode + pincode + Uri.encode("#");

        Intent i = new Intent("android.intent.action.CALL", Uri.parse("tel:" + callstring));
        context.startActivity(i);
    }

    public static boolean isNumber(String value) {
        try {
            long l = Long.parseLong(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String formatText(String value) {
        if (value == null) {
            return "fail";
        }
        if (value.contains(" ")) {
            return value.replaceAll("\\s+", BuildConfig.FLAVOR);
        }
        return "fail";
    }

    public static boolean checkLength(String cleanString) {
        try {
            return 14 == cleanString.length();
        } catch (Exception e) {
            return false;
        }
    }
}
