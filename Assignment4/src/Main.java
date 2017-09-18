//Group: Adam Larson and Junsu Jeong
//Author of all methods: Adam Larson
//Assignment 4
//CS323
//Spring 2017

import java.util.Scanner;

//The main class that take in the input for the number of 
//forks and philosophers starts the threads.
public class Main 
{
   public static void main(String[] args)
   {
      Table t = new Table();
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter a number: ");
      int n = reader.nextInt();
      t.setTable(n);
      t.seatPhilosophers(n);
      t.startPhilosophers(n);
   }
}
