/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

public class Apple implements Consumable{
    public void gainHealth(Person p)
    {
        p.health += 10;
    }
    public void foodImp(Person p)
    {
        int gain = (int)(Math.random()*5+1);
        p.health += gain;
        System.out.println("You ate a healthy apple and gained " + (10 + gain) + " health as a bonus.");
        System.out.println("Health: " + p.health);
    }

    @Override
    public String toString()
    {
        return("Apple");
    }
}
