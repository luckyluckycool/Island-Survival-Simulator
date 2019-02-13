package luckycoolgames.mygame.Resources.types;

public class Wood extends BasicRes{
   private int wood=0;

    @Override
    public void add(int value) {
        res = wood;
        super.add(value);
        wood =res;
    }

    public int getWood() {
        return wood;
    }
}
