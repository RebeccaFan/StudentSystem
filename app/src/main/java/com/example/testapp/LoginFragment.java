package com.example.testapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://192.168.0.108:8080";


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_login, container, false);
        Button button = (Button) view.findViewById(R.id.btn_login);


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLoginDialog(view);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void handleLoginDialog(View v) {

        final EditText emailEdit = v.findViewById(R.id.et_email);
        final EditText passwordEdit = v.findViewById(R.id.et_password);

        HashMap<String, String> map = new HashMap<>();

        map.put("email", emailEdit.getText().toString());
        map.put("password", passwordEdit.getText().toString());

        Call<LoginResult> call = retrofitInterface.executeLogin(map);

        call.enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {

                if (response.code() == 200) {
                    // TODO - Fix
//                    ((MyApplication) getActivity().getApplication()).setAuthToken(response.headers().get("auth-token"));

                    Intent intent = new Intent(getActivity(), HomeActivity.class);

                    startActivity(intent);
                    Toast.makeText(getActivity(), "Logged in !!!!",
                            Toast.LENGTH_LONG).show();
                } else if (response.code() == 400) {
                    Toast.makeText(getActivity(), "Invalid Credentials",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "Server Error",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

}
