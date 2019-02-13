package luckycoolgames.mygame.Resources.types;

public class Stone extends BasicRes {
   private int stone=0;

    @Override
   public void add(int value) {
        res = stone;
        super.add(value);
        stone = res;
    }

    public int getStone() {
        return stone;
    }
}
