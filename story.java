//variables
int randomStory=0;
        String comStory="";
        String getaWeapon="";
        boolean already1 = false, already2 = false, already3 = false;            


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
            }

            
            if (randomStory == 2){
                if (already3 == false){
                    System.out.println("You're minding your own business when a leprechaun "
                        + "jumps out of nowhere, screams at the top of his lungs, " +
                        "\"ELON MUSK IS MY DAD\", \nthen steals all your loot and runs away. " 
                        + "You stand there for several minutes realizing you've just met the "
                        + "son of a god.");
                    LootTotal=0;
                    System.out.println("You have no loot in your inventory at the moment.");
                    already3=true;
                }
            }