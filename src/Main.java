import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        //testing pokemon class

//        Pokemon pokemon1 = new Pokemon();
//        pokemon1.setSpecies("Pikachu");
//        pokemon1.setAttack(58);
//        pokemon1.setDefense(52);
//        pokemon1.setSpeed(55);
//        System.out.println(pokemon1.getAttack());
//        System.out.println(pokemon1.getDefense());
//        System.out.println(pokemon1.getSpecies());
//        System.out.println(pokemon1.getSpeed());

        //entering the number of pokemon
        Scanner scnr = new Scanner(System.in);
        //Pokedex index
        String pokemonNumber="a";
        //option chosen
        String selectionS;
        int selection=0;
        //option 2
        String pokemonSpecies;
        //option three
        String pokemonCheck;
        //option four
        String evolvePokemon1;


        System.out.println("Welcome to your new PokeDex!");
        System.out.print("How many Pokemon are in your region?: ");
        //might want to include a while loop

            try {
                pokemonNumber = scnr.next();
                if (Character.isDigit(pokemonNumber.charAt(0)) != true) {

                    throw new InputMismatchException();
                }
            } catch (InputMismatchException expt) {
                while(Character.isDigit(pokemonNumber.charAt(0))==false) {
                    System.out.print('\n');
                    System.out.print("That is not a valid choice. Try again.");
                    System.out.print('\n');
                    System.out.print("How many Pokemon are in your region?: ");
                    pokemonNumber = scnr.next();
                }

        }
        //initialize string in pokedex
        Pokedex pokemon = new Pokedex(Integer.parseInt(pokemonNumber));

        System.out.print('\n');
        System.out.println("Your new Pokedex can hold " + Integer.parseInt(pokemonNumber) +" Pokemon. Let's start using it!");
        System.out.print('\n');

        //handle error cases input a value for option outside of the given range
        //relist the main menu again and again
        while (true) {
            System.out.println("1. List Pokemon");
            System.out.println("2. Add Pokemon");
            System.out.println("3. Check a Pokemon's Stats");
            System.out.println("4. Evolve Pokemon");
            System.out.println("5. Sort Pokemon");
            System.out.println("6. Exit");
            System.out.print('\n');
            System.out.print("What would you like to do? ");
            try {
                selectionS = scnr.next();

                if(Character.isDigit(selectionS.charAt(0))!=true){
                    throw new NumberFormatException ();
                }

            }
            catch(NumberFormatException expt2){
                System.out.print('\n');
                System.out.println("That is not a valid choice. Try again.");
                System.out.print('\n');
                System.out.println("1. List Pokemon");
                System.out.println("2. Add Pokemon");
                System.out.println("3. Check a Pokemon's Stats");
                System.out.println("4. Evolve Pokemon");
                System.out.println("5. Sort Pokemon");
                System.out.println("6. Exit");
                System.out.print('\n');
                System.out.print("What would you like to do?  ");
                selectionS = scnr.next();

            }

            if(Character.isDigit(selectionS.charAt(0))==true){
                selection = Integer.parseInt(selectionS);
            }


            //error handling???
            if (selection == 1) {
                if (pokemon.listPokemon() == null) {
                    System.out.println("Empty");
                    System.out.print('\n');
                }
                //check this portion of the code
                else {
                    int i=0;
                    //going through the size of the returned string array
                    //changed the size
                        while (pokemon.listPokemon()[i] != null && i<pokemon.listPokemon().length-1) {
                            int num = i + 1;
                            System.out.println(num + ". " + pokemon.listPokemon()[i]);
                            i++;
                        }
                        int size = pokemon.listPokemon().length;
                        if(pokemon.listPokemon()[size-1]!=null){
                            System.out.println(size +". " + pokemon.listPokemon()[size-1]);
                        }
                        System.out.print('\n');

                }

            } else if (selection == 2) {
                System.out.print('\n');
                System.out.print("Please enter the Pokemon's Species: ");
                pokemonSpecies = scnr.next();
                pokemon.addPokemon(pokemonSpecies);

            } else if (selection == 3) {
                System.out.print('\n');
                System.out.print("Please enter the Pokemon of interest: ");
                pokemonCheck = scnr.next();
                //check spacing
                pokemon.checkStats(pokemonCheck);

            } else if (selection == 4) {
                System.out.print('\n');
                System.out.print("Please enter the Pokemon of interest: ");
                evolvePokemon1 = scnr.next();
                //make sure it is in the pokedex before evolving
                if (pokemon.evolvePokemon(evolvePokemon1) == true) {
                    System.out.print( evolvePokemon1 + " has evolved!");
                    System.out.println('\n');
                } else {
                    System.out.println("Missing");
                    System.out.print('\n');
                }
            } else if (selection == 5) {
                //means that the array has been sorted
                System.out.print('\n');
                pokemon.sortPokedex();
                System.out.print('\n');

            } else if (selection == 6) {
                break;
            }
            else {
                System.out.print('\n');
                System.out.println("That is not a valid choice. Try again.");
                System.out.print('\n');
            }


        }
    }
}
