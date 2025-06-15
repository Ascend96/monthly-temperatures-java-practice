package services;
import java.util.InputMismatchException;
import java.util.Scanner;

// A service for working with inputs to reduce bloat in main method and for readability
public class InputService {
    private Scanner scanner;

    public InputService() {
        this.scanner = new Scanner(System.in);
    }

    public int[] getDoubleInputArray(String prompt, String[] months){
        int[] monthlyTemperatures = new int[months.length]; // initialize double array to store temps in
        for(int index = 0; index < months.length; index++){ // loop through months to get temps to be stored
            while(true){
                System.out.println(prompt + months[index] + "\n");
                try{
                    monthlyTemperatures[index] = scanner.nextInt();
                    break;
                } catch(InputMismatchException e){
                    System.out.println("Please enter a valid integer.");
                    scanner.next();
                }
            }
        }

        return monthlyTemperatures;
    }

    public void close(){
        scanner.close();
    }
}
