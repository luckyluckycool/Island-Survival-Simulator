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
//import luckycoolgames.mygame.RealmObjects.RealmBuildingsMadeList;
import luckycoolgames.mygame.RealmObjects.RealmResourceList;
import luckycoolgames.mygame.fragments.ActionFragment;
import luckycoolgames.mygame.fragments.GatherFragment;
import luckycoolgames.mygame.fragments.CraftFragment;
import luckycoolgames.mygame.fragments.StorageFragment;
import luckycoolgames.mygame.fragments.TempFragment;

public class PlayActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private RealmResourceList realmResourceList;

    //private RealmBuildingsMadeList realmBuildingsMadeList;

    Realm realm = new MainActivity().getRealm();

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
    private boolean death;




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

    //init resourceList
    private List<Integer> resourceList = new ArrayList<>();
    private List<Integer> buildedList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        death = false;

        //init textView
        wood_text = findViewById(R.id.wood_text);
        stone_text = findViewById(R.id.stone_text);
        fiber_text = findViewById(R.id.fiber_text);
        food_text = findViewById(R.id.food_text);
        health_text = findViewById(R.id.health_text);
        stamina_text = findViewById(R.id.stamina_text);


        youDied = findViewById(R.id.you_died);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //      realm = Realm.getDefaultInstance();

        realm = Realm.getDefaultInstance();
        if (!realm.isEmpty())
            allFromRealm();
        else
            newGameSetList();

        setTextsFromList();

        loadFragment(new TempFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }


    //fast action for button
    public void woodAdd(int value) {
        resourceList.set(woodIndex, resourceList.get(woodIndex) + value);
        wood_text.setText(resourceList.get(woodIndex).toString());
    }

    public void stoneAdd(int value) {
        resourceList.set(stoneIndex, resourceList.get(stoneIndex) + value);
        stone_text.setText(resourceList.get(stoneIndex).toString());
    }

    public void foodAdd(int value) {
        resourceList.set(foodIndex, resourceList.get(foodIndex) + value);
        food_text.setText(resourceList.get(foodIndex).toString());
    }

    public void fiberAdd(int value) {
        resourceList.set(fiberIndex, resourceList.get(fiberIndex) + value);
        fiber_text.setText(resourceList.get(fiberIndex).toString());
    }

    public void healthAdd(int value) {

        if (resourceList.get(healthIndex) + value <= 0) {
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
            if (resourceList.get(healthIndex) + value > 100)
                resourceList.set(healthIndex, 100);
            else
                resourceList.set(healthIndex, resourceList.get(healthIndex) + value);
            health_text.setText(resourceList.get(healthIndex).toString());
        }
    }

    public void staminaAdd(int value) {

        if (resourceList.get(staminaIndex) + value <= 0) {
            bottomNavigationView.setVisibility(View.GONE);
            youDied.setVisibility(View.VISIBLE);
            youDied.bringToFront();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    realm.beginTransaction();
                    realm.deleteAll();
                    realm.commitTransaction();
                    Intent intent = new Intent(PlayActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }, 5000);

        } else {
            if (resourceList.get(staminaIndex) + value > 100)
                resourceList.set(staminaIndex, 100);
            else
                resourceList.set(staminaIndex, resourceList.get(staminaIndex) + value);
            stamina_text.setText(resourceList.get(staminaIndex).toString());
        }
    }




    //resourceList g&s

    public List<Integer> getResourceList() {
        return resourceList;
    }


    //bottom_navigation_methods
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
                break;
            case R.id.storage_button:
                fragment = new StorageFragment();
                break;
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


    //realm methods
    public void resourcesToRealm(List<Integer> list) {
        realm.beginTransaction();
        realmResourceList = realm.createObject(RealmResourceList.class);
        realmResourceList.setList(list);
        realm.commitTransaction();

    }

    /*public void buildingsToRealm(List<Integer> list) {
        if (death == false) {
            realm.beginTransaction();
            realmBuildingsMadeList = realm.createObject(RealmBuildingsMadeList.class);
            realmBuildingsMadeList.setList(list);
            realm.commitTransaction();
        } else {
            realm.deleteAll();
        }
    }*/

    public void setAllToRealm() {
        resourcesToRealm(resourceList);
        //buildingsToRealm(buildedList);
    }


    public List<Integer> resourcesFromRealm() {
        List<Integer> list = new ArrayList<>();
        RealmResourceList realmResourceList = realm.where(RealmResourceList.class).findAllAsync().last();
        realm.beginTransaction();
        if (!realm.isEmpty()) {
            list.addAll(realmResourceList.getList());
            realm.commitTransaction();
        } else
            realm.cancelTransaction();
        return list;
    }

    /*public List<Integer> buildedFromRealm() {
        List<Integer> list = new ArrayList<>();
        RealmBuildingsMadeList realmBuildingsMadeList = realm.where(RealmBuildingsMadeList.class).findAllAsync().last();
        realm.beginTransaction();
        if (!realm.isEmpty()) {
            list.addAll(realmBuildingsMadeList.getList());
            realm.commitTransaction();
        } else
            realm.cancelTransaction();
        return list;
    }*/

    public void allFromRealm() {
        resourceList = resourcesFromRealm();
        //buildedList = buildedFromRealm();
    }


    //first actions
    private void newGameSetList() {
        resourceList.add(woodIndex, 0);
        resourceList.add(stoneIndex, 0);
        resourceList.add(fiberIndex, 0);
        resourceList.add(foodIndex, 0);
        resourceList.add(healthIndex, 100);
        resourceList.add(staminaIndex, 100);
        resourceList.add(woodInstrumentIndex, 0);
        resourceList.add(stoneInstrumentIndex, 0);
        resourceList.add(fiberInstrumentIndex, 0);
        resourceList.add(foodInstrumentIndex, 0);
    }

    private void setTextsFromList() {
        wood_text.setText(resourceList.get(woodIndex).toString());
        stone_text.setText(resourceList.get(stoneIndex).toString());
        fiber_text.setText(resourceList.get(fiberIndex).toString());
        food_text.setText(resourceList.get(foodIndex).toString());
        stamina_text.setText(resourceList.get(staminaIndex).toString());
        health_text.setText(resourceList.get(healthIndex).toString());
    }

    @Override
    protected void onStop() {
        if (realm != null && !realm.isClosed()) {
            resourcesToRealm(resourceList);
            Realm.compactRealm(Realm.getDefaultConfiguration());
        }
        super.onStop();

    }

    //onDestroy
    @Override
    protected void onDestroy() {
        realm.close();
        super.onDestroy();
    }


    public boolean chance(double chance) {
        double random = Math.random();
        if (random + chance >= 1)
            return true;
        else
            return false;
    }


    @Override
    public void onBackPressed() {
    }
}