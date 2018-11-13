/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

public class ExpiredMilk implements Consumable{
    public void gainHealth(Person p)
    {
        p.health -= 10;
    }
    public void foodImp(Person p)
    {
        int loss = (int)(Math.random()*5+11);
        p.health -= loss;
        System.out.println("RIP, that milk was expired! You now have a stomachache and as a result, you lost " + (10+loss) + " health.");
        System.out.println("Health: " + p.health);
    }

    @Override
    public String toString()
    {
        return("Milk");
    }
}
