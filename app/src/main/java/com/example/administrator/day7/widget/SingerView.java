package com.example.administrator.day7.widget;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.day7.R;
import com.example.administrator.day7.data.SingerData;
import com.nostra13.universalimageloader.core.ImageLoader;

public class SingerView extends RelativeLayout {
//    public ImageLoader imageLoader = ImageLoader.getInstance();
    View view;

    /**
     * ͷ��
     */
    ImageView imageIcon;

    /**
     * ����
     */
    TextView textName;

    /**
     * ����
     */
    TextView textIntroduce;

    public SingerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public SingerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SingerView(Context context) {
        super(context);
        init(context);
    }

    Context context;

    private void init(Context context) {
        this.context = context;
        view = ((Activity) context).getLayoutInflater().inflate(
                R.layout.singer_view, this);

        getWidget();
    }

    /**
     *
     */
    private void getWidget() {
        getIcon();
        getTextView_name();
        getTextView_introduce();

    }

    /**
     * ��ȡͷ��ͼƬ
     */
    private void getIcon() {
        imageIcon = (ImageView) view.findViewById(R.id.singer_view_icon);

    }

    /**
     * ��������ı����
     */
    private void getTextView_name() {
        textName = (TextView) view.findViewById(R.id.singer_view_name);

    }

    /**
     * ��ý����ı����
     */
    private void getTextView_introduce() {
        textIntroduce = (TextView) view
                .findViewById(R.id.singer_view_introduce);

    }

    Bitmap bitmap;
    Drawable drawable;

    public void setSingerData(SingerData data) {
//		if (bitmap == null) {
//			bitmap = MyImageFactory.getBitmap(context, data.getImageRes());
//
//			drawable = MyImageFactory.getDrawable(context, bitmap);
//		}
//		DisplayImageOptions options = new DisplayImageOptions.Builder()
//				.cacheInMemory(true)
//				.cacheOnDisc(true)
//				.showImageForEmptyUri(R.mipmap.ic_launcher)
//				.build();
//		com.nostra13.universalimageloader.core.ImageLoader.getInstance()
//				.displayImage(data.getImageRes(),  imageIcon, options);

        RequestQueue mQueue = Volley.newRequestQueue(context);
        ImageRequest imageRequest = new ImageRequest(
                data.getImageRes(),
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageIcon.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageIcon.setImageResource(R.drawable.ic_launcher);
            }
        });
        mQueue.add(imageRequest);

      /*  imageLoader.init(ImageLoaderConfiguration.createDefault(context));

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .showImageForEmptyUri(R.drawable.ic_launcher)
                .build();

     ImageLoader.getInstance().displayImage(data.getImageRes(),imageIcon, options);*/

        imageIcon.setBackgroundDrawable(drawable);

        textName.setText(data.getName());

        textIntroduce.setText(data.getIntroduce());
    }

/*

	RequestQueue requestQueue = Volley.newRequestQueue(getContext());
ImageLoader imageLoader = new ImageLoader(requestQueue, ImageLoader.ImageCache());
	ImageLoader.ImageListener listener = ImageLoader.getImageListener(imageIcon,R.drawable.ic_launcher,R.drawable.ic_launcher);
*/


}
