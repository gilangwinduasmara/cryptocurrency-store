package com.ggv.cryptocurrencystore.ui.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.ggv.cryptocurrencystore.R;
import com.ggv.cryptocurrencystore.models.Users;
import com.ggv.cryptocurrencystore.services.AuthService;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class ProfileFragment extends Fragment {

    private EditText editTextUsername, editTextName, editTextEmail;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        editTextUsername = view.findViewById(R.id.edtUsername);
        editTextName = view.findViewById(R.id.edtName);
        editTextEmail = view.findViewById(R.id.edtEmail);

//        Textview textViewBlabla = view.findById(blabla)
        AuthService authService = new AuthService(getActivity());

        authService.getUser(new AuthService.ResultListener() {
            @Override
            public void onSuccess(JSONObject response) {
                Log.d("user", response.toString());
              Users user = new Users();
                try {
                    JSONObject userObject = response.getJSONObject("user");
                    user.setUsername(userObject.getString("username"));
                    user.setName(userObject.getString("name"));
                    user.setEmail(userObject.getString("email"));
                    editTextUsername.setText(user.getUsername());
                    editTextName.setText(user.getName());
                    editTextEmail.setText(user.getEmail());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFail(JSONObject response) {

            }

            @Override
            public void onError(VolleyError error) {

            }
        });
        return view;
    }
}