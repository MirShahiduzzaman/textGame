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
            System.out.println("You are bombarded with memories and faint for one turn. The horseman has now moved.");
        }

        //make horseman move randomly or else it will be too hard!
    }

    /*public boolean moveAgain(String move,Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "ne":
                if(p instanceof Monster)
                {
                    if (p.getxLoc() > 0 && p.getyLoc()< map[p.getyLoc()].length -1)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            case "nw":
                if(p instanceof Monster)
                {
                    if (p.getxLoc() > 0 && p.getyLoc() > 0)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            case "se":
                if(p instanceof Monster)
                {
                    if (p.getxLoc() < map.length - 1 && p.getyLoc()< map[p.getyLoc()].length -1)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            case "sw":
                if(p instanceof Monster)
                {
                    if (p.getxLoc() < map.length - 1 && p.getyLoc() > 0)
                    {
                        System.out.println(p.getyLoc());
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
        }
        return false;
    }*/
}
