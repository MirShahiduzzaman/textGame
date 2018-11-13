/**Mir Shahiduzzaman November 9*/
package Rooms;

import People.Monster;
import People.Person;

public class BedRoom extends Room
{
    /**
     * sets up variables for BedRoom
     * @param x the row the Room is in
     * @param y the column the Room is in
     */
    public BedRoom(int x, int y) {
        super(x, y);
    }

    /**
     * Sets the coordinates of the specified Person to the coordinates of the Room
     * Checks for whether there are two people in the room, which would mean GAME OVER
     * @param x the Person entering the Room
     */
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

        if((!(x instanceof Monster)) && !enter)
        {
            enter = true;
            System.out.println("You wake up in the middle of the night and hear a loud noise. It seems to be your " +
                    "horseman. He's behind you, giving you a one move headstart.\nMission: Get to the exit without " +
                    "getting caught\nStarting Point:BED");
        }
    }

    /**
     * Distinguishes the BED in the map and shows if there is a Person in the Bedroom
     * @return String BED to represent BedRoom or M or P to represent the Person in the Room
     */
    @Override
    public String toString()
    {
        if(!(strOccupant==null))
        {
            if(occupant instanceof Monster)
            {
                return(" M ");
            }
            else
            {
                return(" P ");
            }
        }
        return("BED");
    }
}
