public class Pokemon {
    private String species;
    private int attack;
    private int defense;
    private int speed;

    //testing constructor
    public Pokemon(String speciesType){
        attack =(speciesType.length() * 7) + 9;
        defense = defense = (speciesType.length() * 5) + 17;
        speed = speed = (speciesType.length() * 6) + 13;
        species=speciesType;

    }
    public String getSpecies(){
        return species;
    }
    public void setSpecies(String speciesType){
       species=speciesType;
    }

    public int getAttack(){
        return attack;
    }
    public int getDefense(){
        return defense;
    }
    public int getSpeed(){
        return speed;
    }

    public void setAttack(int newAttack){
        attack = newAttack;
    }

    public void setDefense(int newDefense){
        defense = newDefense;
    }

    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }


}
