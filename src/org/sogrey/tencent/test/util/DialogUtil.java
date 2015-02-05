package org.sogrey.tencent.test.util;

import org.sogrey.tencent.test.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

/**
 * 对话框工具类
 * @author Sogrey
 *
 */
public class DialogUtil {
	/** 对话框key */
	public static final String DIALOG_NAME_STRING = "dialog";
	/** 退出提示对话框 */
	public static final int DIALOG_EXIT = 0x400;
	/** 等待对话框 */
	public static final int DIALOG_WAITING = 0x500;
	private static Context mContext;

	public DialogUtil(Context context) {
		mContext = context;
	}

	public Dialog createDialog(int id) {

		switch (id) {
		case DIALOG_EXIT:// 退出对话框
			return createExitDialog();
		case DIALOG_WAITING:// 等待对话框
			return createWaitingDialog();

		default:
			return null;
		}
	}
	/**
	 * 自定义Toast
	 * @param context 上下文对象
	 * @param msg 消息体
	 * @param gravity 显示位置 Gravity.CENTER 等
	 * @param duration 显示持续时间
	 * @param view toast中View（null==view 时 msg才有效，view优先）
	 */
	public static void MyToast(Context context ,String msg ,int gravity,int duration,View view){
//		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		Toast toast = new Toast(context);
		if (null!=view){
			toast.setView(view);
			toast.setDuration(duration);
		}else{
			toast = Toast.makeText(context, msg, duration);
		}
		toast.setGravity(gravity, 0, 0);
		toast.show();
	}
	
	private Dialog createWaitingDialog() {
		ProgressDialog dialog = new ProgressDialog(mContext);
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		 dialog.setTitle(mContext.getString(R.string.hint));
		dialog.setMessage(mContext.getString(R.string.hint_dialog_waiting));
		dialog.setCancelable(false);
		return dialog;
	}

	private Dialog createExitDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
		builder.setTitle(R.string.exit);
		builder.setMessage(R.string.exit_sure);
		builder.setCancelable(false);
		builder.setNegativeButton(R.string.no, null);
		builder.setPositiveButton(R.string.yes,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
		return builder.create();
	}
}
