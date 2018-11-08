/**Mir Shahiduzzaman November 5*/
package Rooms;

import People.Monster;
import People.Person;

//wastes ur time
public class RookieRoom extends Room
{
    public RookieRoom(int x, int y)
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
            System.out.println("You are bombarded with memories and faint. The horse to made a second move.");
        }

        //make horseman move randomly or else it will be too hard!
    }
}
