import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

 class Player {
    private String firstName;
    private String lastName;
    private int apt;
    private int set;
    private String position;
    private String nationalAssociation;
    private static List<Player> playerList = new ArrayList<>();
    
        public static void main(String[] args) {
            run();
    }

    public static void run(){
        boolean running = true;
            sampleData();
            while (running) {
                System.out.println("\nEnter 1 to add player data");
                System.out.println("Enter 2 to select team based on player positions");
                System.out.println("Enter 3 to get random players of your count");
                System.out.println("Enter 4 to generate report of players");
                System.out.println("Enter 5 to sort players by APT score (high to low)");
                System.out.println("Enter 6 to sort players by APT score (low to high)");
                System.out.println("Enter 7 to find player with highest APT score");
                System.out.println("Enter 8 to find player with lowest APT score");
                System.out.println("Enter 9 to Display Data");
                System.out.println("Enter 10 to exit program");
                
                int choice = getIntInput("Enter choice: ");
                switch (choice) {
                    case 1:
                        clearScreen();
                         addPlayerToList();
                        break;
                    case 2:
                        clearScreen();
                        selectTeam();
                        break;
                    case 3:
                        clearScreen();
                        selectRandomPlayerFromTeam();
                        break;
                    case 4:
                        clearScreen();
                        generateReport();
                        break;
                    case 5:
                        clearScreen();
                        sortPlayersHighToLow();
                        break;
                    case 6:
                        clearScreen();
                        sortPlayersLowToHigh();
                        break;
                    case 7:
                        clearScreen();
                        playerWithHigestApt();
                        break; 
                    case 8:
                        clearScreen();
                        playerWithLowestApt();
                        break;    
                    case 9:
                        clearScreen();
                        printTeam(playerList);
                        break;     
                    case 10:
                    running = false;
                    break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid choice.");
                        break;
                }
            }
    }
    
    // constructor
    public Player(String firstName, String lastName, int apt, int set, String position, String nationalAssociation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.apt = apt;
        this.set = set;
        this.position = position;
        this.nationalAssociation = nationalAssociation;
    }
  
    
    // getters and setters
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getApt() {
        return apt;
    }
    
    public void setApt(int apt) {
        this.apt = apt;
    }
    
    public int getSet() {
        return set;
    }
    
    public void setSet(int set) {
        this.set = set;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getNationalAssociation() {
        return nationalAssociation;
    }

    public void setNationalAssociation(String nationalAssociation) {
        this.nationalAssociation = nationalAssociation;
    }


    //this function is used to get the user input only in integer
    public static int getIntInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        boolean isValidInput = false;
        while (!isValidInput) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // clear the scanner buffer
            }
        }
        return input;
    }
    

    //this function is used to get the user input only as character string
    public static String getStringInput(String promt) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print(promt);
            input = scanner.nextLine();
            if (input.matches("^[a-zA-Z ]+$")) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a string consisting of only characters.");
            }
        }
        
        return input;
    }
    

    
   
    // method to calculate average score
    public static  double calculateAverageScore(int a,int b) {
        return  (a + b) / 2;
    }


    //this function is used to display all the data in the player list
    // private static void printTeam(List<Player> team) {
    //     //if the size of the list is less then 0 we will return form here
    //     if(playerList.size()<=0)
    //     {
    //         System.out.println("No data to display");
    //         return;
    //     }
    //     System.out.println("Data");
    //     System.out.println("First_Name"+" "+"Last_Name"+" "+"APT"+"  "+"SET"+" "+"National_Association"+"  "+"AVG"+"  "+"Postion");
    //     System.out.println();
    //     for (Player player : team) {
    //         System.out.println( player.getFirstName()+"       "+ player.getLastName()+"      "+ player.getApt()+"  "+ player.getSet()+"        "+player.getNationalAssociation() +"             "+calculateAverageScore(player.getApt(),player.getSet())+"   "+ player.getPosition());
    //     }
    // }
    private static void printTeam(List<Player> team) {
        // if the size of the list is less than or equal to 0 we will return from here
        if (team.size() <= 0) {
            System.out.println("No data to display");
            return;
        }
        System.out.println("Data");
        System.out.println(String.format("%-12s %-12s %-3s %-3s %-20s %-5s %-8s", "First_Name", "Last_Name", "APT", "SET", "National_Association", "AVG", "Position"));
        System.out.println();
        for (Player player : team) {
            System.out.println(String.format("%-12s %-12s %-3d %-3d %-20s %-5.2f %-8s", player.getFirstName(), player.getLastName(), player.getApt(), player.getSet(), player.getNationalAssociation(), calculateAverageScore(player.getApt(), player.getSet()), player.getPosition()));
        }
    }

    //This function is used to add players detail in list
    public static void addPlayerToList() {
    
        Scanner sc = new Scanner(System.in);

        String firstName = getStringInput("Enter player's first name: ");
        String lastName = getStringInput("Enter player's last name: ");
        int apt = getIntInput("Enter player's APT: ");
        int set = getIntInput("Enter player's SET: ");
        String position = getStringInput("Enter player's position: ");
        String nationalAssociation = getStringInput("Enter player's national association: ");   
        //stroing information in Player object then adding into the list 
        Player player = new Player(firstName, lastName, apt, set, position, nationalAssociation);
        playerList.add(player);
        
        System.out.println("Player added successfully!");
    }




    //This method is used to fillter out the team of your choice on the basis of SET values
    public static void selectTeam() {
        // first we check if the original list is empty we will return right from here
        if(playerList.size()<=0)
        {
        System.out.println( "You dont have any saved data to filter out the player");
        return;
        }

        //Now getting input from user how much attackers,defenders and midfileder he/she needs
        Scanner scanner = new Scanner(System.in);
        int numDefenders = getIntInput("Enter the required number of defenders: ");
        int numMidfielders = getIntInput("Enter the required number of midfielders: ");
        int numAttackers = getIntInput("Enter the required number of attackers: ");

        int totlal=numDefenders+numAttackers+numMidfielders;

        //Now here we are checking if the list size is less then the total sum of all user inputs if so we will return from here
        if(playerList.size()<totlal){
        System.out.println( "Insuficent data");
        return;
        }

        //here we are checking if the total sum of all inputs is greater than 10 we will return
        if(totlal>10){
            System.out.println( "No more than 10 players in single team ");
            return;
            }

        //Here we created three differents list which can only contain the objects of Player Class defender,midfielder and attacker    
        List<Player> defenders = new ArrayList<>();
        List<Player> midfielders = new ArrayList<>();
        List<Player> attackers = new ArrayList<>();


        //Here we are looping in original player list to check the position of the players    
        for (Player player : playerList) {
            //here we are checking a condition if the postion of player equal to available role then add that 
            //player in the relative list
        if (player.getPosition().equals("defender")|| player.getPosition().equals("Defender")) {
            defenders.add(player);
        } else if (player.getPosition().equals("midfielder") || player.getPosition().equals("Midfielder")) {
            midfielders.add(player);
        } else if (player.getPosition().equals("attacker") || player.getPosition().equals("Attacker")) {
            attackers.add(player);
        }
    }

        //Here we are checking if the size of defender list is less then the user required defenders if not we will return
        if(defenders.size()<numDefenders){
        System.out.println( "Insuficent Defender Player data");
        return;
        }

        //Here we are checking if the size of midfielders list is less then the user required midfielders if not we will return
        if(midfielders.size()<numMidfielders){
        System.out.println( "Insuficent MidFielder Player data");
        return;
        }

        //Here we are checking if the size of attackers list is less then the user required attackers if not we will return
        if(attackers.size()<numAttackers){
        System.out.println( "Insuficent Attacker Player data");
        return;
        }

        Comparator<Player> bySetScore=Comparator.comparingInt(Player::getSet).reversed();
    
        //Here we are adding all the list object in new list to sort them all 
         List<Player> team = new ArrayList<>();
         team.addAll(defenders.stream().sorted(bySetScore).limit(numDefenders).collect(Collectors.toList()));
         team.addAll(attackers.stream().sorted(bySetScore).limit(numAttackers).collect(Collectors.toList()));
         team.addAll(midfielders.stream().sorted(bySetScore).limit(numMidfielders).collect(Collectors.toList()));
         
        
         // Use Collections.sort() method to sort playerList in Decending order of SET
        Collections.sort(team,new Comparator<Player>() {
        // Override the compare() method of the Comparator interface to compare players based on their APT values
        public int compare(Player p1,Player p2)
        {
            //it will not update the original list as we are using duplicate list in Collection.sort()
            return Integer.compare(p2.getSet(), p1.getSet());
        }
        });
    
        System.out.println("Selected team:");
        System.out.println("--------------");
        System.out.println("First_Name"+" "+"Last_Name"+" "+"APT"+"  "+"SET"+" "+"National_Association"+"  "+"AVG"+"  "+"Postion");

        for (Player player : team) {
        System.out.println( player.getFirstName()+"       "+ player.getLastName()+"      "+ player.getApt()+"  "+ player.getSet()+"        "+player.getNationalAssociation() +"             "+calculateAverageScore(player.getApt(),player.getSet())+"   "+ player.getPosition());
        
        }
    }


    //this method is use to get random players from the list depending upon the user how much he/she wants
    public static void selectRandomPlayerFromTeam(){

        // first we check if the original list is empty we will return right from here
        if(playerList.size()<=0)
        {
        System.out.println( "You dont have any saved data");
        return;
        }
        //getting input from user
        int randomNumber = getIntInput("Enter the number of players required: ");
        //Now checking if the user input in less then the player list size if not then we will return from here
        if(playerList.size()<randomNumber){
        System.out.println( "Insuficent data");
        return;
        }

        //here we are creating a duplicate list just to keep the original safe
        List<Player> randomPlayers=new ArrayList<>(playerList);
        List<Player> randomPlayers2;

        //here we are call method to shuffle all the list object and stroing the shuffeled list into new list to loop throug
        randomPlayers2=shufflePlayers(randomPlayers);
        System.out.println("First_Name"+" "+"Last_Name"+" "+"APT"+"  "+"SET"+" "+"National_Association"+"  "+"AVG"+"  "+"Postion");
        for(int i=0; i<randomNumber; i++)
        {
        System.out.println( randomPlayers2.get(i).getFirstName()+"       "+ randomPlayers2.get(i).getLastName()+"      "+ randomPlayers2.get(i).getApt()+"  "+ randomPlayers2.get(i).getSet()+"        "+randomPlayers2.get(i).getNationalAssociation() +"             "+calculateAverageScore(randomPlayers2.get(i).getApt(),randomPlayers2.get(i).getSet())+"   "+ randomPlayers2.get(i).getPosition());

        }
    }

    //this method is used to get the player list as argument and then re-arrange the object in the list
    public static List<Player> shufflePlayers(List<Player> players) {
        Random rand = new Random();
        List<Player> shuffled = new ArrayList<>(players);
        for (int i = shuffled.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Player temp = shuffled.get(i);
            shuffled.set(i, shuffled.get(j));
            shuffled.set(j, temp);
        }
        return shuffled;
    }
    
    


    //This method is used to get the count of attacker defender and midfielder from the playerlist
    public static void generateReport(){
        //Here we created three differents list which can only contain the objects of Player Class defender,midfielder and attacker
        List<Player> defenders = new ArrayList<>();
        List<Player> midfielders = new ArrayList<>();
        List<Player> attackers = new ArrayList<>();
    
        //Here we are looping in original player list to check the position of the players
        for (Player player : playerList) {
            //here we are checking a condition if the postion of player equal to available role then add that 
            //player in the relative list
        if (player.getPosition().equals("defender")|| player.getPosition().equals("Defender")) {
            defenders.add(player);
        } else if (player.getPosition().equals("midfielder") || player.getPosition().equals("Midfielder")) {
            midfielders.add(player);
        } else if (player.getPosition().equals("attacker") || player.getPosition().equals("Attacker")) {
            attackers.add(player);
        }

        }

        // here we are getting the total size of each list to display how many attackers,midfielder
        // and defender we have by list_name.size()method whic return the size of list
        System.out.println("Postions"+"   "+"Counts");
        System.out.println("Attackers"+"    "+attackers.size());
        System.out.println("Midfielder"+"   "+midfielders.size());
        System.out.println("Defender"+"     "+defenders.size());

    }



    //This fuction is used to sort the player list based on APT From High to Low
    // public static void sortPlayersHighToLow(){
    //     // Use Collections.sort() method to sort playerList in Decending order of APT
    //     Collections.sort(playerList,new Comparator<Player>() {
    //     // Override the compare() method of the Comparator interface to compare players based on their APT values
    //     public int compare(Player p1,Player p2)
    //     {
    //         // returning this will automatically update the original player list because we uses it in Collection.sort() 
    //         return Integer.compare(p2.getApt(), p1.getApt());
    //     }
    //     });

    //     System.out.println();
    //     System.out.println("Sorted Successfully you can press 9 from menu to display the result");
    // }
    public static void sortPlayersHighToLow() {
        sortPlayerListQuick(playerList, 0, playerList.size() - 1);
        System.out.println();
        System.out.println("Sorted Successfully you can press 9 from menu to display the result");
    }
    
    private static void sortPlayerListQuick(List<Player> playerList, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionPlayerList(playerList, low, high);
            sortPlayerListQuick(playerList, low, pivotIndex - 1);
            sortPlayerListQuick(playerList, pivotIndex + 1, high);
        }
    }
    
    private static int partitionPlayerList(List<Player> playerList, int low, int high) {
        int pivot = playerList.get(high).getApt();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (playerList.get(j).getApt() >= pivot) {
                i++;
                swapPlayers(playerList, i, j);
            }
        }
        swapPlayers(playerList, i + 1, high);
        return i + 1;
    }
    
    private static void swapPlayers(List<Player> playerList, int i, int j) {
        Player temp = playerList.get(i);
        playerList.set(i, playerList.get(j));
        playerList.set(j, temp);
    }


    //This fuction is used to sort the player list based on APT From low to High
    // public static void sortPlayersLowToHight(){
    //     // Use Collections.sort() method to sort playerList in ascending order of APT
    //     Collections.sort(playerList,new Comparator<Player>() {
    //     // Override the compare() method of the Comparator interface to compare players based on their APT values
    //     public int compare(Player p1,Player p2)
    //     {
    //         // returning this will automatically update the original player list because we uses it in Collection.sort() 
    //         return Integer.compare(p1.getApt(), p2.getApt());
    //     }
    //     });
    
    //     System.out.println();
    //     System.out.println("Sorted Successfully you can press 9 from menu to display the result");
    // }
    public static void sortPlayersLowToHigh() {
        quickSortWithPlayerListAndIndices(playerList, 0, playerList.size() - 1);
        System.out.println();
        System.out.println("Sorted Successfully you can press 9 from menu to display the result");
    }
    
    private static void quickSortWithPlayerListAndIndices(List<Player> playerList, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivotIndex = partitionPlayerListByApt(playerList, leftIndex, rightIndex);
            quickSortWithPlayerListAndIndices(playerList, leftIndex, pivotIndex - 1);
            quickSortWithPlayerListAndIndices(playerList, pivotIndex + 1, rightIndex);
        }
    }
    
    private static int partitionPlayerListByApt(List<Player> playerList, int leftIndex, int rightIndex) {
        Player pivot = playerList.get(rightIndex);
        int partitionIndex = leftIndex - 1;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (playerList.get(i).getApt() <= pivot.getApt()) {
                partitionIndex++;
                Collections.swap(playerList, partitionIndex, i);
            }
        }
        Collections.swap(playerList, partitionIndex + 1, rightIndex);
        return partitionIndex + 1;
    }

    //This function is used to clear the Console screen
    public static void clearScreen() {
        //The first line (\033[H\033[2J) moves the cursor to the top left corner of the console and clears the screen.
        //The System.out.flush() flushes the output stream to make sure the screen is cleared immediately.
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



    //This function is used to get the player with highest APT from the players list
    public static void playerWithHigestApt(){
        //first we create the players which will be used to get the details of the player with higest apt 
        Player highestAptPlayer = null;
        int highestApt = Integer.MIN_VALUE;
    //Here we are looping the list and comparing the apt 
    for (Player player : playerList) {
        if (player.getApt() > highestApt) {
            highestApt = player.getApt();
            highestAptPlayer = player;
        }
    }
        //displaying the the lowest apt player we got in highestAptPlayer from the above lopp
        System.out.printf("%-13s %-13s %4s %5s %-25s %6s %10s%n", 
        "First_Name", "Last_Name", "APT", "SET", "National_Association", "AVG", "Postion");
        System.out.printf("%-13s %-13s %3d %5d %17s %17.2f %11s%n",
        highestAptPlayer.getFirstName(), highestAptPlayer.getLastName(),
        highestAptPlayer.getApt(), highestAptPlayer.getSet(),
        highestAptPlayer.getNationalAssociation(),
        calculateAverageScore(highestAptPlayer.getApt(), highestAptPlayer.getSet()),
        highestAptPlayer.getPosition());
    }
    

/* 
    //This function is used to get the player with lowes APT from the players list
    public static void playerWithLoestApt(){

        //first we store the players which is at index 0 to check and iterate 
        Player lowestAPTPlayer = playerList.get(0);
        for (int i = 1; i < playerList.size(); i++) {
            //Here we are looping the list and comparing the apt 
        Player currentPlayer = playerList.get(i);
        if (currentPlayer.getApt() < lowestAPTPlayer.getApt()) {
            lowestAPTPlayer = currentPlayer;
        }
    }
        //displaying the the lowest apt player we got in lowestAPTPlayer from the above lopp
        System.out.println("First_Name"+" "+"Last_Name"+" "+"APT"+"  "+"SET"+" "+"National_Association"+"  "+"AVG"+"  "+"Postion");
        System.out.println( lowestAPTPlayer.getFirstName()+"       "+ lowestAPTPlayer.getLastName()+"      "+ lowestAPTPlayer.getApt()+"  "+ lowestAPTPlayer.getSet()+"        "+lowestAPTPlayer.getNationalAssociation() +"             "+calculateAverageScore(lowestAPTPlayer.getApt(),lowestAPTPlayer.getSet())+"   "+ lowestAPTPlayer.getPosition());

    }

public static void playerWithLowestApt(){
    // sort the playerList in ascending order based on their aptitude scores
    Collections.sort(playerList, new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {
            return p1.getApt() - p2.getApt();
        }
    });

    // select the first player in the sorted list as the player with the lowest aptitude
    Player lowestAPTPlayer = playerList.get(0);

    // print the details of the player with the lowest aptitude
    System.out.println("First_Name"+" "+"Last_Name"+" "+"APT"+"  "+"SET"+" "+"National_Association"+"  "+"AVG"+"  "+"Postion");
    System.out.println(lowestAPTPlayer.getFirstName()+"       "+lowestAPTPlayer.getLastName()+"      "+lowestAPTPlayer.getApt()+"  "+lowestAPTPlayer.getSet()+"        "+lowestAPTPlayer.getNationalAssociation()+"             "+calculateAverageScore(lowestAPTPlayer.getApt(),lowestAPTPlayer.getSet())+"   "+lowestAPTPlayer.getPosition());
}
*/
public static void playerWithLowestApt() {
    // sort the playerList in ascending order based on their aptitude scores using quicksort
    quickSort(playerList, 0, playerList.size() - 1);

    // select the first player in the sorted list as the player with the lowest aptitude
    Player lowestAPTPlayer = playerList.get(0);

    // print the details of the player with the lowest aptitude
    System.out.println("First_Name    Last_Name     APT    SET    National_Association    AVG    Postion");
    System.out.printf("%-13s %-13s %2d %6d %10s %20.2f %12s%n",
            lowestAPTPlayer.getFirstName(), lowestAPTPlayer.getLastName(),
            lowestAPTPlayer.getApt(), lowestAPTPlayer.getSet(),
            lowestAPTPlayer.getNationalAssociation(),
            calculateAverageScore(lowestAPTPlayer.getApt(), lowestAPTPlayer.getSet()),
            lowestAPTPlayer.getPosition());
}

// quicksort function to sort the playerList in ascending order based on their aptitude scores
public static void quickSort(List<Player> playerList, int low, int high) {
    if (low < high) {
        int pi = partition(playerList, low, high);
        quickSort(playerList, low, pi - 1);
        quickSort(playerList, pi + 1, high);
    }
}

// partition function used in the quicksort algorithm to partition the playerList
public static int partition(List<Player> playerList, int low, int high) {
    int pivot = playerList.get(high).getApt();
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (playerList.get(j).getApt() < pivot) {
            i++;
            swap(playerList, i, j);
        }
    }
    swap(playerList, i + 1, high);
    return i + 1;
}

