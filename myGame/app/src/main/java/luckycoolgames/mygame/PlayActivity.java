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

    Realm realm = Realm.getDefaultInstance();

    private BottomNavigationView bottomNavigationView;

    //init textViews
    private TextView wood_text, stone_text, fiber_text, food_text, health_text, stamina_text;

    //init FM
    public FragmentManager fragmentManager = getFragmentManager();

    //init ImageView
    private ImageView youDied;

    //init Handler
    private Handler handler = new Handler();

    //init realm
    private MyBook myBook = new MyBook();

    //death Counter
    private boolean death = false;


    //eat counter
    private int n = 0;

    //instrumentsLevels
    private int stoneInstrumentLevel = 0;
    private int woodInstrumentLevel = 0;
    private int fiberInstrumentLevel = 0;
    //init exmpls of classes
    private final Wood wood = new Wood();
    private final Stone stone = new Stone();
    private final Fiber fiber = new Fiber();
    private final Food food = new Food();
    private final Health health = new Health();
    private final Stamina stamina = new Stamina();
    //resource Indexes
    private int woodIndex = 0;
    private int stoneIndex = 1;
    private int fiberIndex = 2;
    private int foodIndex = 3;
    private int healthIndex = 4;
    private int staminaIndex = 5;
    //init list
    private List<Integer> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        myBook.fromRealm();

        if(realmIsEmpty()==true){
            newGameSetList();
        }else {
            list = myBook.getList();
        }

        loadFragment(new GatherFragment());
        youDied = findViewById(R.id.you_died);
        bottomNavigationView = findViewById(R.id.bottom_navigation);



        //init textView
        wood_text = findViewById(R.id.wood_text);
        stone_text = findViewById(R.id.stone_text);
        fiber_text = findViewById(R.id.fiber_text);
        food_text = findViewById(R.id.food_text);
        health_text = findViewById(R.id.health_text);
        stamina_text = findViewById(R.id.stamina_text);

        //first list_add
        /*if(*//*realmIsEmpty()*//*){

        }else{
            getListFromRealm();
        }*/
        newGameSetList();


        //first set text
        wood_text.setText(list.get(woodIndex).toString());
        stone_text.setText(list.get(stoneIndex).toString());
        food_text.setText(list.get(fiberIndex).toString());
        fiber_text.setText(list.get(fiberIndex).toString());
        health_text.setText(list.get(healthIndex).toString());
        stamina_text.setText(list.get(staminaIndex).toString());


        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }


    //fast action for button
    public void wood_button_action(int value) {
        wood.add(value);
        list.set(woodIndex, wood.get());
        wood_text.setText(list.get(woodIndex).toString());
    }

    public void stone_button_action(int value) {
        stone.add(value);
        list.set(stoneIndex, stone.get());
        stone_text.setText(list.get(stoneIndex).toString());
    }

    public void food_button_action(int value) {
        food.add(value);
        list.set(foodIndex, food.get());
        food_text.setText(list.get(foodIndex).toString());
    }

    public void fiber_button_action(int value) {
        fiber.add(value);
        list.set(fiberIndex, fiber.get());
        fiber_text.setText(list.get(fiberIndex).toString());
    }

    public void health_button_action(int value) {
        health.add(value);
        if (health.get() <= 0) {
            youDied.setVisibility(View.VISIBLE);
            youDied.bringToFront();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(PlayActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }, 5000);

        }
        list.set(healthIndex, health.get());
        health_text.setText(list.get(healthIndex).toString());
    }

    public void stamina_button_action(int value) {
        stamina.add(value);

        if (stamina.get() <= 0) {
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

        }

        list.set(staminaIndex, stamina.get());
        stamina_text.setText(list.get(staminaIndex).toString());
    }

    public void eatFoodAction() {

        if (!(food.get() <= 0)) {
            food.add(-1);
            n++;
            list.set(foodIndex, food.get());
            food_text.setText(list.get(foodIndex).toString());


            double chance = Math.random();
            if (chance + 0.97 >= 1) {

                if (stamina.get() + 10 > 100) {
                    stamina.set(100);

                    list.set(staminaIndex, stamina.get());
                    stamina_text.setText(list.get(staminaIndex).toString());
                } else {
                    stamina.add(10);
                    list.set(staminaIndex, stamina.get());
                    stamina_text.setText(list.get(staminaIndex).toString());
                }
                if (n == 5) {
                    if (health.get() + 3 > 100) {
                        health.set(100);

                        list.set(healthIndex, health.get());
                        health_text.setText(list.get(healthIndex).toString());
                    } else {
                        health.add(3);
                        list.set(healthIndex, health.get());
                        health_text.setText(list.get(healthIndex).toString());
                    }
                }
            } else {
                health.add(-5);
                n = 0;
                list.set(healthIndex, health.get());
                health_text.setText(list.get(healthIndex).toString());


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

    public int getStoneInstrumentLevel() {
        return stoneInstrumentLevel;
    }

    public void setStoneInstrumentLevel(int stoneInstrumentLevel) {
        this.stoneInstrumentLevel = stoneInstrumentLevel;
    }

    public int getWoodInstrumentLevel() {
        return woodInstrumentLevel;
    }

    public void setWoodInstrumentLevel(int woodInstrumentLevel) {
        this.woodInstrumentLevel = woodInstrumentLevel;
    }

    public int getFiberInstrumentLevel() {
        return fiberInstrumentLevel;
    }

    public void setFiberInstrumentLevel(int fiberInstrumentLevel) {
        this.fiberInstrumentLevel = fiberInstrumentLevel;
    }

    @Override
    protected void onDestroy() {
        myBook.toRealm(list);
        realm.close();
        super.onDestroy();
    }

    private void newGameSetList() {
        list.add(woodIndex, wood.get());
        list.add(stoneIndex, stone.get());
        list.add(fiberIndex, fiber.get());
        list.add(foodIndex, food.get());
        list.add(healthIndex, health.get());
        list.add(staminaIndex, stamina.get());
    }

    /*public void setListToRealm(){
        .beginTransaction();
        MyBook myBook = realm.createObject(MyBook.class);
        myBook.setList(list);
        realm.commitTransaction();
    }*/

    private void getListFromRealm() {
        realm.beginTransaction();
        MyBook myBook = realm.createObject(MyBook.class);
        list.addAll(realm.copyFromRealm(myBook).getList());
        realm.commitTransaction();
    }




    private boolean realmIsEmpty(){
        List<Integer> list = myBook.fromRealm();
        if(list.isEmpty()){
            return true;
        }else {
            return false;
        }
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





    private class MyBook extends RealmObject{
        private RealmList<Integer> list = new RealmList<>();

        public RealmList<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> arrayList) {
            list.addAll(arrayList);
        }


        public void toRealm(List<Integer> list){
            myBook.setList(list);
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(myBook);
            realm.commitTransaction();
        }
        public List<Integer> fromRealm(){
            realm.beginTransaction();
            myBook = realm.copyFromRealm(myBook);
            realm.commitTransaction();
            return myBook.getList();
        }

    }

}