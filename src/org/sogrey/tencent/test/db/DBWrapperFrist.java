package org.sogrey.tencent.test.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * �жϳ����Ƿ��һ������
 * @author Sogrey
 *
 */
public class DBWrapperFrist {
private SQLiteDatabase mDb;// SQL���ݿ����
/** ����ģʽ ���� */
private static DBWrapperFrist sInstance;

/**
 * ����ģʽ <br>
 * һ�������ֻ����һ��ʵ�� <br>
 * 1����һ��˽�о�̬��Ա <br>
 * 2����һ��������̬����getInstance�õ����˽�о�̬��Ա <br>
 * 3����һ��˽�еĹ��췽����������ʵ������ <br>
 */

public static DBWrapperFrist getInstance(Context context) {
	if (sInstance == null) {
		synchronized (DBWrapperFrist.class) {
			if (sInstance == null) {
				sInstance = new DBWrapperFrist(context);
			}
		}
	}
	return sInstance;
}

private DBWrapperFrist(Context context) {
	DBHelper helpper = new DBHelper(context);
	mDb = helpper.getWritableDatabase();
}

public void upData(boolean isFrist){
	int frist = 0;
	if (isFrist) {
		frist = 1;
	}
	ContentValues values = new ContentValues();
	values.put(DBHelper.COLUMN_FRIST, frist);
	mDb.update(DBHelper.TABLE_FRIST, values, null, null);
}

public boolean query(){
	boolean isFrist = false;
	Cursor cursor = null;
	try {
		cursor = mDb.query(/* ���� */DBHelper.TABLE_FRIST,
				/* ��Ҫ��ѯ������ */new String[]{DBHelper.COLUMN_FRIST},
				/* ��ѯ������Ӧ��ֵ */null,null,
				/* ���� */null, null,null);
		int isFristIndex = cursor.getColumnIndex(DBHelper.COLUMN_FRIST);
		int frist = 0;
		while (cursor.moveToNext()) {
			frist = cursor.getInt(isFristIndex);
			if (frist==1) {
				isFrist = true;
			}
		}
	} catch (Exception e) {
	} finally {
		if (cursor != null) {
			cursor.close();// �α�ִ�����ж��Ƿ�Ϊ�գ���Ϊ�ռ��ɹر�
		}
	}
	return isFrist;
}
}
