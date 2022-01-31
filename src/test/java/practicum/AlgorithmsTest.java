package practicum;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class AlgorithmsTest {

    @Test
    public void test_sort() {
        assertEquals(List.of(1, 2, 3), Algorithms.sort(List.of(1, 2, 3)));
        assertEquals(List.of(1, 2, 3), Algorithms.sort(List.of(3, 1, 2)));
        assertEquals(List.of(1, 1, 2, 3, 4, 5, 6, 9), Algorithms.sort(List.of(3, 1, 4, 1, 5, 9, 2, 6)));
        assertEquals(List.of(-1, 0, 1), Algorithms.sort(List.of(0, 1, -1)));
        assertEquals(List.of(1, 1, 1, 1), Algorithms.sort(List.of(1, 1, 1, 1)));
        assertEquals(Collections.emptyList(), Algorithms.sort(Collections.emptyList()));
    }

    @Test
    public void test_removeDuplicates() {
        assertEquals(List.of(1, 2, 3), Algorithms.removeDuplicates(List.of(1, 2, 3)));
        assertEquals(List.of(1, 2, 3), Algorithms.removeDuplicates(List.of(1, 2, 2, 3, 3, 3)));
        assertEquals(List.of(3, 1, 4, 5, 9, 2, 6), Algorithms.removeDuplicates(List.of(3, 1, 4, 1, 5, 9, 2, 6)));
        assertEquals(List.of(1), Algorithms.removeDuplicates(List.of(1, 1, 1, 1)));
        assertEquals(Collections.emptyList(), Algorithms.removeDuplicates(Collections.emptyList()));
    }

    @Test
    public void test_isPalindrome() {
        assertTrue(Algorithms.isPalindrome(List.of(1, 2, 1)));
        assertTrue(Algorithms.isPalindrome(List.of(3, 2, 1, 2, 3)));
        assertTrue(Algorithms.isPalindrome(List.of(2, 2, 2)));
        assertTrue(Algorithms.isPalindrome(Collections.emptyList()));

        assertFalse(Algorithms.isPalindrome(List.of(1, 2, 3)));
        assertFalse(Algorithms.isPalindrome(List.of(2, 2, 3)));
        assertFalse(Algorithms.isPalindrome(List.of(3, 2, 1, 3, 2)));
    }

    @Test
    public void test_mergeSortedLists() {
        assertEquals(List.of(1, 2, 3, 4, 5, 6), Algorithms.mergeSortedLists(List.of(1, 3, 5), List.of(2, 4, 6)));
        assertEquals(List.of(1, 1, 2, 3, 3, 5), Algorithms.mergeSortedLists(List.of(1, 2, 3), List.of(1, 3, 5)));
        assertEquals(List.of(1, 4, 7), Algorithms.mergeSortedLists(List.of(7), List.of(1, 4)));

        assertEquals(List.of(1, 2, 3), Algorithms.mergeSortedLists(Collections.emptyList(), List.of(1, 2, 3)));
        assertEquals(List.of(1, 2, 3), Algorithms.mergeSortedLists(List.of(1, 2, 3), Collections.emptyList()));
        assertEquals(Collections.emptyList(), Algorithms.mergeSortedLists(Collections.emptyList(), Collections.emptyList()));
    }

    @Test
    public void test_containsEveryElementOnce() {
        assertTrue(Algorithms.containsEveryElementOnce(new int[] { 1, 2, 3 }));
        assertTrue(Algorithms.containsEveryElementOnce(new int[] { 3, 1, 4, 5, 9, 2, 6 }));
        assertTrue(Algorithms.containsEveryElementOnce(new int[] { }));

        assertFalse(Algorithms.containsEveryElementOnce(new int[] { 1, 2, 3, 1 }));
        assertFalse(Algorithms.containsEveryElementOnce(new int[] { 1, 1 }));
        assertFalse(Algorithms.containsEveryElementOnce(new int[] { 3, 1, 4, 1, 5, 9, 2, 6 }));
    }

    @Test
    public void test_isPermutation() {
        assertTrue(Algorithms.isPermutation(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 }));
        assertTrue(Algorithms.isPermutation(new int[] { 1, 1, 2 }, new int[] { 1, 2, 1 }));
        assertTrue(Algorithms.isPermutation(new int[] { 3, 1, 4, 1, 5, 9, 2, 6 }, new int[] { 1, 1, 9, 2, 3, 4, 5, 6 }));
        assertTrue(Algorithms.isPermutation(new int[] { }, new int[] { }));

        assertFalse(Algorithms.isPermutation(new int[] { 1, 2, 3 }, new int[] { 2, 3, 4 }));
        assertFalse(Algorithms.isPermutation(new int[] { 1, 1, 2 }, new int[] { 1, 2 }));
        assertFalse(Algorithms.isPermutation(new int[] { 1, 1, 2 }, new int[] { 1, 2, 2 }));
        assertFalse(Algorithms.isPermutation(new int[] { 1, 1, 1 }, new int[] { 1 }));
        assertFalse(Algorithms.isPermutation(new int[] { }, new int[] { 1 }));

        // bigger values
        int[] a = new int[1000];
        int[] b = new int[1000];
        for (int i = 0; i < 1000; i++) {
            a[i] = 1;
            b[i] = 1;
        }
        assertTrue(Algorithms.isPermutation(a, b));
    }

    @Test
    public void test_rotateRight() {
        int[][] image;
        int[][] expected;

        image = new int[][] {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 }};
        expected = new int[][] {
                { 5, 3, 1 },
                { 6, 4, 2 }};
        assertArrayEquals(expected, Algorithms.rotateRight(image));

        image = new int[][] {
                { 1, 2 },
                { 3, 4 }};
        expected = new int[][] {
                { 3, 1 },
                { 4, 2 }};
        assertArrayEquals(expected, Algorithms.rotateRight(image));

        image = new int[][] {
                { 1, 2, 3, 4, 5 }};
        expected = new int[][] {
                { 1 },
                { 2 },
                { 3 },
                { 4 },
                { 5 }};
        assertArrayEquals(expected, Algorithms.rotateRight(image));

        image = new int[][] {
                { 1 },
                { 2 },
                { 3 }};
        expected = new int[][] {
                { 3, 2, 1 }};
        assertArrayEquals(expected, Algorithms.rotateRight(image));

        // 4 rotations = no rotation
        image = new int[][] {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 }};
        expected = new int[][] {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 }};

        image = Algorithms.rotateRight(image);
        image = Algorithms.rotateRight(image);
        image = Algorithms.rotateRight(image);
        image = Algorithms.rotateRight(image);
        assertArrayEquals(expected, image);
    }
}