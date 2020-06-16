public class Client2 {
   public static void main(String[] args) {
      SortedList<Integer> intlist = new SortedList<Integer>();
      processIntList(intlist);
      System.out.println();
      SortedList<String> stringlist = new SortedList<String>();
      processStringList(stringlist);
   }

   public static void processIntList(SortedList<Integer> list) {
      list.add(42);
      list.add(18);
      list.add(27);
      list.add(93);
      System.out.println("List (ascending order): " + list);
      System.out.println("list.size() " + list.size());
      System.out.println("list.contains(18) " + list.contains(18));
      System.out.println("list.indexOf(18) " + list.indexOf(18));
      list.add(10);
      System.out.println("list.add(10) " + list);
      list.clear();
      System.out.println("list.clear() " + list);
   }

   public static void processStringList(SortedList<String> list) {
      list.add("any");
      list.add("before");
      list.add("came");
      list.add("dodge");
      list.add("except");
      list.add("fox");
      System.out.println("List (ascending order): " + list);
      System.out.println("list.size() " + list.size());
      System.out.println("list.contains(\"any\") " + list.contains("any"));
      System.out.println("list.indexOf(\"george\") " + list.indexOf("george"));
      list.add("angry");
      System.out.println("list.add(\"angry\") " + list);
      list.clear();
      System.out.println("list.clear() " + list);
   }
}
