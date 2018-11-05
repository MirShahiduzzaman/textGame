package Rooms;

import Game.Runner;
import People.Person;

public class BedRoom extends Room
{
    public BedRoom(int x, int y) {
        super(x, y);
    }

    @Override
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You wake up in the middle of the night and hear a loud noise. It seems to be your " +
                "horseman. You don't know where the sound is coming from, but you decide to go towards it.");
    }

    @Override
    public String toString()
    {
        return("BED");
    }
}
