package org.sogrey.tencent.test.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * ���ݿ�汾����
 * @author Sogrey
 *
 */
public class DBHelper  extends SQLiteOpenHelper{
	
	/** ���ݿ��� */
	private final static String DB_NAME = "Example.db";
	/** ���ݿ�汾�� */
	private final static int DB_VERSION = 1;
	
	//####################
	/** ��һ������ */
	public final static String TABLE_FRIST= "frist";
	/** ���ݿ�汾�� */
	public final static String COLUMN_FRIST = "isFrist";
	
	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		//FRIST��
		String sql = "CREATE TABLE "+ TABLE_FRIST+ " ( " // �˵���
				+ COLUMN_FRIST+ "  INTEGER " // �汾����
				+ ")";
		db.execSQL(sql);// ִ��SQL��䣬����������ֵΪ�գ�
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
