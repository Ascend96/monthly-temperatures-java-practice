import models.TemperatureYear;
import services.InputService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var inputService = new InputService();
        System.out.println("Welcome to an application that will allow you to add monthly temperatures for an entire year.");
        System.out.println("This application will only let you view data you have entered.");

        // a logically created model to store values of average temps for each month of the year.
        // also allows for some extensibility if I wanted to add more years to the logic although just doing one for now.
        var year = new TemperatureYear();

        var yearlyTemperatures = inputService.getDoubleInputArray("Please enter the average temperature for the month of ", year.getMonths());
        year.setTemperatures(yearlyTemperatures);

        System.out.println("Temperatures have been populated for the year.");
        System.out.println("Please enter 'year' to display all temps, yearly average, and highest/lowest monthly temps.");
        System.out.println("Otherwise enter the name of the month to view its average temperature.");

        var userInput = scanner.nextLine().toLowerCase();
        if (userInput.equals("year")) {
            year.displayYearlyTemperatureInformation();
        } else {
            while (true) {
                try {
                    if(userInput.isBlank()){
                        System.out.println("user input is blank");
                        userInput = scanner.nextLine();
                    }
                    year.displayMonthlyTemperatureInformation(userInput.toLowerCase());
                    return;
                } catch (Exception e) {
                    System.out.println("Please enter a valid month.");
                    userInput = ""; // not ideal but use this as a way for the decision statement to determine whether we need to gather the input if the first value isn't a valid month
                }
            }
        }

        inputService.close();

        System.out.println("Application Ending");


    }
}