package com.nazmul.retrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nazmul.rectrofit.R;
import com.nazmul.retrofit.model.Contacts;
import com.nazmul.retrofit.remote.ApiClient;
import com.nazmul.retrofit.remote.ApiInterface;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button signup,login;
    private ProgressDialog loading;
    EditText etxtCell,etxtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


     signup = findViewById(R.id.btn_signup);
     login = findViewById(R.id.btn_login);
     etxtCell= findViewById(R.id.etxt_cell);
     etxtPassword=findViewById(R.id.etxt_password);


     signup.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
             startActivity(intent);
         }
     });

     login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String cell = etxtCell.getText().toString();
             String password= etxtPassword.getText().toString();

             //validation
             if (cell.length()!=11){
                 etxtCell.setError("Invalid Cell!");
                 etxtCell.requestFocus();

             }
             else if (password.isEmpty()){
                 etxtPassword.setError("password can't be Empty!");
                 etxtPassword.requestFocus();

             }
             else {
                 login(cell,password);
             }
         }
     });


    }

    private void login(String cell, String password){
        loading=new ProgressDialog(this);
        loading.setMessage("Please Wait");
        loading.show();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Contacts> call = apiInterface.login(cell,password);
        call.enqueue(new Callback<Contacts>() {
            @Override
            public void onResponse(Call<Contacts> call, Response<Contacts> response) {
                String value = response.body().getValue();
                String message = response.body().getMassage();
                if (value.equals("success")){
                    loading.dismiss();
                    Toasty.success(LoginActivity.this,"Login Successfull ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    loading.dismiss();
                    Toasty.info(LoginActivity.this,"something is wrong!",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<Contacts> call, Throwable t) {
                loading.dismiss();
                Toasty.error(LoginActivity.this,"Network Error",Toast.LENGTH_LONG).show();

            }
        });

    }


}
