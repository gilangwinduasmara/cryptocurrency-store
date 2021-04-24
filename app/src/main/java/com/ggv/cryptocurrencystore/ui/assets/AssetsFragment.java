package com.ggv.cryptocurrencystore.ui.assets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.ggv.cryptocurrencystore.R;
import com.ggv.cryptocurrencystore.adapter.AssetAdapter;
import com.ggv.cryptocurrencystore.models.Asset;
import com.ggv.cryptocurrencystore.services.AssetService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AssetsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AssetsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;

    public AssetsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AssetsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AssetsFragment newInstance(String param1, String param2) {
        AssetsFragment fragment = new AssetsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_assets, container, false);

        AssetService assetService = new AssetService(getActivity());

        assetService.get(new AssetService.ResultListener() {
            @Override
            public void onSuccess(JSONObject response) {
                try {
                    Log.d("assets",response.toString());
                    List<Asset> assets = new ArrayList<>();
                    JSONArray assetsResponse = response.getJSONArray("data");
                    for(int i = 0; i < assetsResponse.length(); i++){
                        JSONObject assetObject = assetsResponse.getJSONObject(i);
                        Asset asset = new Asset();
                        asset.setName(assetObject.getString("name"));
                        assets.add(asset);
                        Log.d("asset name", asset.getName());
                    }
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView = view.findViewById(R.id.recyclerViewAsset);
                    recyclerView.setLayoutManager(layoutManager);
                    AssetAdapter adapter = new AssetAdapter(assets);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFail(JSONObject response) {
                Log.d("assets",response.toString());
            }

            @Override
            public void onError(VolleyError error) {
                error.printStackTrace();
            }
        });

        return view;
    }
}