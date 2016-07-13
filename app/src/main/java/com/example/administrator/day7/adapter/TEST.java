package com.example.administrator.day7.adapter;

/**
 * Created by Administrator on 2016/7/9.
 */
public class TEST {
    /*package com.fs.music;

    import java.util.ArrayList;
    import java.util.List;
    import com.fs.music.adapter.SingerAdapter;
    import com.fs.music.data.SingerData;
    import com.fs.music.interfaces.OnMyClickListener;
    import com.fs.music.tool.MyImageFactory;
    import com.fs.music.widget.MyMenu;
    import android.os.Bundle;
    import android.util.DisplayMetrics;
    import android.widget.ListView;
    import android.app.Activity;

    public class MainActivity extends Activity {

        String url = "http://192.168.0.118:8080/music/do";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            DisplayMetrics m_DisplayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(m_DisplayMetrics);

            MyImageFactory.init(m_DisplayMetrics.widthPixels,
                    m_DisplayMetrics.heightPixels);

            setContentView(R.layout.activity_main);



            getWidget();


        }



        *//**
         * 获得显示组件
         *//*
        private void getWidget() {

            getMenu();
            getListView();
        }


        *//**
         * 获得菜单组件
         *//*
        private void getMenu() {
            MyMenu menu = (MyMenu) this.findViewById(R.id.my_menu);

            MenuLister m_MenuLister = new MenuLister();
            //设置监听
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

        *//**
         * 获得listview
         *//*
        private void getListView() {
            // 1,准备ListView对象
            ListView listView = (ListView) this.findViewById(R.id.list_view);

            // 2，准备数据
            String singers[] = getResources().getStringArray(R.array.singer_names);
            String introduces[] = getResources().getStringArray(
                    R.array.singer_introduce);
            int icons[] = { R.drawable.icon_01, R.drawable.icon_02,
                    R.drawable.icon_03, R.drawable.icon_04, R.drawable.icon_05,
                    R.drawable.icon_06, R.drawable.icon_07, R.drawable.icon_08,
                    R.drawable.icon_09, R.drawable.icon_10, };

            List<SingerData> list = new ArrayList<SingerData>();

            int length = icons.length;

            for (int i = 0; i < length; i++) {
                list.add(new SingerData(icons[i], singers[i], introduces[i]));
            }

            // 3,准备adapter对象
            SingerAdapter m_SingerAdapter = new SingerAdapter(this, list);

            // 4,让listView和SingerAdapter产生联系
            listView.setAdapter(m_SingerAdapter);

        }

    }*/

}
