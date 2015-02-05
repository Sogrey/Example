package org.sogrey.tencent.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ������
 * @author Sogrey
 *
 */
public class MyTools {

	/**
	 * ʱ���ת"yyyy-M-d_HH:mn:ss_SSS"��ʽ
	 * 
	 * @param date
	 *            long ʱ���
	 * @return String yyyy-M-d_HH:mn:ss_SSS
	 */
	public static String GetStringFromDate(long date) {
		/* ���ڸ�ʽ */
		String patternDate = Constants.LOG_NAME;
		/* new ��SimpleDateFormat ����sdf */
		SimpleDateFormat sdfDate = new SimpleDateFormat(patternDate);
		/* ��ʽ����ǰʱ�丳�� dateString */
		String dateString = sdfDate.format(new Date(date));
		return dateString;
	}
	
}
