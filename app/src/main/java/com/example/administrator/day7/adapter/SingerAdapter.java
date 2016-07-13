package com.example.administrator.day7.adapter;

import java.util.HashMap;
import java.util.List;



import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.administrator.day7.Singer_page;
import com.example.administrator.day7.data.SingerData;
import com.example.administrator.day7.widget.SingerView;

public class SingerAdapter extends BaseAdapter {

	HashMap<Integer, Drawable> map = new HashMap<Integer, Drawable>();

	List<SingerData> list;

	Context context;

	public SingerAdapter(Context context, List<SingerData> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {

		return position;
	}

	@Override
	public long getItemId(int position) {

		return position;
	}


	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = new SingerView(context);

		}

		// if (map.get(list.get(position).getImageRes()) == null) {
		//
		// Bitmap bitmap = MyImageFactory.getBitmap(context, list
		// .get(position).getImageRes());
		// Drawable drawable = MyImageFactory.getDrawable(context, bitmap);
		//
		// map.put(list.get(position).getImageRes(), drawable);
		//
		// }

		((SingerView) convertView).setSingerData(list.get(position));

//		convertView.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(context, Singer_page.class);
//				intent.putExtra("list_position",position);
//				Toast.makeText(context, position, Toast.LENGTH_SHORT).show();
//				intent.putExtra("singer_name",list.get(position).getName());
//				intent.putExtra("singer_image",list.get(position).getImageRes());
//
//				context.startActivity(intent);
//			}
//		});


		return convertView;
	}

}
