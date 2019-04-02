package luckycoolgames.mygame.Adapters;

import luckycoolgames.mygame.R;

public class RecyclerViewData {

   /* public String[] storageTexts = {

            getTextFromList(1),
            getTextFromList(1),
            getTextFromList(2),
            getTextFromList(3)
    };*/



    public int[] gatherImages(int woodInstrument, int stoneInstrument, int fiberInstrument, int foodInstrument) {

        int woodImage, stoneImage, fiberImage, foodImage;

        switch (woodInstrument) {

            case 0:
                woodImage = R.drawable.hand_gathering;
                break;
            case 1:
                woodImage = R.drawable.stone_axe_icon;
                break;
            default:
                woodImage = R.drawable.hand_gathering;
        }
        switch (stoneInstrument) {

            case 0:
                stoneImage = R.drawable.hand_gathering;
                break;
            case 1:
                stoneImage = R.drawable.stone_pickaxe_icon;
                break;
            default:
                stoneImage = R.drawable.hand_gathering;
        }
        switch (fiberInstrument) {

            case 0:
                fiberImage = R.drawable.hand_gathering;
                break;
            case 1:
                fiberImage = R.drawable.stone_sickle_icon;
                break;
            default:
                fiberImage = R.drawable.hand_gathering;

        }
        switch (foodInstrument) {

            case 0:
                foodImage = R.drawable.hand_gathering;
                break;
            case 1:
                foodImage = R.drawable.basket_icon;
                break;
            default:
                foodImage = R.drawable.hand_gathering;

        }

        int[] images = new int[]{woodImage, stoneImage, fiberImage, foodImage};

        return images;
    }

    public String[] gatherTexts(int woodInstrument, int stoneInstrument, int fiberInstrument, int foodInstrument) {
        String woodText, stoneText, fiberText, foodText;

        switch (woodInstrument) {
            case 0:
                woodText = "Gather sticks";
                break;
            case 1:
                woodText = "Chop trees";
                break;
            default:
                woodText = "sth wrong";
                break;
        }
        switch (stoneInstrument) {
            case 0:
                stoneText = "Gather stones";
                break;
            case 1:
                stoneText = "Pick stone with pickaxe";
                break;
            default:
                stoneText = "sth wrong";
                break;
        }
        switch (fiberInstrument) {
            case 0:
                fiberText = "Gather fiber";
                break;
            case 1:
                fiberText = "Mow the grass";
                break;
            default:
                fiberText = "sth wrong";
        }
        switch (foodInstrument) {
            case 0:
                foodText = "Gather berries";
                break;
            case 1:
                foodText = "Gather in basket";
                break;
            default:
                foodText = "sth wrong";
                break;
        }
        String[] gatherTexts = new String[]{woodText, stoneText, fiberText, foodText};
        return gatherTexts;
    }




}
