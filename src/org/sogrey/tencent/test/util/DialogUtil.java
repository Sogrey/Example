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
 * �Ի��򹤾���
 * @author Sogrey
 *
 */
public class DialogUtil {
	/** �Ի���key */
	public static final String DIALOG_NAME_STRING = "dialog";
	/** �˳���ʾ�Ի��� */
	public static final int DIALOG_EXIT = 0x400;
	/** �ȴ��Ի��� */
	public static final int DIALOG_WAITING = 0x500;
	private static Context mContext;

	public DialogUtil(Context context) {
		mContext = context;
	}

	public Dialog createDialog(int id) {

		switch (id) {
		case DIALOG_EXIT:// �˳��Ի���
			return createExitDialog();
		case DIALOG_WAITING:// �ȴ��Ի���
			return createWaitingDialog();

		default:
			return null;
		}
	}
	/**
	 * �Զ���Toast
	 * @param context �����Ķ���
	 * @param msg ��Ϣ��
	 * @param gravity ��ʾλ�� Gravity.CENTER ��
	 * @param duration ��ʾ����ʱ��
	 * @param view toast��View��null==view ʱ msg����Ч��view���ȣ�
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
