package com.pbd.techtestqlue

import org.junit.Assert.*
import org.junit.Test


class UtilsTest {
    private val utils: Utils = Utils()

    @Test
    fun `sortArray function return sorted array in ascending order`() {
        val unsortedArray = arrayListOf(1, 6, 3, 5, 8, 7, 4, 20)
        val expectedSortedArray = arrayListOf(1, 3, 4, 5, 6, 7, 8, 20)
        assertEquals(expectedSortedArray, utils.sortArray(unsortedArray))
    }

    @Test
    fun `sortArray with negative number function return sorted array in ascending order`() {
        val unsortedArray = arrayListOf(-1, 6, 3, 5, -8, 7, 4, 20)
        val expectedSortedArray = arrayListOf(-8, -1, 3, 4, 5, 6, 7, 20)
        assertEquals(expectedSortedArray, utils.sortArray(unsortedArray))
    }

    @Test
    fun `multiplyArray function is Correct`() {
        val initial = arrayListOf(1, 2, 3, 4, 5, 6)
        val expected = arrayListOf(6, 10, 12, 12, 10, 6)
        assertEquals(expected, utils.multiplyArray(initial))
    }

    @Test
    fun `multiplyArray with odd numbers array function is Correct`() {
        val initial = arrayListOf(1, 2, 3, 4, 5, 6, 7)
        val expected = arrayListOf(7, 12, 15, 4, 15, 12, 7)
        assertEquals(expected, utils.multiplyArray(initial))
    }

    @Test
    fun `evenOddArray function is Correct`() {
        val initial = arrayListOf(10, 33, 13, 72, 44, 51, 17)
        val expected = arrayListOf(43, 20, 85, 28, 95, 34)
        assertEquals(expected, utils.evenOddArray(initial))
    }

    @Test
    fun `evenOddArray with function is Correct`() {
        val initial = arrayListOf(21, -10, 29, 40)
        val expected = arrayListOf(11, -39, 69)
        assertEquals(expected, utils.evenOddArray(initial))
    }
}