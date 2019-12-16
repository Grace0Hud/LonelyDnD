//creates a wizard player character
//+2 wis
//+3 int
// -1 con
public class Wizard implements userClasses
{
    //dice for character creation and attacks
    private Dice d20 = new Dice(20);
    private Dice d12 = new Dice(12);
    private Dice d8 = new Dice(8);
    private Dice d6 = new Dice(6);
    private Dice d4 = new Dice(4);

    //details of character. starts level 1
    private String name, race;
    private int str, wis, in, cha, dex, con;
    private int hp, temphp;
    private int level = 1;
    private int AC = 14;

    //blank constructor wiht just defaults
    public Wizard() {
        name = "Qatu Zepphor";
        race = "Chicken";
        setUp();
    }//end of defalt constructor

    public Wizard(String name, String race, int level) {
        this.name = checkName(name);
        this.race = race;
        this.level = level;
        setUp();
    }//end multi arg constructor

    //getters
    public int getStr()
    {
        return str;
    }//end str getter
    public int getWis()
    {
        return wis;
    }//end wis
    public int getIn()
    {
        return in;
    }//end in getter
    public int getCha()
    {
        return cha;
    }//end cha getter
    public int getDex()
    {
        return dex;
    }//end dex getter
    public int getCon()
    {
        return con;
    }//end of con getter
    public int getHP()
    {
        return temphp;
    }//end hp getter
    public int getAC()
    {
        return AC;
    }//end ac getter
    public String getName()
    {
        return name;
    }//end name getter
    public String getRace()
    {
        return race;
    }//end race getter
    public int getLevel()
    {
        return level;
    }//end level getter
    //setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setRace(String race)
    {
        this.race = race;
    }
    public void levelUp(int level)
    {
        this.level += level;
        in = in + (3 + level);
        wis = wis + (2 + level);
        con += level;
        hp += d12.roll(level);
        temphp = hp;
    }//end of level up method
    public void heal()
    {
        int heal = d4.roll(level);
        temphp += heal;
    }//end heal
    //rolls for stats and hp
    private void setUp()
    {
        str = d6.roll(3);
        wis = d6.roll(3) + (2 + level);
        in = d6.roll(3) + (3 + level);
        cha = d6.roll(3);
        dex = d6.roll(3);
        con = d6.roll(3) + level;

        hp = d12.roll(level) - level;
        temphp = hp;
    }
    // controls if the character will receive damage
    //toHit is rolled by the enemy using their attack stat
    //if it is less than the AC of the character, it does not hit.
    //if it is larger the player will take the damage rolled for
    public void takeHit(int toHit, int damage)
    {
        if(AC <= toHit && temphp != 0)
        {
            System.out.println("Hit!");
            temphp = temphp - damage;
        }
        else
        {
            System.out.println("Miss!");
        }
    }//end of takeHit
    //rolls for hitting the enemy with FISTS
    public int rollToHit(String weapon)
    {
        int toHit = d20.roll(1) + howMuchHit(weapon);
        return toHit;
    }
    public int rollDamage(String weapon)
    {
        int damage = howMuchDamage(weapon);
        return damage;
    }
    //decides how much extra help the user gets based on their weapon
    private int howMuchHit(String weapon)
    {
        int mod = 0;
        if(weapon.equals("whoosh"))
        {
            mod = (wis / 10 + wis % 10) + 3;
        }
        else if(weapon.equals("fist"))
        {
            mod = (str / 10 + str % 10);
        }
        else
        {
            mod = 0;
        }
        return mod;
    }
    //checks name length
    private String checkName(String name)
    {
        String tempName = name;
        if(tempName.length() > 30)
        {
            name = tempName.substring(0, 30);
        }
        else if(tempName.length() < 1)
        {
            name = "Sam Smorkle";
        }
        return name;
    }
    //rolls for the damage the attack deals, the powerful magic attack also deals
    //a die of damage to the user
    private int howMuchDamage(String weapon)
    {
        int damage = 0;
        if(weapon.equals("whoosh"))
        {
            damage = d12.roll(3);
            temphp -= damage/3;
        }
        else if(weapon.equals("fist"))
        {
            damage = d6.roll(1);
        }
        return damage;
    }
    //prints out character sheet
    public String toString()
    {
        String output = "\tCharacter Sheet";
        output +=          "\nName:" + name;
        output +=          "\nRace:" + race;
        output +=          "\nClass: Wizard";
        output +=          "\nlevel:" + level;
        output +=          "\n\tStr:" + str;
        output +=          "\tWis:" + wis;
        output +=          "\tInt:" + in;
        output +=          "\tChar:" + cha;
        output +=          "\tDex:" + dex;
        output +=          "\tCon:" + con;
        output +=          "\nAC:" + AC;
        output +=          "\nHP:" + temphp + "/" + hp;
        output += "\n";
        return output;
    }//end to string
}
