package myhashtable;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Files {
    
    public Map reading(String fileName) {
        BufferedReader reader = null;
        Map map = new LinkedHashMap();
        String nowString = "";
        int lineNumber = 0;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException ex) {
            System.out.println("File " + fileName +" not found!");
            return null;
        }
        try {
            while ((nowString = reader.readLine()) != null) {
                if (nowString.isEmpty())
                    continue;
                String []str = nowString.split("\\s+", 2); //разбиваем по пробелам
                lineNumber++;
                if (str.length != 2) {
                    System.out.println("String " + lineNumber + " error. This"
                            + "string will be ignored");
                    continue;
                }
                map.put(str[0], str[1]);
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println("Reading error");
            return null;
        }
        return map;
    }
    
    public void writing(OpenAdressTable table, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException ex) {
            System.out.println("Writing error");
            return;
        }
        Set set = table.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            try {
                Data data = (Data) it.next();
                writer.write("" + data);
                writer.newLine();
            } catch (IOException ex) {
                System.out.println("Writing error");
                return;
            }
        }
        try {
            writer.close();
        } catch (IOException ex) {
            System.out.println("File closing error");
            return;
        }
    }
    
}
