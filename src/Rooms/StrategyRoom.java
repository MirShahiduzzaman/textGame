/**Mir Shahiduzzaman November 9*/
package Rooms;

import People.Monster;
import People.Person;

//you feel smarter but soon realize this is the horseman's strategy room AKA u find out he can only move in a small L
// shape
public class StrategyRoom extends Room
{
    /**
     * Sets up the variables for StrategyRoom
     * @param x row strategyRoom is in
     * @param y column strategyRoom is in
     */
    public StrategyRoom(int x, int y)
    {
        super(x,y);
    }

    /**
     * Adds 5 health to player for finding and drinking health potion
     * Checks for whether there are two people in the room, which would mean GAME OVER
     * @param x the Person entering
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

        if(!(x instanceof Monster))
        {
            if(!enter)
            {
                System.out.println("\nYou search through this room for help and find a health potion! Your health " +
                        "went up by 5.");
                x.health += 5;
                System.out.println("Health: " + x.health);
            }
            if(!(food == null))
            {
                this.food.gainHealth(x);
                this.food.foodImp(x);
                this.food = null;
            }

            if(enter)
            {
                System.out.println("\nYou already found a health potion here.");
            }

            enter = true;
        }
    }

    /**
     * Shows the StrategyRoom on the map
     * @return String STR to represent StrategyRoom or M or P if there is a Person in the Room
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
        if(!enter)
        {
            return("???");
        }
        else
        {
            return("STR");
        }
    }
}
