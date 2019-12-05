//a knight character.
//Skill bonuses
    //+3 str
    //+2 char
public class Knight implements userClass
{
    //dice for character creation and attacks
    private Dice d20 = new Dice(20);
    private Dice d12 = new Dice(12);
    private Dice d8 = new Dice(8);
    private Dice d6 = new Dice(6);

    //details of character. starts level 1
    private String name, race;
    private int str, wis, in, cha, dex, con;
    private int hp, temphp;
    private int level = 1;
    //blank constructor wiht just defalts
    public Knight()
    {
        name = "Sam Smorkle";
        race = "Goblin";
        setUp();
    }//end of defalt constructor

    public Knight(String name, String race, int level)
    {
        this.name = name;
        this.race = race;
        this.level = level;
        setUp();
    }//end multi arg constructor

    //rolls for stats and hp
    private void setUp()
    {
        str = d6.roll(3);
        wis = d6.roll(3);
        in = d6.roll(3);
        cha = d6.roll(3);
        dex = d6.roll(3);
        con = d6.roll(3);

        hp = d12.roll(level);
        temphp = hp;
    }

    //prints out character sheet
    public String toString()
    {
        String output = "\tCharacter Sheet";
        output +=          "\n\t\tName:" + name;
        output +=          "\n\t\tRace" + race;
        output +=          "\n\t\tClass: Knight";
        output +=          "\n\t\tlevel:" + level;
        output +=          "\n\tStr:" + str;
        output +=          "\tWis:" + wis;
        output +=          "\tInt:" + in;
        output +=          "\tChar:" + cha;
        output +=          "\tDex:" + dex;
        output +=          "\tCon:" + con;
        output +=          "\n\t\tHP:" + temphp + "/" + hp;
        return output;
    }//end to string
}
