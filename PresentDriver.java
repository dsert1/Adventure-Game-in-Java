import java.util.*;
/**
 * Driver.java
 * This is the driver program for Fortnite.
 * @author Deniz Sert, Nic Campanile
 * @version March 5, 2018
 */
public class PresentDriver{
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
        int randomStory=0;
        String comStory="";
        String getaWeapon="";
        boolean already1 = false, already2 = false, already3 = false;

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

            //story
            randomStory=((int)(Math.random()*3));
            if (randomStory==0){
                if(already1==false){
                    System.out.println("A black cat has appeared. It doesn't appear to be " 
                        + " aggressive but it looks like it's been through a lot.");
                    System.out.println("Stop to pet the cat? (Y/N)");
                    comStory = scan.next();
                    if (comStory.equalsIgnoreCase("y"))
                        System.out.println("The cat scratched you and ran away. " 
                            + "You don't take any damage but you feel the pain on the inside:(");

                    else 
                        System.out.println("The cat looks sad that you didn't pet it. You "
                            + " suddenly feel guilty, but before you can do anything more the " 
                            + " cat runs away.");
                    already1=true;
                }
            }

            if (randomStory==1){
                if (already2 == false){
                    System.out.println("A villager appears. You don't fight him because " +
                        " he doesn't look aggressive. He asks you where his money is, punk.");
                    System.out.println("You decide to kill him for his insolence.");
                    comStory=scan.nextLine();

                    System.out.println("You square up and "
                        + "prepare to take revenge on the man for ever trying to take \n"
                        + "your hard earned dinero. Before you can do more, he karate " 
                        + "chops you and you become very sad:( He's accomlished his goal and runs away.");

                }
                already2=true;
            }

            
            if (randomStory == 2){
                if (already3 == false){
                    System.out.println("You're minding your own business when a leprechaun "
                        + "jumps out of nowhere, screams at the top of his lungs, " +
                        "\"ELON MUSK IS MY DAD\", \nthen steals all your loot and runs away. " 
                        + "You stand there for several minutes realizing you've just met the "
                        + "son of a god.");
                    LootTotal=0;
                    for (int i=0; i<p.getBackpack().size();i++){
                        if(p.getBackpack().get(i) instanceof Treasure)
                            p.getBackpack().remove(i);   
                    }
                    
                    System.out.println("You have no loot in your inventory at the moment.");
                    already3=true;
                }
            }

            int battle = (int)((Math.random()*3)+1);
            // System.out.println(battle);
            if (battle == 2){
                //  System.out.println("Fight sequence");
                Foe foe = new Foe();
                System.out.println("\nAn enemy has appeared. Fight!");

                if(p.getBackpack().size()>0){
                    System.out.println("You have the following items in your backpack");
                    for (int i=0;i<p.getBackpack().size();i++){
                        System.out.println(" - " + p.getBackpack().get(i).toString());
                    }
                }
                else
                    System.out.println("You don't have any weapons! You have to fight with your " 
                        + "bare hands!");

                b=foe.fight(p.getBackpack().size());
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

                if (newLocations.size() == 0)
                    r = 2;
                else
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
                    System.out.println("The note says: Get a " + ((Note)n).getClue() + " from " + newLocations.get(locN).getName());
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
                    newLocations.removeAll(locations);
                    newLocations.addAll(locations);
                    locationsVisited = 0;
                    iteration = 0;
                    LootTotal = 0;
                    p = new Entity();
                }
                else
                    System.out.println("Have a good day!");
            }

        }

    }
    
   
}

