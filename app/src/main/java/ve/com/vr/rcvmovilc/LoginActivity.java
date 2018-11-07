package ve.com.vr.rcvmovilc;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import ve.com.vr.rcvmovilc.interfaces.RetrofitInterface;
import ve.com.vr.rcvmovilc.model.LoginData;
import ve.com.vr.rcvmovilc.model.LoginResult;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    EditText emailText;
    EditText A;
    EditText passwordText;
    Button loginButton;
    TextView signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       // ButterKnife.bind(this);
        //A = (EditText)findViewById( R.id.A);
         emailText = (EditText)findViewById( R.id.input_email);
         passwordText = (EditText)findViewById( R.id.input_password);
         loginButton = (Button)findViewById( R.id.btn_login);
         signupLink = (TextView)findViewById( R.id.link_signup);


        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               // login();
                String vEmailText = emailText.getText().toString();
                String vPassWord = passwordText.getText().toString();


//https://stackoverflow.com/questions/43366164/retrofit-and-okhttp-basic-authentication
                OkHttpClient.Builder oktHttpClient = new OkHttpClient.Builder();
               /*if(BuildConfig.DEBUG){
                    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    oktHttpClient.addInterceptor(httpLoggingInterceptor);
                }*/

                /*****
                 * Opcion funcional para consumir un API
                 */
                /*
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(A.getText().toString())
                        //.client(oktHttpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RetrofitInterface service = retrofit.create(RetrofitInterface.class);
                // prepare call in Retrofit 2.0
                Call<ResponseBody> call = service.getStringScalar(new LoginData(vEmailText,vPassWord));
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(getBaseContext(),response.body().toString(),Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d(TAG, t.toString() +"-CAZ-"+ call.toString());
                        Toast.makeText(getBaseContext(),"Error " ,Toast.LENGTH_SHORT).show();
                    }
               });*/


               /****
                * Opcion para consumir API llenando una clase personalizada
                */
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.venezuelaresponsable.com.ve")
                        .client(oktHttpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RetrofitInterface service = retrofit.create(RetrofitInterface.class);

                Call<LoginResult> call = service.mfLogin(new LoginData(vEmailText,vPassWord));

                call.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {

                        if (response.isSuccessful()) {
                            Toast.makeText(getBaseContext(),response.body().getMessage(),Toast.LENGTH_SHORT).show();

                            login();

                        } else {
                            try {
                                JSONObject jObjError = new JSONObject(response.errorBody().string());
                                Toast.makeText(getBaseContext(), jObjError.getString("message"), Toast.LENGTH_LONG).show();
                            } catch (Exception e) {
                                Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        Log.d(TAG, t.toString() +"-CAZ-"+ call.toString());
                        Toast.makeText(getBaseContext(),"Error " ,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onLoginSuccess();
                // Start the Signup activity
              //  Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
           //     startActivityForResult(intent, REQUEST_SIGNUP);
             //   finish();
             //   overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        loginButton.setEnabled(true);
        Intent homeIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(homeIntent);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;
    }
}
