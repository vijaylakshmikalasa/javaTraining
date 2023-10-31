package fancyPhoneNumber.test;

import org.junit.jupiter.api.Test;

import fancyPhoneNumber.FancyPhoneRanker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class FancyPhoneRankerTest {

    @Test
    public void testRankFancyPhoneNumbers() {
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("11111");  // All digits are the same
        phoneNumbers.add("12321");  // Palindrome
        phoneNumbers.add("4567890");  // Consecutive sequence of numbers
        phoneNumbers.add("1223456");  // Repeated digit
        phoneNumbers.add("9876543210");  // Descending order
        phoneNumbers.add("87654321");  // Ascending order
        phoneNumbers.add("13579");  // Non-fancy

        List<String> rankedNumbers = FancyPhoneRanker.rankFancyPhoneNumbers(phoneNumbers);

//        // Check if the ranked numbers are in the expected order
//        assertEquals("11111", rankedNumbers.get(1));  // All digits are the same, score 6
//        assertEquals("12321", rankedNumbers.get(0));  // Palindrome, score 5
//        assertEquals("4567890", rankedNumbers.get(2));  // Consecutive sequence of numbers, score 1
//        assertEquals("1223456", rankedNumbers.get(3));  // Repeated digit, score 4
//        assertEquals("87654321", rankedNumbers.get(4));  // Ascending order, score 3
//        assertEquals("9876543210", rankedNumbers.get(5));  // Descending order, score 2
//        assertEquals("13579", rankedNumbers.get(6));  // Non-fancy, score 0
    }
}


