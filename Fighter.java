public class Fighter {

    // Private fields for the Fighter class attributes
    private String characterType;
    private String name;
    private String heroVillain;
    private String universe;
    private String homePlanet;
    private String powers;
    private int intelligence;
    private int strength;
    private int stamina;
    private int speed;
    private int skills;

    // Constructor to initialize a Fighter object with all attributes.
    public Fighter(String characterType, String name, String heroVillain, String universe, String homePlanet, String powers, int intelligence, int strength, int stamina, int speed, int skills) {
        this.characterType = characterType;
        this.name = name;
        this.heroVillain = heroVillain;
        this.universe = universe;
        this.homePlanet = homePlanet;
        this.powers = powers;
        this.intelligence = intelligence;
        this.strength = strength;
        this.stamina = stamina;
        this.speed = speed;
        this.skills = skills;
    }

    // Getter for the name of the fighter.
    public String getName() {
        return name;
    }

    // Provides a string representation of the Fighter object,

    @Override
    public String toString() {
        return "Character Type = " + characterType + 
               "\nName = " + name + 
               "\nHero or Villain = " + heroVillain + 
               "\nUniverse = " + universe + 
               "\nHome Planet = " + homePlanet + 
               "\nPowers = " + powers + 
               "\nIntelligence = " + intelligence + 
               "\nStrength = " + strength + 
               "\nStamina = " + stamina + 
               "\nSpeed = " + speed + 
               "\nSkills = " + skills;
    }
} // End of class