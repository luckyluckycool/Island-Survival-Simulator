package luckycoolgames.mygame.Resources.types;



public class BasicRes {
    int res;
   protected void add(int value){
           res += value;

    }
    public int get(){
       return res;
    }
   public void set(int value){
        res = value;
    }
}
