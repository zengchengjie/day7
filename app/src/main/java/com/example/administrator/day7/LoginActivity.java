package com.example.administrator.day7;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.day7.data.MyResponse;
import com.example.administrator.day7.data.SingerResponse;
import com.example.administrator.day7.net.ServiceApi;
import com.example.administrator.day7.net.ServiceApiListener;

public class LoginActivity extends Activity implements OnClickListener {


    static String ip = "192.168.0.2";

    EditText editText_userName;

    EditText editText_passWd;


    TextView button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        createEditText_userName();
        createEditText_passWd();
        createButton_login();
    }

    private void createButton_login() {
        button_login = (TextView) this
                .findViewById(R.id.login_page_login_button2);

        button_login.setOnClickListener(this);


    }

    private void createEditText_passWd() {
        editText_passWd = (EditText) this
                .findViewById(R.id.login_page_edit_passwd);
    }

    private void createEditText_userName() {
        editText_userName = (EditText) this
                .findViewById(R.id.login_page_edit_user_name);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.login_page_login_button2:
                actionLogin();
                break;
        }

    }

    String url = "http://192.168.0.2:8080//FsMusic/recommend";

    private void actionLogin() {
//		//1�����û����༭��������
//		String userName = editText_userName.getText().toString();
//		//2��������༭��������
//		String passWd = editText_passWd.getText().toString();
//		//3��ƴ��URL
//		StringBuilder buffer = new StringBuilder(url);
//		buffer.append(userName);
//		buffer.append("&password=");
//		buffer.append(passWd);
//		
//		url=buffer.toString();

        ServiceApi m_ServiceApi = new ServiceApi(url, this, new ServiceApiListener() {
            @Override
            public void getResponse(MyResponse m_Response) {
                SingerResponse m_SingerResponse = (SingerResponse) m_Response;

                if (m_SingerResponse.code.equals("1")) {
                    turnToMainPage();
                }
            }
        });
        m_ServiceApi.askData(SingerResponse.class);

    }

    private void turnToMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
