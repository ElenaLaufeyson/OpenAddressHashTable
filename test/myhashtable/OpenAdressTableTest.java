package myhashtable;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class OpenAdressTableTest {
    
    @Test
    public void testPut() {
        System.out.println("put");
        Integer key1 = 2;
        String value1 = "123";
        Integer key2 = 3;
        String value2 = "321";
        OpenAdressTable myTable = new OpenAdressTable();
        OpenAdressTable expTable = new OpenAdressTable();
        myTable.put(key1, value1);
        myTable.put(key2, value2);
        Map mapRead = new LinkedHashMap();
        mapRead.put(key1, value1);
        mapRead.put(key2, value2);
        expTable.putAll(mapRead);
        Set set1 = myTable.entrySet();
        Set set2 = expTable.entrySet();
        Set set3 = myTable.keySet();
        Set set4 = expTable.keySet();
        assertEquals(set1, set2); //тест entrySet
        assertEquals(set3, set4); //тест KeySet
        assertEquals(expTable, myTable);
    }
    
    @Test
    public void testKeyIndex() {
        System.out.println("keyIndex");
        OpenAdressTable myTable = new OpenAdressTable();
        OpenAdressTable myTable2 = new OpenAdressTable();
        myTable.put(1, "11");
        myTable.put(2, "12");
        myTable.put(3, "33");
        myTable.put(178, "89");
        int expResult1 = myTable.hashFunction(1);
        int expResult2 = -1;
        int result1 = myTable.keyIndex(1);
        int result2 = myTable.keyIndex(9);
        int result3 = myTable2.keyIndex(1);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult2, result3);
    }
    

    @Test
    public void testGet() {
        System.out.println("get");
        OpenAdressTable myTable = new OpenAdressTable();
        myTable.put(1, "Loki");
        myTable.put(2, "Stark");
        myTable.put(3, "Thor");
        myTable.put(178, "Steve");
        int key1 = 2;
        int key2 = 1;
        int key3 = 22;
        String expResult2 = "Loki";
        String expResult1 = "Stark";
        String expResult3 = null;
        String result1 = (String)myTable.get(key1);
        String result2 = (String)myTable.get(key2);
        String result3 = (String)myTable.get(key3);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        OpenAdressTable myTable = new OpenAdressTable();
        OpenAdressTable expTable = new OpenAdressTable();
        myTable.put(1, "Loki");
        myTable.put(2, "Stark");
        myTable.put(3, "Thor");
        myTable.put(178, "Steve");
        int key1 = 178;
        int key2 = 2;
        Map mapRead = new LinkedHashMap();
        mapRead.put(1, "Loki");
        mapRead.put(3, "Thor");
        expTable.putAll(mapRead);
        String result1 = (String)myTable.remove(key1);
        String result2 = (String)myTable.remove(key2);
        assertEquals("Steve", result1);
        assertEquals("Stark", result2);
        assertEquals(expTable, myTable);
    }

    @Test
    public void testSize() {
        System.out.println("size");
        OpenAdressTable myTable = new OpenAdressTable();
        myTable.put(1, "Loki");
        myTable.put(2, "Stark");
        myTable.put(3, "Thor");
        int expResult = 3;
        int result = myTable.size();
        assertEquals(expResult, result);
        myTable.remove(3);
        int expResult2 = 2;
        int result2 = myTable.size();
        assertEquals(expResult2, result2);
    }

   
    @Test
    public void testClear() {
        System.out.println("clear");
        OpenAdressTable myTable = new OpenAdressTable();
        myTable.put(1, "Loki");
        myTable.put(2, "Stark");
        myTable.put(3, "Thor");
        myTable.clear();
        OpenAdressTable expTable = new OpenAdressTable();
        assertEquals(expTable, myTable);
    }

    @Test
    public void testContainsKey() {
        System.out.println("containsKey");
        OpenAdressTable myTable = new OpenAdressTable();
        myTable.put(1, "Loki");
        myTable.put(2, "Stark");
        myTable.put(3, "Thor");
        boolean expResult1 = true;
        boolean expResult2 = false;
        boolean result1 = myTable.containsKey(1);
        boolean result2 = myTable.containsKey(333);
        boolean result3 = myTable.containsKey(3);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult1, result3);
    }

    @Test
    public void testContainsValue() {
        System.out.println("containsValue");
        OpenAdressTable myTable = new OpenAdressTable();
        myTable.put(1, "Loki");
        myTable.put(2, "Stark");
        myTable.put(3, "Thor");
        boolean expResult1 = true;
        boolean expResult2 = false;
        boolean result1 = myTable.containsValue("Stark");
        boolean result2 = myTable.containsValue("Steven");
        boolean result3 = myTable.containsValue("Loki");
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult1, result3);
    }
    
}
