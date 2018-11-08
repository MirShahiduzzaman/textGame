/**Mir Shahiduzzaman November 5*/
package Game;

import People.Monster;
import People.Person;
import Rooms.BedRoom;
import Rooms.RookieRoom;
import Rooms.Room;
import Rooms.WinningRoom;
import Board.Board;

import java.util.Scanner;

public class Runner {


    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        int row = 0;
        int column = 0;
        int diffInt = 0;
        int xRoom = 0;
        int yRoom = 0;

        Scanner fin = new Scanner(System.in);
        System.out.println("Hello player, you will soon play a game of horror. In this game, your goal is to get to the exit, which will be marked on the map. Press any key to begin.");
        fin.nextLine();

        System.out.println("Before we start, please enter the difficulty you want for this game.\n 1 easy\n 2 medium\n 3 hard");
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
                if (diff.equals("2") || diff.equals("two") || diff.equals("medium") || diff.equals("m"))
                {
                    diffInt = 2;
                    row = 6;
                    column = 6;
                }
                else
                {
                    if (diff.equals("3") || diff.equals("three") || diff.equals("hard") || diff.equals("h"))
                    {
                        diffInt = 3;
                        row = 7;
                        column = 7;
                    }
                    else
                    {
                        System.out.println("Please choose a valid difficulty (easy, medium, or hard).");
                    }
                }
            }
        }

        Room[][] mansion = new Room[row][column];
        Board haunt = new Board(mansion);

        for (int x = 0; x<mansion.length; x++)
        {
            for (int y = 0; y < mansion[x].length; y++)
            {
                haunt.addRoom(x,y,new Room(x,y));
            }
        }

        haunt.addRoom(mansion[0].length-1,mansion.length-1,new WinningRoom(mansion.length-1,mansion.length-1));
        haunt.addRoom(0,0,new BedRoom(0,0));

        /**Need to work on adding this room*/
        for(int i = 0;i<diffInt*3;i++)
        {
            xRoom = (int)(Math.random()*mansion.length);
            yRoom = (int)(Math.random()*mansion.length);
            if(mansion[xRoom][yRoom] instanceof BedRoom || mansion[xRoom][yRoom] instanceof RookieRoom)
            {
                i--;
            }
            else
            {
                haunt.addRoom(xRoom, yRoom, new RookieRoom(xRoom, yRoom));
            }
        }

        System.out.println(haunt);

        Person player1;
        if(diffInt == 1 || diffInt == 2)
        {
            player1 = new Person("FirstName", "FamilyName", 0, 0,100);
        }
        else
        {
            player1 = new Person("FirstName", "FamilyName", 0, 0);
        }
        Monster horseman = new Monster("Mad","Horseman",1,1);
        mansion[0][0].enterRoom(player1);
        mansion[2][2].enterRoom(horseman);
        Scanner in = new Scanner(System.in);
        int counter;
        int temp;
        String choice;

        while(gameOn)
        {
            //counts distance from player and uses it to decide on a way to go
            counter = 0;
            choice = "";

            System.out.println("Where would you like to move? (Choose W, A, S, D)");
            String move = in.nextLine();
            if(validMove(move, player1, mansion))
            {
                if(validMove("ne",horseman,mansion))
                {
                    //map[p.getxLoc()-1][p.getyLoc()+1].enterRoom(p);
                    counter = Math.abs(horseman.getxLoc()-1 - player1.getxLoc());
                    counter += Math.abs(horseman.getyLoc()+1 - player1.getyLoc());
                    choice = "ne";
                }
                if(validMove("nw",horseman,mansion))
                {
                    //map[p.getxLoc()-1][p.getyLoc()-1].enterRoom(p);
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
                    //map[p.getxLoc()+1][p.getyLoc()+1].enterRoom(p);
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
                    //map[p.getxLoc()+1][p.getyLoc()-1].enterRoom(p);
                    temp = Math.abs(horseman.getxLoc()+1 - player1.getxLoc());
                    temp += Math.abs(horseman.getyLoc()-1 - player1.getyLoc());

                    if(temp<counter || choice.equals(""))
                    {
                        System.out.println("WOW");
                        choice = "sw";
                    }
                }

                mansion[horseman.getxLoc()][horseman.getyLoc()].leaveRoom(horseman);

                mansion[player1.getxLoc()][player1.getyLoc()].leaveRoom(player1);

                if(choice.equals("ne"))
                {
                    //System.out.println("ne");
                    mansion[horseman.getxLoc()-1][horseman.getyLoc()+1].enterRoom(horseman);
                }
                if(choice.equals("nw"))
                {
                    //System.out.println("nw");
                    mansion[horseman.getxLoc()-1][horseman.getyLoc()-1].enterRoom(horseman);
                    System.out.println(horseman.getxLoc());
                    System.out.println(horseman.getyLoc());
                }
                if(choice.equals("se"))
                {
                    //System.out.println("se");
                    mansion[horseman.getxLoc()+1][horseman.getyLoc()+1].enterRoom(horseman);
                }
                if(choice.equals("sw"))
                {
                    //System.out.println("sw");
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

                /**Horse moves, but player1 stays where he is.
                if(mansion[player1.getxLoc()][player1.getyLoc()] instanceof RookieRoom)
                {
                    if(validMove("ne",horseman,mansion))
                    {
                        //map[p.getxLoc()-1][p.getyLoc()+1].enterRoom(p);
                        counter = Math.abs(horseman.getxLoc()-1 - player1.getxLoc());
                        counter += Math.abs(horseman.getyLoc()+1 - player1.getyLoc());
                        choice = "ne";
                    }
                    if(validMove("nw",horseman,mansion))
                    {
                        //map[p.getxLoc()-1][p.getyLoc()-1].enterRoom(p);
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
                        //map[p.getxLoc()+1][p.getyLoc()+1].enterRoom(p);
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
                        //map[p.getxLoc()+1][p.getyLoc()-1].enterRoom(p);
                        temp = Math.abs(horseman.getxLoc()+1 - player1.getxLoc());
                        temp += Math.abs(horseman.getyLoc()-1 - player1.getyLoc());

                        if(temp<counter || choice.equals(""))
                        {
                            System.out.println("WOW");
                            choice = "sw";
                        }
                    }

                    mansion[horseman.getxLoc()][horseman.getyLoc()].leaveRoom(horseman);

                    mansion[player1.getxLoc()][player1.getyLoc()].leaveRoom(player1);

                    if(choice.equals("ne"))
                    {
                        //System.out.println("ne");
                        mansion[horseman.getxLoc()-1][horseman.getyLoc()+1].enterRoom(horseman);
                    }
                    if(choice.equals("nw"))
                    {
                        //System.out.println("nw");
                        mansion[horseman.getxLoc()-1][horseman.getyLoc()-1].enterRoom(horseman);
                        System.out.println(horseman.getxLoc());
                        System.out.println(horseman.getyLoc());
                    }
                    if(choice.equals("se"))
                    {
                        //System.out.println("se");
                        mansion[horseman.getxLoc()+1][horseman.getyLoc()+1].enterRoom(horseman);
                    }
                    if(choice.equals("sw"))
                    {
                        //System.out.println("sw");
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
                }*/

                System.out.println(haunt);
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
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
    public static void gameOff()
    {
        gameOn = false;
    }



}
