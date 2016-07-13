package com.example.administrator.day7.widget;



import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.day7.R;
import com.example.administrator.day7.interfaces.OnMyClickListener;

public class MyMenu extends RelativeLayout implements View.OnClickListener {

	/**
	 * �����Ļ���
	 */
	Context context;

	final int CLICK_RECOMMEND = 0;
	final int CLICK_LIST = CLICK_RECOMMEND + 1;
	final int CLICK_SINGER = CLICK_LIST + 1;
	final int CLICK_MUSIC_LIST = CLICK_SINGER + 1;
	final int CLICK_CLASS = CLICK_MUSIC_LIST + 1;

	int state = CLICK_RECOMMEND;

	/**
	 * �Ƽ���ť
	 */
	TextView button_recommend;
	Bitmap bitmapRecommendDown;
	Bitmap bitmapRecommendUp;
	Drawable drawableRecommendDown;
	Drawable drawableRecommendUp;

	/**
	 * ���а�ť
	 */
	TextView button_list;
	Bitmap bitmapListDown;
	Bitmap bitmapListUp;
	Drawable drawableListDown;
	Drawable drawableListUp;

	/**
	 * ���ְ�ť
	 */
	TextView button_singer;
	Bitmap bitmapSingerDown;
	Bitmap bitmapSingerUp;
	Drawable drawableSingerDown;
	Drawable drawableSingerUp;

	/**
	 * �赥��ť
	 */
	TextView button_musicList;
	Bitmap bitmapMusicListDown;
	Bitmap bitmapMusicListUp;
	Drawable drawableMusicListDown;
	Drawable drawableMusicListUp;

	/**
	 * ���ఴť
	 */
	TextView button_class;
	Bitmap bitmapClassDown;
	Bitmap bitmapClassUp;
	Drawable drawableClassDown;
	Drawable drawableClassUp;

	View view;

	public MyMenu(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public MyMenu(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public MyMenu(Context context) {
		super(context);
		init(context);
	}

	/**
	 * ���ݳ�ʼ��
	 */
	private void init(Context context) {
		this.context = context;

		// ��һ�������ļ�תΪview�����LayoutInflater������÷���inflate��һ�������ļ�תΪview��LayoutInflater��������Activity
		view = ((Activity) context).getLayoutInflater().inflate(
				R.layout.my_menu_view, null);

		getWidget();

		this.addView(view);

	}

	/**
	 * ��ȡ5����ť
	 */
	private void getWidget() {

		getButton_recommend();
		getButton_list();
		getButton_singer();
		getButton_musicList();
		getButton_class();
	}

	/**
	 * ����Ƽ���ť
	 */
	private void getButton_recommend() {

		button_recommend = (TextView) view
				.findViewById(R.id.my_menu_view_button_recommend);

		// ���ü���
		button_recommend.setOnClickListener(this);

		// ���λͼ
		bitmapRecommendUp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.button_1_1);
		bitmapRecommendDown = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.button_1_2);

		// ��û��ƶ���
		drawableRecommendUp = new BitmapDrawable(context.getResources(),
				bitmapRecommendUp);
		drawableRecommendDown = new BitmapDrawable(context.getResources(),
				bitmapRecommendDown);
		// ���ñ���ͼƬ
		button_recommend.setBackgroundDrawable(drawableRecommendDown);

	}

