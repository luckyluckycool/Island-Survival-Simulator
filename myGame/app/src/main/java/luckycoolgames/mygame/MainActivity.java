package luckycoolgames.mygame;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import io.realm.Realm;
import luckycoolgames.mygame.Resources.types.Wood;
import luckycoolgames.mygame.fragments.LoadingFragment;

public class MainActivity extends AppCompatActivity {
    private TextView newGame, continueGame;
    private FrameLayout frameLayout;
    FragmentManager fragmentManager = getFragmentManager();
    private LoadingFragment loadingFragment = new LoadingFragment();
    PlayActivity playActivity = new PlayActivity();
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        newGame = findViewById(R.id.new_game_button);
        continueGame = findViewById(R.id.continue_button);
        frameLayout = findViewById(R.id.frame_for_loading);

        if(realm.isEmpty()){
            continueGame.setVisibility(View.GONE);

        }
        realm.close();
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm.deleteRealm(Realm.getDefaultConfiguration());
                newGame.setEnabled(false);
                continueGame.setVisibility(View.GONE);
                newGame.animate().scaleX((float) 0).scaleY((float) 0).setDuration(1000).start();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        frameLayout.bringToFront();
                        fragmentManager.beginTransaction().replace(R.id.frame_for_loading, loadingFragment).commit();
                    }

                }, 1000);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                        startActivity(intent);
                    }
                }, 5000);
            }
        });

        /*if (realmIsEmpty()){
            continueGame.setVisibility(View.GONE);
        }*/

        continueGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueGame.setEnabled(false);
                newGame.setVisibility(View.GONE);
                continueGame.animate().scaleX((float) 0).scaleY((float) 0).setDuration(1000).start();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        frameLayout.bringToFront();
                        fragmentManager.beginTransaction().replace(R.id.frame_for_loading, loadingFragment).commit();
                    }

                }, 1000);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                        startActivity(intent);
                    }

                }, 5000);
            }
        });


    }
    /*private boolean realmIsEmpty(){
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        MyBook myBook = realm.createObject(MyBook.class);
        if(myBook.getList().isEmpty()){
            return true;
        }else {
            return false;
        }
    }*/
}
