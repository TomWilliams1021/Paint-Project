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
        short squareMetersPaintedPerHour = 7;
        int priceOfPaintPerLitreInPounds = 0;
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
        boolean anotherWall = true;
        String numOfWallsString = "";
        String anotherWallString = "";

        int[][] paintPricePerCan = {{0, 1, 2, 3},{1000, 1500, 2500, 5000}};

        do{

            System.out.println("What is the height of this wall in millimeters?");
            int heightOfWallInMM = numberInputReader();   //Add Try Catch incase non number characters are inputed.

            System.out.println("What is the width of this wall in millimeters?");
            int widthOfWallInMM = numberInputReader();      //Add Try Catch incase non number characters are inputed.

            System.out.println("What type of paint do you want to use? For Low Quality enter 0, For Medium enter 1, For High enter 2 and for UltraHigh enter 3.");
            int paintQualityInt = numberInputReader();
            for(int i = 0; i < paintPricePerCan[0].length; i++ ){
                if(i == paintQualityInt){
                    priceOfPaintPerLitreInPounds = divider(paintPricePerCan[1][i], 100);
                }
            }

            areaOfWallInMSquared = multiplier(divider(heightOfWallInMM, 1000), divider(widthOfWallInMM, 1000));
            wallAreaDividePaintCoverage = (int) Math.ceil(divider(areaOfWallInMSquared, paintCoveragePerLitre));
            volumeOfPaintNeededInLitres = multiplier(wallAreaDividePaintCoverage, numOfCoatsOfPaint);
            if (volumeOfPaintNeededInLitres == 0){
                volumeOfPaintNeededInLitres = 1;
            }
            priceEstimate = multiplier(volumeOfPaintNeededInLitres, priceOfPaintPerLitreInPounds);


            System.out.println("The area of this wall is " + areaOfWallInMSquared + " square meters. Therefore you will need at least " + volumeOfPaintNeededInLitres + " litres of paint.");
            System.out.println("This will cost £" + priceEstimate + ".");

            totalManHours += (int) Math.ceil(divider(areaOfWallInMSquared, squareMetersPaintedPerHour));
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

            System.out.println("Do you want to paint another wall? Enter Y or y for Yes and N or n for No.");
            anotherWallString = inputReader();
            if(anotherWallString.contains("Y") || anotherWallString.contains("y")){
                anotherWall = true;
                numOfWalls++;
            }
            else if(anotherWallString.contains("N") || anotherWallString.contains("n")){
                anotherWall = false;
            }
            else{
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
                numOfWallsString = "There is only one wall to paint!";
                break;
            case 2:
                numOfWallsString = "There are two walls to paint.";
                break;
            case 3:
                numOfWallsString = "There are three walls to paint.";
                break;
            default:
                numOfWallsString = "There are more than three walls this will be a big job.";
                break;
        }
        System.out.println(numOfWallsString);

        String ladderMessage = (needLadder == true) ? "At least one ceiling is very high, you need to bring a ladder." : "You don't need a ladder for this project.";
        String shorterPainterMessage = (needShorterPainter == true) ? "At least one ceiling is very low, you might need a short painter." : "The ceilings are a resonable height don't worry.";

        totalCostOfLabour = multiplier(totalManHours, labourCostPerHour);

        System.out.println("You will need " + totalPaintInLitres + " Litres of paint.");
        System.out.println("The total cost of paint for this project will be roughly £" + totalCost + ".");
        System.out.println("The total labour cost for this project will be £" + totalCostOfLabour + " at a rate of £" + labourCostPerHour + " per-hour.");
        System.out.println(ladderMessage);
        System.out.println(shorterPainterMessage);
        System.out.println("Process Complete.");

    }

    public static int multiplier(int num1, int num2){
        return num1 * num2;
    }

    public static int divider(int num1, int num2){
        return num1 / num2;
    }

    public static int numberInputReader(){
        String inputString = inputReader();
        int inputStringToInteger = Integer.parseInt(inputString);   //need a try-catch to catch characters hat aren't numbers being entered.
        return inputStringToInteger;
    }

    public static String inputReader(){
        //Don't put scanners in methods in practice as it breaks Unit Testing and other functionality.
        Scanner userInputScanner = new Scanner(System.in);
        String inputString = userInputScanner.nextLine();
        return inputString;
    }
}