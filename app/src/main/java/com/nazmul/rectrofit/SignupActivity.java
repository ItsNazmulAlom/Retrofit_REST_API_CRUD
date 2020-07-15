package com.nazmul.rectrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nazmul.rectrofit.model.Contacts;
import com.nazmul.rectrofit.remote.ApiClient;
import com.nazmul.rectrofit.remote.ApiInterface;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    EditText etxtname,etxtcell,etxtpassword;
    Button btnSignup;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etxtname = findViewById(R.id.etxt_name);
        etxtcell = findViewById(R.id.etxt_cell);
        etxtpassword= findViewById(R.id.etxt_password);
        btnSignup = findViewById(R.id.btn_signup);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //taking value

                String name = etxtname.getText().toString();
                String cell = etxtcell.getText().toString();
                String password = etxtpassword.getText().toString();

                //field validation

                if (name.isEmpty()){
                    etxtname.setError("Name can not be empty!");
                    etxtname.requestFocus();
                }
                else if (cell.length()!=11){
                    etxtcell.setError("ivalid cell");
                    etxtcell.requestFocus();
                }
                else if (password.length()!=5){
                    etxtpassword.setError("password shoud be > 5 character!");
                    etxtpassword.requestFocus();
                }
                else {
                    sign_up(name,cell,password);
                }


            }
        });

    }

    private void sign_up(String name,String cell, String password){
        loading = new ProgressDialog(this);
        loading.setMessage("Please Wait...");
        loading.show();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Contacts> call = apiInterface.signUp(name,cell,password);
        call.enqueue(new Callback<Contacts>() {
            @Override
            public void onResponse(Call<Contacts> call, Response<Contacts> response) {
                String value = response.body().getValue();
                String message = response.body().getMassage();
                Log.d("value",value);
                Log.d("message",message);
                if (value.equals("success")){
                    loading.dismiss();
//                    Toast.makeText(SignupActivity.this,message,Toast.LENGTH_LONG).show();
//                    Toasty.success(SignupActivity.this,"Success!",Toast.LENGTH_SHORT, true).show();
                    Toasty.success(SignupActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);

                }
                else if (value.equals("exists")){
                    loading.dismiss();
                    Toasty.info(SignupActivity.this,"already have account!",Toast.LENGTH_SHORT,true).show();
                    Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else {
                    loading.dismiss();
                    Toast.makeText(SignupActivity.this, message, Toast.LENGTH_SHORT).show();
//                    Toasty.info(SignupActivity.this,"").show();
                }
            }

            @Override
            public void onFailure(Call<Contacts> call, Throwable t) {
                loading.dismiss();
//                Toasty.error(yourContext, "This is an error toast.", Toast.LENGTH_SHORT, true).show();
                Toasty.error(SignupActivity.this,"Something is wrong",Toast.LENGTH_SHORT,true).show();


            }
        });
    }

}
