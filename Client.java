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

public class Client {
	   public static void main(String[] args) {
	      SortedList<Integer> intlist = new SortedList<Integer>();  
	      processIntList(intlist); 	//process sorted list of integers
	      System.out.println();
	      SortedList<String> stringlist = new SortedList<String>();
	      processStringList(stringlist); //process sorted list of strings
	   }

	   //runs all SortedList operations on a SortedList of Integers
	   public static void processIntList(SortedList<Integer> list) {
	      list.add(42);
	      list.add(18);
	      list.add(27);
	      list.add(93);
	      System.out.println("List (ascending order): " + list);
	      System.out.println("list.size(): " + list.size());
	      System.out.println("list.contains(18): " + list.contains(18));
	      System.out.println("list.indexOf(18): " + list.indexOf(18));
	      list.add(10);
	      System.out.println("list.add(10): " + list);
	      list.clear();
	      System.out.println("list.clear(): " + list);
	   }

	   //runs all SortedList operations on a SortedList of Strings
	   public static void processStringList(SortedList<String> list) {
	      list.add("any");
	      list.add("before");
	      list.add("came");
	      list.add("dodge");
	      list.add("except");
	      list.add("fox");
	      System.out.println("List (ascending order): " + list);
	      System.out.println("list.size(): " + list.size());
	      System.out.println("list.contains(\"any\"): " + list.contains("any"));
	      System.out.println("list.indexOf(\"george\"): " + list.indexOf("george"));
	      list.add("angry");
	      System.out.println("list.add(\"angry\"): " + list);
	      list.clear();
	      System.out.println("list.clear(): " + list);
	   }
	}