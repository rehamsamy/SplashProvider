package com.openthedoorprovider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.openthedoorprovider.pojo.RegisterProviderResponse;
import com.openthedoorprovider.utils.RetrofitClientInstance;
import com.openthedoorprovider.utils.RetrofitInterface;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerificationCodeActivity extends AppCompatActivity {

    private static final String TAG = "VerificationCodeActivity";
    @BindView(R.id.signup4_toolbar) Toolbar toolbar;
    @BindView(R.id.back_btn) ImageView backImage;
    @BindView(R.id.verify_btn) MaterialButton verifyBtn;
    String name,email,password,confirmPassword,phone;
    RetrofitInterface retrofitInterface;
    List<Uri> uriListData;
   InputStream inputStream1,inputStream2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);

        ButterKnife.bind(this);
        retrofitInterface= RetrofitClientInstance.getRetrofitInstance();

        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        email=intent.getStringExtra("email");
        phone=intent.getStringExtra("phone");
        password=intent.getStringExtra("password");
        confirmPassword=intent.getStringExtra("confirm_password");
       uriListData=SignUp3Activity.selectedUriList;

        try {
            inputStream1=getContentResolver().openInputStream(uriListData.get(0));
            inputStream2=getContentResolver().openInputStream(uriListData.get(1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp4Activity.class));
            }
        });

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    registerProvider(getByte(inputStream1));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void registerProvider(byte[]bytes) {
        Map<String,Object> map=new HashMap<>();
        map.put("name",name);
        map.put("email",email);
        map.put("phone",phone);
        map.put("password",password);
        map.put("password_confirmation",confirmPassword);
        map.put("birthdate","2019-07-02");
        map.put("gender","male");
        map.put("citizen","citizen");
        map.put("employee","employee");
        map.put("residentnumberorstatuscard","residentnumberorstatuscard");
        map.put("placeofemployment","placeofemployment");



        Log.v("LoginActivity","rrrrrrrrrr"+"\n"+name+"\n"+email+"\n"+password+"\n"+confirmPassword+"\n"+phone);
          // File file=new File();
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), bytes);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file","name", requestBody);


        final RequestBody requestBody1=RequestBody.create(MediaType.parse("image/jpeg"),bytes);
        MultipartBody.Part part=MultipartBody.Part.createFormData("image", "image.jpeg",requestBody1);


       // MultipartBody.Part part2=MultipartBody.Part.createFormData("image", "image.jpeg",requestBody1);


        Call<RegisterProviderResponse> call=retrofitInterface.registerProvider(map,part,fileToUpload);

        call.enqueue(new Callback<RegisterProviderResponse>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(Call<RegisterProviderResponse> call, Response<RegisterProviderResponse> response) {
                Log.v(TAG,"registerrrrr"+response.body().toString());
                if(response.body().isStatus()){
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                }

            }

            @SuppressLint("LongLogTag")
            @Override
            public void onFailure(Call<RegisterProviderResponse> call, Throwable t) {
                Log.v(TAG,"registerrrrr"+t.getMessage());
            }
        });

    }


    private byte[] getByte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
         int size=1024;
        byte [] bytes=new byte[size];
        int len=0;

        while ((len=inputStream.read(bytes))!=-1){
           outputStream.write(bytes,0,len);
        }
        return  outputStream.toByteArray();
    }



}