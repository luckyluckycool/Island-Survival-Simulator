/*
package luckycoolgames.mygame.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import luckycoolgames.mygame.R;

public class StorageRecyclerAdapter extends RecyclerView.Adapter<StorageRecyclerAdapter.ImageViewHolder> {

    private int[] resourceImages;

    private String[] resourceTexts;

    public StorageRecyclerAdapter(int[] images, String[] texts){
        this.resourceImages = images;
        this.resourceTexts = texts;
    }


    @Override
    public ImageViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.storage_resource_layout, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder( ImageViewHolder holder, int position) {
        String textId = resourceTexts[position];
        int imageId = resourceImages[position];
        holder.resourceImage.setImageResource(imageId);
        holder.resourceText.setText(textId);
    }

    @Override
    public int getItemCount() {
        return resourceImages.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder{

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
