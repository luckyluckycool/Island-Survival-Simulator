package luckycoolgames.mygame.Resources.types;

public class Food extends BasicRes {
    int food=0;

    @Override
   public void add(int value) {
       res = food;
        super.add(value);
    }
}
