package com.delowar.post_api;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Interface.InterfaceClass;
import modelClass.LogInModel;
import modelClass.LogInResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    InterfaceClass interfaceClass;
    LogInModel logInModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username=findViewById(R.id.user_name);
        password=findViewById(R.id.password);

        Retrofit retrofit=new Retrofit.Builder()
                          .baseUrl("http://dotnet.nerdcastlebd.com/")
                          .addConverterFactory(GsonConverterFactory.create())
                          .build();

        interfaceClass=retrofit.create(InterfaceClass.class);
    }

    public void logIn(View view) {
        logInModel=new LogInModel(username.getText().toString(),password.getText().toString());

        Call<LogInResponse> callApi= interfaceClass.logInUser(logInModel);
        callApi.enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                if (response.isSuccessful()){
                    boolean message=response.body().getResultState();
                    Toast.makeText(getApplicationContext(),""+message,Toast.LENGTH_SHORT).show();
                }else {
                    String message="An error occurred try again...";
                    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LogInResponse> call, Throwable t) {
                String message=t.getLocalizedMessage();
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });

    }
}