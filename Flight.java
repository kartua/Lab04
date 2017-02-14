/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kartua
 */
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Flight implements Comparable<Flight> {

    private String source, destination, airline;
    private GregorianCalendar departure, arrival;
    private static int mode = 1;//variable to control how to use compareTo()

    //Constructor 
    public Flight(String s, String des, String al, GregorianCalendar dep,
            GregorianCalendar arr) {
        source = s;
        destination = des;
        airline = al;
        departure = dep;
        arrival = arr;

    }

    // Constructor without departure and arrival time.
    public Flight(String s, String des, String al) {
        source = s;
        destination = des;
        airline = al;
    }

    @Override
    public String toString() {
        String output;
        if (departure == null && arrival == null) {// w/o departing&arrival
            output = "Source City: " + source;
            output += "\nDestination City: " + destination;
            output += "\nAirline: " + airline;
        } else {// with all information
            output = "Source City: " + source;
            output += "\nDestination City: " + destination;
            output += "\nAirline: " + airline;
            output += "\nDeparture: " + departure.getTime();
            output += "\nArrival: " + arrival.getTime();
        }
        return output + "\n";
    }
    // setMode: Promp user to select mode to use compareTo
    private static void setMode(){
        Scanner scan = new Scanner(System.in);
        try{   
            do{
                System.out.println("Please select criteria.\n1 For source city"
                        + "\n2 For departure date and time ");
                mode = scan.nextInt();
            }while(mode< 1 || mode>2);
        }catch(InputMismatchException e){
            System.out.println("Please input a number!!!");
            setMode();
        }
    }
    public static int getMode(){
        return mode;
    }

    // create a string to compare flight
    public String flightStr() {
        String output;
        output = source + destination + airline;
        output = output.replace(" ", "");
        output = output.toLowerCase();
        //sourece, destination and airline w/o space and all lowercase
        return output;

    }
    public static void sort(Flight[] data){
        setMode();
        Sorting.insertionSort(data);
    }

    @Override
    public int compareTo(Flight target) {
        switch (mode) {
            case 1:
                return source.compareToIgnoreCase(target.source);
            case 2:
                return departure.compareTo(target.departure);
            default:
                return 0;
        }
    }
}
