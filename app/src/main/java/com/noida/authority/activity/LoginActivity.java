package com.noida.authority.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.noida.authority.R;
import com.noida.authority.body_model.TokenResponse;
import com.noida.authority.databinding.ActivityLoginBinding;
import com.noida.authority.pojo.Login;
import com.noida.authority.response_model.LoginResponse;
import com.noida.authority.retrofit.ApiManager;
import com.noida.authority.retrofit.ApiResponseInterface;
import com.noida.authority.utils.Constants;
import com.noida.authority.utils.SessionManager;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class LoginActivity extends AppCompatActivity implements ApiResponseInterface {

    Dialog dialogLayout;
    ApiManager apiManager;
    ActivityLoginBinding loginBinding;
    public static String token;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginBinding.setClickListener(new EventHandler(this));
        loginBinding.setActivity(this);
        sessionManager = new SessionManager(this);

        apiManager = new ApiManager(this, this);
    }

    private void callDialog() {

        dialogLayout = new Dialog(this);
        dialogLayout.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialogLayout.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialogLayout.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogLayout.setContentView(R.layout.kya_dialog);

        dialogLayout.show();

        Button performKya = dialogLayout.findViewById(R.id.perform_kya);
        performKya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Intent intent = new Intent(LoginActivity.this, GeneralInstruction.class);
//                startActivity(intent);
//                dialogLayout.dismiss();
            }
        });
    }

    @Override
    public void isError(String errorCode) {
        Toast.makeText(this, errorCode, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void isSuccess(Object response, int ServiceCode) {
        if (ServiceCode == Constants.LOGIN_REQUEST) {
            LoginResponse loginBean = (LoginResponse) response;
            if (loginBean.getMessage() != null) {
                if (loginBean.getMessage().equalsIgnoreCase("Invalid username or password.")) {
                    Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_LONG).show();

                }
            } else {
                apiManager.requestToken(loginBinding.mobileNumber.getText().toString(), loginBinding.password.getText().toString(), "password");
                sessionManager.createLoginSession(loginBinding.mobileNumber.getText().toString(), loginBinding.password.getText().toString(), "password");

                checkKya();
            }
        } else if (ServiceCode == Constants.Token_REQUEST) {

            TokenResponse tokenBean = (TokenResponse) response;
            token = tokenBean.getAccess_token();
            sessionManager.saveToke("Bearer " + token);

        } else if (ServiceCode == Constants.IS_KYA) {
            boolean b = (boolean) response;

            if (!b) {
                sessionManager.saveKyaStatus(b);
                callDialog();
            } else {
                sessionManager.saveKyaStatus(b);
                Toast.makeText(this, "KYA Already Completed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void checkKya() {
        callDialog();
        apiManager.getKyaDetails("Bearer " + token, /*"9811206110"*/loginBinding.mobileNumber.getText().toString());
    }

    public class EventHandler {
        Context mContext;

        public EventHandler(Context mContext) {
            this.mContext = mContext;
        }


        public void loginApi() {

            Login login = new Login();
            login.setMobileNumber(loginBinding.mobileNumber.getText().toString());
            login.setPassword(loginBinding.password.getText().toString());
            loginBinding.setLogin(login);

            AwesomeValidation validation = new AwesomeValidation(BASIC);
           // validation.addValidation(LoginActivity.this, R.id.mobile_number, "[a-zA-Z0-9_-]+", R.string.username_error);
            validation.addValidation(LoginActivity.this, R.id.password, "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}", R.string.password_error);

            if (validation.validate()) {
                //loginAPi();
                //Toast.makeText(LoginActivity.this, loginBinding.getLogin().getMobileNumber()+" "+loginBinding.getLogin().getPassword(), Toast.LENGTH_SHORT).show();
                if(loginBinding.getLogin().getMobileNumber().trim().equals("Ceo@2019")&&loginBinding.getLogin().getPassword().trim().equals("Noida@2019"))
                {
                    Intent intent = new Intent(LoginActivity.this, OfficerDashBoardActivity.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(LoginActivity.this, "Credentials not matched.", Toast.LENGTH_SHORT).show();
                }

            }
        }

        private void loginAPi() {
            //apiManager.loginRequest(loginBinding.getLogin().getMobileNumber(), loginBinding.getLogin().getPassword());



        }
    }
}