import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Random randomNumber = new Random();
        short lowRand = 1000;
        short highRand = 20000;

        Scanner userInputScanner = new Scanner(System.in);

        short numOfCoatsOfPaint = 2;
        short paintCoveragePerLitre = 6;
        short priceOfPaintPerLitreInPounds = 5;
        short squareMetersPaintedPerHour = 7;
        int areaOfWallInMSquared = 0;
        int priceEstimate = 0;
        int volumeOfPaintNeededInLitres = 0;
        int wallAreaDividePaintCoverage = 0;
        int numOfWalls = 1;
        int totalCost = 0;
        int totalPaintInLitres = 0;
        int totalManHours = 0;
        int labourCostPerHour = 10;
        int totalCostOfLabour = 0;
        boolean needLadder = false;
        boolean needShorterPainter = false;
        String numOfWallsString = "";
        boolean anotherWall = true;
        String anotherWallString = "";

        do{

            System.out.println("What is the height of this wall in millimeters?");
            String heightOfWallInMMString = userInputScanner.nextLine();
            int heightOfWallInMM = Integer.parseInt(heightOfWallInMMString);  //Add Try Catch incase non number characters are inputted.

            System.out.println("What is the width of this wall in millimeters");
            String widthOfWallInMMString = userInputScanner.nextLine();
            int widthOfWallInMM = Integer.parseInt(widthOfWallInMMString);      //Add Try Catch incase non number characters are inputted.

            areaOfWallInMSquared = (heightOfWallInMM / 1000) * (widthOfWallInMM / 1000);
            wallAreaDividePaintCoverage = (int) Math.ceil(areaOfWallInMSquared / paintCoveragePerLitre);
            volumeOfPaintNeededInLitres = (wallAreaDividePaintCoverage * numOfCoatsOfPaint);
            if (volumeOfPaintNeededInLitres == 0){
                volumeOfPaintNeededInLitres = 1;
            }
            priceEstimate = volumeOfPaintNeededInLitres * priceOfPaintPerLitreInPounds;


            System.out.println("The area of this wall is " + areaOfWallInMSquared + " square meters. Therefore you will need at least " + volumeOfPaintNeededInLitres + " litres of paint.");
            System.out.println("This will cost £" + priceEstimate + ".");

            totalManHours += (int) Math.ceil(areaOfWallInMSquared / squareMetersPaintedPerHour);
            if (totalManHours == 0){
                totalManHours = 1;
            }
            totalPaintInLitres += volumeOfPaintNeededInLitres;
            totalCost += priceEstimate;

            if (heightOfWallInMM >= 2000){
                needLadder = true;
            }
            else if(heightOfWallInMM <= 1200){
                needShorterPainter = true;
            }

            System.out.println("Do you want to paint another wall? Enter Y for Yes and N for No.");
            anotherWallString = userInputScanner.nextLine();
            if(anotherWallString.contains("Y")){
                anotherWall = true;
                numOfWalls++;
            }else if(anotherWallString.contains("N")){
                anotherWall = false;
            }else{
                System.out.println("No proper input detected, we are going to assume you don't want to calculate another wall.");
                anotherWall = false;
            }

        }while(anotherWall == true);

        /*

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
            else if(heightOfWallInMM <= 1200){
                needShorterPainter = true;
            }
        }

         */

        switch(numOfWalls){
            case 1:
                numOfWallsString = "There is only one wall to paint.";
                break;
            case 2:
                numOfWallsString = "There are two walls to paint.";
                break;
            case 3:
                numOfWallsString = "There are three walls to paint.";
                break;
            case 4, 5:
                numOfWallsString = "There are more than three walls this will be a big job.";
                break;
            default:
                numOfWallsString = "This isnt supposed to happen ... whats going on!";
                break;
        }
        System.out.println(numOfWallsString);

        String ladderMessage = (needLadder == true) ? "At least one ceiling is very high, you need to bring a ladder." : "You don't need a ladder for this project.";
        String shorterPainterMessage = (needShorterPainter == true) ? "At least one ceiling is very low, you might need a short painter'" : "The ceilings are a resonable height don't worry.";

        totalCostOfLabour = totalManHours * labourCostPerHour;

        System.out.println("You will need " + totalPaintInLitres + " Litres of paint.");
        System.out.println("The total cost of paint for this project will be roughly £" + totalCost + ".");
        System.out.println("The total labour cost for this project will be £" + totalCostOfLabour + " at a rate of £" + labourCostPerHour + " per-hour.");
        System.out.println(ladderMessage);
        System.out.println(shorterPainterMessage);
        System.out.println("Process Complete.");

    }
}