import java.util.*;


public class WorldCup {
    public static void main(String[] args) {
        //Group A
        Country qatar = new Country("Qatar", 1439);
        Country ecuador = new Country("Ecuador", 1464);
        Country senegal = new Country("Senegal", 1584);
        Country netherlands = new Country("Netherlands", 1694);
        WorldCupGroup groupA = new WorldCupGroup(qatar, ecuador, senegal, netherlands);
        System.out.println("GROUP A");
        groupA.play();
        System.out.println();
        System.out.println();
        System.out.println("GROUP A RESULTS   ");
        groupA.results();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        //Group B
        Country england = new Country("England", 1728);
        Country iran = new Country("Iran", 1564);
        Country usa = new Country("USA", 1627);
        Country wales = new Country("Wales", 1569);
        WorldCupGroup groupB = new WorldCupGroup(england, iran, usa, wales);
        System.out.println("GROUP B");
        groupB.play();
        System.out.println();
        System.out.println();
        System.out.println("GROUP B RESULTS   ");
        groupB.results();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        //Group C
        Country argentina = new Country("Argentina", 1773);
        Country saudiarabia = new Country("Saudi Arabia", 1437);
        Country mexico = new Country("Mexico", 1644);
        Country poland = new Country("Poland", 1548);
        WorldCupGroup groupC = new WorldCupGroup(argentina, saudiarabia, mexico, poland);
        System.out.println("GROUP C");
        groupC.play();
        System.out.println();
        System.out.println();
        System.out.println("GROUP C RESULTS   ");
        groupC.results();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        //Group D
        Country france = new Country("France", 1759);
        Country australia = new Country("Australia", 1488);
        Country denmark = new Country("Denmark", 1666);
        Country tunisia = new Country("Tunisia", 1507);
        WorldCupGroup groupD = new WorldCupGroup(france, australia, denmark, tunisia);
        System.out.println("GROUP D");
        groupD.play();
        System.out.println();
        System.out.println();
        System.out.println("GROUP D RESULTS   ");
        groupD.results();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        //Group E
        Country spain = new Country("Spain", 1715);
        Country costarica = new Country("Costa Rica", 1503);
        Country germany = new Country("Germany", 1650);
        Country japan = new Country("Japan", 1559);
        WorldCupGroup groupE = new WorldCupGroup(spain, costarica, germany, japan);
        System.out.println("GROUP E");
        groupE.play();
        System.out.println();
        System.out.println();
        System.out.println("GROUP E RESULTS   ");
        groupE.results();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        //Group F
        Country belgium = new Country("Belgium", 1816);
        Country canada = new Country("Canada", 1475);
        Country morocco = new Country("Morocco", 1563);
        Country croatia = new Country("Croatia", 1645);
        WorldCupGroup groupF = new WorldCupGroup(belgium, canada, morocco, croatia);
        System.out.println("GROUP F");
        groupF.play();
        System.out.println();
        System.out.println();
        System.out.println("GROUP F RESULTS   ");
        groupF.results();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        //Group G
        Country brazil = new Country("Brazil", 1841);
        Country serbia = new Country("Serbia", 1563);
        Country switzerland = new Country("Switzerland", 1635);
        Country cameroon = new Country("Cameroon", 1471);
        WorldCupGroup groupG = new WorldCupGroup(brazil, serbia, switzerland, cameroon);
        System.out.println("GROUP G");
        groupG.play();
        System.out.println();
        System.out.println();
        System.out.println("GROUP G RESULTS   ");
        groupG.results();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        //Group H
        Country portugal = new Country("Portugal", 1676);
        Country ghana = new Country("Ghana", 1393);
        Country uruguay = new Country("Uruguay", 1638);
        Country southkorea = new Country("South Korea", 1530);
        WorldCupGroup groupH = new WorldCupGroup(portugal, ghana, uruguay, southkorea);
        System.out.println("GROUP H");
        groupH.play();
        System.out.println();
        System.out.println();
        System.out.println("GROUP H RESULTS   ");
        groupH.results();
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();


        //knockout stages
        Country[] sixteen = {
            groupA.getFirst(), groupB.getSecond(), groupC.getFirst(), groupD.getSecond(),
            groupE.getFirst(), groupF.getSecond(), groupG.getFirst(), groupH.getSecond(),
            groupB.getFirst(), groupA.getSecond(), groupD.getFirst(), groupC.getSecond(),
            groupF.getFirst(), groupE.getSecond(), groupH.getFirst(), groupG.getSecond(),
        };
        System.out.println("ROUND OF 16");
        Country[] quarterFinalists = roundOfSixteen(sixteen);
        Country[] sixteenLosers = losers(sixteen, quarterFinalists);

        System.out.println("QUARTERFINALS");
        Country[] semiFinalists = quarterFinals(quarterFinalists);
        Country[] quarterLosers = losers(quarterFinalists, semiFinalists);

        System.out.println("SEMIFINALS");
        Country[] two = semiFinals(semiFinalists);
        Country[] semiLosers = losers(semiFinalists, two);
        Country thirdPlace = playoffGame(semiLosers[0], semiLosers[1]);
        Country fourthPlace;
        if (semiLosers[0].equals(thirdPlace)) {
            fourthPlace = semiLosers[1];
        } else {
            fourthPlace = semiLosers[0];
        }

        System.out.println("FINALS");
        Country winner = playoffGame(two[0], two[1]);
        Country runnerUp;
        if (two[0].equals(winner)) {
            runnerUp = two[1];
        } else {
            runnerUp = two[0];
        }
        System.out.println(winner.name + " wins!!!!!");
        System.out.println("-----------------------------------");
        System.out.println("TOP 16:");
        for (Country c : sixteenLosers) {
            System.out.println(c.name);
        }
        System.out.println();
        System.out.println("QUARTERFINALISTS: ");
        for (Country c : quarterLosers) {
            System.out.println(c.name);
        }
        System.out.println();
        System.out.println("FOURTH PLACE: " + fourthPlace.name);
        System.out.println();
        System.out.println("THIRD PLACE: " + thirdPlace.name);
        System.out.println();
        System.out.println("RUNNER UP: " + runnerUp.name);
        System.out.println();
        System.out.println("CHAMPION: " + winner.name);
    }



