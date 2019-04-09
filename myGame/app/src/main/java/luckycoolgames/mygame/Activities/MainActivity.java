package luckycoolgames.mygame.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import io.realm.Realm;
import luckycoolgames.mygame.R;

public class MainActivity extends AppCompatActivity {
    private TextView newGame, continueGame;
    private Realm realm;
    private Handler handler = new Handler();

    public Realm getRealm() {
        return realm;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        newGame = findViewById(R.id.new_game_button);
        continueGame = findViewById(R.id.continue_button);

        if (realm.isEmpty())
            continueGame.setVisibility(View.GONE);
        realm.close();
        realm.compactRealm(Realm.getDefaultConfiguration());

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.close();
                Realm.deleteRealm(Realm.getDefaultConfiguration());
                newGame.setEnabled(false);
                continueGame.setVisibility(View.GONE);
                newGame.animate().scaleX((float) 0).scaleY((float) 0).setDuration(1000).start();

                Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(intent);


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                        startActivity(intent);
                    }

                }, 1000);
            }
        });

        continueGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueGame.setEnabled(false);
                newGame.setVisibility(View.GONE);
                continueGame.animate().scaleX((float) 0).scaleY((float) 0).setDuration(1000).start();


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                        startActivity(intent);
                    }

                }, 1000);

            }
        });


    }
}
