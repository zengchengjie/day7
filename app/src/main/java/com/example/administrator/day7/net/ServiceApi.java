package com.example.administrator.day7.net;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.day7.data.MyResponse;
import com.google.gson.Gson;

public class ServiceApi {

    String url;

    Context m_Context;

    ServiceApiListener m_ServiceApiListener;


    public ServiceApi(String url, Context m_Context,
                      ServiceApiListener m_ServiceApiListener) {
        this.url = url;

        this.m_Context = m_Context;

        this.m_ServiceApiListener = m_ServiceApiListener;

    }

    public void askData(final Class<?> cl) {
        RequestQueue mQueue = Volley.newRequestQueue(m_Context);

        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String infor = response.substring(1,
                                response.length() - 1);

                        MyResponse m_Response = (MyResponse) new Gson().fromJson(infor, cl);

                        m_ServiceApiListener.getResponse(m_Response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String infor = error.getMessage();
                String infor2 = error.toString();
                System.out.println(infor);
                System.out.println(infor2);
            }
        });

        mQueue.add(stringRequest);
    }

}
