package org.sogrey.tencent.test.util;

import android.os.Environment;

/**
 * ������
 * @author Sogrey
 *
 */
public class Constants {

	/** SD��·�� */
	public final static String PATH_SDCARD= Environment
			.getExternalStorageDirectory().getPath();
	/**
	 * Log��־����·��<br>
	 * "SD+/sogrey_tencent/log/"
	 */
	public static final String LOG_PATH =PATH_SDCARD+ "/sogrey_tencent/log/";
}