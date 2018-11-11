/**Mir Shahiduzzaman November 9*/
package Consumables;

import People.Person;

//decrease speed
public class Candy implements Consumable{
    public void gainHealth(Person p)
    {
        p.health -= 4;
    }
    public void foodImp(Person p)
    {
        p.health -= (int)(Math.random()*5);
    }
}
