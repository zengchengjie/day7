package com.example.administrator.day7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.day7.R;
import com.example.administrator.day7.data.SongList;

import java.util.List;

/**
 * Created by Administrator on 2016/7/12.
 */
public class SongAdapter  extends ArrayAdapter<SongList> {
private int recsourceid;
    public SongAdapter(Context context, int resource, List<SongList> objects) {
        super(context, resource, objects);
        recsourceid= resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SongList  songList= getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(recsourceid,null);
        TextView textView = (TextView) view.findViewById(R.id.song_list_name);
        textView.setText(songList.getSong_name());
        return view;
    }


}
