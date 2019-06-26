package com.openthedoorprovider;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fourhcode.forhutils.FUtilsValidation;
import com.fourhcode.forhutils.Futils;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.sign_up_txt) TextView signUpTxtView;
    @BindView(R.id.forget_password_txt) TextView forgetPasswordTxtView;
    @BindView(R.id.sign_in_btn) MaterialButton signInBtn;
    @BindView(R.id.phone_input_layout) TextInputLayout phoneInput;
    @BindView(R.id.password_input_layout) TextInputLayout passwordInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);

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
                if(!FUtilsValidation.isEmpty(phoneInput.getEditText(),"please enter your phone number !")
                        &&!FUtilsValidation.isEmpty(passwordInput.getEditText(),"please enter password !")
                        )
                   // && FUtilsValidation.isPhone(phoneInput.getEditText().toString())

                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
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
}
