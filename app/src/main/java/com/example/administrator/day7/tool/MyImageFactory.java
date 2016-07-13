package com.example.administrator.day7.tool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class MyImageFactory {

	/**
	 * 做屏幕适配的
	 */


	/**
	 * 手机宽
	 */
	static int contentWidth;

	/**
	 * ��ǰ�ֻ��ĸ�
	 */
	static int contentHeight;

	/**
	 * ��������ԭʼģ��Ŀ�
	 */
	static int width = 720;

	/**
	 * ��������ԭʼģ��ĸ�
	 */
	static int height = 1280;

	/**
	 * ͼƬ�����ŵı���
	 */
	static float bufferX;

	/**
	 * ͼƬ�����ŵı���
	 */
	static float bufferY;

	public static void init(int widthPixels, int heightPixels) {

		contentWidth = widthPixels;

		contentHeight = heightPixels;

		bufferX = (float) contentWidth / width;

		bufferY = (float) contentHeight / height;
	}

	/**
	 * ��һ��ͼƬ��������
	 * 
	 * @param context
	 *            �����Ļ���
	 * @param res
	 *            ԭʼ�DƬ��ID
	 * @param x
	 *            ԭʼ�DƬ�Č��ȿs�ű���
	 * @param y
	 *            ԭʼ�DƬ�ĸ߶ȿs�ű���
	 * @return �s�ź�ĈDƬ
	 */
		public static Bitmap getBitmap(Context context, int res) {
		Bitmap buffer = BitmapFactory.decodeResource(context.getResources(),
				res);
		int width = buffer.getWidth();

		int height = buffer.getHeight();

		Matrix m_Matrix = new Matrix();

		m_Matrix.setScale((float) bufferX / 2, (float) bufferY / 2);

		Bitmap bitmap = Bitmap.createBitmap(buffer, 0, 0, width, height,
				m_Matrix, true);

		return bitmap;
	}

	/**
	 * ��bitmapתΪdrawable
	 * 
	 * @param context
	 *            �����Ļ���
	 * @param bitmap
	 *            ԭʼ��bitmap
	 * @return ת�����drawable
	 */
	public static Drawable getDrawable(Context context, Bitmap bitmap) {

		Drawable drawable = new BitmapDrawable(context.getResources(), bitmap);

		return drawable;
	}

}
