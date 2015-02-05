package org.sogrey.tencent.test.util;

import android.os.Environment;

/**
 * 常量类
 * @author Sogrey
 *
 */
public class Constants {

	/** SD卡路径 */
	public final static String PATH_SDCARD= Environment
			.getExternalStorageDirectory().getPath();
	/**
	 * Log日志保存路径<br>
	 * "SD+/sogrey_tencent/log/"
	 */
	public static final String LOG_PATH =PATH_SDCARD+ "/sogrey_tencent/log/";
}
