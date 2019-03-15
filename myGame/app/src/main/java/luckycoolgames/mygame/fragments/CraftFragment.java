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
    private GatherFragment addButtonsFragment = new GatherFragment();
    private ActionFragment actionButtonsFragment = new ActionFragment();
    private ImageView craftStoneAxe, craftStonePickaxe, craftStoneSickle;
    private TextView craftStoneAxeText, craftStonePickaxeText, craftStoneSickleText;
    //resource Indexes
    private int woodIndex = 0;
    private int stoneIndex = 1;
    private int fiberIndex = 2;
    private int foodIndex = 3;
    private int healthIndex = 4;
    private int staminaIndex = 5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.craft_fragment, container, false);
        craftStoneAxe = view.findViewById(R.id.craft_stone_axe);
        craftStonePickaxe = view.findViewById(R.id.craft_stone_pickaxe);
        craftStoneSickle = view.findViewById(R.id.craft_stone_sickle);
        craftStoneAxeText = view.findViewById(R.id.craft_stone_axe_text);
        craftStonePickaxeText = view.findViewById(R.id.craft_stone_pickaxe_text);
        craftStoneSickleText = view.findViewById(R.id.craft_stone_sickle_text);


        craftStoneAxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double chance = Math.random();
                if (((PlayActivity) getActivity()).getList().get(woodIndex) >= 5 && ((PlayActivity) getActivity()).getList().get(stoneIndex) >= 3 && ((PlayActivity) getActivity()).getList().get(fiberIndex) >= 10 && ((PlayActivity) getActivity()).getList().get(staminaIndex) >= 20) {
                    ((PlayActivity) getActivity()).stamina_button_action(-20);
                    if (chance + 0.8 >= 1) {
                        craft(5, 3, 10, 0, 0, 0);
                        ((PlayActivity) getActivity()).setWoodInstrumentLevel(1);
                        craftStoneAxe.setVisibility(View.GONE);
                        craftStoneAxeText.setVisibility(View.GONE);
                    } else {
                        ((PlayActivity) getActivity()).health_button_action(-5);
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
                double chance = Math.random();
                if (((PlayActivity) getActivity()).getList().get(woodIndex) >= 4 && ((PlayActivity) getActivity()).getList().get(stoneIndex) >= 4 && ((PlayActivity) getActivity()).getList().get(fiberIndex) >= 10 && ((PlayActivity) getActivity()).getList().get(staminaIndex) >= 20) {
                    ((PlayActivity) getActivity()).stamina_button_action(-20);
                    if (chance + 0.8 >= 1) {
                        craft(4, 4, 10, 0, 0, 0);
                        ((PlayActivity) getActivity()).setStoneInstrumentLevel(1);
                        craftStonePickaxe.setVisibility(View.GONE);
                        craftStonePickaxeText.setVisibility(View.GONE);
                    } else {
                        ((PlayActivity) getActivity()).health_button_action(-5);
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
                double chance = Math.random();
                if (((PlayActivity) getActivity()).getList().get(woodIndex) >= 3 && ((PlayActivity) getActivity()).getList().get(stoneIndex) >= 3 && ((PlayActivity) getActivity()).getList().get(fiberIndex) >= 8 && ((PlayActivity) getActivity()).getList().get(staminaIndex) >= 20) {
                    ((PlayActivity) getActivity()).stamina_button_action(-20);
                    if (chance + 0.8 >= 1) {
                        craft(3, 3, 8, 0, 0, 0);
                        ((PlayActivity) getActivity()).setFiberInstrumentLevel(1);
                        craftStoneSickle.setVisibility(View.GONE);
                        craftStoneSickleText.setVisibility(View.GONE);
                    } else {
                        ((PlayActivity) getActivity()).health_button_action(-5);
                        Toast.makeText(getContext(), "Nice try, but you have two left hands", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "You need 3 woods, 3 stones, 8 fibers and 20 stamina", Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;
    }

    void craft(int wood, int stone, int fiber, int food, int stamina, int health) {
        ((PlayActivity) getActivity()).wood_button_action(-wood);
        ((PlayActivity) getActivity()).stone_button_action(-stone);
        ((PlayActivity) getActivity()).fiber_button_action(-fiber);
        ((PlayActivity) getActivity()).food_button_action(-food);
        ((PlayActivity) getActivity()).stamina_button_action(stamina);
        ((PlayActivity) getActivity()).health_button_action(health);
    }
}
