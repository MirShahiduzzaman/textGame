/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

//less buff and less speed
public class ExpiredMilk implements Consumable{
    public void gainHealth(Person p)
    {
        p.health -= 10;
    }
    public void foodImp(Person p)
    {
        p.health -= (int)(Math.random()*5 + 11);
    }
}
