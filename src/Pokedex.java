import java.util.Arrays;
import java.util.Scanner;
//constructor
//evolution stats
//stats
//alphabetical

public class Pokedex implements PokedexInterface {
    private int Index;

    //trying constructor
    public Pokedex(int stringSize){
        if(stringSize==0){
            pokemon = new String [1];
            pokemonCap = new String [1];
            pokemon[0] = null;
            pokemonCap[0] = null;
            Index=1;
        }
        else {
            pokemon = new String[stringSize];
            pokemonCap = new String[stringSize];
            Index =stringSize;
            specialChar = new String[stringSize];
            Alphabet = new String[stringSize];
        }
    }
    //index holder

    //object from pokemon class

    Pokemon pokemonStats;
    private String[] pokemon;
    private String[] adjPokemonS = {null};
    private String[] adjPokemonA = {null};
    private String[] pokemonCap;
    private String[] specialChar;
    private String[] Alphabet;
    private int[] numbers = new int[3];
    //counter for the size of the string's added componenets
    private int counter =0;
    private boolean check;

    //option one
    //might need a parameter??
    public String[] listPokemon(){
    //string empty-prints out null when indexed
        if(pokemon[0]==null){
            return null;
        }

        else{
            return pokemon;
        }

    }
   public boolean addPokemon(String species){
       //https://www.programcreek.com/2014/04/check-if-array-contains-a-value-java/
       //need to handle code for both upper and lower cases
       //make sure get an error with a full array
       //toupercase code from http://www.informit.com/articles/article.aspx?p=680829&seqNum=6
       check = Arrays.asList(pokemonCap).contains(species.toUpperCase());
       if(pokemon[0]==null && pokemon.length==1){
           System.out.println("Max");
           System.out.print('\n');
           return false;
       }
        else if(counter<pokemon.length && check ==false) {
            pokemon[counter] = species;
            pokemonStats = new Pokemon(species);
            //separate string array with all the same characters just all capitalized to remove captialization errors
            pokemonCap[counter] = species.toUpperCase();
            //incrementing the counter
            //test to make sure this allows up to the last entry to be filled
            counter++;
            System.out.print('\n');
            return true;
        }
        //handling multiple errors max or reoccurence
        //handle the error print statements here
        //max
        else if(counter==pokemon.length && check ==false){
            System.out.println("Max");
            System.out.print('\n');
            return false;
        }
        //reoccurance
        else if(check==true){
           if(counter==pokemon.length){
               System.out.println("Max");
           }
           else {
               System.out.println("Duplicate");
               System.out.print('\n');
           }
            return false;
        }
        //handle the else case later
        else{
            return false;
        }

    }

