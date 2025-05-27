package epam.learning.CustomHashMapImpl;

public class MyHashMap{

    private Data[] data;
    private int size;
    private static final double LOAD_FACTOR=0.75;

    MyHashMap(int size){
        this.size = size;
        this.data = new Data[size];
    }

    private int hash(Integer key){
        return key % data.length;
    }
    public void put(Integer key, String value){

        if((size/data.length)>=LOAD_FACTOR){
            reHash();
        }

        int hashIdx = hash(key);
        Data data1 = data[hashIdx];
        if(data1==null){
            data[hashIdx] = new Data(key, value);
            return;
        }
        Data prev=null;
        while(data1!=null){
            prev = data1;
            data1= data1.getNext();
        }
        prev.setNext(new Data(key, value));
        size++;
    }

    public String get(Integer key){
        int hashIdx = hash(key);
        Data data1 = data[hashIdx];

        while(data1!=null){
            if(data1.getKey().equals(key)){
                return data1.getValue();
            }
            data1= data1.getNext();
        }
        return null;
    }

    private void reHash(){
        Data[] oldData = data;
        data = new Data[data.length*2];

        for(int i=0; i< oldData.length; i++){
            Data head = oldData[i];
            while(head!=null){
                int hash = hash(head.getKey());
                data[hash] = new Data(head.getKey(), head.getValue());
                head=head.getNext();
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap(4);
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(11, "Eleven");
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");
        hashMap.put(5, "Five");
        System.out.println(hashMap.get(1)); // Output: One
        System.out.println(hashMap.get(4)); // Output: One
        System.out.println(hashMap.get(5)); // Output: One
    }

}

class Data{

    private Integer key;
    private String value;
    private Data next;

    Data(Integer key, String value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Data getNext() {
        return next;
    }
    public void setNext(Data next) {
        this.next = next;
    }
}


