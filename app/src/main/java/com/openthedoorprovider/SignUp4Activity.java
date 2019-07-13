package com.openthedoorprovider;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.fourhcode.forhutils.FUtilsValidation;
import com.fourhcode.forhutils.Futils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp4Activity extends AppCompatActivity {

    @BindView(R.id.sign_in_btn) MaterialButton signInBtn;
    @BindView(R.id.signup4_toolbar) Toolbar toolbar;
    @BindView(R.id.back_btn) ImageView backImage;
    @BindView(R.id.confirmpassword_input_layout)TextInputLayout confirmPasswordInput;
    @BindView(R.id.password_input_layout)TextInputLayout passwordInput;

    String email,phone,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        email=intent.getStringExtra("email");
        phone=intent.getStringExtra("phone");
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!FUtilsValidation.isEmpty(passwordInput.getEditText(),"please enter your password !")
                        && !FUtilsValidation.isEmpty(confirmPasswordInput.getEditText(),"please enter your confirm password !")
                    &&FUtilsValidation.isPasswordEqual(passwordInput.getEditText(),confirmPasswordInput.getEditText(),"password not matched"))
                {
                    Intent intent1=new Intent(getApplicationContext(), VerificationCodeActivity.class);
                    intent1.putExtra("phone",phone);
                    intent1.putExtra("email",email);
                    intent1.putExtra("name",name);
                    intent1.putExtra("password",passwordInput.getEditText().getText().toString());
                    intent1.putExtra("confirm_password",confirmPasswordInput.getEditText().getText().toString());
                    startActivity(intent1);

                } }
        });

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp3Activity.class));
            }
        });



    }
}
