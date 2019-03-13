package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;

public class ActButtonsFragment extends Fragment {

private ImageView eatFood, back;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.act_buttons_fragment, container, false);
        eatFood = view.findViewById(R.id.eat_food);
        back = view.findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionButtonFragment actionButtonFragment = new ActionButtonFragment();
                ((PlayActivity) getActivity()).fragmentManager.beginTransaction().replace(R.id.frame_for_action_buttons, actionButtonFragment).commit();
            }
        });

        eatFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PlayActivity)getActivity()).eatFoodAction();
            }
        });
        return view;
    }
}
