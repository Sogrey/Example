package org.sogrey.tencent.test.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库版本控制
 * @author Sogrey
 *
 */
public class DBHelper  extends SQLiteOpenHelper{
	
	/** 数据库名 */
	private final static String DB_NAME = "Example.db";
	/** 数据库版本号 */
	private final static int DB_VERSION = 1;
	
	//####################
	/** 第一次启用 */
	public final static String TABLE_FRIST= "frist";
	/** 数据库版本号 */
	public final static String COLUMN_FRIST = "isFrist";
	
	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		//FRIST表
		String sql = "CREATE TABLE "+ TABLE_FRIST+ " ( " // 菜单表
				+ COLUMN_FRIST+ "  INTEGER " // 版本名称
				+ ")";
		db.execSQL(sql);// 执行SQL语句，创建表（返回值为空）
		init(db);
	}

	private void init(SQLiteDatabase db) {
		int frist = 0;
		ContentValues values = new ContentValues();
		values.put(DBHelper.COLUMN_FRIST, frist);
		db.insert(DBHelper.TABLE_FRIST, "", values);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "DROP TABLE IS " + TABLE_FRIST;
		db.execSQL(sql);
		onCreate(db);
	}
}
