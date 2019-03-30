package luckycoolgames.mygame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import luckycoolgames.mygame.Adapters.RecyclerAdapter;
import luckycoolgames.mygame.Adapters.RecyclerViewData;
import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;

public class StorageFragment extends Fragment {

    private int woodIndex = 0;
    private int stoneIndex = 1;
    private int fiberIndex = 2;
    private int foodIndex = 3;

    RecyclerViewData data = new RecyclerViewData();

    private RecyclerView recyclerView;

    private int[] images = data.storageImages;

    private String[] texts;

    private RecyclerAdapter recyclerAdapter;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.storage_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(getContext(),  LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter(images, texts);
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        texts = data.storageTexts;

    }


}
