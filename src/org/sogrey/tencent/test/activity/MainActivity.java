package org.sogrey.tencent.test.activity;

import org.sogrey.tencent.test.R;
import org.sogrey.tencent.test.util.DialogUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Sogrey
 * 
 */
public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
		initDatas();
	}

	private void initViews() {
		// TODO Auto-generated method stub

	}

	private void initDatas() {
		// TODO Auto-generated method stub
		ImageView iv  = new ImageView(this);
		iv.setImageResource(R.drawable.ic_launcher);
DialogUtil.MyToast(this, "Ð»Ð»", Gravity.CENTER, Toast.LENGTH_LONG, null);
TextView tv = null;
tv.setText("³ö´íÁË");
	}
}
