package com.ggv.cryptocurrencystore.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

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

public class TransactionService {
    private String token;

    public interface ResultListener {
        void onSuccess(JSONObject response);
        void onFail(JSONObject response);
        void onError(VolleyError error);
    }

    Context context;

    public TransactionService(Context context){
        this.context = context;
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        this.token = sharedPref.getString("token", "");
    }

    public void get(AssetService.ResultListener listener){
        String url ="http://54.151.229.213:8000/transactions/user";

        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject body = new JSONObject();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, body, new Response.Listener<JSONObject>() {

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

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error);
                    }
                }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("Authorization", "Bearer "+token);
                return headers;
            }
        };

        queue.add(jsonObjectRequest);

    }

    public void create(String asset_id, String ammount, String status, AssetService.ResultListener listener){
        String url ="http://54.151.229.213:8000/transactions";

        RequestQueue queue = Volley.newRequestQueue(context);
        JSONObject body = new JSONObject();
        try {
            body.put("asset_id", asset_id);
            body.put("ammount", ammount);
            body.put("status", status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
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

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listener.onError(error);
                    }
                }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("Authorization", "Bearer "+token);
                return headers;
            }
        };

        queue.add(jsonObjectRequest);

    }
}
