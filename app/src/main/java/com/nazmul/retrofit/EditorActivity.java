package com.nazmul.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nazmul.rectrofit.R;
import com.nazmul.retrofit.model.Contacts;
import com.nazmul.retrofit.remote.ApiClient;
import com.nazmul.retrofit.remote.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorActivity extends AppCompatActivity {


    private ApiInterface apiInterface;
    EditText etxtname,etxtemail;
    Button btnsave,btndelete;

    //get data from main activity recycler view
    String getID;
    String getName;
    String getEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

//get data from recylcer view
        Intent i = getIntent();
        getID = i.getStringExtra("id");
        getName = i.getStringExtra("name");
        getEmail = i.getStringExtra("email");


        etxtname = findViewById(R.id.etxt_name);
        etxtemail = findViewById(R.id.etxt_email);
        btnsave = findViewById(R.id.btn_save);
        btndelete = findViewById(R.id.btn_delete);

        condition(getID);
        

    }

    private void condition(String getID) {
        if (getID == null){
            btndelete.setVisibility(View.INVISIBLE);
            btnsave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    insertUser();
                }
            });
        }else {
            etxtname.setText(getName);
            etxtemail.setText(getEmail);
            Log.d("Id",getID);
            btnsave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editUser();
                }
            });

            btndelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteUser();
                }
            });
        }

    }

    private void insertUser(){
       String sname = etxtname.getText().toString();
       String semail = etxtemail.getText().toString();
       apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
       Call<Contacts> call = apiInterface.insertUser(sname,semail);
        call.enqueue(new Callback<Contacts>() {
            @Override
            public void onResponse(Call<Contacts> call, Response<Contacts> response) {
                String value = response.body().getValue();
                String message = response.body().getMassage();
                if (value.equals("1")){
                    Toast.makeText(EditorActivity.this, message, Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(EditorActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Contacts> call, Throwable t) {
                Toast.makeText(EditorActivity.this, "Error! "+ t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void editUser(){
        String sid = getID;
        String sname = etxtname.getText().toString();
        String semail= etxtemail.getText().toString();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Contacts> call = apiInterface.editUser(sid,sname,semail);
        call.enqueue(new Callback<Contacts>() {
            @Override
            public void onResponse(Call<Contacts> call, Response<Contacts> response) {
                String value = response.body().getValue();
                String message = response.body().getMassage();
                if (value.equals("1")){
                    Toast.makeText(EditorActivity.this,message,Toast.LENGTH_LONG).show();
                    finish();
                }
                else {
                    Toast.makeText(EditorActivity.this,message,Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Contacts> call, Throwable t) {
                Toast.makeText(EditorActivity.this,"Error!"+t.toString(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void deleteUser(){
       int id = Integer.parseInt(getID);

       apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
       Call<Contacts> call = apiInterface.deleteUser(id);
       call.enqueue(new Callback<Contacts>() {
           @Override
           public void onResponse(Call<Contacts> call, Response<Contacts> response) {
               String value = response.body().getValue();
               String message = response.body().getMassage();
               if (value.equals("1")){
                   Toast.makeText(EditorActivity.this, message, Toast.LENGTH_SHORT).show();
                   finish();
               } else {
                   Toast.makeText(EditorActivity.this, message, Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onFailure(Call<Contacts> call, Throwable t) {
               Toast.makeText(EditorActivity.this, "Error! "+ t.toString(), Toast.LENGTH_SHORT).show();

           }
       });



    }




}
