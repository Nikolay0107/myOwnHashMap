package my.own.hash.map;


public class Main {
    public static void main(String[] args) {

        HashMapImplementation myMap = new HashMapImplementation();

        myMap.put(new Key(1), new Value(9223372036854775807L));
//      myMap.put(new Key(2), new Value(9223372036854775807L));
//      myMap.put(new Key(3), new Value(9223372036854775807L));

        System.out.println(myMap.size());

        System.out.println(myMap.isEmpty());

        System.out.println(myMap.get(new Key(1)).getValue());


    }
}
