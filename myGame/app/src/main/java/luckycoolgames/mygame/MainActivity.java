package luckycoolgames.mygame;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import luckycoolgames.mygame.Resources.types.Wood;

public class MainActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.new_game_button);

        textView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        textView.animate().scaleX((float)0).scaleY((float)0).setDuration(1000).start();

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoadingActivity.class);
                startActivity(intent);
            }

        }, 1000);
    }
});



    }
}
