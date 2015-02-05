package org.sogrey.tencent.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类
 * @author Sogrey
 *
 */
public class MyTools {

	/**
	 * 时间戳转"yyyy-M-d_HH:mn:ss_SSS"格式
	 * 
	 * @param date
	 *            long 时间戳
	 * @return String yyyy-M-d_HH:mn:ss_SSS
	 */
	public static String GetStringFromDate(long date) {
		/* 日期格式 */
		String patternDate = Constants.LOG_NAME;
		/* new 出SimpleDateFormat 对象sdf */
		SimpleDateFormat sdfDate = new SimpleDateFormat(patternDate);
		/* 格式化当前时间赋给 dateString */
		String dateString = sdfDate.format(new Date(date));
		return dateString;
	}
	
}