    public static int playoffMatch(Country a, Country b) { //calculates the winner (returns number)
        double x = Math.random();
        double probTie = probabilityTie(a, b);
        double probNotTie = 1 - probTie;
        double aWins = Math.pow(10, ((double) (a.rating - b.rating))/300);
        double probAWins = aWins/(1 + aWins);
        double actualProbAWins = probAWins * probNotTie;
        if (x <= probTie/2) {
            return -1; //a wins in penalities
        } else if (x <= probTie) {
            return -2; //b wins in penalties
        } else if (x <= probTie + actualProbAWins) {
            return 1; //a wins
        } else {
            return 2; //b wins
        }
    }

    public static double probabilityTie(Country a, Country b) { //returns probability of a tie w/ extra time
        int difference = Math.abs(a.rating - b.rating);
        if (difference <= 50) {
            return .22;
        } else if (difference <= 150) {
            return .17;
        } else if (difference <= 200) {
            return .13;
        } else if (difference <= 250) {
            return .09;
        } else if (difference <= 325) {
            return .07;
        } else if (difference <= 500) {
            return .05;
        } else {
            return .02;
        }
    }

    public static Country playoffGame(Country a, Country b) { //this prints out and returns the winner
        int result = playoffMatch(a, b);
        if (result == -1) {
            System.out.println(a.name + " beats " + b.name + " in PKs.");
            return a;
        } else if (result == -2) {
            System.out.println(b.name + " beats " + a.name + " in PKS.");
            return b;
        } else if (result == 1) {
            System.out.println(a.name + " beats " + b.name + ".");
            return a;
        } else {
            System.out.println(b.name + " beats " + a.name + ".");
            return b;
        }
    }

