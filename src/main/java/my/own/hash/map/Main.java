package my.own.hash.map;


public class Main {

    public static void main(String[] args) {

        HashMapImplementation myMap = new HashMapImplementation();

        myMap.put(new Key(1), new Value(10000000));
        myMap.put(new Key(2), new Value(20000000));
        myMap.put(new Key(3), new Value(30000000));

        System.out.println(myMap.get(new Key(1)).getValue());

        System.out.println(myMap.size());


    }
}
