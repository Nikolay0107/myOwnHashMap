package my.own.hash.map;

import sun.security.mscapi.CPublicKey;

import java.util.LinkedList;

public class HashMapImplementation {

    LinkedList<Entry>[] hashMap = new LinkedList[2];
    int size = 0;

    public HashMapImplementation() {
    }

    // PUT method
    public void put(Key key, Value value) {
        if (size >= hashMap.length) {
            resize();
        }

        int ix = getIndex(key) % hashMap.length;

        if (hashMap[ix] == null) {
            hashMap[ix] = new LinkedList<>();
            hashMap[ix].add(new Entry(key, value));
            size++;
            return;

        } else {
            for (Entry entry : hashMap[ix]) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    size++;
                    return;
                }
            }

            hashMap[ix].add(new Entry(key, value));
            size++;
            return;

        }
    }

    // GET method
    public Value get(Key key) {
        int ix = getIndex(key) % hashMap.length;

        if (hashMap[ix] == null) return null;

        for (Entry entry : hashMap[ix]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;

    }

    // RESIZE arr
    private void resize() {
        LinkedList<Entry>[] oldHashMap = hashMap;
        hashMap = new LinkedList[size * 2];
        size = 0;

        for (int i = 0; i < oldHashMap.length; i++) {
            if (oldHashMap[i] == null) continue;
            for (Entry entry : oldHashMap[i]) {
                put(entry.key, entry.value);
            }
        }
    }

    public int getIndex(Key key) {
        return key.hashCode();
    }



    public int size() {
        return size;
    }


}
