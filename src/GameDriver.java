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
        //enemies
        Healer enemy1 = new Healer("Lil Miss", "gnome", 1);
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
                userk.levelUp(1);
                System.out.println(userk);
                valid = true;
                sameStuff2("knight", username);
                boolean fight = true;
                while(fight)
                {
                    if(userk.getHP() < 0)
                    {
                       death();
                    }//end if death
                     else if(enemy1.getHP() < 0)
                    {
                        fight = false;
                        System.out.println("You defeated that scary deer! The girl is no where to be seen. Level up!");
                        userk.levelUp(1);
                    }
                    else
                    {
                        System.out.println("Would you like to stab it or hit it?");
                        String answer = keyboard.next();
                        valid = false;
                        while(!valid)
                        {
                            if(answer.equalsIgnoreCase("stab") || answer.equalsIgnoreCase("hit"))
                            {
                                enemy1.takeHit(userk.rollToHit(answer), enemy1.rollDamage(answer));
                                System.out.println("Enemy now has " + enemy1.getHP() + " HP");
                                valid = true;
                            }
                            else
                            {
                                System.out.println("Only two options bro.");
                                answer = keyboard.next();
                            }
                        }
                        userk.takeHit(enemy1.rollToHit("summon"), enemy1.rollDamage("summon"));
                        System.out.println("You have: " + userk.getHP() + "HP");

                    }
                }
                valid = true;
            } else if (userClass.equals("healer")) {
                Healer userh = new Healer(username, userRace, 1);
                System.out.println(userh);
                sameStuff1("healer", username);
                userh.levelUp(1);
                System.out.println(userh);
                valid = true;
            } else if (userClass.equals("wizard")) {
                Wizard userw = new Wizard(username, userRace, 1);
                System.out.println(userw);
                sameStuff1("wizard", username);
                userw.levelUp(1);
                System.out.println(userw);
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
                System.out.println("Yeah. Whatever that was, it's stupid. The dragon roars.");
                System.out.println("\"Hello, traveler, lovely to see you again,\" says the dragon");
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
                                        "\nBut if i find you lying to me about it... you better be prepared. \nGo East. Toward the town. There, perhaps, you'll find it.\"");
                        System.out.println("Listening to dragons sounds quite good right now, and there's something about those eyes that just makes you want to obey."
                        + "You go East.");
                        valid = true;
                    }
                    else
                    {
                        System.out.println("Yes...or no... not whatever the heck that is... Try again");
                        answer = scan.next();
                    }
                }//end while loop valid tester for yes/no to dragon
            }//end of talk if statement and start fight statement
            else if(answer.equalsIgnoreCase("fight"))
            {
                System.out.println("Thats. That's kinda dumb. You're like, level one," + name);
                System.out.println("You throw your fists at the lizard. It breathes fire and you are burt to a nice, tasty crisp.");
                System.out.println("Hope you weren't attached to that character");
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
            }//end of fight
            else if(answer.equalsIgnoreCase("run"))
            {
                System.out.println("That's a pretty smart decision.");
                System.out.println("I assume you run the opposite direction of the dragon? That would be East.");
                valid = true;
            }//run if end
            else
            {
                System.out.println("I understand you're a little spelling challenged. Try again deer.");
                answer = scan.next();
                valid = false;
            }
        }//validates user's reaction to seeing the dragon
        System.out.println();
        System.out.println("Before you is teh Great Desert of Tourbor. It's dry, annoying, and filled with minions."
        + "\n Minions of the Great Gold Dragon Toubour of course.");
        System.out.println("He's an odd dragon, that one you just met. You can't seem to remember where you've met him before. ");
        System.out.println("He obviously thinks he's met you... Though he didn't use your name, did he, " + name + "?");
        System.out.println("Across this desert is the sea town of Levilis. A dragon such as Tourbor will not cross the city limits.");
        System.out.println("If you can get there, you will be safe from him. But his minions lie riddled throughout the desert.");
        System.out.println("Well, at least you passed your first encounter. Level up ;}");
        System.out.println();
    }//end of sameStuff1 -- the beginning is the same for all classes.
    //things that are the same for the start of the player being at level 2
    public static void sameStuff2(String userClass, String name)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("To your left is a little girl sitting on top of a rock. Straight ahead is the road to Levilis. To your right is a rough canyon wall.");
        System.out.println("Where would you like to go? (left/front/right");
        String answer = scan.next();
        boolean valid = false;
        while(!valid)
        {
            if(answer.equalsIgnoreCase("left"))
            {
                System.out.println("Before you can get to the girl, a large deer leaps out from the bushes");
                System.out.println("It is misty and indistinct, it charges you.");
                valid = true;
            }
            else if(answer.equalsIgnoreCase("right"))
            {
                System.out.println("That's a pretty rough wall. You start trying to climb it when you hear a large bang from behind you.");
                System.out.println("When you turn around, a blue deer stands before you, misty and indistinct. It charges you.");
                valid = true;
            }
            else if(answer.equalsIgnoreCase("front"))
            {
                System.out.println("You trek onward. Good job on following the road. But just as you round a bend, the same girl stands in front of you.");
                System.out.println("She grins at you, then waves her hand. A mystical deer appears and charges toward you.");
                valid = true;
            }
            else
            {
                System.out.println("Try again. LEFT, RIGHT or FRONT");
                answer = scan.next();
            }
        }
    }//end same stuff2
    public static void death()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("You're kinda dead.... Want to try again?");
        String answer = keyboard.next();
        boolean valid = false;
        while(!valid)
        {
            if(answer.equalsIgnoreCase("yes"))
            {
                valid = true;
                setUp();
            }
            else if(answer.equalsIgnoreCase("no"))
            {
                valid = true;
                System.out.println("Bye!");
                return;
            }
            else
            {
                System.out.println("Try again. Invalid.");
                answer = keyboard.next();
            }
        }
    }//end death
}//end game driver
