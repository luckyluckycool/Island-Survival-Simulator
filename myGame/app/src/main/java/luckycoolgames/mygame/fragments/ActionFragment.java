package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;

public class ActionFragment extends Fragment {

private ImageView eatFood;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.action_fragment, container, false);
        eatFood = view.findViewById(R.id.eat_food);


        eatFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PlayActivity)getActivity()).eatFoodAction();
            }
        });
        return view;
    }
}
