package myhashtable;

import java.util.Map;

public class Data<T1,T2> implements Map.Entry<T1,T2> {

    private T1 key;
    private T2 value;
    private boolean freedom; //�������� �� ������(��������������)

    public Data(T1 key, T2 value) {
        addData(key, value);
    }
    
    void addData(T1 key, T2 value) {
        this.key = key;
        this.value = value;
        this.freedom = false; //������ ������
    }
    
    @Override
    public T1 getKey() {
        return key;
    }

    @Override
    public T2 getValue() {
        return value;
    }

    @Override
    public T2 setValue(T2 value) {
        T2 oldValue = this.value;
        this.value = value; //���������� ������ ��������, ���� ��� ����
        return oldValue;
    }
    
    void changeFreedom() {
        freedom = true; //������ ��������, ������� ��� ��������������
    }
    
    boolean isFree() {
        return freedom;
    }    

    @Override
    public String toString() {
        String keyAndValue = key.toString() + "\t\t " + value.toString();
        return keyAndValue;
    }

    @Override
    public boolean equals(Object obj) {
        Data data = (Data)obj;
        return (this.key.equals(data.key) && this.value.equals(data.value));
    }
    
    @Override
    public int hashCode() {
        int result = 31 * Integer.parseInt(key.toString()) + 
                13 * Integer.parseInt(value.toString());
        return result;
    }
    
    
}
