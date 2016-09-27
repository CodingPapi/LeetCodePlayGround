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

}