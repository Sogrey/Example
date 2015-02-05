package org.sogrey.tencent.test.adapter;

import java.util.ArrayList;

import org.sogrey.tencent.test.activity.GuideActivity;
import org.sogrey.tencent.test.activity.MainActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * @author Sogrey
 *	功能描述：ViewPager适配器，用来绑定数据和view
 */
public class ViewPagerAdapter extends PagerAdapter {
	
	//界面列表
    private ArrayList<View> views;
    Context mContext;
    public ViewPagerAdapter (Context context,ArrayList<View> views){
    	mContext = context;
        this.views = views;
    }
       
	/**
	 * 获得当前界面数
	 */
	@Override
	public int getCount() {
		 if (views != null) {
             return views.size();
         }      
         return 0;
	}

	/**
	 * 初始化position位置的界面
	 */
    @Override
    public Object instantiateItem(View view, final int position) {
       
        ((ViewPager) view).addView(views.get(position), 0);
       
        views.get(position).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (position==views.size()-1) {
					GuideActivity.guide.gotoMain();
				}
			}
		});
        return views.get(position);
    }
    
    /**
	 * 判断是否由对象生成界面
	 */
	@Override
	public boolean isViewFromObject(View view, Object arg1) {
		return (view == arg1);
	}

	/**
	 * 销毁position位置的界面
	 */
    @Override
    public void destroyItem(View view, int position, Object arg2) {
        ((ViewPager) view).removeView(views.get(position));       
    }
}
