//Group: Adam Larson and Junsu Jeong
//Author of all methods: Adam Larson
//Assignment 4
//CS323
//Spring 2017

import java.util.*;

//This class sets the forks at the table and seats the philosophers.
public class Table 
{
   LinkedList<Fork> forkList = new LinkedList<>();
   LinkedList<Philosopher> philList = new LinkedList<>();
  
   //Places(creates an array) the forks at the table assigning each fork
   //an id.
   public void setTable(int numf)
   {
      for(int i = 1; i <= numf; i++)
      {
         forkList.add(new Fork(i));
      }
   }
   
   //Seats(creates an array) the philosopher at the table and assigns 
   //them a left and right fork from the array of forks.
   public void seatPhilosophers(int nump)
   {
      for(int i = 1; i <= nump; i++)
      {
         philList.add(new Philosopher(i, getLeftFork(i), 
               getRightFork(i)));
      }
   }
   
   //Gets the fork to the left of the philosopher based on their id.
   private Fork getLeftFork(int num)
   {
      return forkList.get(num - 1);
   }
   
   //Gets the fork to the right of the philosopher based on their id.
   private Fork getRightFork(int num)
   {
      if((num + 1) > forkList.size())
         return forkList.getFirst();
      return forkList.get(num);
   }
   
   //Starts the thread for all philosophers at the table.
   public void startPhilosophers(int num)
   {
      for(int i = 0; i < num; i++)
         philList.get(i).start();
   }
}
