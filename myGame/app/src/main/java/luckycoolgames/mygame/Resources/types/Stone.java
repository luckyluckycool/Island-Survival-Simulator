package luckycoolgames.mygame.Resources.types;

public class Stone extends BasicRes {
    private int stone = 0;

    @Override
   public void add(int value) {
        res = stone;
        super.add(value);
        stone = res;
    }

    @Override
    public int get() {
        res = stone;
        return super.get();
    }

    @Override
   public void set(int value) {
        super.set(value);
        stone = res;
    }
}
