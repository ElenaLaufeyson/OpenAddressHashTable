package myhashtable;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashTable {

    public static void main(String[] args) {
        OpenAdressTable myTable = new OpenAdressTable();
//        myTable.put(131, "Thor");
//        myTable.print();
//        myTable.put(131, "Loki");
//        myTable.print();
//        myTable.put(136, "Tony Stark");
//        myTable.print();
//        myTable.put(137, "Bucky");
//        myTable.print();
//        myTable.put(89, "Odin");
//        myTable.print();
//        System.out.println("=====================");
//        System.out.println("Get");
//        System.out.println("Get500");
//        System.out.println(myTable.get(500)); //ищем ключ, которого нет
//        System.out.println("Get131");
//        System.out.println(myTable.get(131));
//        System.out.println("+++++++++++++++++++");
//        System.out.println("Remove54");
//        myTable.remove(54);
//        myTable.print();
//        System.out.println("Remove89");
//        myTable.remove(89);
//        myTable.print();
//        System.out.println("=======================");
//        myTable.put(99, "Steve Rogers");
//        myTable.print();
//        myTable.put(187, "Black Widow");
//        myTable.print();
//        myTable.put(17, "Clint Barton");
//        myTable.print();
//        myTable.put(147, "Nick Fury");
//        myTable.print();
//        Map map = new LinkedHashMap();
//        map.put(11, "Koulsen");
//        map.put(16, "AntMan");
//        myTable.putAll(map);
//        myTable.print();
//        Files file = new Files();
//        Map mapRead = file.reading("in.txt");
//        myTable.putAll(mapRead);
//        myTable.print();
//        Files fileOut = new Files();
//        fileOut.writing(myTable, "out.txt");
          myTable.put(1, "11");
          myTable.put(2, "11");
          myTable.put(3, "33");
          myTable.print();
          
          //замечание 2 - зачем понадобился Enumeration :
          Enumeration en = myTable.keys(); 
          while (en.hasMoreElements()) {
              Integer key = (Integer)en.nextElement();
              String value = (String)myTable.get(key);
              System.out.println(key + ": " + value);
          }
          /////////////////////
          System.out.println("Key set");
          Set set2 = myTable.keySet();
          Iterator it2 = set2.iterator();
          while (it2.hasNext()) {
              System.out.println(it2.next());
          }
          
          System.out.println("====iterator remove======");
          System.out.println(set2);
          myTable.print();
          it2 = set2.iterator();
          it2.next();
          it2.remove(); //удаление по итератору
          System.out.println("after");
          System.out.println(set2);
          myTable.print();
          
          System.out.println("====keySet remove======");
          set2.remove(2);
          System.out.println("after");
          System.out.println(set2);
          myTable.print();
          
          System.out.println("+++++++++++++++++++++++++++");
          OpenAdressTable myTable2 = new OpenAdressTable();
          myTable2.put(1, "11");
          myTable2.put(2, "11");
          myTable2.put(3, "33");
          myTable2.print();
          
          System.out.println("Entry set");
          Set set3 = myTable2.entrySet();
          Iterator it3 = set3.iterator();
          while (it3.hasNext()) {
              System.out.println(it3.next());
          }
          
          System.out.println("====iterator remove======");
          System.out.println(set3);
          myTable2.print();
          it3 = set3.iterator();
          it3.next();
          it3.remove(); //удаление по итератору
          System.out.println("after");
          System.out.println(set3);
          myTable2.print();
          
          System.out.println("====entrySet remove======");
          set3.remove(2);
          System.out.println("after(instanceof)");
          System.out.println(set3);
          myTable2.print();
          it3 = set3.iterator();
          Map.Entry obj = (Map.Entry)it3.next();
          set3.remove(obj);
          System.out.println("after 2");
          System.out.println(set3);
          myTable2.print();
          
          //замечание 9(повтор значений - работает):
          System.out.println("+++++++++++++++++++++++++++");
          OpenAdressTable myTable3 = new OpenAdressTable();
          myTable3.put(1, "11");
          myTable3.put(2, "11");
          myTable3.put(3, "33");
          myTable3.print();
          List list = new ArrayList(myTable3.values());
          System.out.println(list);
          ////
//          System.out.println("Entry set");
//          Set set = myTable.entrySet();
//          Iterator it = set.iterator();
//          while (it.hasNext()) {
//              Data dat = (Data)it.next();
//              System.out.println(dat);
//          }
          
          
        }
    }
