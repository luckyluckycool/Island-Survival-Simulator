package luckycoolgames.mygame.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import luckycoolgames.mygame.R;
import luckycoolgames.mygame.RealmObjects.RealmBuildingsMadeList;
import luckycoolgames.mygame.RealmObjects.RealmResourceList;
import luckycoolgames.mygame.fragments.ActionFragment;
import luckycoolgames.mygame.fragments.GatherFragment;
import luckycoolgames.mygame.fragments.CraftFragment;
import luckycoolgames.mygame.fragments.StorageFragment;

public class PlayActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private int WOOD_INDEX = 0;
    private int STONE_INDEX = 1;
    private int FIBER_INDEX = 2;
    private int FOOD_INDEX = 3;
    private int HEALTH_INDEX = 4;
    private int STAMINA_INDEX = 5;


    private RealmResourceList realmResourceList;

    private RealmBuildingsMadeList realmBuildingsMadeList;

    Realm realm = new MainActivity().getRealm();

    private BottomNavigationView bottomNavigationView;

    //init textViews
    private TextView wood_text, stone_text, fiber_text, food_text, health_text, stamina_text;

    //init FM
    public FragmentManager fragmentManager = getFragmentManager();

    //init ImageView
    private ImageView youDied;
    public ImageView sleepImage;
    public TextView sleepTimer;

    //init Handler
    private Handler handler = new Handler();

    private CoordinatorLayout coordinatorLayout;

    //init resourceList
    private List<Integer> resourceList = new ArrayList<>();


    private List<Integer> buildedList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //init textView
        wood_text = findViewById(R.id.wood_text);
        stone_text = findViewById(R.id.stone_text);
        fiber_text = findViewById(R.id.fiber_text);
        food_text = findViewById(R.id.food_text);
        health_text = findViewById(R.id.health_text);
        stamina_text = findViewById(R.id.stamina_text);

        coordinatorLayout = findViewById(R.id.coordinator);

        youDied = findViewById(R.id.you_died);

        sleepImage = findViewById(R.id.sleep_image);

        sleepTimer = findViewById(R.id.sleep_timer);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //      realm = Realm.getDefaultInstance();

        realm = Realm.getDefaultInstance();
        realm.compactRealm(Realm.getDefaultConfiguration());
        if (!realm.isEmpty())
            allFromRealm();
        else
            newGameSetList();

        setTextsFromList();

        loadFragment(new GatherFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }


    //fast adds
    public void woodAdd(int value) {
        resourceList.set(getResources().getInteger(R.integer.WOOD_INDEX), resourceList.get(getResources().getInteger(R.integer.WOOD_INDEX)) + value);
        wood_text.setText(resourceList.get(getResources().getInteger(R.integer.WOOD_INDEX)).toString());

    }

    public void woodAdd(int value, int limit) {
        if (resourceList.get(getResources().getInteger(R.integer.WOOD_INDEX)) + value <= limit)
            resourceList.set(getResources().getInteger(R.integer.WOOD_INDEX), resourceList.get(getResources().getInteger(R.integer.WOOD_INDEX)) + value);
        else if (resourceList.get(getResources().getInteger(R.integer.WOOD_INDEX)) + value >= limit && resourceList.get(getResources().getInteger(R.integer.WOOD_INDEX)) != limit)
            resourceList.set(getResources().getInteger(R.integer.WOOD_INDEX), limit);
        else if (resourceList.get(getResources().getInteger(R.integer.WOOD_INDEX)) == limit)
            showSnackbar("You can't add more now");
        wood_text.setText(resourceList.get(getResources().getInteger(R.integer.WOOD_INDEX)).toString());

    }

    public void stoneAdd(int value) {
        resourceList.set(getResources().getInteger(R.integer.STONE_INDEX), resourceList.get(getResources().getInteger(R.integer.STONE_INDEX)) + value);
        stone_text.setText(resourceList.get(getResources().getInteger(R.integer.STONE_INDEX)).toString());
    }

    public void stoneAdd(int value, int limit) {
        if (resourceList.get(getResources().getInteger(R.integer.STONE_INDEX)) + value <= limit)
            resourceList.set(getResources().getInteger(R.integer.STONE_INDEX), resourceList.get(getResources().getInteger(R.integer.STONE_INDEX)) + value);
        else if (resourceList.get(getResources().getInteger(R.integer.STONE_INDEX)) + value >= limit && resourceList.get(getResources().getInteger(R.integer.STONE_INDEX)) != limit)
            resourceList.set(getResources().getInteger(R.integer.STONE_INDEX), limit);
        else if (resourceList.get(getResources().getInteger(R.integer.STONE_INDEX)) == limit)
            showSnackbar("You can't add more now");
        stone_text.setText(resourceList.get(getResources().getInteger(R.integer.STONE_INDEX)).toString());

    }

    public void foodAdd(int value) {
        resourceList.set(getResources().getInteger(R.integer.FOOD_INDEX), resourceList.get(getResources().getInteger(R.integer.FOOD_INDEX)) + value);
        food_text.setText(resourceList.get(getResources().getInteger(R.integer.FOOD_INDEX)).toString());
    }

    public void foodAdd(int value, int limit) {
        if (resourceList.get(getResources().getInteger(R.integer.FOOD_INDEX)) + value <= limit)
            resourceList.set(getResources().getInteger(R.integer.FOOD_INDEX), resourceList.get(getResources().getInteger(R.integer.FOOD_INDEX)) + value);
        else if (resourceList.get(getResources().getInteger(R.integer.FOOD_INDEX)) + value >= limit && resourceList.get(getResources().getInteger(R.integer.FOOD_INDEX)) != limit)
            resourceList.set(getResources().getInteger(R.integer.FOOD_INDEX), limit);
        else if (resourceList.get(getResources().getInteger(R.integer.FOOD_INDEX)) + value >= limit && resourceList.get(getResources().getInteger(R.integer.FOOD_INDEX)) == limit)
            showSnackbar("You can't add more now");
        food_text.setText(resourceList.get(getResources().getInteger(R.integer.FOOD_INDEX)).toString());

    }

    public void fiberAdd(int value) {
        resourceList.set(getResources().getInteger(R.integer.FIBER_INDEX), resourceList.get(getResources().getInteger(R.integer.FIBER_INDEX)) + value);
        fiber_text.setText(resourceList.get(getResources().getInteger(R.integer.FIBER_INDEX)).toString());
    }

    public void fiberAdd(int value, int limit) {
        if (resourceList.get(getResources().getInteger(R.integer.FIBER_INDEX)) + value <= limit)
            resourceList.set(getResources().getInteger(R.integer.FIBER_INDEX), resourceList.get(getResources().getInteger(R.integer.FIBER_INDEX)) + value);
        else if (resourceList.get(getResources().getInteger(R.integer.FIBER_INDEX)) + value >= limit && resourceList.get(getResources().getInteger(R.integer.FIBER_INDEX)) != limit)
            resourceList.set(getResources().getInteger(R.integer.FIBER_INDEX), limit);
        else if (resourceList.get(getResources().getInteger(R.integer.FIBER_INDEX)) == limit)
            showSnackbar("You can't add more now");
        fiber_text.setText(resourceList.get(getResources().getInteger(R.integer.FIBER_INDEX)).toString());

    }

    public void healthAdd(int value) {

        if (resourceList.get(getResources().getInteger(R.integer.HEALTH_INDEX)) + value <= 0) {
            youDied.setVisibility(View.VISIBLE);
            youDied.bringToFront();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(PlayActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 5000);

        } else {
            if (resourceList.get(getResources().getInteger(R.integer.HEALTH_INDEX)) + value > 100)
                resourceList.set(getResources().getInteger(R.integer.HEALTH_INDEX), 100);
            else
                resourceList.set(getResources().getInteger(R.integer.HEALTH_INDEX), resourceList.get(getResources().getInteger(R.integer.HEALTH_INDEX)) + value);
            health_text.setText(resourceList.get(getResources().getInteger(R.integer.HEALTH_INDEX)).toString());
        }
    }

    public void healthAdd(int value, int limit) {
        if (resourceList.get(getResources().getInteger(R.integer.HEALTH_INDEX)) + value <= limit)
            resourceList.set(getResources().getInteger(R.integer.HEALTH_INDEX), resourceList.get(getResources().getInteger(R.integer.HEALTH_INDEX)) + value);
        else if (resourceList.get(getResources().getInteger(R.integer.HEALTH_INDEX)) + value >= limit && resourceList.get(getResources().getInteger(R.integer.HEALTH_INDEX)) != limit)
            resourceList.set(getResources().getInteger(R.integer.HEALTH_INDEX), limit);
        else if (resourceList.get(getResources().getInteger(R.integer.HEALTH_INDEX)) == limit)
            showSnackbar("You can't add more now");
        health_text.setText(resourceList.get(getResources().getInteger(R.integer.HEALTH_INDEX)).toString());

    }

    public void staminaAdd(int value) {

        if (resourceList.get(getResources().getInteger(R.integer.STAMINA_INDEX)) + value <= 0) {
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
                    finish();
                }
            }, 5000);

        } else {
            if (resourceList.get(getResources().getInteger(R.integer.STAMINA_INDEX)) + value > 100)
                resourceList.set(getResources().getInteger(R.integer.STAMINA_INDEX), 100);
            else
                resourceList.set(getResources().getInteger(R.integer.STAMINA_INDEX), resourceList.get(getResources().getInteger(R.integer.STAMINA_INDEX)) + value);
            stamina_text.setText(resourceList.get(getResources().getInteger(R.integer.STAMINA_INDEX)).toString());
        }
    }

    public void staminaAdd(int value, int limit) {
        if (resourceList.get(getResources().getInteger(R.integer.STAMINA_INDEX)) + value <= limit)
            resourceList.set(getResources().getInteger(R.integer.STAMINA_INDEX), resourceList.get(getResources().getInteger(R.integer.STAMINA_INDEX)) + value);
        else if (resourceList.get(getResources().getInteger(R.integer.STAMINA_INDEX)) + value >= limit && resourceList.get(getResources().getInteger(R.integer.STAMINA_INDEX)) != limit)
            resourceList.set(getResources().getInteger(R.integer.STAMINA_INDEX), limit);
        else if (resourceList.get(getResources().getInteger(R.integer.STAMINA_INDEX)) == limit)
            showSnackbar("You can't add more now");
        stamina_text.setText(resourceList.get(getResources().getInteger(R.integer.STAMINA_INDEX)).toString());

    }

    //Lists getters

    public List<Integer> getResourceList() {
        return resourceList;
    }

    public List<Integer> getBuildedList() {
        return buildedList;
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
            /*case R.id.storage_button:
                fragment = new StorageFragment();
                break;*/
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

    public void buildingsToRealm(List<Integer> list) {
        realm.beginTransaction();
        realmBuildingsMadeList = realm.createObject(RealmBuildingsMadeList.class);
        realmBuildingsMadeList.setList(list);
        realm.commitTransaction();
    }

    public void setAllToRealm() {
        resourcesToRealm(resourceList);
        buildingsToRealm(buildedList);
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

    public List<Integer> buildedFromRealm() {
        List<Integer> list = new ArrayList<>();
        RealmBuildingsMadeList realmBuildingsMadeList = realm.where(RealmBuildingsMadeList.class).findAllAsync().last();
        realm.beginTransaction();
        if (!realm.isEmpty()) {
            list.addAll(realmBuildingsMadeList.getList());
            realm.commitTransaction();
        } else
            realm.cancelTransaction();
        return list;
    }

    public void allFromRealm() {
        resourceList = resourcesFromRealm();
        buildedList = buildedFromRealm();
    }


    //first actions
    private void newGameSetList() {
        resourceList.add(getResources().getInteger(R.integer.WOOD_INDEX), 0);
        resourceList.add(getResources().getInteger(R.integer.STONE_INDEX), 0);
        resourceList.add(getResources().getInteger(R.integer.FIBER_INDEX), 0);
        resourceList.add(getResources().getInteger(R.integer.FOOD_INDEX), 0);
        resourceList.add(getResources().getInteger(R.integer.HEALTH_INDEX), 100);
        resourceList.add(getResources().getInteger(R.integer.STAMINA_INDEX), 100);

        buildedList.add(getResources().getInteger(R.integer.WOOD_INSTRUMENT_INDEX), 0);
        buildedList.add(getResources().getInteger(R.integer.STONE_INSTRUMENT_INDEX), 0);
        buildedList.add(getResources().getInteger(R.integer.FIBER_INSTRUMENT_INDEX), 0);
        buildedList.add(getResources().getInteger(R.integer.FOOD_INSTRUMENT_INDEX), 0);
        buildedList.add(getResources().getInteger(R.integer.BED_INDEX), 0);
        buildedList.add(getResources().getInteger(R.integer.STORAGE_INDEX), 0);
    }

    private void setTextsFromList() {
        wood_text.setText(resourceList.get(getResources().getInteger(R.integer.WOOD_INDEX)).toString());
        stone_text.setText(resourceList.get(getResources().getInteger(R.integer.STONE_INDEX)).toString());
        fiber_text.setText(resourceList.get(getResources().getInteger(R.integer.FIBER_INDEX)).toString());
        food_text.setText(resourceList.get(getResources().getInteger(R.integer.FOOD_INDEX)).toString());
        stamina_text.setText(resourceList.get(getResources().getInteger(R.integer.HEALTH_INDEX)).toString());
        health_text.setText(resourceList.get(getResources().getInteger(R.integer.STAMINA_INDEX)).toString());
    }

    @Override
    protected void onStop() {
        if (realm != null && !realm.isClosed()) {
            setAllToRealm();

        }
        super.onStop();

    }

    //onDestroy
    @Override
    protected void onDestroy() {
        realm.close();
        Realm.compactRealm(Realm.getDefaultConfiguration());
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

    public void showSnackbar(String text, int duration) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, text, duration);
        snackbar.show();
    }

    private void showSnackbar(String text) {
        Snackbar.make(coordinatorLayout, text, 400).show();
    }
}