package luckycoolgames.mygame.RealmObjects;

import io.realm.RealmObject;

public class RealmSleep extends RealmObject {

    long timeLeft;

    public long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }
}
