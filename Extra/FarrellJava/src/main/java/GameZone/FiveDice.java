package GameZone;

class DieSet
{
    private Die DieOne, DieTwo, DieThree, DieFour, DieFive  ;
    public DieSet()
    {
        DieOne = new Die() ;
        DieTwo = new Die() ;
        DieThree = new Die() ;
        DieFour = new Die() ;
        DieFive = new Die() ;
    }

    public Die getDieOne() { return DieOne; }
    public Die getDieTwo() { return DieTwo; }
    public Die getDieThree() { return DieThree; }
    public Die getDieFour() { return DieFour; }
    public Die getDieFive() { return DieFive; }
}
public class FiveDice
{
    public static void main( String[] args )
    {
        DieSet PlayerDice = new DieSet() ;
        DieSet ComputerDice = new DieSet() ;
        displayDieSet( "  Player Roll -> ", PlayerDice ) ;
        displayDieSet( "Computer Roll -> ", ComputerDice ) ;
    }
    static void displayDieSet( String preFix, DieSet dice )
    {
        System.out.println( preFix + "\tD1: " + dice.getDieOne().getValue() + "\t" +
                                        "D2: " + dice.getDieTwo().getValue() + "\t" +
                                        "D3: " + dice.getDieThree().getValue() + "\t" +
                                        "D4: " + dice.getDieFour().getValue() + "\t" +
                                        "D5: " + dice.getDieFive().getValue() ) ;
    }
}
