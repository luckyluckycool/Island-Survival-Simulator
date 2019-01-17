package luckycoolgames.mygame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.victor.loading.rotate.RotateLoading;

public class LoadingActivity extends AppCompatActivity {
RotateLoading rotateLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        rotateLoading = findViewById(R.id.rotateLoading);
        if(rotateLoading.isStart()){
            rotateLoading.stop();
        }else {
            rotateLoading.start();
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingActivity.this, PlayActivity.class);
                startActivity(intent);
            }
        },5000);

    }
}
