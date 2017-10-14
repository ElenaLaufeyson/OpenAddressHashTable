package myhashtable;

import java.util.*;

public class OpenAdressTable<T1,T2> implements Map<T1,T2> {

    private Data<T1,T2> table[];
    private int sizeOfTable = 4;
    private int freePlaces, freeIndex;
    private int howEnlarge = 2; //на сколько увеличить таблицу

    public OpenAdressTable() {
        this.table = new Data[sizeOfTable];
        this.freePlaces = sizeOfTable;
    }

    public OpenAdressTable(int sizeOfTable) {
        this.sizeOfTable = sizeOfTable;
        this.table = new Data[sizeOfTable];
        this.freePlaces = sizeOfTable;
    }
    
    public int keyIndex(T1 key) {
        return keyIndex(key, table);
    }
    
    private int keyIndex(T1 key, Data tab[]) {
        int hashIndex = hashFunction(key);
        int i = hashIndex;
        freeIndex = -1;
        do {
            if (tab[i] == null) {
                freeIndex = i;
                return -1;
            }
            if (tab[i].isFree() && freeIndex == -1)
                freeIndex = i;
            if (!tab[i].isFree() && tab[i].getKey().equals(key))
                return i;
            i=(i+1)%tab.length;
        } while (i!=hashIndex);
        return -1; //нет такого индекса в таблице
    }
    
    @Override
    public T2 put(T1 key, T2 value) {
        T2 oldValue;
        oldValue = put(key, value, table);
        if (freeIndex == -1) { //мест нет
            sizeOfTable = table.length * howEnlarge; //увеличиваем таблицу
            freePlaces = sizeOfTable; //создаем новую пустую увеличенную таблицу
            Data newTable[] = new Data[sizeOfTable];
            for (int i=0;i<table.length;i++) { //из старой таблицы пихаем все в новую
                put(table[i].getKey(),table[i].getValue(), newTable);
            }
            oldValue = put(key, value, newTable);
            table = newTable;
            return oldValue;
        }
        return oldValue;
    }
    
    private T2 put(T1 key, T2 value, Data tab[]) {
        int keyInd = keyIndex(key, tab);
        if (keyInd != -1) { //в таблице есть такой ключ
            T2 oldValue = (T2)tab[keyInd].getValue();
            table[keyInd].setValue(value);
            freeIndex = keyInd;
            return oldValue;
        }
        
        if (freeIndex == -1) {
            freePlaces = 0;
            return null;
        }
        
        if (tab[freeIndex] == null) {
            tab[freeIndex] = new Data(key, value);
            freePlaces--;
            return null;
        }
        
        if (tab[freeIndex].isFree()) {
            tab[freeIndex].addData(key, value);
            freePlaces--;
            return null;
        }
        
        return null;
    }

    @Override
    public T2 get(Object key) {
        int keyInd = keyIndex((T1)key);
        if (keyInd == -1)
            return null;
        return table[keyInd].getValue();
    } 
    
    @Override
    public T2 remove(Object key) {
        int keyInd = keyIndex((T1)key);
        if (keyInd == -1)
            return null;
        table[keyInd].changeFreedom();
        freePlaces++;
        return table[keyInd].getValue();
    }

    @Override
    public int size() {
        return table.length - freePlaces;
    }
    
    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public void clear() {
        if (size() == 0)
            return;
        for (int i=0;i<table.length;i++) {
            if (table[i] != null)
                table[i].changeFreedom();
        }
        freePlaces = table.length;
    }

    @Override
    public boolean containsKey(Object key) { 
        if (size() == 0 || keyIndex((T1)key) == -1)
            return false;
        return true;
    }
    
    
    @Override
    public boolean containsValue(Object value) {
        if (size() == 0)
            return false;
       for (int i=0;i<table.length;i++) {
           if (table[i] == null || table[i].isFree())
               continue;
           if (table[i].getValue().equals((T2)value))
               return true;
       }
       return false;
    }
    
    @Override 
    public Set<T1> keySet() { 
        Set<T1> allKeys = new LinkedHashSet<>(); 
        for (int i=0;i<table.length;i++) { 
            if (table[i] == null || table[i].isFree()) 
                continue; 
            allKeys.add(table[i].getKey()); 
        } 
        return allKeys; 
    } 

    
    @Override 
    public Set<Entry<T1, T2>> entrySet() { 
        Set<Entry<T1,T2>> allData = new LinkedHashSet<>(); 
        for (int i=0;i<table.length;i++) { 
            if (table[i] == null || table[i].isFree()) 
                continue; 
            allData.add(new Data(table[i].getKey(), table[i].getValue())); 
            } 
        return allData; 
    }
    
    @Override
    public void putAll(Map<? extends T1, ? extends T2> m) {
        for (Map.Entry entry: m.entrySet()) 
            put((T1)entry.getKey(), (T2)entry.getValue());
    }
    
    @Override 
    public Collection<T2> values() { 
       List list = new LinkedList(); 
       for (int i=0;i<table.length;i++) { 
           if (table[i] == null || table[i].isFree()) 
              continue; 
           list.add(table[i].getValue()); 
       } 
       return (Collection)list; 
    }
    
    public int hashFunction(T1 key) {
        int i = key.hashCode()%sizeOfTable; //индексы в диапазоне от 0 до размера таблицы-1
        return i;
    }
    
    void print() {
        int hashIndex;
        for (int i=0;i<table.length;i++) {
            if (table[i] == null)
                System.out.println("null");
            else if (table[i].isFree()) {
                hashIndex = hashFunction((T1)table[i].getKey());
                System.out.println(hashIndex + "   [" + i + "]    free");
            }
            else {
              hashIndex = hashFunction((T1)table[i].getKey());
              System.out.println(hashIndex + "   [" + i + "]   " + table[i]);
            }
        }
        System.out.println("");            
    }

}
