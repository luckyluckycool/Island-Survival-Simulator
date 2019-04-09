/*
package luckycoolgames.mygame.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import luckycoolgames.mygame.Activities.PlayActivity;
import luckycoolgames.mygame.R;
import luckycoolgames.mygame.fragments.GatherFragment;

public class GatherRecycleAdapter extends RecyclerView.Adapter<GatherRecycleAdapter.ImageViewHolder> {

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



    GatherFragment gatherFragment = new GatherFragment();
    private int[] resourceImages;
    List<Integer> list;

    private String[] resourceTexts;


    public GatherRecycleAdapter(int[] images, String[] texts) {
        this.resourceImages = images;
        this.resourceTexts = texts;
    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.default_resource_layout, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, final int position) {
        String textId = resourceTexts[position];
        int imageId = resourceImages[position];
        holder.resourceImage.setImageResource(imageId);
        holder.resourceText.setText(textId);

        holder.resourceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayActivity playActivity = new PlayActivity();
                switch (position) {
                    case 0:
                        switch (playActivity.getResourceList().get(woodInstrumentIndex)){
                            case 0:
                                gatherFragment.gatherSticks();
                                break;
                            case 1:
                                gatherFragment.cutTreesByStoneAxe();
                        }break;
                    case 1:
                        switch (playActivity.getResourceList().get(stoneInstrumentIndex)){
                            case 0:
                                gatherFragment.gatherRocks();
                                break;
                            case 1:
                                gatherFragment.pickStonesWithStonePickaxe();
                                break;
                        }break;
                    case 2:
                        switch (playActivity.getResourceList().get(fiberInstrumentIndex)){
                            case 0:
                                gatherFragment.gatherGrass();
                                break;
                            case 1:
                                gatherFragment.mowGrassWithStoneSickle();
                                break;
                        }break;
                    case 3:
                        switch (playActivity.getResourceList().get(foodInstrumentIndex)){
                            case 0:
                                gatherFragment.gatherBerries();
                                break;
                            case 1:
                                gatherFragment.gatherBerriesInBasket();
                                break;
                        }break;
                }
            }

    });

}

    @Override
    public int getItemCount() {
        return resourceImages.length;
    }




public static class ImageViewHolder extends RecyclerView.ViewHolder {

    ImageView resourceImage;
    TextView resourceText;

    public ImageViewHolder(View itemView) {
        super(itemView);
        resourceImage = itemView.findViewById(R.id.resource_image);
        resourceText = itemView.findViewById(R.id.resource_text);

    }
}
}
*/