    public static Country[] roundOfSixteen(Country[] sixteen) { //this executes the round of 16 games and prints them out
        Country[] eight = new Country[8];
        eight[0] = playoffGame(sixteen[0], sixteen[1]);
        eight[1] = playoffGame(sixteen[2], sixteen[3]);
        eight[2] = playoffGame(sixteen[4], sixteen[5]);
        eight[3] = playoffGame(sixteen[6], sixteen[7]);
        eight[4] = playoffGame(sixteen[8], sixteen[9]);
        eight[5] = playoffGame(sixteen[10], sixteen[11]);
        eight[6] = playoffGame(sixteen[12], sixteen[13]);
        eight[7] = playoffGame(sixteen[14], sixteen[15]);
        System.out.println("-----------------------------------");
        return eight;
    }

    public static Country[] quarterFinals(Country[] eight) { //executes and prints quarterfinals
        Country[] four = new Country[4];
        four[0] = playoffGame(eight[0], eight[1]);
        four[1] = playoffGame(eight[2], eight[3]);
        four[2] = playoffGame(eight[4], eight[5]);
        four[3] = playoffGame(eight[6], eight[7]);
        System.out.println("-----------------------------------");
        return four;
    }

    public static Country[] semiFinals(Country[] four) { //executes and prints semifinals
        Country[] two = new Country[2];
        two[0] = playoffGame(four[0], four[1]);
        two[1] = playoffGame(four[2], four[3]);
        System.out.println("-----------------------------------");
        return two;
    }

    //the finals is implemented in main method

    public static Country[] losers(Country[] previous, Country[] winners) {
        Country[] losers = new Country[winners.length];
        for (int i = 0; i < winners.length; i++) {
            if (previous[2 * i].equals(winners[i])) {
                losers[i] = previous[2 * i + 1];
            } else {
                losers[i] = previous[2 * i];
            }
        }
        return losers;
    }
}



class Country {
    String name; int rating;

    public Country(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public boolean equals(Country b) {
        if (this.name.equals(b.name) && this.rating == b.rating) {
            return true;
        }
        return false;
    }
}


class CountryPoint { //this class consists of a country and their group stage points
    Country country; int points;
    public CountryPoint(Country country, int points)  {
        this.country = country;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
    public int compareTo(CountryPoint c) {
        return points - c.points;
    }

    public String toString() { //this prints out the country along with the points
        String returnString = country.name;
        int numberOfLetters = country.name.length();
        int x = 17 - numberOfLetters;
        for (int i = 0; i < x; i++) {
            returnString += " ";
        }
        returnString += points;
        return returnString;
    }
}

class Sortbyroll implements Comparator<CountryPoint> { //this compares two CountryPoints for the sort method
    // Used for sorting in ascending order of
    // roll number
    public int compare(CountryPoint a, CountryPoint b)
    {
        if (a.points == b.points) {
            return b.country.rating - a.country.rating;
        }
        return b.points - a.points;
    }
}

class WorldCupGroup {
    Country a; Country b; Country c; Country d;
    int pointA = 0; int pointB = 0; int pointC = 0; int pointD = 0;
    CountryPoint[] pointTable = new CountryPoint[4];

