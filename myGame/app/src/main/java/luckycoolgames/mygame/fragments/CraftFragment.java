package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;


public class CraftFragment extends Fragment {

    private ImageView craftStoneAxe, craftStonePickaxe, craftStoneSickle, craftFiberBasket;
    private TextView craftStoneAxeText, craftStonePickaxeText, craftStoneSickleText, craftFiberBasketText;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.craft_fragment, container, false);

        craftStoneAxe = view.findViewById(R.id.craft_stone_axe);
        craftStonePickaxe = view.findViewById(R.id.craft_stone_pickaxe);
        craftStoneSickle = view.findViewById(R.id.craft_stone_sickle);
        craftFiberBasket = view.findViewById(R.id.craft_fiber_basket);

        craftStoneAxeText = view.findViewById(R.id.craft_stone_axe_text);
        craftStonePickaxeText = view.findViewById(R.id.craft_stone_pickaxe_text);
        craftStoneSickleText = view.findViewById(R.id.craft_stone_sickle_text);
        craftFiberBasketText = view.findViewById(R.id.craft_fiber_basket_text);

        craftStoneAxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (((PlayActivity) getActivity()).getResourceList().get(woodIndex) >= 5 && ((PlayActivity) getActivity()).getResourceList().get(stoneIndex) >= 3 && ((PlayActivity) getActivity()).getResourceList().get(fiberIndex) >= 10 && ((PlayActivity) getActivity()).getResourceList().get(staminaIndex) >= 20) {
                    ((PlayActivity) getActivity()).staminaAdd(-20);
                    if (chance(0.8)) {
                        craft(5, 3, 10, 0, 0, 0);
                        ((PlayActivity) getActivity()).getResourceList().set(woodInstrumentIndex,1);
                        craftStoneAxe.setVisibility(View.GONE);
                        craftStoneAxeText.setVisibility(View.GONE);
                    } else {
                        ((PlayActivity) getActivity()).healthAdd(-5);
                        Toast.makeText(getActivity(), "Nice try, but you have two left hands", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "You need 5 woods, 3 stones, 10 fibers and 20 stamina", Toast.LENGTH_LONG).show();
                }
            }
        });
        craftStonePickaxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((PlayActivity) getActivity()).getResourceList().get(woodIndex) >= 4 && ((PlayActivity) getActivity()).getResourceList().get(stoneIndex) >= 4 && ((PlayActivity) getActivity()).getResourceList().get(fiberIndex) >= 10 && ((PlayActivity) getActivity()).getResourceList().get(staminaIndex) >= 20) {
                    ((PlayActivity) getActivity()).staminaAdd(-20);
                    if (chance(0.8)) {
                        craft(4, 4, 10, 0, 0, 0);
                        ((PlayActivity) getActivity()).getResourceList().set(stoneInstrumentIndex,1);
                        craftStonePickaxe.setVisibility(View.GONE);
                        craftStonePickaxeText.setVisibility(View.GONE);
                    } else {
                        ((PlayActivity) getActivity()).healthAdd(-5);
                        Toast.makeText(getActivity(), "Nice try, but you have two left hands", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "You need 4 woods, 4 stones, 10 fibers and 20 stamina", Toast.LENGTH_LONG).show();
                }
            }
        });
        craftStoneSickle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((PlayActivity) getActivity()).getResourceList().get(woodIndex) >= 3 && ((PlayActivity) getActivity()).getResourceList().get(stoneIndex) >= 3 && ((PlayActivity) getActivity()).getResourceList().get(fiberIndex) >= 8 && ((PlayActivity) getActivity()).getResourceList().get(staminaIndex) >= 20) {
                    ((PlayActivity) getActivity()).staminaAdd(-20);
                    if (chance(0.8)) {
                        craft(3, 3, 8, 0, 0, 0);
                        ((PlayActivity) getActivity()).getResourceList().set(fiberInstrumentIndex,1);
                        craftStoneSickle.setVisibility(View.GONE);
                        craftStoneSickleText.setVisibility(View.GONE);
                    } else {
                        ((PlayActivity) getActivity()).healthAdd(-5);
                        Toast.makeText(getActivity(), "Nice try, but you have two left hands", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "You need 3 woods, 3 stones, 8 fibers and 20 stamina", Toast.LENGTH_LONG).show();
                }
            }
        });
        craftFiberBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((PlayActivity) getActivity()).getResourceList().get(fiberIndex) >= 20 && ((PlayActivity) getActivity()).getResourceList().get(staminaIndex) >= 20) {
                    staminaAdd(-20);
                    if (chance(0.8)) {
                        craft(0, 0, 20, 0, 0, 0);
                        ((PlayActivity) getActivity()).getResourceList().set(foodInstrumentIndex,1);
                        craftFiberBasket.setVisibility(View.GONE);
                        craftFiberBasketText.setVisibility(View.GONE);
                    } else {
                        healthAdd(-5);
                        Toast.makeText(getActivity(), "Nice try, but you have two left hands", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "You need 20 fibers and 20 stamina", Toast.LENGTH_LONG).show();
                }
            }
        });

        switch (getWoodInstrument()){
            case 1:
              craftStoneAxe.setVisibility(View.GONE);
              craftStoneAxeText.setVisibility(View.GONE);

        }
        switch (getStoneInstrument()){
            case 1:
                craftStonePickaxe.setVisibility(View.GONE);
                craftStonePickaxeText.setVisibility(View.GONE);

        }
        switch (getFiberInstrument()){
            case 1:
                craftStoneSickle.setVisibility(View.GONE);
                craftStoneSickleText.setVisibility(View.GONE);


        }
        switch (getFoodInstrument()){
            case 1:
                craftFiberBasket.setVisibility(View.GONE);
                craftFiberBasketText.setVisibility(View.GONE);
        }









        return view;
    }

    private void craft(int wood, int stone, int fiber, int food, int stamina, int health) {
        woodAdd(-wood);
        stoneAdd(-stone);
        fiberAdd(-fiber);
        foodAdd(-food);
        staminaAdd(stamina);
        healthAdd(health);
    }

    public boolean chance(double chance) {
        double random = Math.random();
        if (random + chance >= 1)
            return true;
        else
            return false;
    }

    private int getWood(){
        return ((PlayActivity)getActivity()).getResourceList().get(woodIndex);
    }
    private int getStone(){
        return ((PlayActivity)getActivity()).getResourceList().get(stoneIndex);
    }
    private int getFiber(){
        return ((PlayActivity)getActivity()).getResourceList().get(fiberIndex);
    }
    private int getFood(){
        return ((PlayActivity)getActivity()).getResourceList().get(foodIndex);
    }
    private int getHealth(){
        return ((PlayActivity)getActivity()).getResourceList().get(healthIndex);
    }
    private int getStamina(){
        return ((PlayActivity)getActivity()).getResourceList().get(staminaIndex);
    }

    public int getWoodInstrument() {
        int woodInstrument;

        woodInstrument = ((PlayActivity) getActivity()).getResourceList().get(woodInstrumentIndex);

        return woodInstrument;
    }

    public int getFoodInstrument() {
        int foodInstrument;

        foodInstrument = ((PlayActivity) getActivity()).getResourceList().get(foodInstrumentIndex);

        return foodInstrument;
    }

    public int getFiberInstrument() {
        int fiberInstrument;

        fiberInstrument = ((PlayActivity) getActivity()).getResourceList().get(fiberInstrumentIndex);

        return fiberInstrument;
    }

    public int getStoneInstrument() {
        int stoneInstrument;

        stoneInstrument = ((PlayActivity) getActivity()).getResourceList().get(stoneInstrumentIndex);

        return stoneInstrument;
    }

    private void woodAdd(int value) {
        ((PlayActivity) getActivity()).woodAdd(value);
    }

    private void stoneAdd(int value) {
        ((PlayActivity) getActivity()).stoneAdd(value);
    }

    private void fiberAdd(int value) {
        ((PlayActivity) getActivity()).fiberAdd(value);
    }

    private void foodAdd(int value) {
        ((PlayActivity) getActivity()).foodAdd(value);
    }

    private void staminaAdd(int value) {
        ((PlayActivity) getActivity()).staminaAdd(value);
    }

    private void healthAdd(int value) {
        ((PlayActivity) getActivity()).healthAdd(value);
    }
}
