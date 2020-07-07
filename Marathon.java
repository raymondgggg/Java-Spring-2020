// Raymond Guevara Lozano 
// CECS 274-05
// Prog 1 Marathon 
// Due Date 2/11/2020

import java.util.Scanner;

public class Marathon {
    // Method for printing the pace table
    public static void PaceTable(String name, String name2, double pace, double pace2) {
        int hrs, mins, sec, hrs2, mins2, sec2 = 0;
        double paceadd = pace; double paceadd2 = pace2;
        double marathonTime, marathonTime2;
        int marathonSec, marathonMin, marathonHrs, marathonSec2, marathonMin2, marathonHrs2;

        System.out.println("\nPace Table");
        System.out.printf("Mile%15s%15s%n", name, name2);

        marathonTime = pace * 26.2188; //Time in seconds, immediate value of 26.2188 is how many miles are in a marathon
        marathonHrs = (int) marathonTime / 3600;
        marathonMin = (int) (marathonTime % 3600) / 60;
        marathonSec = (int) marathonTime % 60;

        marathonTime2 = pace2 * 26.2188;
        marathonHrs2 = (int) marathonTime2 / 3600;
        marathonMin2 = (int) (marathonTime2 % 3600) / 60;
        marathonSec2 = (int) marathonTime2 % 60;

        for (int mile = 1; mile <= 26; mile ++){
            hrs = (int) pace / 3600;
            mins = (int) (pace % 3600) / 60;
            sec = (int) pace % 60;
            hrs2 = (int) pace2 / 3600;
            mins2 = (int) (pace2 % 3600) / 60;
            sec2 = (int) pace2 % 60;
            if (mile < 10){
                System.out.printf("%d%13d:%02d:%02d %7d:%02d:%02d%n", mile, hrs, mins, sec, hrs2, mins2, sec2);
            }
            else{
                System.out.printf("%d%12d:%02d:%02d %7d:%02d:%02d%n", mile, hrs, mins, sec, hrs2, mins2, sec2);
            } 
            pace += paceadd;
            pace2 += paceadd2;
        }
        System.out.printf("26m, 385y %4d:%02d:40 %7d:%02d:%02d%n", marathonHrs, marathonMin, marathonHrs2, marathonMin2, marathonSec2);
    }

    public static void main(String[] args) {
        String name;
        double distance, hours, minutes, seconds, pace, marathonTime;
        int paceMin, paceSec;
        int marathonSec, marathonHrs, marathonMin;

        Scanner userInput = new Scanner(System.in);

        // Asks user for needed data
        System.out.println("Welcome to the Los Angeles Marathon Training Program");
        System.out.print("Please enter your name: ");
        name = userInput.next();
        System.out.print("Please enter your distance (in miles): ");
        distance = userInput.nextDouble();
        System.out.print("How many hours: ");
        hours = userInput.nextDouble();
        System.out.print("How many minutes: ");
        minutes = userInput.nextDouble();
        System.out.print("How many seconds: ");
        seconds = userInput.nextDouble();
        System.out.println("\nHi " + name);

        // Calculating the pace given the specified inputs
        pace = ((3600 * hours) + (60 * minutes) + (seconds)) / distance; //Pace calculation in seconds
        paceMin = (int) pace / 60;
        paceSec = (int) (pace % 60);

        System.out.printf("Your pace is %d:%02d\n", paceMin, paceSec);

        //Calculating the time for marathon
        marathonTime = pace * 26.2188; //Time in seconds, immediate value of 26.2188 is how many miles are in a marathon
        marathonHrs = (int) marathonTime / 3600;
        marathonMin = (int) (marathonTime % 3600) / 60;
        marathonSec = (int) marathonTime % 60;

        System.out.printf("At this rate your marathon time would be: %d:%02d:%02d \nGood luck with your training!\n",
                marathonHrs, marathonMin, marathonSec);

        PaceTable("Euclid", name, 274, pace); //274 is Euclid's pace in seconds
        userInput.close();
    }
}