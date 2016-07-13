package com.example.administrator.day7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.day7.adapter.Singer_Infor_Adapter;
import com.example.administrator.day7.adapter.SongAdapter;

import com.example.administrator.day7.data.MyResponse;
import com.example.administrator.day7.data.Singer_Infor_Response;
import com.example.administrator.day7.data.SongList;
import com.example.administrator.day7.net.ServiceApi;
import com.example.administrator.day7.net.ServiceApiListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/9.
 */
public class Singer_page extends Activity implements View.OnClickListener, MediaPlayer.OnPreparedListener {
    private TextView textView_singername, textView_songname, play_song;
    String url = "http://192.168.0.2:8080//FsMusic/songOfSinger?singerId=";
    String position = null;
    String URL = null;
    String thesong_url;
    String singer_name = " ", singer_imageurl = "";
    List<SongList> list = new ArrayList<SongList>();
    ImageView singer_imageView, song_image;
    String image_url = null;
    Context context;
    ListView listView;
    Singer_Infor_Adapter singer_infor_adapter;
    View view;
    ArrayAdapter<String> adapter;
    MediaPlayer mediaPlayer = new MediaPlayer();
    String song_url[] = new String[10];
    Boolean TAG = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.singerinfor_layout);

        singer_imageView = (ImageView) findViewById(R.id.song_singer_image);
        song_image = (ImageView) findViewById(R.id.singer_infor_image);

        textView_singername = (TextView) findViewById(R.id.song_singer_name);
        textView_songname = (TextView) findViewById(R.id.song_name);
        play_song = (TextView) findViewById(R.id.play_song);
        play_song.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.singer_infor_list);

        Intent intent = getIntent();//这一步切记不要搞错！！！！！！
        position = intent.getStringExtra("list_position");
        singer_name = intent.getStringExtra("singer_name");
        singer_imageurl = intent.getStringExtra("singer_image");
        Log.e("name", singer_name);
        Log.e("image", singer_imageurl);

        URL = url + position;
        Log.e("url", URL);

        textView_singername.setText(singer_name);

        getListView(URL);
        setimage(singer_imageurl, singer_imageView);
    }


    public void getListView(String surl) {
        final ServiceApi serviceApi = new ServiceApi(surl, this, new ServiceApiListener() {
            @Override
            public void getResponse(MyResponse m_Response) {
                final Singer_Infor_Response singer_infor_response = (Singer_Infor_Response) m_Response;
                Log.e("infor", singer_infor_response.toString());

                image_url = singer_infor_response.getList().get(0).getSong_icon_url();
                setimage(image_url, song_image);

                Log.d("tesimage", image_url);
                int length = singer_infor_response.getList().size();
                final String name[] = new String[length];
                final String song_url[] = new String[length];

                for (int i = 0; i < length; i++) {
                    name[i] = singer_infor_response.getList().get(i).getSong_neme();

                    list.add(new SongList(name[i]));
                    Log.d("testname", name[i]);

                    song_url[i] = singer_infor_response.getList().get(i).getSong_url();

                    SongAdapter songAdapter = new SongAdapter(Singer_page.this, R.layout.singer_list_detail, list);

                    listView.setAdapter(songAdapter);

                }

                thesong_url = song_url[0];
                textView_songname.setText(name[0]);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (TAG){
                            textView_songname.setText(name[position]);
                            thesong_url = song_url[position];
                            Toast.makeText(Singer_page.this, "播放", Toast.LENGTH_SHORT).show();
                            Log.e("song", thesong_url);
                            init_play(thesong_url);
                            play_song.setBackgroundResource(R.drawable.player_view_pause_default);
                            TAG = false;
                        }else {
                            Toast.makeText(Singer_page.this, "点击过了", Toast.LENGTH_SHORT).show();
                        }
                        
                    }
                });

            }
        });

        serviceApi.askData(Singer_Infor_Response.class);
    }

    Drawable drawable;

    public void setimage(String songimage_url, final ImageView image) {

        RequestQueue mQueue = Volley.newRequestQueue(Singer_page.this);
        ImageRequest imageRequest = new ImageRequest(
                songimage_url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        image.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                image.setImageResource(R.drawable.ic_launcher);
            }
        });
        mQueue.add(imageRequest);
        image.setBackgroundDrawable(drawable);
    }


    public void init_play(String url) {
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        Log.e("hehe", url);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {//当歌曲准备好以后
        mediaPlayer.start();//开始播放
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.play_song:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    play_song.setBackgroundResource(R.drawable.player_view_play_default);

                } else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    play_song.setBackgroundResource(R.drawable.player_view_pause_default);
                }
                break;

            case R.id.last_song:

                break;

            case R.id.next_song:

                break;
        }


    }
}