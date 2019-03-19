package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import luckycoolgames.mygame.MyBook;
import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;


public class CraftFragment extends Fragment {
    private GatherFragment addButtonsFragment = new GatherFragment();
    private ActionFragment actionButtonsFragment = new ActionFragment();
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

                if (((PlayActivity) getActivity()).getList().get(woodIndex) >= 5 && ((PlayActivity) getActivity()).getList().get(stoneIndex) >= 3 && ((PlayActivity) getActivity()).getList().get(fiberIndex) >= 10 && ((PlayActivity) getActivity()).getList().get(staminaIndex) >= 20) {
                    ((PlayActivity) getActivity()).staminaAdd(-20);
                    if (chance(0.8)) {
                        craft(5, 3, 10, 0, 0, 0);
                        ((PlayActivity) getActivity()).getList().set(stoneInstrumentIndex,1);
                        craftStoneAxe.setVisibility(View.GONE);
                        craftStoneAxeText.setVisibility(View.GONE);
                    } else {
                        ((PlayActivity) getActivity()).healthAdd(-5);
                        Toast.makeText(getContext(), "Nice try, but you have two left hands", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "You need 5 woods, 3 stones, 10 fibers and 20 stamina", Toast.LENGTH_LONG).show();
                }
            }
        });
        craftStonePickaxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((PlayActivity) getActivity()).getList().get(woodIndex) >= 4 && ((PlayActivity) getActivity()).getList().get(stoneIndex) >= 4 && ((PlayActivity) getActivity()).getList().get(fiberIndex) >= 10 && ((PlayActivity) getActivity()).getList().get(staminaIndex) >= 20) {
                    ((PlayActivity) getActivity()).staminaAdd(-20);
                    if (chance(0.8)) {
                        craft(4, 4, 10, 0, 0, 0);
                        ((PlayActivity) getActivity()).getList().set(stoneInstrumentIndex,1);
                        craftStonePickaxe.setVisibility(View.GONE);
                        craftStonePickaxeText.setVisibility(View.GONE);
                    } else {
                        ((PlayActivity) getActivity()).healthAdd(-5);
                        Toast.makeText(getContext(), "Nice try, but you have two left hands", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "You need 4 woods, 4 stones, 10 fibers and 20 stamina", Toast.LENGTH_LONG).show();
                }
            }
        });
        craftStoneSickle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((PlayActivity) getActivity()).getList().get(woodIndex) >= 3 && ((PlayActivity) getActivity()).getList().get(stoneIndex) >= 3 && ((PlayActivity) getActivity()).getList().get(fiberIndex) >= 8 && ((PlayActivity) getActivity()).getList().get(staminaIndex) >= 20) {
                    ((PlayActivity) getActivity()).staminaAdd(-20);
                    if (chance(0.8)) {
                        craft(3, 3, 8, 0, 0, 0);
                        ((PlayActivity) getActivity()).getList().set(fiberInstrumentIndex,1);
                        craftStoneSickle.setVisibility(View.GONE);
                        craftStoneSickleText.setVisibility(View.GONE);
                    } else {
                        ((PlayActivity) getActivity()).healthAdd(-5);
                        Toast.makeText(getContext(), "Nice try, but you have two left hands", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "You need 3 woods, 3 stones, 8 fibers and 20 stamina", Toast.LENGTH_LONG).show();
                }
            }
        });
        craftFiberBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((PlayActivity) getActivity()).getList().get(fiberIndex) >= 20 && ((PlayActivity) getActivity()).getList().get(staminaIndex) >= 20) {
                    ((PlayActivity) getActivity()).staminaAdd(-20);
                    if (chance(0.8)) {
                        craft(0, 0, 20, 0, 0, 0);
                        ((PlayActivity) getActivity()).getList().set(foodInstrumentIndex,1);
                        craftFiberBasket.setVisibility(View.GONE);
                        craftFiberBasketText.setVisibility(View.GONE);
                    } else {
                        ((PlayActivity) getActivity()).healthAdd(-5);
                        Toast.makeText(getContext(), "Nice try, but you have two left hands", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "You need 20 fibers and 20 stamina", Toast.LENGTH_LONG).show();
                }
            }
        });

        switch (((PlayActivity)getActivity()).getList().get(woodInstrumentIndex)){
            case 1:
              craftStoneAxe.setVisibility(View.GONE);
              craftStoneAxeText.setVisibility(View.GONE);

        }
        switch (((PlayActivity)getActivity()).getList().get(stoneInstrumentIndex)){
            case 1:
                craftStonePickaxe.setVisibility(View.GONE);
                craftStonePickaxeText.setVisibility(View.GONE);

        }switch (((PlayActivity)getActivity()).getList().get(fiberInstrumentIndex)){
            case 1:
                craftStoneSickle.setVisibility(View.GONE);
                craftStoneSickleText.setVisibility(View.GONE);


        }switch (((PlayActivity)getActivity()).getList().get(foodInstrumentIndex)){
            case 1:
                craftFiberBasket.setVisibility(View.GONE);
                craftFiberBasketText.setVisibility(View.GONE);
        }









        return view;
    }

    private void craft(int wood, int stone, int fiber, int food, int stamina, int health) {
        ((PlayActivity) getActivity()).woodAdd(-wood);
        ((PlayActivity) getActivity()).stoneAdd(-stone);
        ((PlayActivity) getActivity()).fiberAdd(-fiber);
        ((PlayActivity) getActivity()).foodAdd(-food);
        ((PlayActivity) getActivity()).staminaAdd(stamina);
        ((PlayActivity) getActivity()).healthAdd(health);
    }

    public boolean chance(double chance) {
        double random = Math.random();
        if (random + chance >= 1)
            return true;
        else
            return false;
    }
}
