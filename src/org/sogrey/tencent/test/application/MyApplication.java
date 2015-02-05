package org.sogrey.tencent.test.application;

import org.sogrey.tencent.test.util.CrashHandler;

import android.app.Application;

/**
 * @author Sogrey
 *
 */
public class MyApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		CrashHandler.getInstance().init();// ≥ı ºªØ
	}
}
