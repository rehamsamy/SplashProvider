package com.openthedoorprovider;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fourhcode.forhutils.FUtilsValidation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgetPasswordActivity extends AppCompatActivity {

    @BindView(R.id.phone_input_layout) TextInputLayout phoneInput;
    @BindView(R.id.send_code_btn) TextInputLayout sendCodeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);

        sendCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!FUtilsValidation.isEmpty(phoneInput.getEditText(),"please enter your phone number!")
                        && FUtilsValidation.isPhone(phoneInput.getEditText().toString())){

                }
            }
        });

    }
}
