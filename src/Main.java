import java.util.Random;

public class Main {

    public static void main(String[] args){

        Random randomNumber = new Random();
        short lowRand = 1000;
        short highRand = 20000;

        short numOfCoatsOfPaint = 2;
        short paintCoveragePerLitre = 6;
        short priceOfPaintPerLitreInPounds = 5;
        short squareMetersPaintedPerHour = 7;
        int areaOfWallInMSquared = 0;
        int priceEstimate = 0;
        int volumeOfPaintNeededInLitres = 0;
        int wallAreaDividePaintCoverage = 0;
        int numOfWalls = randomNumber.nextInt(5-1) + 1;
        int totalCost = 0;
        int totalPaintInLitres = 0;
        int totalManHours = 0;
        int labourCostPerHour = 10;
        int totalCostOfLabour = 0;
        boolean needLadder = false;


        System.out.println("There are " + numOfWalls +" walls to paint.");

        for(int loopCounter = 1; loopCounter <= numOfWalls; loopCounter++) {

            int heightOfWallInMM = randomNumber.nextInt(highRand-lowRand) + lowRand;
            int widthOfWallInMM = randomNumber.nextInt(highRand-lowRand) + lowRand;

            areaOfWallInMSquared = (heightOfWallInMM / 1000) * (widthOfWallInMM / 1000);
            wallAreaDividePaintCoverage = (int) Math.ceil(areaOfWallInMSquared / paintCoveragePerLitre);
            volumeOfPaintNeededInLitres = (wallAreaDividePaintCoverage * numOfCoatsOfPaint);
            priceEstimate = volumeOfPaintNeededInLitres * priceOfPaintPerLitreInPounds;

            System.out.println("The area of this wall is " + areaOfWallInMSquared + " square meters. Therefore you will need at least " + volumeOfPaintNeededInLitres + " litres of paint.");
            System.out.println("This will cost £" + priceEstimate + ".");

            totalManHours += (int) Math.ceil(areaOfWallInMSquared / squareMetersPaintedPerHour);
            totalPaintInLitres += volumeOfPaintNeededInLitres;
            totalCost += priceEstimate;

            if (heightOfWallInMM >= 2000){
                needLadder = true;
            }
        }

        String ladderMessage = (needLadder == true) ? "You need to bring a ladder." : "You do not need a ladder.";

        totalCostOfLabour = totalManHours * labourCostPerHour;

        System.out.println("You will need " + totalPaintInLitres + " Litres of paint.");
        System.out.println("The total cost of paint for this project will be roughly £" + totalCost + ".");
        System.out.println("The total labour cost for this project will be £" + totalCostOfLabour + " at a rate of £" + labourCostPerHour + " per-hour.");
        System.out.println(ladderMessage);
        System.out.println("Process Complete.");

    }
}