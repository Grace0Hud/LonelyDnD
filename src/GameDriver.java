public class GameDriver
{
    public static void main(String [] args)
    {
        //tests
        Dice d20 = new Dice(20);
        Knight gerard = new Knight("Gerard Nurahad", "dwarf", 4);
        System.out.println(gerard);
        gerard.takeHit(19, 9);
        System.out.println(gerard.getHP());
        System.out.println(gerard);

    }
}
