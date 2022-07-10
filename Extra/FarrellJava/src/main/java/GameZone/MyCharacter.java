package GameZone;
/*
2.  Computer games often contain different characters or creatures. For example,
    you might design a game in which alien beings possess specific characteristics
    such as color, number of eyes, or number of lives. Design a character for a game,
    creating a class to hold at least three attributes for the character. Include methods
    to get and set each of the character's attributes. Save the file as MyCharacter.java.
    Then write an application in which you create at least two characters.
    In turn, pass each character to a display method that displays the character's
    attributes. Save the application as TwoCharacters.java.
 */
public class MyCharacter
{
    private String  characterName ;
    private String  characterRace ;
    private String  characterClass ;

    private int strength ;
    private int intelligence ;
    private int agility ;
    private int hitpoints ;

    public String getCharacterName() { return characterName; }
    public String getCharacterRace() { return characterRace; }
    public String getCharacterClass() { return characterClass; }
    public int getStrength() { return strength; }
    public int getIntelligence() { return intelligence; }
    public int getAgility() { return agility; }
    public int getHitpoints() { return hitpoints; }

    public void setCharacterName(String characterName) { this.characterName = characterName; }
    public void setCharacterRace(String characterRace) { this.characterRace = characterRace; }
    public void setCharacterClass(String characterClass) { this.characterClass = characterClass; }
    public void setStrength(int strength) { this.strength = strength; }
    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    public void setAgility(int agility) { this.agility = agility; }
    public void setHitpoints(int hitpoints) { this.hitpoints = hitpoints; }
}
