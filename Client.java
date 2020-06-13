/*
 * Team Members: Shefali Khatri, Youssef Ben Taleb, Safwaan Taher
 * Course: CS211 (C) Spring 2020
 * Date: June 13, 2020
 * Assignment: Ch15 Programming Project #4
 * 
 * This is a test client to ensure all methods of the SortedList object have been correctly
 * implemented.
 *  
 */

import java.util.*;
public class Client {

   public static void main(String[] args) {
      SortedList<Integer> list = new SortedList<Integer>();
       list.add(5);
       list.add(3);
       list.add(50);
       list.add(-5);
       
       System.out.println(list);
       System.out.println(list.indexOf(50));
       list.remove(2);
       System.out.println(list.indexOf(2));
   }
}