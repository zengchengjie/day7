package com.example.administrator.day7;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.app.Activity;
import android.widget.Toast;

import com.example.administrator.day7.adapter.SingerAdapter;
import com.example.administrator.day7.data.MyResponse;
import com.example.administrator.day7.data.SingerData;
import com.example.administrator.day7.data.SingerResponse;
import com.example.administrator.day7.interfaces.OnMyClickListener;
import com.example.administrator.day7.net.ServiceApi;
import com.example.administrator.day7.net.ServiceApiListener;
import com.example.administrator.day7.tool.MyImageFactory;
import com.example.administrator.day7.widget.MyMenu;

import org.json.JSONObject;

public class MainActivity extends Activity {

    String url = "http://192.168.0.2:8080/FsMusic/singer";
    ListView listView;
    List<SingerData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics m_DisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(m_DisplayMetrics);
        list = new ArrayList<SingerData>();//创建集合
        MyImageFactory.init(m_DisplayMetrics.widthPixels,
                m_DisplayMetrics.heightPixels);

        setContentView(R.layout.activity_main);
        listView = (ListView) this.findViewById(R.id.list_view);


        getWidget();
        list_click();

    }


    /**
     * �����ʾ���
     */
    private void getWidget() {

        getMenu();
        getListView();
    }


    /**
     * ��ò˵����
     */
    private void getMenu() {
        MyMenu menu = (MyMenu) this.findViewById(R.id.my_menu);

        MenuLister m_MenuLister = new MenuLister();
        //���ü���
        menu.setOnMyClickListener(m_MenuLister);

    }

    public class MenuLister implements OnMyClickListener {

        @Override
        public void onClickRecommend() {


        }

        @Override
        public void onClickList() {

        }

        @Override
        public void onClickSinger() {


        }

        @Override
        public void onClickMusicList() {
        }

        @Override
        public void onClickClass() {

        }

    }


    private void getListView() {

        /**
         * 下面是获取数据
         */
        final ServiceApi serviceApi = new ServiceApi(url, this, new ServiceApiListener() {
            @Override
            public void getResponse(MyResponse m_Response) {

                SingerResponse singerResponse = (SingerResponse) m_Response;

                Log.e("singer_infor", singerResponse.toString() );

                int length = singerResponse.getList().size();
                String name[] = new String[length];
                String introduce[] = new String[length];
                String images[] = new String[length];

                for (int i = 0; i < length; i++) {
                    name[i] = singerResponse.getList().get(i).getName();
                    introduce[i] = singerResponse.getList().get(i).getIntroduce();
                    images[i] = singerResponse.getList().get(i).getSinger_icon_url();


                    //装入数据
                    list.add(new SingerData(images[i], name[i], introduce[i]));
                    // 3,准备adapter对象
                    SingerAdapter m_SingerAdapter = new SingerAdapter(MainActivity.this, list);
                    listView.setAdapter(m_SingerAdapter);
                }
            }
        });   // 4,让listView和SingerAdapter产生联系

        serviceApi.askData(SingerResponse.class);

    }

    public void list_click() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Intent intent = new Intent(MainActivity.this, Singer_page.class);
                intent.putExtra("list_position", (position+1)+"");

                Log.d("surl",(position+1)+"");
//                Toast.makeText(MainActivity.this, position, Toast.LENGTH_SHORT).show();
				intent.putExtra("singer_name",list.get(position).getName());
				intent.putExtra("singer_image",list.get(position).getImageRes());

                startActivity(intent);
            }
        });
    }


}
