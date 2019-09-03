import java.util.*;
/**
 * Driver.java
 * This is the driver program for Fortnite.
 * @author Deniz Sert, Nic Campanile
 * @version March 5, 2018
 */
public class Driver{
    private static Entity p = new Entity();

    public static void main (String[] args){
        System.out.println("\f");
        Scanner scan = new Scanner(System.in);
        String com="";
        int icom=0;
        boolean b=false;
        int r=0;
        int locationsVisited = 0;
        ArrayList<Place> locations = new ArrayList<Place>();
        ArrayList<Place> newLocations = new ArrayList<Place>();
        locations.add(0, new Place("The Lake"));
        locations.add(1, new Place("The Grove"));
        locations.add(2, new Place("The City"));
        locations.add(3, new Place("The Lodge"));
        newLocations.addAll(locations);
        Place currentPlace;
        boolean life=true;
        int iteration=0;
        int LootTotal=0;

        System.out.println("*******************\nWelcome to Legends of Hollow! \n*******************");
        System.out.println("You've been kidnapped and thrown onto an island and you " 
            + "need to survive\n... good luck");

        while(life){   

            if(iteration>0)
                System.out.println("The sun's going down, it's time to move on.");

            if(newLocations.size()==0){
                newLocations.addAll(locations);
                locationsVisited=0;
            }

            System.out.println("\n\nPick a location:");
            for(int x = 0;x<locations.size() - locationsVisited;x++){
                System.out.println((x+1) + ") "+ newLocations.get(x));
            }

            icom = scan.nextInt();
            locationsVisited++;

            currentPlace = newLocations.get(icom-1);
            System.out.println("\nYou're at " + currentPlace + ".");
            newLocations.remove(newLocations.indexOf(currentPlace));
            icom=0;

            int battle = (int)((Math.random()*3)+1);
            // System.out.println(battle);
            if (battle == 2){
                //  System.out.println("Fight sequence");
                Foe foe = new Foe();
                System.out.println("An enemy has appeared. Fight!");

                if(p.getBackpack().size()>0){
                    System.out.println("You have the following items in your backpack");
                    for (int i=0;i<p.getBackpack().size();i++){
                        System.out.println(" - " + p.getBackpack().get(i).toString());
                    }
                }
                else
                    System.out.println("You don't have any weapons! You have to fight with your " 
                        + "bare hands!");

                b=foe.fight(p.getInventory().size());
                if (b==true){ //player wins fight
                    System.out.println("You won the fight. You've acquired the foe's inventory.");

                    for (int i=0;i<foe.getBackpack().size();i++){ //acquire foe inventory
                        p.getBackpack().add(foe.getBackpack().get(i));

                    }

                }
                if (b==false){ //player loses fight
                    System.out.println("\nYou've lost the game. You ended with " + LootTotal + " gems.");
                    life=false;

                    // exitGame();
                }

            }

            if (life){
                r=(int)(Math.random()*3); //player finds either a note or treasure
                //System.out.println("r " + r);
                int r1 = (int)(Math.random()*3); //random notes
                if(r==2){ //player finds treasure
                    Item t = new Treasure();
                    //t.makeSound();
                    System.out.println("You found some gems!");
                    p.addItem(t);
                    LootTotal += ((Treasure)t).getValue();
                }

                if (r==1){ //sets game direction. notes help you find cool stuff in game
                    //debug if statement

                    /*
                    for(int i=0;i<locations.size();i++){ //makes the currentPlace not an option to go to
                    newLocations.add(i, locations.get(i));
                    if(newLocations.get(i).getName().equalsIgnoreCase(currentPlace.getName()))
                    newLocations.remove(i);
                    }
                     */
                    System.out.println("You found a note!");
                    int locN = (int)(Math.random()*(newLocations.size()));
                    Item n = new Note(newLocations.get(locN).getWeapon().getWeaponName(), currentPlace);
                    System.out.println("The note says: Get a " + n + " from " + newLocations.get(locN).getName());
                    p.addItem(n);

                }
                if(r==0){
                    System.out.println("You found a " + currentPlace.getWeapon().getWeaponName() + 
                        ". This will increase your chances of winning a fight.");
                    p.addItem(currentPlace.getWeapon());

                }

                iteration++;
            }

            if (life==false) {
                System.out.println("\n\nWould you like to play again? (y/n)");
                scan.nextLine();
                String playAgain = scan.nextLine();
                if (playAgain.equalsIgnoreCase("y")) {
                    life = true;
                    newLocations.addAll(locations);
                    locationsVisited = 0;
                    iteration = 0;
                    LootTotal = 0;
                    p = new Player();
                }
                else
                    System.out.println("Have a good day!");
            }

        }

    }

}
