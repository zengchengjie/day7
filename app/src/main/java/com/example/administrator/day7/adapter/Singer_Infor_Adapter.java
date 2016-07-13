package com.example.administrator.day7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.day7.R;
import com.example.administrator.day7.data.Singer_Infor;
import com.example.administrator.day7.data.SongList;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
public class Singer_Infor_Adapter  extends BaseAdapter{


    List<SongList> list;
    Context context;
    private static HashMap<Integer, Boolean> isSeleceted;
    LayoutInflater layoutInflater = null;

    public Singer_Infor_Adapter(Context context, List<SongList> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
        isSeleceted = new HashMap<Integer, Boolean>();
        initData();
    }

    private void initData() {
        for (int i = 0; i < list.size(); i++) {
            getselected().put(i, null);
        }
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.singer_list_detail, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.song_list_name);
            viewHolder.imageView_left = (ImageView) convertView.findViewById(R.id.image_erji);
            viewHolder.imageView_right = (ImageView) convertView.findViewById(R.id.image_go);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(Singer_Infor.class.getName());

        return convertView;
    }
    public static HashMap<Integer, Boolean> getselected() {
        return isSeleceted;
    }

    public static void setlsSelected(HashMap<Integer, Boolean> isSelected) {
        Singer_Infor_Adapter.isSeleceted = isSelected;
    }

        class ViewHolder {
        TextView textView;
        ImageView imageView_left;
        ImageView imageView_right;
    }
}
