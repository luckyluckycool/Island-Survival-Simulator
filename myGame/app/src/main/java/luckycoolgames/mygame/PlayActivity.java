package luckycoolgames.mygame;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.RealmClass;
import luckycoolgames.mygame.Resources.types.Fiber;
import luckycoolgames.mygame.Resources.types.Food;
import luckycoolgames.mygame.Resources.types.Health;
import luckycoolgames.mygame.Resources.types.Stamina;
import luckycoolgames.mygame.Resources.types.Stone;
import luckycoolgames.mygame.Resources.types.Wood;
import luckycoolgames.mygame.fragments.ActionFragment;
import luckycoolgames.mygame.fragments.GatherFragment;
import luckycoolgames.mygame.fragments.CraftFragment;

public class PlayActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private MyBook myBook;

    public Realm realm;

    private BottomNavigationView bottomNavigationView;

    //init textViews
    private TextView wood_text, stone_text, fiber_text, food_text, health_text, stamina_text;

    //init FM
    public FragmentManager fragmentManager = getFragmentManager();

    //init ImageView
    private ImageView youDied;

    //init Handler
    private Handler handler = new Handler();

    //death Counter
    private boolean death = false;


    //eat counter
    private int n = 0;


    //instrumentsLevels
    private int stoneInstrumentLevel = 0;
    private int woodInstrumentLevel = 0;
    private int fiberInstrumentLevel = 0;
    //resource Indexes
    private int woodIndex = 0;
    private int stoneIndex = 1;
    private int fiberIndex = 2;
    private int foodIndex = 3;
    private int healthIndex = 4;
    private int staminaIndex = 5;
    private int woodInstrumentIndex = 6;
    private int stoneInstrumentIndex = 7;
    private int fiberInstrumentIndex = 8;
    private int foodInstrumentIndex = 9;

    //init list
    private List<Integer> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //init textView
        wood_text = findViewById(R.id.wood_text);
        stone_text = findViewById(R.id.stone_text);
        fiber_text = findViewById(R.id.fiber_text);
        food_text = findViewById(R.id.food_text);
        health_text = findViewById(R.id.health_text);
        stamina_text = findViewById(R.id.stamina_text);

        youDied = findViewById(R.id.you_died);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        realm = Realm.getDefaultInstance();

        list = fromRealm();
        if(list.isEmpty()){
            newGameSetList();
        }
        setTextsFromList();

        loadFragment(new GatherFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }


    //fast action for button
    public void woodAdd(int value) {
        list.set(woodIndex, list.get(woodIndex) + value);
        wood_text.setText(list.get(woodIndex).toString());
    }

    public void stoneAdd(int value) {
        list.set(stoneIndex, list.get(stoneIndex) + value);
        stone_text.setText(list.get(stoneIndex).toString());
    }

    public void foodAdd(int value) {
        list.set(foodIndex, list.get(foodIndex) + value);
        food_text.setText(list.get(foodIndex).toString());
    }

    public void fiberAdd(int value) {
        list.set(fiberIndex, list.get(fiberIndex) + value);
        fiber_text.setText(list.get(fiberIndex).toString());
    }

    public void healthAdd(int value) {

        if (list.get(healthIndex) + value <= 0) {
            youDied.setVisibility(View.VISIBLE);
            youDied.bringToFront();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(PlayActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }, 5000);

        } else {
            if (list.get(healthIndex) + value > 100)
                list.set(healthIndex, 100);
            else
                list.set(healthIndex, list.get(healthIndex) + value);
            health_text.setText(list.get(healthIndex).toString());
        }
    }

    public void staminaAdd(int value) {

        if (list.get(staminaIndex) + value <= 0) {
            death = true;
            youDied.setVisibility(View.VISIBLE);
            youDied.bringToFront();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(PlayActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }, 5000);

        } else {
            if (list.get(staminaIndex) + value > 100)
                list.set(staminaIndex, 100);
            else
                list.set(staminaIndex, list.get(staminaIndex) + value);
            stamina_text.setText(list.get(staminaIndex).toString());
        }
    }

    public void eatFoodAction() {

        if (!(list.get(foodIndex) <= 0)) {
            foodAdd(-1);
            n++;

            double chance = Math.random();
            if (chance + 0.97 >= 1) {

                staminaAdd(10);
                if (n == 5) {
                    healthAdd(3);
                }

            } else {
                healthAdd(-5);
                n = 0;

                final Toast toast = Toast.makeText(this, "You eat rotten food", Toast.LENGTH_SHORT);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 1000);

            }

        }
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        toRealm(list);
        realm.close();
    }

    private void newGameSetList() {
        list.add(woodIndex, 0);
        list.add(stoneIndex, 0);
        list.add(fiberIndex, 0);
        list.add(foodIndex, 0);
        list.add(healthIndex, 100);
        list.add(staminaIndex, 100);
        list.add(woodInstrumentIndex, 0);
        list.add(stoneInstrumentIndex, 0);
        list.add(fiberInstrumentIndex, 0);
        list.add(foodInstrumentIndex, 0);
    }


    //bottom_navigation_methodes
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.gather_button:
                fragment = new GatherFragment();
                break;
            case R.id.craft_button:
                fragment = new CraftFragment();
                break;
            case R.id.action_button:
                fragment = new ActionFragment();
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            fragmentManager.beginTransaction().replace(R.id.frame_for_action_buttons, fragment).commit();
            return true;
        }
        return false;
    }


    public void toRealm( List<Integer> list) {
        realm.beginTransaction();
        if(realm.isEmpty()){
            myBook = realm.createObject(MyBook.class);
            myBook.setList(list);}
        else{
            realm.insertOrUpdate(myBook) ;
            myBook.setList(list);
        }

        realm.commitTransaction();
    }

    public List<Integer> fromRealm() {
        List<Integer> list = new ArrayList<>();
        MyBook myBook = realm.where(MyBook.class).findFirst();
        //поміняв
        realm.beginTransaction();

        if (!realm.isEmpty()) {
            list.addAll(myBook.getList());
            realm.commitTransaction();
        } else
            realm.cancelTransaction();
        return list;

    }

    public boolean realmIsEmpty() {
        MyBook myBook = realm.where(MyBook.class).findFirst();
        realm.beginTransaction();
        if (myBook.getList().isEmpty())
            return true;
        else
            return false;

    }
    private void setTextsFromList(){
        wood_text.setText(list.get(woodIndex).toString());
        stone_text.setText(list.get(stoneIndex).toString());
        fiber_text.setText(list.get(fiberIndex).toString());
        food_text.setText(list.get(foodIndex).toString());
        stamina_text.setText(list.get(staminaIndex).toString());
        health_text.setText(list.get(healthIndex).toString());
    }

}