    public int[] checkStats(String species){
        //return null if the error cases are met
        //website to check if an array contains a set value
        //https://www.programcreek.com/2014/04/check-if-array-contains-a-value-java/
        //returns false or true
        check = Arrays.asList(pokemonCap).contains(species.toUpperCase());
        //in the list
        if(check==true){

            //change the stats
            //stats for a different species reinitialize
            if(!pokemonStats.getSpecies().equals(species)){
               //System.out.print("check");
                System.out.println("The stats for " + species + " are:");
                pokemonStats.setSpecies(species);
                pokemonStats.setAttack((species.length()*7)+9);
                pokemonStats.setSpeed((species.length()*6)+13);
                pokemonStats.setDefense((species.length()*5)+17);
                System.out.println("Attack: " + pokemonStats.getAttack());
                System.out.println("Defense: " + pokemonStats.getDefense());
                System.out.println("Speed: "+ pokemonStats.getSpeed());
                numbers[0]=pokemonStats.getAttack();
                numbers[1]= pokemonStats.getDefense();
                numbers[2]= pokemonStats.getSpeed();
            }
            else{
                //System.out.print("check2");
                System.out.println("The stats for " + species + " are:");
                System.out.println("Attack: " + pokemonStats.getAttack());
                System.out.println("Defense: " + pokemonStats.getDefense());
                System.out.println("Speed: "+ pokemonStats.getSpeed());
                numbers[0]=pokemonStats.getAttack();
                numbers[1]= pokemonStats.getDefense();
                numbers[2]= pokemonStats.getSpeed();
            }
//            System.out.println("The stats for " + species +" are:");
//            //saved stats are for another species
//            if(!pokemonStats.getSpecies().equals(species)){
//                pokemonStats.setSpecies(species);
//                pokemonStats.getSpecies();
//                numbers[0] = pokemonStats.getAttack();
//                numbers[1] = pokemonStats.getSpeed();
//                numbers[2] = pokemonStats.getDefense();
//                System.out.println("Attack: " + numbers[0]);
//                System.out.println("Defense: " + numbers[2]);
//                System.out.println("Speed: "+ numbers[1]);
            //System.out.print("check3");
            return numbers;

            }
            //same species call getstats

//                numbers[0] = pokemonStats.getAttack();
//                numbers[1] = pokemonStats.getSpeed();
//                numbers[2] = pokemonStats.getDefense();
//                System.out.println("Attack: " + numbers[0]);
//                System.out.println("Defense: " + numbers[2]);
//                System.out.println("Speed: "+ numbers[1]);


        //empty
        else if(pokemon[0]==null){
            //necessary statement??
            System.out.println("Missing");
            System.out.print('\n');
            return null;
        }
        //not in the list
        else if(check==false){
            System.out.println("Missing");
            System.out.print('\n');
            return null;
        }
        else{
            return null;
        }
    }
    //errors
    public void sortPokedex(){
        //alphabetical order
        //might need to handle capitilization problems
        //https://alvinalexander.com/java/how-sort-java-string-array
        //source for sorting string array
        int index=0;
        int counter=0;
        int counterS=0;
        int counterA=0;
        //need to initialize size
        //max
        if(pokemon[0]!=null && pokemon[Index-1]!=null){
            //separate a special character and character array

            for(int i=0; i<pokemon.length; i++){
                //special character
                if(Character.isAlphabetic(pokemon[i].charAt(0))==false){
                    specialChar[counterS]=pokemon[i];
                    counterS++;
                }
                //alphabet
                else{
                    Alphabet[counterA]=pokemon[i];
                    counterA++;
                }
            }
            //no special characters
            if(counterS==0){
                Arrays.sort(pokemon);
            }
            //special characters
            else{
                Arrays.sort(specialChar);
                Arrays.sort(Alphabet);
                for(int i=0; i<pokemon.length;  i++){
                    if(i<specialChar.length) {
                        pokemon[i] = specialChar[i];
                    }
                    else{
                        pokemon[i]=Alphabet[i-specialChar.length];
                    }
                }
            }


        }
        //empty nothing to sort
        else if(pokemon[0]==null){

        }
        //handling when the max has yet to be reached
        else{
            //find the first instance of null
            for(int i=0; i<pokemon.length;i++){
                if(pokemon[i]==null && counter==0) {
                    index = i;
                    counter = 1;
                }
            }
            //size without nulls
            //adjPokemon = new String[index];
            for(int i=0; i<index; i++){
                if(Character.isAlphabetic(pokemon[i].charAt(0))==false){
                    specialChar[counterS]=pokemon[i];
                    counterS++;
                }
                //alphabet
                else{
                    Alphabet[counterA]=pokemon[i];
                    counterA++;
                }
                //adjPokemon[i] = pokemon[i];
            }



            //no special characters
            if(counterS==0){
                adjPokemonA = new String[counterA];
                for(int i=0; i<counterA; i++){
                    adjPokemonA[i]=Alphabet[i];
                }
                Arrays.sort(adjPokemonA);

                for(int i=0; i<index; i++){
                    //changing the sorting order for the pokemon string array
                    pokemon[i]=adjPokemonA[i];
                }
            }
            else{
                //need to just sort the characters not the empty spots
                adjPokemonA = new String[counterA];
                adjPokemonS = new String[counterS];
                for(int i=0; i<counterA; i++){
                    adjPokemonA[i]=Alphabet[i];
                }
                for(int i=0; i<counterS; i++){
                    adjPokemonS[i]=specialChar[i];
                }
                Arrays.sort(adjPokemonA);
                Arrays.sort(adjPokemonS);

                for(int i=0; i<index; i++){
                    //changing the sorting order for the pokemon string array
                    if(i<adjPokemonS.length){
                        pokemon[i]=adjPokemonS[i];
                    }
                    else{
                        pokemon[i]=adjPokemonA[i-adjPokemonS.length];
                    }
                }
            }


            //Arrays.sort(adjPokemon);

            //for detection end with displaying purposes
            //debugging make sure the components of the array are correct
//            for (int i=0; i<index; i++) {
//                System.out.print(adjPokemon[i] + " ");
//                System.out.print('\n');
//            }
        }

    }
   public boolean evolvePokemon(String species){
       //https://www.programcreek.com/2014/04/check-if-array-contains-a-value-java/
       //returns false or true
       check = Arrays.asList(pokemonCap).contains(species.toUpperCase());
       if(check==true){
           //change the stats
           //
            if(!pokemonStats.getSpecies().equals(species)){
                //System.out.print("check4");
                pokemonStats.setSpecies(species);
                pokemonStats.setAttack(2*((species.length()*7)+9));
                pokemonStats.setSpeed(3*((species.length()*6)+13));
                pokemonStats.setDefense(4*((species.length()*5)+17));
            }
            else{
                //System.out.print("check5");
                pokemonStats.setAttack(2*(pokemonStats.getAttack()));
                pokemonStats.setSpeed(3*(pokemonStats.getSpeed()));
                pokemonStats.setDefense(4*(pokemonStats.getDefense()));
            }
           //triple the speed stat
           //double the attack stat
           //4* the defense stats

           return true;
       }
       else{
           return false;
       }
  }
}
