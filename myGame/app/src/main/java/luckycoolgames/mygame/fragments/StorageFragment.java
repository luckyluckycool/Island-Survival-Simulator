/*
package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import luckycoolgames.mygame.Adapters.StorageRecyclerAdapter;
import luckycoolgames.mygame.Adapters.RecyclerViewData;
import luckycoolgames.mygame.Activities.PlayActivity;
import luckycoolgames.mygame.R;

public class StorageFragment extends Fragment {

    private int[] storageImages = new int[]{
            R.drawable.wood_icon,
            R.drawable.stone_icon,
            R.drawable.fiber_icon,
            R.drawable.food_icon
    };
    private String[] texts;

    RecyclerViewData data = new RecyclerViewData();

    private RecyclerView recyclerView;


    private StorageRecyclerAdapter recyclerAdapter;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.storage_fragment, container, false);
        recyclerView = view.findViewById(R.id.storageRecycleView);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new StorageRecyclerAdapter(storageImages, texts);
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        texts = new String[]{getTextFromList(0), getTextFromList(1), getTextFromList(2), getTextFromList(3)};

    }

    private String getTextFromList(int id) {
        String text = ((PlayActivity) getActivity()).getResourceList().get(id).toString();
        return text;
    }

}
*/
