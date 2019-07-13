package com.openthedoorprovider;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fourhcode.forhutils.FUtilsValidation;
import com.fourhcode.forhutils.Futils;
import com.openthedoorprovider.pojo.LoginResponse;
import com.openthedoorprovider.utils.NetworkAvailable;
import com.openthedoorprovider.utils.RetrofitClientInstance;
import com.openthedoorprovider.utils.RetrofitInterface;

import java.security.acl.LastOwnerException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

    private static final String TAG ="SignInActivity" ;
    @BindView(R.id.sign_up_txt) TextView signUpTxtView;
    @BindView(R.id.forget_password_txt) TextView forgetPasswordTxtView;
    @BindView(R.id.sign_in_btn) MaterialButton signInBtn;
    @BindView(R.id.phone_input_layout) TextInputLayout phoneInput;
    @BindView(R.id.password_input_layout) TextInputLayout passwordInput;

     RetrofitInterface retrofitInterface;
  public  static   LoginResponse loginResponse;
    NetworkAvailable available;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);

        retrofitInterface=RetrofitClientInstance.getRetrofitInstance();
        available=new NetworkAvailable(this);

        signUpTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),SignUp1Activity.class));
            }
        });


        forgetPasswordTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ForgetPasswordActivity.class));
            }
        });


        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();

            }
        });


//
//        if (HomeActivity.lang.equals("en")) {
//            Locale locale = new Locale("en");
//            Locale.setDefault(locale);
//            Configuration config = new Configuration();
//            config.locale = locale;
//            getBaseContext().getResources().updateConfiguration(config,
//                    getBaseContext().getResources().getDisplayMetrics());
//
//            Intent refresh = new Intent(this, SignInActivity.class);
//            startActivity(refresh);
//        }
//



    }

    private void loginUser() {
        String email=phoneInput.getEditText().getText().toString();
        String password=passwordInput.getEditText().getText().toString();

        if(!FUtilsValidation.isEmpty(phoneInput.getEditText(),"please enter your phone number !")
                &&!FUtilsValidation.isEmpty(passwordInput.getEditText(),"please enter password !")
                ){
            if(available.isAvailable()){
                Map<String,Object> map=new HashMap<>();
                map.put("email",email);
                map.put("password",password);


                retrofit2.Call<LoginResponse> call=retrofitInterface.loginUser(map);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(retrofit2.Call<LoginResponse> call, Response<LoginResponse> response) {

                        loginResponse=response.body();
                        Log.v(TAG,"loginnnnnn"+response.body().toString());
                        Intent intent=new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(retrofit2.Call<LoginResponse> call, Throwable t) {
                        Log.v(TAG,"loginnnnnn"+t.getMessage().toString());
                    }
                });

            }
            else {
                Toast.makeText(getApplicationContext(),"make sure internet is connected!!",Toast.LENGTH_LONG).show();
            }


        }



    }
}
