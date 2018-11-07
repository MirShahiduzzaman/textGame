/**Mir Shahiduzzaman November 5*/
package Game;

import People.Person;
import Rooms.BedRoom;
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


        Scanner fin = new Scanner(System.in);
        System.out.println("Hello player, you will soon play a game of horror. In this game, your goal is to get to the exit, which will be marked on the map. Press any key to begin.");
        String begin = fin.nextLine();

        System.out.println("Before we start, please enter the difficulty you want for this game.\n 1 easy\n 2 medium\n 3 hard");
        while(row == 0)
        {
            String diff = fin.nextLine();
            if (diff.equals("1") || diff.equals("one") || diff.equals("easy") || diff.equals("e"))
            {
                row = 5;
                column = 5;
            }
            else
            {
                if (diff.equals("2") || diff.equals("two") || diff.equals("medium") || diff.equals("m"))
                {
                    row = 6;
                    column = 6;
                }
                else
                {
                    if (diff.equals("3") || diff.equals("three") || diff.equals("hard") || diff.equals("h"))
                    {
                        row = 7;
                        column = 7;
                    }
                    else
                    {
                        System.out.println("Please choose a difficulty");
                    }
                }
            }
        }

        //detect answer
        //use answer for dimensions

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
        System.out.println(haunt);

        /**
        //Create a random winning room.
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new WinningRoom(x, y);
        */

        //Setup player 1 and the input scanner
        Person player1 = new Person("FirstName", "FamilyName", 0,0);
        mansion[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if(validMove(move, player1, mansion))
            {
                System.out.println(haunt);
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
            }
            else {
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
     * @return
     */
    public static boolean validMove(String move, Person p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }



}
