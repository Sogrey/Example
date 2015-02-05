package org.sogrey.tencent.test.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 判断程序是否第一次启动
 * @author Sogrey
 *
 */
public class DBWrapperFrist {
private SQLiteDatabase mDb;// SQL数据库对象
/** 单例模式 对象 */
private static DBWrapperFrist sInstance;

/**
 * 单例模式 <br>
 * 一个类最多只能有一个实例 <br>
 * 1、有一个私有静态成员 <br>
 * 2、有一个公开静态方法getInstance得到这个私有静态成员 <br>
 * 3、有一个私有的构造方法（不允许被实例化） <br>
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
		cursor = mDb.query(/* 表名 */DBHelper.TABLE_FRIST,
				/* 需要查询的列名 */new String[]{DBHelper.COLUMN_FRIST},
				/* 查询条件对应的值 */null,null,
				/* 分组 */null, null,null);
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
			cursor.close();// 游标执行完判断是否为空，不为空即可关闭
		}
	}
	return isFrist;
}
}