    public WorldCupGroup(Country a, Country b, Country c, Country d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void results() { //prints out the group table (country, placing, points)
        System.out.println("1. " + pointTable[0]);           
        System.out.println("2. " + pointTable[1]);           
        System.out.println("3. " + pointTable[2]);           
        System.out.println("4. " + pointTable[3]); 
        System.out.println(pointTable[0].country.name + " and " + pointTable[1].country.name + " move on!");             
    }

    public Country getFirst() {
        return pointTable[0].country;
    }

    public Country getSecond() {
        return pointTable[1].country;
    }

    public Country getThird() {
        return pointTable[2].country;
    }

    public Country getFourth() {
        return pointTable[3].country;
    }

    public void play() { //plays the matches and prints out the results
        int result = groupMatch(a, b);
        if (result == 0) {
            pointA += 1;
            pointB += 1;
            System.out.println(a.name + " ties " + b.name + ".");
        } else if (result == 1) {
            pointA += 3;
            System.out.println(a.name + " beats " + b.name + ".");
        } else {
            pointB += 3;
            System.out.println(b.name + " beats " + a.name + ".");
        }

        result = groupMatch(c, d);
        if (result == 0) {
            pointC += 1;
            pointD += 1;
            System.out.println(c.name + " ties " + d.name + ".");
        } else if (result == 1) {
            pointC += 3;
            System.out.println(c.name + " beats " + d.name + ".");
        } else {
            pointD += 3;
            System.out.println(d.name + " beats " + c.name + ".");
        }
        
        result = groupMatch(a, c);
        if (result == 0) {
            pointA += 1;
            pointC += 1;
            System.out.println(a.name + " ties " + c.name + ".");
        } else if (result == 1) {
            pointA += 3;
            System.out.println(a.name + " beats " + c.name + ".");
        } else {
            pointC += 3;
            System.out.println(c.name + " beats " + a.name + ".");
        }

        result = groupMatch(b, d);
        if (result == 0) {
            pointB += 1;
            pointD += 1;
            System.out.println(b.name + " ties " + d.name + ".");
        } else if (result == 1) {
            pointB += 3;
            System.out.println(b.name + " beats " + d.name + ".");
        } else {
            pointD += 3;
            System.out.println(d.name + " beats " + b.name + ".");
        }

        result = groupMatch(a, d);
        if (result == 0) {
            pointA += 1;
            pointD += 1;
            System.out.println(a.name + " ties " + d.name + ".");
        } else if (result == 1) {
            pointA += 3;
            System.out.println(a.name + " beats " + d.name + ".");
        } else {
            pointD += 3;
            System.out.println(d.name + " beats " + a.name + ".");
        }

        result = groupMatch(b, c);
        if (result == 0) {
            pointB += 1;
            pointC += 1;
            System.out.println(b.name + " ties " + c.name + ".");
        } else if (result == 1) {
            pointB += 3;
            System.out.println(b.name + " beats " + c.name + ".");
        } else {
            pointC += 3;
            System.out.println(c.name + " beats " + b.name + ".");
        }


        pointTable[0] = new CountryPoint(a, pointA);
        pointTable[1] = new CountryPoint(b, pointB);
        pointTable[2] = new CountryPoint(c, pointC);
        pointTable[3] = new CountryPoint(d, pointD);
        Arrays.sort(pointTable, new Sortbyroll());
    }

    public static int groupMatch(Country a, Country b) { //calculates the winner (returns number)
        double x = Math.random();
        double probTie = probabilityTie(a, b);
        double probNotTie = 1 - probTie;
        double aWins = Math.pow(10, ((double) (a.rating - b.rating))/300);
        double probAWins = aWins/(1 + aWins);
        double actualProbAWins = probAWins * probNotTie;
        if (x <= probTie) {
            return 0;
        } else if (x <= probTie + actualProbAWins) {
            return 1; //a wins
        } else {
            return 2; //b wins
        }
    }

    public static double probabilityTie(Country a, Country b) { //calculates probability of tie in 90 minutes
        int difference = Math.abs(a.rating - b.rating);
        if (difference <= 50) {
            return .32;
        } else if (difference <= 150) {
            return .27;
        } else if (difference <= 200) {
            return .22;
        } else if (difference <= 250) {
            return .17;
        } else if (difference <= 325) {
            return .13;
        } else if (difference <= 500) {
            return .10;
        } else {
            return .05;
        }
    }
}
