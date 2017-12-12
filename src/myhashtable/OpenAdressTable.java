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
    
    private int keyIndex(T1 key, Data<T1,T2> tab[]) {
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
            Data<T1,T2> newTable[] = new Data[sizeOfTable];
            for (int i=0;i<table.length;i++) { //из старой таблицы пихаем все в новую
                put(table[i].getKey(),table[i].getValue(), newTable);
            }
            oldValue = put(key, value, newTable);
            table = newTable;
            return oldValue;
        }
        return oldValue;
    }
    
    private T2 put(T1 key, T2 value, Data<T1,T2> tab[]) {
        int keyInd = keyIndex(key, tab);
        if (keyInd != -1) { //в таблице есть такой ключ
            T2 oldValue = tab[keyInd].getValue();
            table[keyInd].setValue(value);
            freeIndex = keyInd;
            return oldValue;
        }
        
        if (freeIndex == -1) 
            return null;
        
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
    public void putAll(Map<? extends T1, ? extends T2> m) {
        for (Map.Entry entry: m.entrySet()) 
            put((T1)entry.getKey(), (T2)entry.getValue());
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
    
    String[][] printGUI() {
        int hashIndex;
        String[][] str = new String [table.length][4];
        for (int i=0; i<table.length; i++) {
            Arrays.fill(str[i], "");
        }
        for (int i=0;i<table.length;i++) {
            str[i][1] = "[" + i + "]";
            if (table[i] == null)
                str[i][2] = "(null)";
            else if (table[i].isFree())
                str[i][2] = "(free)";
            else {
                hashIndex = hashFunction((T1)table[i].getKey());
                str[i][0] += hashIndex;
                str[i][2] += table[i].getKey();
                str[i][3] +=  table[i].getValue();
            }
        }
        return str;
    }
    
  
    static final int KEYS = 0;
    static final int VALUES = 1;
    static final int ENTRIES = 2;
    
    public synchronized Enumeration<T1> keys() { 
        return this.<T1>getEnumeration(KEYS); 
    }
    
     public synchronized Enumeration<T2> elements() {
        return this.<T2>getEnumeration(VALUES);
    }

    private <T> Enumeration<T> getEnumeration(int type) {
        if (size() == 0) {
            return Collections.emptyEnumeration();
        } else {
            return new OpenAdressTable.Enumerator(type, false);
        }
    }

    private <T> Iterator<T> getIterator(int type) {
        if (size() == 0) {
            return Collections.emptyIterator();
        } else {
            return new OpenAdressTable.Enumerator(type, true);
        }

    }

    private class Enumerator<T> implements Enumeration<T>, Iterator<T> {

        int index;
        Entry<T1, T2> entry;
        int type;
        boolean iterator;

        Enumerator(int type, boolean iterator) {
            this.type = type;
            this.iterator = iterator;
            index = -1;
        }

        @Override
        public boolean hasMoreElements() {
            Entry<T1, T2> e = entry;
            int i = index;
            Entry<T1, T2> t[] = table;
            if (index >= table.length)
                return false;
            while (i < table.length-1 &&
                    (e == null || table[i] == null || table[i].isFree())) { //пропускаю удаленные элементы
                e = t[++i];
            }
            entry = t[i];
            index = i;
            return entry != null;
        }

        @Override
        public T nextElement() {
            if (!hasMoreElements())
                throw new NoSuchElementException("Error out of table");
            Entry<T1, T2> e = table[index];
            index++;
            if (index - 1 < table.length)
                entry = table[index - 1];
            if (e != null) {
                if (type == KEYS) {
                    return (T) e.getKey();
                } else if (type == VALUES) {
                    return (T) e.getValue();
                } else {
                    return (T) e;
                }  
            }
            throw new NoSuchElementException("Error out of table");
        }

        @Override
        public boolean hasNext() {
            return hasMoreElements();
        }

        @Override
        public T next() {
            return nextElement();
        }

        @Override
        public void remove() { //Iterator.remove
            System.out.println("Iterator.remove");
            if (index <= 0 || index >= table.length) 
                throw new NoSuchElementException("out of table (remove)");
            OpenAdressTable.this.remove(table[--index].getKey());
        }
        
    }
    
    
    private Set<T1> keySet;
    
    @Override
    public Set<T1> keySet() {
        if (keySet != null) 
            return keySet;
        keySet = new classKeySet();
        return keySet;
    }
    
    private class classKeySet extends AbstractSet<T1> {
        @Override
        public Iterator<T1> iterator() {
            return getIterator(KEYS);
        }

        @Override
        public int size() {
            return OpenAdressTable.this.size();
        }

        @Override
        public boolean contains(Object o) {
            return OpenAdressTable.this.containsKey((T1)o);
        }

        @Override
        public void clear() {
            OpenAdressTable.this.clear();
            return;
        }

        @Override
        public boolean remove(Object o) {
            System.out.println("remove keySet");
            return OpenAdressTable.this.remove((T1)o) != null;
        }
    }
    

    private Set<Entry<T1, T2>> entrySet;
    
    @Override
    public Set<Entry<T1, T2>> entrySet() {
        if (entrySet != null) 
            return entrySet;
        entrySet = new classEntrySet();
        return entrySet;
    }
    
    private class classEntrySet extends AbstractSet<Map.Entry<T1, T2>> {

        int index = -1;
        @Override
        public Iterator<Entry<T1, T2>> iterator() {
            return getIterator(ENTRIES);
        }

        @Override
        public int size() {
            return OpenAdressTable.this.size();
        }

        @Override
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) //приинадлежность к классу
                return false;
            T1 key = ((Data<T1,T2>)o).getKey();
            T2 tableValue = OpenAdressTable.this.get(key);
            if (tableValue == null) //если нет ключа
                return false;
            return (tableValue.equals(((Data<T1,T2>)o).getValue()));
        }

        @Override
        public void clear() {
            OpenAdressTable.this.clear();
        }

        @Override
        public boolean remove(Object o) {
            if (!contains(o))
                return false;
            return OpenAdressTable.this.remove(table[index].getKey()) != null;
        }
    }

    
    private Collection<T2> values;
    
    //замечание 10 - значения могут быть одинаковые, поэтому по какому
    //значению удалять - непонятно. В стандарте hashTable для этого класса перегружены
    //только следующие функции: iterator, size, contains и clear.
    @Override
    public Collection<T2> values() {
        if (values != null) 
            return values;
        values = new classValues();
        return values;
    }
    
    private class classValues extends AbstractCollection<T2> {

        @Override
        public Iterator<T2> iterator() {
            return getIterator(VALUES);
        }

        @Override
        public int size() {
            return OpenAdressTable.this.size();
        }

        @Override
        public void clear() {
            OpenAdressTable.this.clear();
        }

        @Override
        public boolean contains(Object o) {
           return OpenAdressTable.this.containsValue((T2)o);
        }
    }

    @Override
    public boolean equals(Object obj) {
        OpenAdressTable tbl = (OpenAdressTable)obj;
        if (this.size() != tbl.size())
            return false;
        Set setThis = this.entrySet();
        Set setTbl = tbl.entrySet();
        return (setThis.equals(setTbl));
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (Data<T1,T2> data: this.table)
            result += data.hashCode();
        return result;
    }   
    
}
