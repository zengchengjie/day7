package com.example.administrator.day7.widget;


import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.administrator.day7.R;

public class TitleView extends RelativeLayout{

	public TitleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public TitleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public TitleView(Context context) {
		super(context);
		init(context);
	}
	Context context;
	private void init(Context context){
		this.context=context;
		
		((Activity)context).getLayoutInflater().inflate(R.layout.title_view, this);
	}
}
