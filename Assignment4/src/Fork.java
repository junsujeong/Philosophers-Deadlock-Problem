//Group: Adam Larson and Junsu Jeong
//Author of all methods: Junsu Jeong
//Assignment 4
//CS323
//Spring 2017

//This class is a fork that can be picked up and set down.
public class Fork 
{
   int num = -1;
   int owner = -1;
   
   public Fork(int num)
   {
       this.num = num;
   }
   
   //Sets the owner of the fork to the owner's id.
   public void takeFork(int pNum)
   {
      owner = pNum;
   }
   
   //Sets the owner of the fork to -1.
   public void releaseFork()
   {
      owner = -1;
   }
   
   //Gets the holder of the forks id.
   public int getAvailable()
   {
      return owner;
   }
   
   //Double checks he is the current owner.
   public boolean iHave(int pNum)
   {
      return owner == pNum;
   }
}
