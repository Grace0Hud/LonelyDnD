# LonelyDnD
DESCRIPTION: A game which simulates the mechanics and Choose Your Own Adventure style of Dungeons and Dragons without
needing a Dungeon Master. It is text based and prints out to the console log. The user is first asked to create a character,
becoming either a healer, knight, or wizard. Their character sheet is created and their journey starts in the desert where
the user will meet (or run from) the Great Dragon Tobour. He seems to think the user has promised to get a jewel of his from 
across the desert in a town called Levilis. The user is sent East, only to be greated by the meddelsome minions of Torbour on 
their journey. If they should fall, the user is given thr opportunity to restart the journey with a new character. 

HOW TO PLAY:
Expositions and promts will be given in the console log. When prompted, type one of the provided options. If your answer
is misspelled or impossible you will be asked to try again. 

INTERESTING FEATURES
1. Every answer is validated and offers an opportunity for the user trying again. This ensures that game play continues even
if the user does not answer correctly. This also ensures the correct objects are created when the game is first set up.
2. Dice can be rolled a specified amount of times while offering a new random number every time. For example d6.roll(3) ,
may add together a 6, 3, and 2 to get 11 rather than rolling the first number 6, and returning 3 6s (18).
3. If the user dies, they are given the option to replay the game. This is ensured through recursion. It can be replayed as
many times as necessary and go down whatever path the user wishes each time. 
