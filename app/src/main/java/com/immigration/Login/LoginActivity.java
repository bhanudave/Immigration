package com.immigration.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.immigration.Main.HomeActivity;
import com.immigration.R;
import com.immigration.Registration.RegistrationActivity;
import com.immigration.Utills.utills;
import com.immigration.retofit.ApiUtils;
import com.immigration.retofit.UserService;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private TextView registeration_btn;
    UserService userService;
    SharedPreferences sharedpreferences;
    /*CallbackManager callbackManager;
    LoginButton loginButton;

    SignInButton signInButton;
    private static final int RC_SIGN_IN = 1;

    private static final String EMAIL = "email";
    private GoogleSignInClient mGoogleSignInClient;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedpreferences = getSharedPreferences(utills.MyPREFERENCES, Context.MODE_PRIVATE);
//        callbackManager = CallbackManager.Factory.create();

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        registeration_btn = findViewById(R.id.registeration_btn);
        userService = ApiUtils.getUserService();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                //validate form
                if (validateLogin(username, password)) {
                    //do login
//                    doLogin(username, password);
                    if (sharedpreferences.getString(utills.ID, "").isEmpty() &&
                            sharedpreferences.getString(utills.ID, "").equalsIgnoreCase("")) {
                        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

        registeration_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        /*loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });


        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        Log.d("isLoggedIn", String.valueOf(isLoggedIn));


        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);

        // Set the dimensions of the sign-in button.
        signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        findViewById(R.id.sign_in_button).setOnClickListener(this);*/

    }

    /*private void updateUI(GoogleSignInAccount account) {
        Log.d("Bhanu", String.valueOf(account));
        *//*String Name = account.getDisplayName();
        String Emai = account.getEmail();
        String G_Name = account.getGivenName();
        String Id = account.getId();
        String TokenId = account.getIdToken();
        String Auth_code = account.getServerAuthCode();
        String Photo = String.valueOf(account.getPhotoUrl());

        Log.d("Bhanu", Name+"\n"+Emai+"\n"+G_Name+"\n"+Id+"\n"+TokenId+"\n"+Auth_code+"\n"+Photo);*//*
    }*/


    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Bhanu", "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }*/

    private boolean validateLogin(String username, String password) {
        if (username == null || username.trim().length() == 0) {
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password == null || password.trim().length() == 0) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    /*@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;
        }
    }*/

    /*private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }*/

}
/*221206737110-2g9150rtq3aruf08msk2nd7hueqclnku.apps.googleusercontent.com
        zbl9sb2atJpELA21hq_4HNaB*/

//OnSwipeTouchListener