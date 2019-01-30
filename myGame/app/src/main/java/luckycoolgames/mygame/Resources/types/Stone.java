package luckycoolgames.mygame.Resources.types;

public class Stone extends BasicRes {
    int stone=0;

    @Override
   public void add(int value) {
        res = stone;
        super.add(value);
        stone = res;
    }
}