	/**
	 * ������а�ť
	 */
	private void getButton_list() {
		button_list = (TextView) view
				.findViewById(R.id.my_menu_view_button_list);
		button_list.setOnClickListener(this);

		// ���λͼ
		bitmapListUp = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.button_2_1);
		bitmapListDown = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.button_2_2);

		// ��û��ƶ���
		drawableListUp = new BitmapDrawable(context.getResources(),
				bitmapListUp);
		drawableListDown = new BitmapDrawable(context.getResources(),
				bitmapListDown);
		// ���ñ���ͼƬ
		button_list.setBackgroundDrawable(drawableListUp);

	}

	/**
	 * ��ø��ְ�ť
	 */
	private void getButton_singer() {
		button_singer = (TextView) view
				.findViewById(R.id.my_menu_view_button_singer);
		button_singer.setOnClickListener(this);

		// ���λͼ
		bitmapSingerUp = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.button_3_1);
		bitmapSingerDown = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.button_3_2);

		// ��û��ƶ���
		drawableSingerUp = new BitmapDrawable(context.getResources(),
				bitmapSingerUp);
		drawableSingerDown = new BitmapDrawable(context.getResources(),
				bitmapSingerDown);
		// ���ñ���ͼƬ
		button_singer.setBackgroundDrawable(drawableSingerUp);

	}

	/**
	 * ��������б�İ�ť����
	 */
	private void getButton_musicList() {
		button_musicList = (TextView) view
				.findViewById(R.id.my_menu_view_button_music_list);
		button_musicList.setOnClickListener(this);

		// ���λͼ
		bitmapMusicListUp = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.button_4_1);
		bitmapMusicListDown = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.button_4_2);

		// ��û��ƶ���
		drawableMusicListUp = new BitmapDrawable(context.getResources(),
				bitmapMusicListUp);
		drawableMusicListDown = new BitmapDrawable(context.getResources(),
				bitmapMusicListDown);
		// ���ñ���ͼƬ
		button_musicList.setBackgroundDrawable(drawableMusicListUp);

	}

	/**
	 * ��÷��ఴť����
	 */
	private void getButton_class() {
		button_class = (TextView) view
				.findViewById(R.id.my_menu_view_button_class);

		// ���ü���
		button_class.setOnClickListener(this);

		// ���λͼ
		bitmapClassUp = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.button_5_1);
		bitmapClassDown = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.button_5_2);

		// ��û��ƶ���
		drawableClassUp = new BitmapDrawable(context.getResources(),
				bitmapClassUp);
		drawableClassDown = new BitmapDrawable(context.getResources(),
				bitmapClassDown);
		// ���ñ���ͼƬ
		button_class.setBackgroundDrawable(drawableClassUp);

	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.my_menu_view_button_recommend:
			actionRecommend();
			break;
		case R.id.my_menu_view_button_singer:
			actionSinger();
			break;
		case R.id.my_menu_view_button_list:
			actionList();
			break;
		case R.id.my_menu_view_button_music_list:
			actionMusicList();
			break;
		case R.id.my_menu_view_button_class:
			actionClass();
			break;
		}
	}

	private void actionClass() {
		if (state == CLICK_CLASS)
			return;

		button_class.setBackgroundDrawable(drawableClassDown);
		resetBackground();
		state = CLICK_CLASS;

		m_OnMyClickListener.onClickClass();
	}

	private void actionMusicList() {
		if (state == CLICK_MUSIC_LIST)
			return;

		button_musicList.setBackgroundDrawable(drawableMusicListDown);
		resetBackground();
		state = CLICK_MUSIC_LIST;

		m_OnMyClickListener.onClickMusicList();
	}

	/**
	 * ���а�ť���������
	 */
	private void actionList() {
		if (state == CLICK_LIST)
			return;

		button_list.setBackgroundDrawable(drawableListDown);
		resetBackground();
		state = CLICK_LIST;

		m_OnMyClickListener.onClickList();
	}

	private void actionSinger() {
		if (state == CLICK_SINGER)
			return;
		button_singer.setBackgroundDrawable(drawableSingerDown);
		resetBackground();
		state = CLICK_SINGER;

		m_OnMyClickListener.onClickSinger();
	}

	private void actionRecommend() {
		if (state == CLICK_RECOMMEND)
			return;
		button_recommend.setBackgroundDrawable(drawableRecommendDown);
		resetBackground();
		state = CLICK_RECOMMEND;

		m_OnMyClickListener.onClickRecommend();



	}

	private void resetBackground() {
		switch (state) {
		case CLICK_RECOMMEND:
			button_recommend.setBackgroundDrawable(drawableRecommendUp);
			break;
		case CLICK_LIST:
			button_list.setBackgroundDrawable(drawableListUp);
			break;
		case CLICK_SINGER:
			button_singer.setBackgroundDrawable(drawableSingerUp);
			break;
		case CLICK_MUSIC_LIST:
			button_musicList.setBackgroundDrawable(drawableMusicListUp);
			break;
		case CLICK_CLASS:
			button_class.setBackgroundDrawable(drawableClassUp);
			break;

		}
	}

	OnMyClickListener m_OnMyClickListener;

	public void setOnMyClickListener(OnMyClickListener m_OnMyClickListener) {
		this.m_OnMyClickListener = m_OnMyClickListener;
	}

}
