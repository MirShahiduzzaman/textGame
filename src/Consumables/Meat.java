/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

public class Meat implements Consumable{
    public void gainHealth(Person p)
    {
        p.health += 5;
    }
    public void foodImp(Person p)
    {
        int gain = (int)(Math.random()*5);
        p.health += gain;
        System.out.println("You ate some buff meat and gained " + (5+gain) + "health as a bonus.");
        System.out.println("Health: " + p.health);
    }

    @Override
    public String toString()
    {
        return("Meat");
    }
}
