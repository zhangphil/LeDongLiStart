package com.test.ledongli.myview;

import java.util.ArrayList;

import com.test.ledongli.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class FirstScreen extends ViewGroup {
	
	ImageView image0=null;
	ImageView image1=null;
	ImageView image2=null;
	ImageView image3=null;
	ImageView image4=null;
	ImageView image5=null;
	ImageView tv_a=null;
	
	ArrayList<Bitmap> bmp_list=null;
	Bitmap tv_bmp=null;
	
	//屏幕宽度
	int width=0;
	//计算间隙的宽度
	int perWidth=0;
	//第一张图片游标的位置
	int currentPos=0;
	//起始高度
	int perHeight=50;
	
	Context context=null;

	public FirstScreen(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public FirstScreen(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(context);
	}

	public FirstScreen(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init(context);
	}
	
	public void init(Context context) {
		
		this.context=context;
		width=context.getResources().getDisplayMetrics().widthPixels;		
		tv_bmp=BitmapFactory.decodeResource(getResources(), R.drawable.tv);		
		bmp_list=new ArrayList<Bitmap>();
		
		image0=new ImageView(context);
		Bitmap bmp_grey=BitmapFactory.decodeResource(getResources(), R.drawable.grey);
		image0.setImageBitmap(bmp_grey);
		addView(image0);
		
		image1=new ImageView(context);
		image1.setImageBitmap(bmp_grey);
		addView(image1);
		bmp_list.add(bmp_grey);
		
		image2=new ImageView(context);
        Bitmap bmp_bike=BitmapFactory.decodeResource(getResources(), R.drawable.bike);
        image2.setImageBitmap(bmp_bike);
		addView(image2);
		bmp_list.add(bmp_bike);
		
		image3=new ImageView(context);
		Bitmap bmp_minicar=BitmapFactory.decodeResource(getResources(), R.drawable.minicar);
		image3.setImageBitmap(bmp_minicar);
		addView(image3);
		bmp_list.add(bmp_minicar);
		
		image4=new ImageView(context);
		Bitmap bmp_miniman=BitmapFactory.decodeResource(getResources(), R.drawable.miniman);
		image4.setImageBitmap(bmp_miniman);
		addView(image4);
		bmp_list.add(bmp_miniman);
		
		image5=new ImageView(context);
		Bitmap bmp_run=BitmapFactory.decodeResource(getResources(), R.drawable.run);
		image5.setImageBitmap(bmp_run);
		addView(image5);
		bmp_list.add(bmp_run);
		
		tv_a=(ImageView) LayoutInflater.from(context).inflate(R.layout.tv_image, null);
		addView(tv_a);
		
		perWidth=width/4-bmp_grey.getWidth();
		
	}
	
	//左边偏移量中心点
	public int leftMargin() {
		return bmp_list.get(0).getWidth()+perWidth;
	}
	
	//顶部偏移量中心点
	public int topMargin() {
		return bmp_list.get(0).getHeight()/2+perHeight;
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		
		image0.layout((int) (-bmp_list.get(0).getWidth()*1.5-perWidth), perHeight, (int) (-bmp_list.get(0).getWidth()*0.5-perWidth), bmp_list.get(0).getHeight()+perHeight);
		image1.layout(-bmp_list.get(0).getWidth()/2, perHeight, bmp_list.get(0).getWidth()/2, bmp_list.get(0).getHeight()+perHeight);
		image2.layout(bmp_list.get(0).getWidth()/2+perWidth, perHeight, (int) (bmp_list.get(0).getWidth()*1.5+perWidth), bmp_list.get(0).getHeight()+perHeight);
		image3.layout((int) (bmp_list.get(0).getWidth()*1.5+perWidth*2), perHeight, (int) (bmp_list.get(0).getWidth()*2.5+perWidth*2), bmp_list.get(0).getHeight()+perHeight);
		image4.layout((int) (bmp_list.get(0).getWidth()*2.5+perWidth*3), perHeight, (int) (bmp_list.get(0).getWidth()*3.5+perWidth*3), bmp_list.get(0).getHeight()+perHeight);
		image5.layout((int) (bmp_list.get(0).getWidth()*3.5+perWidth*4), perHeight, (int) (bmp_list.get(0).getWidth()*4.5+perWidth*4), bmp_list.get(0).getHeight()+perHeight);
		tv_a.layout(leftMargin()-tv_bmp.getWidth()/2, topMargin()-tv_bmp.getHeight()/2, leftMargin()+tv_bmp.getWidth()/2, topMargin()+tv_bmp.getHeight()/2);

		doAnimation(image0, false);
		doAnimation(image1, false);
		doAnimation(image2, false);
		doAnimation(image3, false);
		doAnimation(image4, false);
		doAnimation(image5, true);
		
		AnimationDrawable d=(AnimationDrawable) tv_a.getBackground();
		d.start();
	}
	
	Handler handler=new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			currentPos--;
			if(currentPos<1) {
				currentPos=4;
			}
			
			FirstScreen.this.removeAllViews();
			
			image0=new ImageView(context);
			image0.setImageBitmap(bmp_list.get(0));
			addView(image0);
			
			image1=new ImageView(context);
			image1.setImageBitmap(bmp_list.get(0));
			addView(image1);
			
			image2=new ImageView(context);
	        image2.setImageBitmap(bmp_list.get(currentPos>4?(currentPos-4):currentPos));
			addView(image2);
			
			image3=new ImageView(context);
			image3.setImageBitmap(bmp_list.get(currentPos+1>4?(currentPos-3):currentPos+1));
			addView(image3);
			
			image4=new ImageView(context);
			image4.setImageBitmap(bmp_list.get(currentPos+2>4?(currentPos-2):currentPos+2));
			addView(image4);
			
			image5=new ImageView(context);
			image5.setImageBitmap(bmp_list.get(currentPos+3>4?(currentPos-1):currentPos+3));
			addView(image5);			

			tv_a=(ImageView) LayoutInflater.from(context).inflate(R.layout.tv_image, null);
			addView(tv_a);
		}
	};
	
	public void doAnimation(ImageView imageview, boolean isListening) {
		AnimationSet as=new AnimationSet(false);
		TranslateAnimation tran=new TranslateAnimation(0, bmp_list.get(0).getWidth()+perWidth, 0, 0);
		tran.setDuration(1000);
		as.addAnimation(tran);
		as.setFillAfter(true);
		if(isListening) {
			as.setAnimationListener(new AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationEnd(Animation animation) {
					// TODO Auto-generated method stub
					handler.sendMessageDelayed(new Message(), 300);					
				}
			});
		}
		imageview.startAnimation(as);
	}
	
}
