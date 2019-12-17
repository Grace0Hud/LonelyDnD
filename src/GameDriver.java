import java.util.Scanner;
public class GameDriver
{
    public static void main(String [] args)
    {
        System.out.println("\tDUNGEONS and DRAGONS");
        System.out.println("----------------------------");
        startGame();
    }//end main method
    public static void startGame()
    {
        //enemies
        Healer enemy1 = new Healer("Lil Miss", "gnome", 1);
        Wizard enemy2 = new Wizard("Vienna", "celestial", 2);
        Wizard enemy3 = new Wizard("Isaac", "elf", 1);
        //start of game.
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
                sameStuff1("knight", username, keyboard);
                userk.levelUp(1);
                System.out.println(userk);
                valid = true;
                sameStuff2("knight", username, keyboard);
                //start of first level fight against deer
                boolean fight = true;
                //start of second level fight
                fight = true;
                while(fight)
                {
                    if(enemy1.getHP() < 1)
                    {
                        System.out.println("You defeated that scary deer! The girl is no where to be seen. Level up!");
                        userk.levelUp(1);
                        System.out.println(userk);
                        fight = false;
                    }
                    else if(userk.getHP() < 1)
                    {
                        death();
                        fight = false;
                    }//end if death
                    else
                    {
                        System.out.println("Would you like to run, stab it or fist it?");
                        String answer = keyboard.next();
                        valid = false;
                        while(!valid)
                        {
                            if(answer.equalsIgnoreCase("stab") || answer.equalsIgnoreCase("fist"))
                            {
                                enemy1.takeHit(userk.rollToHit(answer), userk.rollDamage(answer));
                                System.out.println("Enemy now has " + enemy1.getHP() + " HP");
                                valid = true;
                            }
                            else if(answer.equalsIgnoreCase("run"))
                            {
                                valid = true;
                                System.out.println("You live to fight another day, however, you gain no experience.");
                                fight = false;
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
                }//end first fight
                sameStuff3("knight", username, keyboard);
                //start of second level fight
                fight = true;
                while(fight)
                {
                    if(enemy2.getHP() < 1 && enemy3.getHP() < 1)
                    {
                        System.out.println("You defeated those two weirdos! Level up!");
                        userk.levelUp(2);
                        System.out.println(userk);
                        fight = false;
                    }
                    else if(userk.getHP() < 1)
                    {
                        death();
                        fight = false;
                    }//end if death
                    else
                    {
                        System.out.println("Would you like to stab it or fist it?");
                        String attack = keyboard.next();
                        System.out.println("Would you like to attack the woman(Vienna) or the elf(Isaac)");
                        String answer = keyboard.next();
                        valid = false;
                        while(!valid)
                        {
                            if(attack.equalsIgnoreCase("stab") || attack.equalsIgnoreCase("fist"))
                            {
                                while(!valid)
                                {
                                    if(answer.equalsIgnoreCase("Vienna"))
                                    {
                                        enemy2.takeHit(userk.rollToHit(attack), userk.rollDamage(attack));
                                        valid = true;
                                    }//attack vienna
                                    else if(answer.equalsIgnoreCase("Isaac"))
                                    {
                                        enemy3.takeHit(userk.rollToHit(attack), userk.rollDamage(attack));
                                        valid = true;
                                    }
                                    else
                                    {
                                        System.out.println("ISAAC or VIENNA");
                                        answer = keyboard.next();
                                    }
                                }
                                System.out.println("Vienna now has " + enemy2.getHP() + " HP");
                                System.out.println("Isaac now has " + enemy3.getHP() + "HP");
                                valid = true;
                            }
                            else
                            {
                                System.out.println("STAB or FIST");
                                attack = keyboard.next();
                            }
                        }
                        if(enemy3.getHP() > 0)
                        {
                            System.out.println("Isaac lunges to smack you. That's just how he is.");
                            userk.takeHit(enemy3.rollToHit("fist"), enemy3.rollDamage("fist"));
                        }
                        if(enemy2.getHP() > 0)
                        {
                            System.out.println("Vienna calls down a lightning bolt... hope it doesn't hit ya...");
                            userk.takeHit(enemy2.rollToHit("whoosh"), enemy2.rollDamage("whoosh"));
                        }
                        System.out.println("You have: " + userk.getHP() + "HP");
                    }
                }//end second level fight
                valid = true;
            }//end knight
            else if (userClass.equals("healer"))
            {
                Healer userh = new Healer(username, userRace, 1);
                System.out.println(userh);
                sameStuff1("healer", username, keyboard);
                userh.levelUp(1);
                System.out.println(userh);
                valid = true;
                sameStuff2("healer", username, keyboard);
                //start of first level fight against deer
                System.out.println("This enemy is the same class as you! If you are higher level, the character sheet will be revealed to you, if not. You will be reminded of your own.");
                System.out.println(Healer.compareHealer(userh, enemy1));
                boolean fight = true;
                while(fight)
                {
                    if (enemy1.getHP() < 1)
                    {
                        System.out.println("You defeated that scary deer! The girl is no where to be seen. Level up!");
                        userh.levelUp(1);
                        System.out.println(userh);
                        fight = false;
                    } else if (userh.getHP() < 1) {
                        death();
                        fight = false;
                    }//end if death
                    else
                        {
                        System.out.println("Would you like to run, summon your own beast (you will take damage too), fist it, "
                                + "or heal yourself?");
                        String answer = keyboard.next();
                        valid = false;
                        while (!valid)
                        {
                            if (answer.equalsIgnoreCase("summon") || answer.equalsIgnoreCase("fist")) {
                                enemy1.takeHit(userh.rollToHit(answer), userh.rollDamage(answer));
                                System.out.println("Enemy now has " + enemy1.getHP() + " HP");
                                valid = true;
                            } else if (answer.equalsIgnoreCase("heal")) {
                                userh.heal();
                                System.out.println("You now have " + userh.getHP() + "HP");
                                valid = true;
                            } else if (answer.equalsIgnoreCase("run")) {
                                valid = true;
                                System.out.println("You live to fight another day, however, you gain no experience.");
                                fight = false;
                            } else {
                                System.out.println("Only two options bro.");
                                answer = keyboard.next();
                            }
                        }//end fight validation
                        userh.takeHit(enemy1.rollToHit("summon"), enemy1.rollDamage("summon"));
                        System.out.println("You have: " + userh.getHP() + "HP");
                         }
                    }
                    sameStuff3("healer", username, keyboard);
                    //start of second level fight
                    fight = true;
                    while(fight)
                    {
                        if(enemy2.getHP() < 1 && enemy3.getHP() < 1)
                        {
                            System.out.println("You defeated those two weirdos! Level up!");
                            userh.levelUp(2);
                            System.out.println(userh);
                            fight = false;
                        }
                        else if(userh.getHP() < 1)
                        {
                            death();
                            fight = false;
                        }//end if death
                        else
                        {
                            System.out.println("Would you like to summon, heal or fist it?");
                            String attack = keyboard.next();
                            System.out.println("Would you like to attack the woman(Vienna) or the elf(Isaac)");
                            String answer = keyboard.next();
                            valid = false;
                            while(!valid)
                            {
                                if(attack.equalsIgnoreCase("heal"))
                                {
                                    userh.heal();
                                    System.out.println("You have healed to " + userh.getHP() + " HP");
                                }
                                else if(attack.equalsIgnoreCase("summon") || attack.equalsIgnoreCase("fist"))
                                {
                                    while(!valid)
                                    {
                                        if(answer.equalsIgnoreCase("Vienna"))
                                        {
                                            enemy2.takeHit(userh.rollToHit(attack), userh.rollDamage(attack));
                                            valid = true;
                                        }//attack vienna
                                        else if(answer.equalsIgnoreCase("Isaac"))
                                        {
                                            enemy3.takeHit(userh.rollToHit(attack), userh.rollDamage(attack));
                                            valid = true;
                                        }
                                        else
                                        {
                                            System.out.println("ISAAC or VIENNA");
                                            answer = keyboard.next();
                                        }
                                    }
                                    System.out.println("Vienna now has " + enemy2.getHP() + " HP");
                                    System.out.println("Isaac now has " + enemy3.getHP() + "HP");
                                    valid = true;
                                }
                                else
                                {
                                    System.out.println("SUMMON, HEAL or FIST");
                                    attack = keyboard.next();
                                }
                            }
                            if(enemy3.getHP() > 0)
                            {
                                System.out.println("Isaac lunges to smack you. That's just how he is.");
                                userh.takeHit(enemy3.rollToHit("fist"), enemy3.rollDamage("fist"));
                            }
                            if(enemy2.getHP() > 0)
                            {
                                System.out.println("Vienna calls down a lightning bolt... hope it doesn't hit ya...");
                                userh.takeHit(enemy2.rollToHit("whoosh"), enemy2.rollDamage("whoosh"));
                            }
                            System.out.println("You have: " + userh.getHP() + "HP");
                        }
                    }//end second level fight
            } //end of healer
            else if (userClass.equals("wizard"))
            {
                Wizard userw = new Wizard(username, userRace, 1);
                System.out.println(userw);
                sameStuff1("wizard", username,  keyboard);
                userw.levelUp(1);
                System.out.println(userw);
                valid = true;
                sameStuff2("wizard", username, keyboard);
                //start of first level fight against deer
                boolean fight = true;
                while(fight) {
                    if (enemy1.getHP() < 1) {
                        System.out.println("You defeated that scary deer! The girl is no where to be seen. Level up!");
                        userw.levelUp(1);
                        System.out.println(userw);
                        fight = false;
                    } else if (userw.getHP() < 1) {
                        death();
                        fight = false;
                    }//end if death
                    else {
                        System.out.println("Would you like to run, whoosh it (magic attack) or fist it?");
                        String answer = keyboard.next();
                        valid = false;
                        while (!valid)
                        {
                            if (answer.equalsIgnoreCase("whoosh") || answer.equalsIgnoreCase("fist")) {
                                enemy1.takeHit(userw.rollToHit(answer), userw.rollDamage(answer));
                                System.out.println("Enemy now has " + enemy1.getHP() + " HP");
                                valid = true;
                            }
                            else if(answer.equalsIgnoreCase("run"))
                            {
                                valid = true;
                                System.out.println("You live to fight another day, however, you gain no experience.");
                                fight = false;
                            }
                            else
                                {
                                System.out.println("Only two options bro.");
                                answer = keyboard.next();
                            }
                        }
                        userw.takeHit(enemy1.rollToHit("summon"), enemy1.rollDamage("summon"));
                        System.out.println("You have: " + userw.getHP() + "HP");
                    }
                }//end first combat //
                sameStuff3("wizard", username, keyboard);
                //start of second level fight
                System.out.println("These two are the same class as you! Their character sheets may be revealed if they are lower level. ");
                System.out.println(Wizard.compareWizard(userw, enemy2));
                System.out.println(Wizard.compareWizard(userw,enemy3));
                fight = true;
                while(fight)
                {
                    if(enemy2.getHP() < 1 && enemy3.getHP() < 1)
                    {
                        System.out.println("You defeated those two weirdos! Level up!");
                        userw.levelUp(2);
                        System.out.println(userw);
                        fight = false;
                    }
                    else if(userw.getHP() < 1)
                    {
                        death();
                        fight = false;
                    }//end if death
                    else
                    {
                        System.out.println("Would you like to whoosh it or fist it?");
                        String attack = keyboard.next();
                        System.out.println("Would you like to attack the woman(Vienna) or the elf(Isaac)");
                        String answer = keyboard.next();
                        valid = false;
                        while(!valid)
                        {
                            if(attack.equalsIgnoreCase("whoosh") || attack.equalsIgnoreCase("fist"))
                            {
                                while(!valid)
                                {
                                    if(answer.equalsIgnoreCase("Vienna"))
                                    {
                                        enemy2.takeHit(userw.rollToHit(attack), userw.rollDamage(attack));
                                        valid = true;
                                    }//attack vienna
                                    else if(answer.equalsIgnoreCase("Isaac"))
                                    {
                                        enemy3.takeHit(userw.rollToHit(attack), userw.rollDamage(attack));
                                        valid = true;
                                    }
                                    else
                                    {
                                        System.out.println("ISAAC or VIENNA");
                                        answer = keyboard.next();
                                    }
                                }
                                System.out.println("Vienna now has " + enemy2.getHP() + " HP");
                                System.out.println("Isaac now has " + enemy3.getHP() + "HP");
                                valid = true;
                            }
                            else
                            {
                                System.out.println("WHOOSH or FIST");
                                attack = keyboard.next();
                            }
                        }
                        if(enemy3.getHP() > 0)
                        {
                            System.out.println("Isaac lunges to smack you. That's just how he is.");
                            userw.takeHit(enemy3.rollToHit("fist"), enemy3.rollDamage("fist"));
                        }
                        if(enemy2.getHP() > 0)
                        {
                            System.out.println("Vienna calls down a lightning bolt... hope it doesn't hit ya...");
                            userw.takeHit(enemy2.rollToHit("whoosh"), enemy2.rollDamage("whoosh"));
                        }
                        System.out.println("You have: " + userw.getHP() + "HP");
                    }
                }//end second level fight
            }//end of wizard if
            else
            {
                System.out.println("You failed... first try... DUDE. Try again. WIZARD, HEALER, or KNIGHT");
                userClass = keyboard.next();
            }
        }//end of valid checking while loop
        System.out.println("As you round the crest of the hill you see a town sprawled before you. Levilis. The town of the sea.");
        System.out.println("You have found saftey. Thank you for playing!");
    }//end set up class

    public static void sameStuff1(String someClass, String name, Scanner scan)
    {
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
                        death();
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
                death();
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
    public static void sameStuff2(String userClass, String name, Scanner scan)
    {
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
    public static void sameStuff3(String userClass, String name, Scanner scan)
    {
        boolean flower = false;
        boolean water = false;
        System.out.println("Well. That first encounter went well enough(or I suppose it could not have happened at all.");
        System.out.println("The little girl you met or avoided was one of the several minions of Torbour in this desert");
        System.out.println("They are all in search of the same thing you are - and aren't very fond of competition. ");
        System.out.println("Perhaps you should be a little more aware from now on.");
        System.out.println();
        System.out.println("The desert stretches on for miles. Ahead lies the path. To the left is the forest of cacti."
        + "To the right is a well.");
        System.out.println("Where would you like to go? (ahead/left/right)");
        String answer = scan.next();
        boolean valid = false;
        while(!valid)
        {
            if(answer.equalsIgnoreCase("ahead"))
            {
                System.out.println("You continue peacefully down the path. Nothing wrong here, no. Nothing wrong.");
                valid = true;
            }//end ahead if
            else if(answer.equalsIgnoreCase("left"))
            {
                System.out.println("The cacti are spikey but... I would describe them as fairly adorable. I love cacti.");
                System.out.println("Atop one of the smaller succulents is a little blossom. Do you want to pick it up?");
                answer = scan.next();
                while(!valid)
                {
                    if(answer.equalsIgnoreCase("yes"))
                    {
                        System.out.println("You pick up the flower. It is a bright red with a yellow pattern on "
                        + "the bottom of the leaves.");
                        flower = true;
                        valid = true;
                    }
                    else
                    {
                        System.out.println("You may admire a few cacti, but eventually it is time to move on and return to the path.");
                        valid = true;
                    }
                }
                valid = true;
            }//end forest if
            else if(answer.equalsIgnoreCase("right"))
            {
                System.out.println("The well is an oasis in a blistering desert, quite literally. Did you want to take a sip of water?");
                answer = scan.next();
                if(answer.equalsIgnoreCase("yes"))
                {
                    System.out.println("You drink some water... It reminds you of home. Such a healing feeling...");
                    water = true;
                }
                System.out.println("You return to the road.");
                valid = true;
            }
        }
        System.out.println("As you continue down the road, you see two figures approaching you in the distance.");
        System.out.println("One of them is a tall woman with blond hair and violet eyes. The other is an elf with a huge smile on his face.");
        System.out.println("There seems to be nowhere to run. Would you like to TALK or FIGHT");
        answer = scan.next();
        valid = false;
        while(!valid)
        {
            if(answer.equalsIgnoreCase("talk"))
            {
                System.out.println("Would you like to ask about \'Torbour\', the \'jewel\' or \'Levilis\'?");
                answer = scan.next();
                while(!valid)
                {
                    if(answer.equalsIgnoreCase("Torbour"))
                    {
                        System.out.println("The woman smiles. \" Torbour? That's an odd \'little\' dragon. He runs this desert.");
                        System.out.println("Most people think he's so scary, but he can't move far from his little rock. ");
                        System.out.println("That's why he has so many minions... why do you ask... you're not.. with him are you?");
                        System.out.println(" Ah... I see... Looking for a jewel for the dragon? That's my money.\"");
                        System.out.println("The woman glances at the smiling elf, they nod, and together begin to murmur in a spell-like language.");
                     valid = true;
                    }//end torbour
                    else if(answer.equalsIgnoreCase("jewel"))
                    {
                        System.out.println("The elf's eyes perk up! \"A jewel? You've seen one? Where? When?\"");
                        System.out.println("The woman squints, \"....You're not looking for it too... are you...?\"");
                        System.out.println("Both look a little angry, they begin to murmur in a spell-like language.");
                     valid = true;
                    }//end of jewel
                    else if(answer.equalsIgnoreCase("Levilis"))
                    {
                        System.out.println("The two wizards look at each other and cringe.");
                        System.out.println("\"Yeah... we aren't allowed there anymore because they are a bit prudish in their spending habits,\" says the woman.");
                        System.out.println("The elf glares at her, \"We aren't allowed there anymore because you threatened a shop keeper!\"");
                        System.out.println("\"Anyway, it's a lovely town full of fish shops and people and all sorts of magical things\"");
                        System.out.println("\"Wait..\"says the woman, \"You're not one of Torbour's minions are you?\" Both of the strangers " +
                                "begin chanting in a spell-like language");
                        valid = true;
                    }
                    else
                    {
                        System.out.println("Your options are: \'Torbour\', the \'jewel\' or \'Levilis\'.");
                        answer = scan.next();
                    }
                }
                valid = true;
            }//end of talk if
            else if(answer.equalsIgnoreCase("fight"))
            {
             valid = true;
            }//end of fight if
            else
            {
                System.out.println("Try again.");
                answer = scan.next();
            }
        }
    }//end sameStuff3
    //called whenever the character dies
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
                startGame();
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
