/**Mir Shahiduzzaman November 5*/
package Rooms;

import People.Person;

public class BedRoom extends Room
{
    public BedRoom(int x, int y) {
        super(x, y);
    }

    @Override
    public void enterRoom(Person x) {

        occupant = x;
        strOccupant = x + "";
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You wake up in the middle of the night and hear a loud noise. It seems to be your " +
                "horseman. He's behind you, giving you a one move headstart.\nMission: Get to the exit without " +
                "getting" +
                " caught");
    }

    @Override
    public String toString()
    {
        if(!(strOccupant==null))
        {
            return("P");
        }
        return("BED");
    }
}
