package com.openthedoorprovider;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.fourhcode.forhutils.FUtilsValidation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp2Activity extends AppCompatActivity {

    @BindView(R.id.continue_btn) MaterialButton continueBtn;
    @BindView(R.id.signup2_toolbar) Toolbar toolbar;
    @BindView(R.id.back_btn) ImageView backImage;
    @BindView(R.id.password_input_layout) TextInputLayout passwordInput;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Intent intent=getIntent();
        phone=intent.getStringExtra("phone");

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!FUtilsValidation.isEmpty(passwordInput.getEditText(),"please enter the code!")){
                    Intent intent1=new Intent(getApplicationContext(),SignUp3Activity.class);
                    intent1.putExtra("phone",phone);
                    startActivity(intent1);

                }

            }
        });

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp1Activity.class));
            }
        });
    }
}
