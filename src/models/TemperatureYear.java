package models;

public class TemperatureYear {
    // private fields for encapsulation
    private final String[] months;
    private int[] temperatures;

    public TemperatureYear(){
        // since months will never change can just initialize once and make final
        months = new String[] {"january", "february", "march", "april",
            "may", "june", "july", "august", "september", "october", "november", "december"};
        this.temperatures = new int[months.length];
    }

    public String[] getMonths() {
        return months;
    }

    public int getTemperatureByMonth(String month) {
        return temperatures[getIndexByMonth(month)];
    }

    public int[] getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(int[] temperatures) {
        this.temperatures = temperatures;
    }

    // helper method to grab the index of the month so the user can just pass the name of month.
    public int getIndexByMonth(String month) {
        int index = 0;
        for(int i = 0; i < months.length; i++){
            if(month.equals(months[i])){
                return index;
            }
            index++;
        }

        return index;
    }

    // handles displaying average temperature information for when year is entered.
    private void displayTempAverageInformation(){
        int[] temps = getTemperatures();
        int lowestAverageTemp = temps[0]; // set to first value for starting point
        int highestAverageTemp = temps[0]; // set to first value for starting point
        for(int i = 1; i < months.length; i++){
            if(temps[i] < lowestAverageTemp){
                lowestAverageTemp = temps[i];
            }
            if(temps[i] > highestAverageTemp){
                highestAverageTemp = temps[i];
            }
        }
        System.out.println("Lowest average temp: " + lowestAverageTemp);
        System.out.println("Highest average temp: " + highestAverageTemp);
    }

    // handles displaying all the information required when user enters year
    public void displayYearlyTemperatureInformation(){
        String[] months = getMonths();
        int[] temps = getTemperatures();
        double totalTempValue = 0.0;
        System.out.println("Displaying average temps for the year:");
        for(int i = 0; i < months.length; i++){
            System.out.println(months[i] + " " + temps[i]);
            totalTempValue += temps[i];
        }

        displayTempAverageInformation();
        System.out.println("Yearly average temp: " + totalTempValue / months.length);
    }

    // handles just displaying the average temperature of the month based on the name the user enters
    public void displayMonthlyTemperatureInformation(String month){
        getIndexByMonth(month);
        System.out.println("The average temperature for " + month + " is: " + getTemperatureByMonth(month));

    }
}
