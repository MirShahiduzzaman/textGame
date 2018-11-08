/**Mir Shahiduzzaman November 5*/
package Rooms;

import People.Monster;
import People.Person;

public class BedRoom extends Room
{
    public BedRoom(int x, int y) {
        super(x, y);
    }

    @Override
    public void enterRoom(Person x) {
        if(!(occupant == null))
        {
            System.out.println("THE MAD HORSEMAN CAUGHT YOU! TRY AGAIN.");
            System.exit(0);
        }
        occupant = x;
        strOccupant = x + "";
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        if(!(x instanceof Monster))
        {
            System.out.println("You wake up in the middle of the night and hear a loud noise. It seems to be your " +
                    "horseman. He's behind you, giving you a one move headstart.\nMission: Get to the exit without " +
                    "getting" +
                    " caught");
        }
    }

    @Override
    public String toString()
    {
        return("BED");
    }
}
