package com.ggv.cryptocurrencystore.services;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AssetService {

    public interface ResultListener {
        void onSuccess(JSONObject response);
        void onFail(JSONObject response);
        void onError(VolleyError error);
    }

    Context context;

    public AssetService(Context context){
        this.context = context;
    }


    public void get(AssetService.ResultListener listener){
        String url ="http://54.151.229.213:8000/assets";

        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject body = new JSONObject();
//        try {
//            body.put("username", username);
//            body.put("password", password);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, body, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            boolean success = response.getBoolean("success");
                            if(success){
                                listener.onSuccess(response);
                            }else{
                                listener.onFail(response);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        // textView.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        listener.onError(error);
                    }
                }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
//                params.put("username", username);
//                params.put("password", password);
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        queue.add(jsonObjectRequest);

    }
}