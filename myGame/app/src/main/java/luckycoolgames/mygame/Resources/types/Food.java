package luckycoolgames.mygame.Resources.types;

public class Food extends BasicRes {
   private int food=0;

    @Override
   public void add(int value) {
       res = food;
        if(!(res+value<0)) {
            super.add(value);}
        food=res;
    }

    @Override
   public int get() {
        res = food;
        return super.get();
    }

    @Override
   public void set(int value) {
        super.set(value);
        food = res;
    }
}
