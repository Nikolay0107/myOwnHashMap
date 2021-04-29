package my.own.hash.map;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class HashMapImplementationTest {
    private HashMapImplementation myMap_Test;

    // Set up an empty map before each test
    @Before
    public void setUp() {
        this.myMap_Test = new HashMapImplementation();
    }

    // Check that a new HashMap returns 'true' for isEmpty
    @Test
    public void testIsEmptyForNewMap() {
        assertTrue(myMap_Test.isEmpty());
    }

    // Test adding an element makes isEmpty return 'false'
    @Test
    public void testAddMakesIsEmptyFalse() {
        myMap_Test.put(new Key(1), new Value(9223372036854775807L));
        assertFalse(myMap_Test.isEmpty());
    }

    // Check that size returns 0 for new HashMaps
    @Test
    public void testSizeForNewMap() {
        assertEquals((Integer)0, (Integer)myMap_Test.size());
    }

    // Test size increases as elements are added
    @Test
    public void testSizeIncrementsWhenAddingElements() {
        myMap_Test.put(new Key(1), new Value(9223372036854775807L));
        assertEquals(1, myMap_Test.size());

        myMap_Test.put(new Key(2), new Value(9223372036854775807L));
        assertEquals(2, myMap_Test.size());
    }

    // Make sure get returns the values added under keys
    @Test
    public void testGetReturnsCorrectValue() {
        myMap_Test.put(new Key(1), new Value(9223372036854775807L));
        myMap_Test.put(new Key(2), new Value(-9223372036854775808L));
        assertEquals(9223372036854775807L, myMap_Test.get(new Key(1)).getValue());
        assertEquals(-9223372036854775808L, myMap_Test.get(new Key(2)).getValue());
    }

    // Test that an exception is thrown if a key does not exist
    @Test(expected= NoSuchElementException.class)
    public void testThrowsExceptionIfKeyDoesNotExist() {
        myMap_Test.get(new Key(1)).getValue();
    }

    // Test that's an added element replaces another with the same key
    @Test
    public void testReplacesValueWithSameKey() {
        myMap_Test.put(new Key(1), new Value(9223372036854775807L));
        myMap_Test.put(new Key(1), new Value(-9223372036854775808L));

        assertEquals(-9223372036854775808L, myMap_Test.get(new Key(1)).getValue());
    }

    // Make sure that two (non-equal) keys with the same hash do not overwrite each other
    @Test
    public void testDoesNotOverwriteSeperateKeysWithSameHash() {
        myMap_Test.put(new Key(1), new Value(9223372036854775807L));
        myMap_Test.put(new Key(2), new Value(-9223372036854775808L));

        assertEquals(9223372036854775807L, myMap_Test.get(new Key(1)).getValue());
        assertEquals(-9223372036854775808L, myMap_Test.get(new Key(2)).getValue());
    }

}