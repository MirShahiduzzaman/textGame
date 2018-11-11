/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

//makes you buff
public class Meat implements Consumable{
    public void gainHealth(Person p)
    {
        p.health += 5;
    }
    public void foodImp(Person p)
    {
        p.health += (int)(Math.random()*5);
    }
}