// swap function used to swap two elements in the playerList
public static void swap(List<Player> playerList, int i, int j) {
    Player temp = playerList.get(i);
    playerList.set(i, playerList.get(j));
    playerList.set(j, temp);
}
    public static void sampleData(){
        playerList.add(new Player("Daniel", "Scott", 79, 92, "Attacker", "Scotland"));
        playerList.add(new Player("Ali", "Aslam", 98, 94, "Midfielder", "Northern ireland"));
        playerList.add(new Player("Oliver", "Barker", 89, 95, "Defender", "Ireland"));
        playerList.add(new Player("Jordan", "Robison", 45, 89, "Attacker", "England"));
        playerList.add(new Player("Steven", "Walker", 88, 87, "Midfielder", "Wales"));
        playerList.add(new Player("Alfie", "Loy",85, 79, "Attacker", "Wales"));
        playerList.add(new Player("Rashid", "Bhatti", 90, 86, "Midfielder", "Wales"));
        playerList.add(new Player("Thomas", "Taylor", 97, 85, "Defender", "England"));
        playerList.add(new Player("Theo", "Dolan", 87, 82, "Attacker", "England"));
        playerList.add(new Player("Finley", "Cross", 95, 83, "Midfielder", "Scotland"));
        playerList.add(new Player("Joshus", "Mills", 92, 71, "Attacker", "Northen ireland"));
        playerList.add(new Player("Leander", "Moore", 91, 72, "Midfielder", "Scotland"));
        playerList.add(new Player("Isaac", "Johnson", 76, 77, "Defender", "Northen ireland"));
        playerList.add(new Player("William", "Adams", 78, 78, "Midfielder", "England"));
        playerList.add(new Player("Jacob", "Stone", 77, 79, "Midfielder", "England"));
        playerList.add(new Player("James", "Chaffey", 93, 70, "Attacker", "Wales"));
        playerList.add(new Player("Lucas", "Saunders", 68, 69, "Attacker", "Wales"));
        playerList.add(new Player("Alexander", "Daly", 43, 67, "Midfielder", "England"));
        playerList.add(new Player("Arlo", "Gilchrist", 50, 65, "Attacker", "England"));

    }


}
