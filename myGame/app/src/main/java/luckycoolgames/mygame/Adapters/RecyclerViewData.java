package luckycoolgames.mygame.Adapters;

import luckycoolgames.mygame.PlayActivity;
import luckycoolgames.mygame.R;

public class RecyclerViewData {
    private PlayActivity playActivity;

    public String[] storageTexts = {

            getTextFromList(0),
            getTextFromList(1),
            getTextFromList(2),
            getTextFromList(3)
    };

    public int[] storageImages = new int[]{
            R.drawable.wood_icon,
            R.drawable.stone_icon,
            R.drawable.fiber_icon,
            R.drawable.food_icon
    };

    /*public int[] gather(int instrument){
        int[] images;
        switch (instrument){
            case 0:

        }
        return images;
    }*/


    private String getTextFromList(int id){
        String text = playActivity.getResourceList().get(id).toString();
        return text;
    }
}
