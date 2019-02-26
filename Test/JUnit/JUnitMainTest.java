package JUnit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class JUnitMainTest {

    @Test
    public void getRandomValueAssertTrue() {
        System.out.println("\nTest 1 - valid input test between 1 and 100");
        int random = JUnitMain.getRandomValue(1, 100);
        assertTrue((random > 0 || random <= 100), "Integer out of range");
        System.out.printf(("Test 1 passed: " + "%d <= %d <= %d\n"), 1, random, 100);
    }

    @Test
    public void getRandomValueAssertEquals() {
        System.out.println("\nTest 2 - invalid input test: lowValue is equal to highValue");
        int random = JUnitMain.getRandomValue(23, 23);
        assertEquals(-2, random);
        System.out.println("Test 2 passed: unsupported range properties successfully detected\n");
    }

    @Test
    public void getRandomValueAssertSame() {
        System.out.println("\nTest 3 - check if two Integers refers to the same Integer object ");

        Integer randomValueOne = new Integer(JUnitMain.getRandomValue(1000, 1005));
        Integer randomValueTwo = randomValueOne;

        assertSame(randomValueOne, randomValueTwo, "The Integer objects " + randomValueOne + " & " + randomValueTwo + " don't refer to the same object in memory!\n");
        System.out.println("Test 3 passed: The Integer objects " + randomValueOne + " & " + randomValueTwo + " refer to the same object in memory.\n");
    }

    @Test
    public void getRandomValueAssertNotSame() {
        System.out.println("\nTest 4 - check if two Integers don't refers to the same Integer object ");

        Integer randomValueOne = new Integer(JUnitMain.getRandomValue(1000, 1005));
        Integer randomValueTwo = new Integer(JUnitMain.getRandomValue(1000, 1005));

        assertNotSame(randomValueOne, randomValueTwo, "The Integer objects " + randomValueOne + " & " + randomValueTwo + " refer to the same object in memory!\n");
        System.out.println("Test 4 passed: The Integer objects " + randomValueOne + " & " + randomValueTwo + " are completely different objects.\n");
    }

    @Test
    public void getRandomValueAssertArrayEquals() {
        System.out.println("\nTest 5 - check if two arrays contains the same elements");

        Integer[] IntArrayOne = new Integer[3];
        IntArrayOne[0] = new Integer(JUnitMain.getRandomValue(1000, 1005));
        IntArrayOne[1] = new Integer(JUnitMain.getRandomValue(1000, 1005));
        IntArrayOne[2] = new Integer(JUnitMain.getRandomValue(1000, 1005));

        Integer[] IntArrayTwo = new Integer[3];
        int j = 0;
        for (Integer i : IntArrayOne) {
            IntArrayTwo[j] = i;
            j++;
        }

        assertArrayEquals(IntArrayOne, IntArrayTwo, "Array elements not matching!");
        System.out.println("Test 5 passed:\nFirst array elements: " + Arrays.toString(IntArrayOne) + "\n" +
                           "Second array elements: " + Arrays.toString(IntArrayTwo) + "\n" +
                           "Elements matching as expected!\n");
    }

    @Test
    public void getRandomValueNotNull() {
        System.out.println("\nTest 6 - make sure that a specific object in an Array is not null");

        List<Integer> IntegerList = new ArrayList<>();
        IntegerList.add(0,new Integer(JUnitMain.getRandomValue(1000, 1005)));
        IntegerList.add(1,new Integer(JUnitMain.getRandomValue(1000, 1005)));
        IntegerList.add(2,new Integer(JUnitMain.getRandomValue(1000, 1005)));

        assertNotNull(IntegerList.get(1),"Array element is null!");
        System.out.println("Test 6 passed: Array element not null\n");
    }

    @Test
    public void getRandomValueNull() {
        System.out.println("\nTest 7 - make sure that a specific object in an Array is null");

        Integer[] IntArrayOne = new Integer[3];
        IntArrayOne[0] = new Integer(JUnitMain.getRandomValue(100, 105));
        IntArrayOne[1] = null;
        IntArrayOne[2] = new Integer(JUnitMain.getRandomValue(100, 105));

        assertNull(IntArrayOne[1],"Array element not null!");
        System.out.println("Test 7 passed: Element null as expected!\n");
    }

    @Test
    public void getRandomValueFalse(){
        System.out.println("\nTest 8 - validate the length of an array and return false when the condition is not met");

        int maximumLength = 3;

        List<Integer> IntegerList = new ArrayList<>();
        IntegerList.add(0,new Integer(JUnitMain.getRandomValue(2000, 2005)));
        IntegerList.add(1,new Integer(JUnitMain.getRandomValue(2000, 2005)));
        IntegerList.add(2,new Integer(JUnitMain.getRandomValue(2000, 2005)));

        assertFalse(IntegerList.size() > maximumLength, "ArrayList is equal or smaller than maximum length");
        System.out.println("Test 8 passed: Array is not larger than required"
                          +"\nArray elements: "+IntegerList.toString()
                          +"\nMaximum length permitted is: "+maximumLength
                          +"\nArray length is: "+IntegerList.size());
    }

    @Test
    public void getRandomValueThat(){
        System.out.println("\nTest 9 - A very generic use of AsserThat");

        int randomOne = JUnitMain.getRandomValue(1, 100);
        int randomTwo = randomOne;

        assertThat(randomOne, is(randomTwo));
        System.out.println("Test 9 passed: The integer "+randomOne+" is equal to integer "+randomTwo);

    }

}
