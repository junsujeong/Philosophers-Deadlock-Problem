//Group: Adam Larson and Junsu Jeong
//Author: Adam Larson and Junsu Jeong
//Assignment 4
//CS323
//Spring 2017

import java.util.*;

//This class is a philosopher that can eat if he has two forks, otherwise he
//thinks.
public class Philosopher extends Thread
{
   static double GO_HOME = 15.0;
   static double MAX_TIME = 1.0;
   static double MIN_TIME = 0.0;
   
   int id = -1;
   double time = 0.0;
   Fork left = null;
   Fork right = null;
   Random r = new Random();
   double randomSec = 0.0;
   String str = "";
   int timesAte = 0;
   double timeThinking = 0.0;
   double timeEating = 0.0;
   
   //Constructor. Adam Larson
   public Philosopher(int id, Fork l, Fork r)
   {
      this.id = id;
      this.left = l;
      this.right = r;
   }
   
   //Runs a philosopher thread for 15 seconds. Adam Larson.
   public void run()
   {
      while(time <= GO_HOME)
      { 
         think();
         tryEating();
      }
      printAllStats();
   }
   
   //Tries to eat. Eats for random amout of time less than 1 second if both
   //forks are available. Adam Larson.
   private void tryEating()
   {
      if((right.getAvailable() == -1) && (left.getAvailable() == -1))
      {
         randomSec = r.nextDouble();
         takeForks();
         //Avoids unlikely deadlock.
         if(!left.iHave(id) || !right.iHave(id))
            releaseForks();
         str = String.format("%1.2f", randomSec);
         randomSec = Double.valueOf(str);
         System.out.println (id + " EATING " + str);
         try
         {
            Philosopher.sleep((long)(randomSec * 1000));
         }
         catch (InterruptedException ex)
         {
            System.out.println(ex);
         }
         releaseForks();
         time += randomSec;
         timesAte++;
         timeEating += randomSec;
      }
   }
   
   //Thinks for a random amount of time less than one second. Adam Larson.
   private void think()
   {
      randomSec = r.nextDouble();
      str = String.format("%1.2f", randomSec);
      randomSec = Double.valueOf(str);
      System.out.println (id + " THINKING " + str);
      try
      {
         Philosopher.sleep((long)(randomSec * 1000));
      }
      catch (InterruptedException ex)
      {
         System.out.println(ex);
      }
      time += randomSec;
      timeThinking += randomSec;
   }
   
   //Releases both forks. Junsu Jeong.
   public void releaseForks()
   {
      left.releaseFork();
      right.releaseFork();
   }
   
   //Takes both forks. Junsu Jeong.
   public void takeForks()
   {
      left.takeFork(id);
      right.takeFork(id);
   }
   
   //Prints the number of time the Philosopher ate, how long he ate, and how
   //long he was thinking. Junsu Jeong.
   public void printAllStats()
   {
      System.out.println("Philosopher " + id + " stats:");
      System.out.print("Ate " + timesAte + " times");
      str = String.format("%1.2f", timeEating);
      timeEating = Double.valueOf(str);
      System.out.println(" for a total of " + str + " seconds");
      System.out.print("and was thinking for a total of ");
      str = String.format("%1.2f", timeThinking);
      timeThinking = Double.valueOf(str);
      System.out.println(str + " seconds");
   }
}

