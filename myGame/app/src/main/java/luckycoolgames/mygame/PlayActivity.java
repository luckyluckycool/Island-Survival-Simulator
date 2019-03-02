package luckycoolgames.mygame;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import luckycoolgames.mygame.Resources.types.Fiber;
import luckycoolgames.mygame.Resources.types.Food;
import luckycoolgames.mygame.Resources.types.Health;
import luckycoolgames.mygame.Resources.types.Stamina;
import luckycoolgames.mygame.Resources.types.Stone;
import luckycoolgames.mygame.Resources.types.Wood;
import luckycoolgames.mygame.fragments.ActionButtonFragment;

public class PlayActivity extends AppCompatActivity {
   private TextView wood_text, stone_text, fiber_text, food_text, health_text, stamina_text;
   public FragmentManager fragmentManager = getFragmentManager();

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
    private List<Integer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ActionButtonFragment actionButtonFragment = new ActionButtonFragment();
        fragmentManager.beginTransaction().add(R.id.frame_for_action_buttons, actionButtonFragment).commit();


        //init textView
        wood_text = findViewById(R.id.wood_text);
        stone_text = findViewById(R.id.stone_text);
        fiber_text = findViewById(R.id.fiber_text);
        food_text = findViewById(R.id.food_text);
        health_text = findViewById(R.id.health_text);
        stamina_text = findViewById(R.id.stamina_text);


        //first list_add
        list.add(woodIndex, wood.get());
        list.add(stoneIndex, stone.get());
        list.add(fiberIndex, fiber.get());
        list.add(foodIndex, food.get());
        list.add(healthIndex, health.get());
        list.add(staminaIndex, stamina.get());


        //first set text
        wood_text.setText(list.get(woodIndex).toString());
        stone_text.setText(list.get(stoneIndex).toString());
        food_text.setText(list.get(fiberIndex).toString());
        fiber_text.setText(list.get(fiberIndex).toString());
        health_text.setText(list.get(healthIndex).toString());
        stamina_text.setText(list.get(staminaIndex).toString());

    }

    //fast action for button
    public void wood_button_action(int value){
        wood.add(value);
        list.set(woodIndex, wood.get());
        wood_text.setText(list.get(woodIndex).toString());
    }
    public void stone_button_action(int value){
        stone.add(value);
        list.set(stoneIndex, stone.get());
        stone_text.setText(list.get(stoneIndex).toString());
    }
    public void food_button_action(int value){
        food.add(value);
        list.set(foodIndex, food.get());
        food_text.setText(list.get(foodIndex).toString());
    }
    public void fiber_button_action(int value){
        fiber.add(value);
        list.set(fiberIndex, fiber.get());
        fiber_text.setText(list.get(fiberIndex).toString());
    }
    public void health_button_action(int value){
        health.add(value);
        list.set(healthIndex, health.get());
        health_text.setText(list.get(healthIndex).toString());
    }
    public void stamina_button_action(int value){
        stamina.add(value);
        list.set(staminaIndex, stamina.get());
        stamina_text.setText(list.get(staminaIndex).toString());
    }
}
