import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by lijia8 on 2016/9/27.
 */
class LeetCodeTest {

    lateinit var  lc: LeetCode

    @Before
    @Throws(Exception::class)
    fun setUp() {
        lc = LeetCode()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {

    }

    @Test
    @Throws(Exception::class)
    fun twoSum() {
        assertArrayEquals(intArrayOf(1, 2), lc.twoSum(intArrayOf(3, 2, 4), 6))
    }

    @Test
    @Throws(Exception::class)
    fun addTwoNumbers() {
        var node1 = LeetCode.ListNode(2)
        node1.next = LeetCode.ListNode(4)
        node1.next.next = LeetCode.ListNode(3)
        var node2 = LeetCode.ListNode(5)
        node2.next = LeetCode.ListNode(6)
        node2.next.next = LeetCode.ListNode(4)
        var nodeTest = lc.addTwoNumbers(node1, node2)
        assertEquals(7, nodeTest.`val`)
        assertEquals(0, nodeTest.next.`val`)
        assertEquals(8, nodeTest.next.next.`val`)
    }

    @Test
    @Throws(Exception::class)
    fun merge() {
        assertArrayEquals(intArrayOf(1, 2, 3), lc.mergeSort(intArrayOf(3, 2, 1), 0, 2))
        assertArrayEquals(intArrayOf(1, 2, 3, 5, 8), lc.mergeSort(intArrayOf(1, 5, 2, 8, 3), 0, 4))
    }

    @Test
    @Throws(Exception::class)
    fun quick() {
        assertArrayEquals(intArrayOf(1, 2, 3), lc.quickSort(intArrayOf(3, 2, 1), 0, 2))
        assertArrayEquals(intArrayOf(1, 2, 3, 5, 8), lc.quickSort(intArrayOf(1, 5, 2, 8, 3), 0, 4))
    }

    @Test
    @Throws(Exception::class)
    fun canPartition() {
        assertTrue(lc.canPartition(intArrayOf(1, 3, 1, 5, 7, 9)))
        assertFalse(lc.canPartition(intArrayOf(2, 2, 3, 5)))
        assertTrue(lc.canPartition(intArrayOf(2, 2, 2, 3, 5)))
        assertFalse(lc.canPartition(intArrayOf(3, 1, 5, 7, 9)))
        assertTrue(lc.canPartition(intArrayOf(71,70,66,54,32,63,38,98,4,22,61,40,6,8,6,21,71,36,30,34,44,60,89,53,60,56,73,14,63,37,15,58,51,88,88,32,80,32,10,89,67,29,68,65,34,15,88,8,57,78,37,63,73,65,47,39,32,74,31,44,43,4,10,8,96,22,58,87,29,99,79,13,96,21,62,71,34,55,72,3,96,7,36,64,30,6,14,87,12,90,40,13,29,21,94,33,99,86,4,100)))
        assertTrue(lc.canPartition(intArrayOf(1, 2, 3, 4, 5, 6, 7)))
    }


}