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
	//定义ViewPager对象
	private ViewPager mViewPager;
	
	//定义ViewPager适配器
	private ViewPagerAdapter mVpAdapter;
	
	//定义一个ArrayList来存放View
	private ArrayList<View> mViews;

	//引导图片资源
    private static final int[] mPics = {R.drawable.guide1,R.drawable.guide2,R.drawable.guide3,R.drawable.guide4};
    
    //底部小点的图片
    private ImageView[] mPoints;
    
    //记录当前选中位置
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
	 * 初始化组件
	 */
	private void initView(){
		//实例化ArrayList对象
		mViews = new ArrayList<View>();
		
		//实例化ViewPager
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		
		//实例化ViewPager适配器
		mVpAdapter = new ViewPagerAdapter(this,mViews);
	}
	
	/**
	 * 初始化数据
	 */
	private void initData(){
		//定义一个布局并设置参数
		LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                														  LinearLayout.LayoutParams.FILL_PARENT);
       
        //初始化引导图片列表
        for(int i=0; i<mPics.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams);
            iv.setImageResource(mPics[i]);
            mViews.add(iv);
        } 
        
        //设置数据
        mViewPager.setAdapter(mVpAdapter);
        //设置监听
        mViewPager.setOnPageChangeListener(this);
        //初始化底部小点
        initPoint();
	}
	
	/**
	 * 初始化底部小点
	 */
	private void initPoint(){
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll);       
		
        mPoints = new ImageView[mPics.length];

        //循环取得小点图片
        for (int i = 0; i < mPics.length; i++) {
        	//得到一个LinearLayout下面的每一个子元素
        	mPoints[i] = (ImageView) linearLayout.getChildAt(i);
        	//默认都设为灰色
        	mPoints[i].setEnabled(true);
        	//给每个小点设置监听
        	mPoints[i].setOnClickListener(this);
        	//设置位置tag，方便取出与当前位置对应
        	mPoints[i].setTag(i);
        }
        
        //设置当面默认的位置
        mCurrentIndex = 0;
        //设置为白色，即选中状态
        mPoints[mCurrentIndex].setEnabled(false);
	}
	
	/**
	 * 当滑动状态改变时调用
	 */
	@Override
	public void onPageScrollStateChanged(int arg0) {

	}
	
	/**
	 * 当当前页面被滑动时调用
	 */

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}
	
	/**
	 * 当新的页面被选中时调用
	 */

	@Override
	public void onPageSelected(int position) {
		//设置底部小点选中状态
        setCurDot(position);
	}

	/**
	 * 通过点击事件来切换当前的页面
	 */
	@Override
	public void onClick(View v) {
		 int position = (Integer)v.getTag();
         setCurView(position);
         setCurDot(position);		
	}

	/**
	 * 设置当前页面的位置
	 */
	private void setCurView(int position){
         if (position < 0 || position >= mPics.length) {
             return;
         }
         mViewPager.setCurrentItem(position);
     }

     /**
     * 设置当前的小点的位置
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
	 * 跳转到主界面
	 */
    public  void gotoMain(){
    	Intent intent=new Intent(this,MainActivity.class);  
    	this.startActivity(intent);
    	this.finish();
    }
}
