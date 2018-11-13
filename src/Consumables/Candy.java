/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

public class Candy implements Consumable{
    public void gainHealth(Person p)
    {
        p.health -= 4;
    }
    public void foodImp(Person p)
    {
        int loss = (int)(Math.random()*5);
        p.health -= loss;
        System.out.println("You ate candy and now have cavities. You lost " + (4+loss) + " health as a result.");
        System.out.println("Health: " + p.health);
    }

    @Override
    public String toString()
    {
        return("Candy");
    }
}
