package org.sogrey.tencent.test.activity;

import java.util.ArrayList;

import org.sogrey.tencent.test.R;
import org.sogrey.tencent.test.adapter.ViewPagerAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * @author Sogrey
 *
 */
public class GuideActivity extends Activity implements OnPageChangeListener, OnClickListener {
	public static GuideActivity guide;
	//����ViewPager����
	private ViewPager mViewPager;
	
	//����ViewPager������
	private ViewPagerAdapter mVpAdapter;
	
	//����һ��ArrayList�����View
	private ArrayList<View> mViews;

	//����ͼƬ��Դ
    private static final int[] mPics = {R.drawable.guide1,R.drawable.guide2,R.drawable.guide3,R.drawable.guide4};
    
    //�ײ�С���ͼƬ
    private ImageView[] mPoints;
    
    //��¼��ǰѡ��λ��
    private int mCurrentIndex;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		guide = this;
		initView();
		
		initData();	
	}

	/**
	 * ��ʼ�����
	 */
	private void initView(){
		//ʵ����ArrayList����
		mViews = new ArrayList<View>();
		
		//ʵ����ViewPager
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		
		//ʵ����ViewPager������
		mVpAdapter = new ViewPagerAdapter(this,mViews);
	}
	
	/**
	 * ��ʼ������
	 */
	private void initData(){
		//����һ�����ֲ����ò���
		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                														  LinearLayout.LayoutParams.FILL_PARENT);
       
        //��ʼ������ͼƬ�б�
        for(int i=0; i<mPics.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams);
            iv.setImageResource(mPics[i]);
            mViews.add(iv);
        } 
        
        //��������
        mViewPager.setAdapter(mVpAdapter);
        //���ü���
        mViewPager.setOnPageChangeListener(this);
        //��ʼ���ײ�С��
        initPoint();
	}
	
	/**
	 * ��ʼ���ײ�С��
	 */
	private void initPoint(){
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);       
		
        mPoints = new ImageView[mPics.length];

        //ѭ��ȡ��С��ͼƬ
        for (int i = 0; i < mPics.length; i++) {
        	//�õ�һ��LinearLayout�����ÿһ����Ԫ��
        	mPoints[i] = (ImageView) linearLayout.getChildAt(i);
        	//Ĭ�϶���Ϊ��ɫ
        	mPoints[i].setEnabled(true);
        	//��ÿ��С�����ü���
        	mPoints[i].setOnClickListener(this);
        	//����λ��tag������ȡ���뵱ǰλ�ö�Ӧ
        	mPoints[i].setTag(i);
        }
        
        //���õ���Ĭ�ϵ�λ��
        mCurrentIndex = 0;
        //����Ϊ��ɫ����ѡ��״̬
        mPoints[mCurrentIndex].setEnabled(false);
	}
	
	/**
	 * ������״̬�ı�ʱ����
	 */
	@Override
	public void onPageScrollStateChanged(int arg0) {

	}
	
	/**
	 * ����ǰҳ�汻����ʱ����
	 */

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}
	
	/**
	 * ���µ�ҳ�汻ѡ��ʱ����
	 */

	@Override
	public void onPageSelected(int position) {
		//���õײ�С��ѡ��״̬
        setCurDot(position);
	}

	/**
	 * ͨ������¼����л���ǰ��ҳ��
	 */
	@Override
	public void onClick(View v) {
		 int position = (Integer)v.getTag();
         setCurView(position);
         setCurDot(position);		
	}

	/**
	 * ���õ�ǰҳ���λ��
	 */
	private void setCurView(int position){
         if (position < 0 || position >= mPics.length) {
             return;
         }
         mViewPager.setCurrentItem(position);
     }

     /**
     * ���õ�ǰ��С���λ��
     */
    private void setCurDot(int positon){
         if (positon < 0 || positon > mPics.length - 1 || mCurrentIndex == positon) {
             return;
         }
         mPoints[positon].setEnabled(false);
         mPoints[mCurrentIndex].setEnabled(true);
         mCurrentIndex = positon;
     }
	/**
	 * ��ת��������
	 */
    public  void gotoMain(){
    	Intent intent=new Intent(this,MainActivity.class);  
    	this.startActivity(intent);
    	this.finish();
    }
}
