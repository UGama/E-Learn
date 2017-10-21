package com.example.e_learn;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by Gama on 10/21/17.
 */

public class MyLeanCloudApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this, "VfbmUOOebQdXHOCzrTKywhJP-gzGzoHsz", "RFiYqqBcOnwW9eHRtuczdhgr");
        AVOSCloud.setDebugLogEnabled(true);
    }
}
