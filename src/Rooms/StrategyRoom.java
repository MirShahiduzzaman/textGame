/**Mir Shahiduzzaman November 9*/
package Rooms;

import People.Monster;
import People.Person;

//you feel smarter but soon realize this is the horseman's strategy room AKA u find out he can only move in a small L
// shape
public class StrategyRoom extends Room
{
    public StrategyRoom(int x, int y)
    {
        super(x,y);
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
            System.out.println("You search through this room for help and find a health potion! Your health went up by 5.");
            x.health += 5;
            System.out.println("Health: " + x.health);
        }
    }

    /**
     * Distinguishes the BED in the map
     * @return String BED to represent BedRoom
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
        return("STR");
    }
}
