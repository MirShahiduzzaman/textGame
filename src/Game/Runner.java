/**Mir Shahiduzzaman November 9*/
package Game;

import Consumables.*;
import People.Monster;
import People.Person;
import Rooms.*;
import Board.Board;

import java.util.Scanner;

public class Runner {
    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        int row = 0;
        int column = 0;
        int diffInt = 0;
        int xRoom;
        int yRoom;

        Scanner fin = new Scanner(System.in);
        System.out.println("Hello player, you will soon play a game of horror. In this game, your goal is to get to the exit, which will be marked on the map.\nPlease enter your name.");
        fin.nextLine();

        System.out.println("Before we start, please enter the difficulty you want for this game.\n 1 easy\n 2 " +
                "challenging\n 3 insane");
        while(row == 0)
        {
            String diff = fin.nextLine();
            if (diff.equals("1") || diff.equals("one") || diff.equals("easy") || diff.equals("e"))
            {
                diffInt = 1;
                row = 5;
                column = 5;
            }
            else
            {
                if (diff.equals("2") || diff.equals("two") || diff.equals("challenge") || diff.equals("c") || diff.equals("challenging"))
                {
                    diffInt = 2;
                    row = 6;
                    column = 6;
                }
                else
                {
                    if (diff.equals("3") || diff.equals("three") || diff.equals("insane") || diff.equals("i"))
                    {
                        diffInt = 3;
                        row = 7;
                        column = 7;
                    }
                    else
                    {
                        System.out.println("Please choose a valid difficulty \n1 easy\n2 " +
                                "challenging\n3 impossible");
                    }
                }
            }
        }

        Room[][] mansion;
        Board haunt;
        /*if(diffInt == 1)
        {*/
            haunt = new Board(row, column);
            mansion = haunt.map;
        /*}
        else
        {
            mansion = new Room[row][column];
            haunt = new Board(mansion);
        }*/

        for (int x = 0; x<mansion.length; x++)
        {
            for (int y = 0; y < mansion[x].length; y++)
            {
                haunt.addRoom(x,y,new NormalRoom(x,y));
            }
        }

        haunt.addRoom(mansion[0].length-1,mansion.length-1,new WinningRoom(mansion.length-1,mansion.length-1));
        haunt.addRoom(0,0,new BedRoom(0,0));

        for(int i = 0;i<(diffInt*3);i++)
        {
            xRoom = (int)(Math.random()*mansion.length);
            yRoom = (int)(Math.random()*mansion.length);
            if(mansion[xRoom][yRoom] instanceof BedRoom || mansion[xRoom][yRoom] instanceof RookieRoom || mansion[xRoom][yRoom] instanceof WinningRoom || xRoom ==1 && yRoom ==1)
            {
                i--;
            }
            else
            {
                haunt.addRoom(xRoom, yRoom, new RookieRoom(xRoom, yRoom));
            }
        }

        for(int i = 0;i<(diffInt*3)-((diffInt-1)*2);i++)
        {
            xRoom = (int)(Math.random()*mansion.length);
            yRoom = (int)(Math.random()*mansion.length);
            if(mansion[xRoom][yRoom] instanceof BedRoom || mansion[xRoom][yRoom] instanceof RookieRoom || mansion[xRoom][yRoom] instanceof WinningRoom)
            {
                i--;
            }
            else
            {
                haunt.addRoom(xRoom, yRoom, new StrategyRoom(xRoom, yRoom));
            }
        }

        int randX;
        int randY;
        Consumable apple = new Apple();
        Consumable candy = new Candy();
        Consumable milk = new ExpiredMilk();
        Consumable meat = new Meat();

        Consumable[] foodList = {apple,candy,milk,meat};
        for(int i = 0;i<4;i++)
        {
            randX = (int)(Math.random()*mansion.length);
            randY = (int)(Math.random()*mansion.length);

            if(mansion[randX][randY].food==null)
            {
                haunt.addFood(randX,randY,foodList[i]);
            }
            else
            {
                i--;
            }
        }

        System.out.println(haunt);

        Person player1;
        if(diffInt == 1 || diffInt == 2)
        {
            player1 = new Person("FirstName", "FamilyName", 0, 0,(8/diffInt));
        }
        else
        {
            player1 = new Person("FirstName", "FamilyName", 0, 0);
        }

        Monster horseman = new Monster("Mad","Horseman",2,2);

        mansion[2][2].enterRoom(horseman);
        mansion[0][0].enterRoom(player1);

        Scanner in = new Scanner(System.in);
        int counter;
        int temp;
        String choice;
        String choice2;

