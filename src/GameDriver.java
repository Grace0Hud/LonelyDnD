import java.util.Scanner;
public class GameDriver
{
   boolean valid = false;
    public static void main(String [] args)
    {
        System.out.println("\tDUNGEONS and DRAGONS");
        System.out.println("----------------------------");
        setUp();
    }//end main method
    public static void setUp()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your name?");
        String username = keyboard.next();
        System.out.println("What fantasy race would you like to choose?");
        String userRace = keyboard.next();
        System.out.println("Would you like to be a \'healer\', \'knight\' or \'wizard\'?");
        String userClass = keyboard.next();
        boolean valid = false;
        while(!valid) {
            if (userClass.equals("knight")) {
                Knight userk = new Knight(username, userRace, 1);
                System.out.println(userk);
                sameStuff1("knight", username);
                valid = true;
            } else if (userClass.equals("healer")) {
                Healer userh = new Healer(username, userRace, 1);
                System.out.println(userh);
                sameStuff1("healer", username);
                valid = true;
            } else if (userClass.equals("wizard")) {
                Wizard userw = new Wizard(username, userRace, 1);
                System.out.println(userw);
                sameStuff1("wizard", username);
                valid = true;
            }
            else
            {
                System.out.println("You failed... first try... DUDE. Try again. WIZARD, HEALER, or KNIGHT");
                userClass = keyboard.next();
            }
        }//end of valid checking while loop
    }//end set up class

    public static void sameStuff1(String someClass, String name)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Why hello new " + someClass + "!");
        System.out.println("You find yourself upon a plateu. All around you are surrounded by a beautiful, wide, expansive...");
        System.out.println("desert.");
        System.out.println("(No, not a dessert. You are not a cake topper)");
        System.out.println("The rocks are red, the sky is blue.... your throat is dry");
        System.out.println("Would you like to look around?");
        String answer = scan.next();
        boolean valid = false;
        while(!valid)
        {
            //validates if the user would like to look around the desert
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("No need to roll. That's, uh, well its pretty obvious when you turn around that there's "
                        + "a dragon staring you in the face");
                valid = true;
            } else if (answer.equalsIgnoreCase("no")) {
                System.out.println("Uh.... you hear some large breathing behind you anyways. Mighty large. Perhaps DRAGON type of large");
                valid = true;
            }
            else
            {
                System.out.println("Yes...or no... not whatever the heck that is... Try again");
                answer = scan.next();
            }
        }//end while loop valid tester
        System.out.println("His scales glisten in the early morning light, golden and bright. This is a mighty ancient dragon."
        + "He stares and he stares with one deep violet eye.");
        System.out.println("What would you like to try to do? TALK, RUN, or FIGHT");
        answer = scan.next();
        valid = false;
        while(!valid)
        {
            //the user's reaction to the dragon.
            if(answer.equalsIgnoreCase("talk"))
            {
                System.out.println("What would you like to say?");
                String talkResponse = scan.next();
                System.out.println("Yeah. Whatever that was, it's stupid. The dragon roars.");
                System.out.println("\"Hello, " + name + "Lovely to see you again,\" says the dragon");
                System.out.println("\"Do you have what I want? (yes/no)");
                answer = scan.next();
                while(!valid)
                {
                    //validates if the user says they have what the dragon wants or not
                    if (answer.equalsIgnoreCase("yes")) {
                        System.out.println("The dragon growls, \"Liar.\" He ludges toward you and eats you up instantly. Never lie to a dragon.");
                        System.out.println("Would you like to play again?");
                        answer = scan.next();
                        //start while
                        while(!valid)
                        {
                            //validates if the user would like to look around the desert
                            if (answer.equalsIgnoreCase("yes")) {
                                System.out.println("Make a new character.");
                                setUp();
                                valid = true;
                            } else if (answer.equalsIgnoreCase("no")) {
                                System.out.println("Okay.... goodbye I guess...");
                                valid = true;
                                return;
                            }
                            else
                            {
                                System.out.println("Yes...or no... not whatever the heck that is... Try again");
                                answer = scan.next();
                            }
                        }//end while loop valid tester for death response
                        valid = true;
                    } else if (answer.equalsIgnoreCase("no"))
                    {
                        System.out.println("\"At least you're honest. I'll give you a little longer to find that jewel for me... " +
                                        "But if i find you lying to me about it... you better be prepared.\"");
                        valid = true;
                    }
                    else
                    {
                        System.out.println("Yes...or no... not whatever the heck that is... Try again");
                        answer = scan.next();
                    }
                }//end while loop valid tester for yes/no to dragon
            }//end of talk if statement
            else if(answer.equalsIgnoreCase("no"))
            {
                
            }

        }//validates user's reaction to seeing the dragon
    }//end of sameStuff1 -- the beginning is the same for all classes.
}//end game driver
