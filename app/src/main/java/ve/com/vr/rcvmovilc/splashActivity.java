package ve.com.vr.rcvmovilc;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import ve.com.vr.rcvmovilc.datos.ConfiguracionesDB;
import ve.com.vr.rcvmovilc.model.Configuracion;


public class splashActivity extends AppCompatActivity {
    private ConfiguracionesDB db;
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mpInicializar();






        /*Funcion Buena*/
        ImageView imageView = (ImageView) findViewById(R.id.imgLogo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),  R.anim.fade);
        imageView.startAnimation(animation);


        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run(){

                Intent homeIntent = new Intent(splashActivity.this, LoginActivity.class);
                startActivity(homeIntent);
                finish();

            }
        },SPLASH_TIME_OUT);
        /*Fin Funcion Buena*/

        //Para colocar una pagina web
        //WebView webView;
        //webView = (WebView) findViewById(R.id.webView);
        //webView.loadUrl("file:///android_asset/splash.html");

    }



    private void mpInicializar(){
        db = new ConfiguracionesDB(this);
    }

    private boolean mfValidarExistencia(){
        boolean vBand = false;
        db = new ConfiguracionesDB(this);

        Configuracion vConfig =  db.buscarConfiguracion("0001");

        if (vConfig != null){
            vBand= true;
        }

        return vBand;
    }




}
