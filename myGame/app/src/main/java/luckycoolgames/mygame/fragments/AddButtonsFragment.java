package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;
import luckycoolgames.mygame.Resources.types.Wood;

public class AddButtonsFragment extends Fragment {

    private ImageView gather_wood, gather_stone, gather_fiber, gather_food, back;
    private TextView gatherWoodText, gatherStoneText, gatherFiberText, gatherFoodText;

    public AddButtonsFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_buttons_fragment, container, false);
        gather_wood = view.findViewById(R.id.gather_wood_button);
        gather_stone = view.findViewById(R.id.gather_stone_button);
        gather_fiber = view.findViewById(R.id.gather_fiber_button);
        gather_food = view.findViewById(R.id.gather_food_button);
        gatherWoodText = view.findViewById(R.id.gather_wood_text);
        gatherStoneText = view.findViewById(R.id.gather_stone_text);
        gatherFiberText = view.findViewById(R.id.gather_fiber_text);
        back = view.findViewById(R.id.back);

        switch (((PlayActivity) getActivity()).getWoodInstrumentLevel()) {
            case 0:
                gather_wood.setBackgroundResource(R.drawable.hand_gathering);
                gatherWoodText.setText("Gather sticks");
                break;
            case 1:
                gather_wood.setBackgroundResource(R.drawable.stone_axe_icon);
                gatherWoodText.setText("Chop trees");
                break;
        }
        switch (((PlayActivity) getActivity()).getStoneInstrumentLevel()) {

            case 0:
                gather_stone.setBackgroundResource(R.drawable.hand_gathering);
                gatherStoneText.setText("Gather stones");
                break;
            case 1:
                gather_stone.setBackgroundResource(R.drawable.stone_pickaxe_icon);
                gatherStoneText.setText("Pick stone with pickaxe");
                break;
        }
        switch (((PlayActivity) getActivity()).getFiberInstrumentLevel()) {
            case 0:
                gather_fiber.setBackgroundResource(R.drawable.hand_gathering);
                gatherFiberText.setText("Gather fiber");
                break;
            case 1:
                gather_fiber.setBackgroundResource(R.drawable.stone_sickle_icon);
                gatherFiberText.setText("Mow the grass");
                break;
        }


        gather_wood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((PlayActivity) getActivity()).getWoodInstrumentLevel()) {
                    case 0:
                        gather_sticks();
                        break;
                    case 1:
                        cutTreesByStoneAxe();
                        break;
                }
            }
        });
        gather_stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((PlayActivity) getActivity()).getStoneInstrumentLevel()) {
                    case 0:
                        gather_rocks();
                        break;
                    case 1:
                        pickStonesWithStonePickaxe();
                        break;
                }
            }
        });
        gather_fiber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((PlayActivity) getActivity()).getFiberInstrumentLevel()) {
                    case 0:
                        gather_grass();
                        break;
                    case 1:
                        mowGrassWithStoneSickle();
                        break;
                }
            }
        });
        gather_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gather_berries();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionButtonFragment actionButtonFragment = new ActionButtonFragment();
                ((PlayActivity) getActivity()).fragmentManager.beginTransaction().replace(R.id.frame_for_action_buttons, actionButtonFragment).commit();
            }
        });


        return view;
    }

    void gather_sticks() {

        ((PlayActivity) getActivity()).wood_button_action(1);
        ((PlayActivity) getActivity()).stamina_button_action(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).health_button_action(-3);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You ran a splinter in your finger =(", Toast.LENGTH_SHORT);
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

    void gather_rocks() {
        ((PlayActivity) getActivity()).stone_button_action(1);
        ((PlayActivity) getActivity()).stamina_button_action(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).health_button_action(-3);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You hit your foot finger by hided stone =(", Toast.LENGTH_SHORT);
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

    void gather_grass() {
        ((PlayActivity) getActivity()).fiber_button_action(1);
        ((PlayActivity) getActivity()).stamina_button_action(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).health_button_action(-3);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You slip and fall on the wet grass =(", Toast.LENGTH_SHORT);
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

    void gather_berries() {
        ((PlayActivity) getActivity()).food_button_action(1);
        ((PlayActivity) getActivity()).stamina_button_action(-5);

        double chance = Math.random();
        if (chance + 0.97 < 1) {
            ((PlayActivity) getActivity()).health_button_action(-3);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You gather rotten berry =(", Toast.LENGTH_SHORT);
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

    void cutTreesByStoneAxe() {
        ((PlayActivity) getActivity()).wood_button_action(3);
        ((PlayActivity) getActivity()).stamina_button_action(-10);

        double chance = Math.random();
        if (chance + 0.9 < 1) {
            ((PlayActivity) getActivity()).health_button_action(-10);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You hit your foot by your stone axe =(", Toast.LENGTH_SHORT);
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

    void pickStonesWithStonePickaxe() {
        ((PlayActivity) getActivity()).stone_button_action(3);
        ((PlayActivity) getActivity()).stamina_button_action(-10);

        double chance = Math.random();
        if (chance + 0.9 < 1) {
            ((PlayActivity) getActivity()).health_button_action(-10);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You hit your foot by your stone pickaxe =(", Toast.LENGTH_SHORT);
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

    void mowGrassWithStoneSickle() {
        ((PlayActivity) getActivity()).fiber_button_action(3);
        ((PlayActivity) getActivity()).stamina_button_action(-10);

        double chance = Math.random();
        if (chance + 0.9 < 1) {
            ((PlayActivity) getActivity()).health_button_action(-10);
            final Toast toast = Toast.makeText(getContext().getApplicationContext(), "You hit your foot by your stone sickle =(", Toast.LENGTH_SHORT);
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





























    //Можна додати тости про втрату причини


