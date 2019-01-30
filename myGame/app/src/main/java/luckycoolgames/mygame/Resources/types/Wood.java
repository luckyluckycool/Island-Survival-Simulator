package luckycoolgames.mygame.Resources.types;

public class Wood extends BasicRes{
    int wood=0;

    @Override
    public void add(int value) {
        res = wood;
        super.add(value);
        wood =res;
    }
}
