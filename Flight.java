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

    // compare check destiation first then check source
    // *************** CONTAIN BUGS **************
    // Forexamples, same airline
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
    //CompareTo call flightStr() to compare 
//    public int compareTo(Flight target) {
//        return flightStr().compareTo(target.flightStr());
//    }
//
//    // linear search 
//    // Use class T so the method can use with any input
//    // extneds Comparable<T> to use compareTo method of it own class(Polymorphism)
//    public static <T extends Comparable<T>>
//            boolean linearSearch(T[] data, T target) {
//        int i = 0;
//        boolean found = false;
//        while (i <= data.length - 1 && !found) {
//            if (data[i].compareTo(target) == 0) {
//                System.out.println("**********THE FLGHT IS FOUND**********\n"
//                        + data[i].toString());
//                found = true;
//            }
//            i++;
//        }
//        //Display "not found" if the flight is not found
//        if (!found) {
//            System.out.println("**********THE FLIGHT IS NOT FOUND**********\n"
//                    + target.toString());
//        }
//        return found;
//    }
//
//    // Use class T so the method can use with any input
//    // extneds Comparable<T> to use compareTo method of it own class(Polymorphism)
//    public static <T extends Comparable<T>>
//            boolean binarySearch(T[] data, T target) {
//        insertionSort(data);
//        int low = 0;
//        int high = data.length - 1;
//        int mid = (low + high) / 2;
//        boolean found = false;
//        while (low <= high && !found) {
//            if (data[mid].compareTo(target) == 0) {
//                System.out.println("**********THE FLGHT IS FOUND**********\n"
//                        + data[mid].toString());
//                found = true;
//            } else if (data[mid].compareTo(target) < 0) {// mid<target
//                low = mid + 1; // cut the hlaf that is lower than target out
//                mid = (low + high) / 2;
//            } else { // mid>target
//                high = mid - 1;// cut the hlaf that is higher than target out
//                mid = (low + high) / 2;
//            }
//        }
//        //Display "not found" if the flight is not found
//        if (!found) {
//            System.out.println("**********THE FLIGHT IS NOT FOUND**********\n"
//                    + target.toString());
//        }
//        return found;
//    }
    
    // insertionSort: add setMode() at the first line to select mode before
    // sorting.
//    public static <T extends Comparable<T>> void insertionSort(T[] data)
//    {
//        setMode();
//        
//        for (int index = 1; index < data.length; index++)
//        {
//            T key = data[index];
//            int position = index;
//			
//            // shift larger values to the right 
//            while (position > 0 && data[position-1].compareTo(key) > 0)
//            {
//                data[position] = data[position-1];
//                position--;
//            }
//            data[position] = key;
//        }
//    }

}