        while(gameOn)
        {
            counter = 0;
            choice = "";

            System.out.println("Where would you like to move? (Choose W, A, S, D) You can also type status to view " +
                    "your status.");
            String move = in.nextLine();
            if(validMove(move, player1, mansion))
            {
                if(validMove("ne",horseman,mansion))
                {
                    counter = Math.abs(horseman.getxLoc()-1 - player1.getxLoc());
                    counter += Math.abs(horseman.getyLoc()+1 - player1.getyLoc());
                    choice = "ne";
                }
                if(validMove("nw",horseman,mansion))
                {
                    temp = Math.abs(horseman.getxLoc()-1 - player1.getxLoc());
                    temp += Math.abs(horseman.getyLoc()-1 - player1.getyLoc());

                    if(temp<counter || choice.equals(""))
                    {
                        counter = temp;
                        choice = "nw";
                    }
                }
                if(validMove("se",horseman,mansion))
                {
                    temp = Math.abs(horseman.getxLoc()+1 - player1.getxLoc());
                    temp += Math.abs(horseman.getyLoc()+1 - player1.getyLoc());

                    if(temp<counter || choice.equals(""))
                    {
                        counter = temp;
                        choice = "se";
                    }
                }
                if(validMove("sw",horseman,mansion))
                {
                    temp = Math.abs(horseman.getxLoc()+1 - player1.getxLoc());
                    temp += Math.abs(horseman.getyLoc()-1 - player1.getyLoc());

                    if(temp<counter || choice.equals(""))
                    {
                        choice = "sw";
                    }
                }

                mansion[horseman.getxLoc()][horseman.getyLoc()].leaveRoom(horseman);

                mansion[player1.getxLoc()][player1.getyLoc()].leaveRoom(player1);


                if(choice.equals("ne"))
                {
                    mansion[horseman.getxLoc()-1][horseman.getyLoc()+1].enterRoom(horseman);
                }
                if(choice.equals("nw"))
                {
                    mansion[horseman.getxLoc()-1][horseman.getyLoc()-1].enterRoom(horseman);
                }
                if(choice.equals("se"))
                {
                    mansion[horseman.getxLoc()+1][horseman.getyLoc()+1].enterRoom(horseman);
                }
                if(choice.equals("sw"))
                {
                    mansion[horseman.getxLoc()+1][horseman.getyLoc()-1].enterRoom(horseman);
                }


                move = move.toLowerCase().trim();
                if(move.equals("w"))
                {
                    mansion[player1.getxLoc()-1][player1.getyLoc()].enterRoom(player1);
                }
                if(move.equals("d"))
                {
                    mansion[player1.getxLoc()][player1.getyLoc() + 1].enterRoom(player1);

                }
                if(move.equals("s"))
                {
                    mansion[player1.getxLoc()+1][player1.getyLoc()].enterRoom(player1);
                }
                if(move.equals("a"))
                {
                    mansion[player1.getxLoc()][player1.getyLoc()-1].enterRoom(player1);
                }

                if(mansion[player1.getxLoc()][player1.getyLoc()] instanceof RookieRoom)
                {
                    choice2 = "";

                    if(validMove("ne",horseman,mansion))
                    {
                        counter = Math.abs(horseman.getxLoc()-1 - player1.getxLoc());
                        counter += Math.abs(horseman.getyLoc()+1 - player1.getyLoc());
                        choice2 = "ne";
                    }
                    if(validMove("nw",horseman,mansion))
                    {
                        temp = Math.abs(horseman.getxLoc()-1 - player1.getxLoc());
                        temp += Math.abs(horseman.getyLoc()-1 - player1.getyLoc());

                        if(temp<counter || choice2.equals(""))
                        {
                            counter = temp;
                            choice2 = "nw";
                        }
                    }
                    if(validMove("se",horseman,mansion))
                    {
                        temp = Math.abs(horseman.getxLoc()+1 - player1.getxLoc());
                        temp += Math.abs(horseman.getyLoc()+1 - player1.getyLoc());

                        if(temp<counter || choice2.equals(""))
                        {
                            counter = temp;
                            choice2 = "se";
                        }
                    }
                    if(validMove("sw",horseman,mansion))
                    {
                        temp = Math.abs(horseman.getxLoc()+1 - player1.getxLoc());
                        temp += Math.abs(horseman.getyLoc()-1 - player1.getyLoc());

                        if(temp<counter || choice2.equals(""))
                        {
                            choice2 = "sw";
                        }
                    }

                    mansion[horseman.getxLoc()][horseman.getyLoc()].leaveRoom(horseman);

                    if(choice2.equals("ne"))
                    {
                        mansion[horseman.getxLoc()-1][horseman.getyLoc()+1].enterRoom(horseman);
                    }
                    if(choice2.equals("nw"))
                    {
                        mansion[horseman.getxLoc()-1][horseman.getyLoc()-1].enterRoom(horseman);
                    }
                    if(choice2.equals("se"))
                    {
                        mansion[horseman.getxLoc() + 1][horseman.getyLoc() + 1].enterRoom(horseman);
                    }
                    if(choice2.equals("sw"))
                    {
                        mansion[horseman.getxLoc()+1][horseman.getyLoc()-1].enterRoom(horseman);
                    }
                }

                System.out.println(haunt);
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                if(player1.health <= 0)
                {
                    System.out.println("YOU DIED FROM BEING TOO UNHEALTHY.");
                    System.exit(0);
                }
            }
            else
            {
                System.out.println("Please choose a valid move.");
            }
        }
        in.close();
    }


    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return true if player input a valid move; false if player input is invalid
     */
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "w":
                if (p.getxLoc() > 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            case "d":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    return true;
                }
                else
                {
                    return false;
                }

            case "a":
                if (p.getyLoc() > 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }

            //Monster commands
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
            //Monster Commands

            default:
                break;

        }
        return false;
    }

    /**
     * Turns the games off
     */
    public static void gameOff()
    {
        gameOn = false;
    }



}
