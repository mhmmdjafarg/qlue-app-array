package com.pbd.techtestqlue

class Utils {

    /**
     * sort an array in ascending order
     * @param arr : ArrayList<Int>
     * @return ArrayList : Integer
     */
    fun sortArray(arr: ArrayList<Int>): List<Int> = arr.sorted()

    /**
     * function or method to process the array data below with first index being multiplied by the last index, the second index being multiplied by second last index, and so on
     */
    fun multiplyArray(arr: ArrayList<Int>): ArrayList<Int> {
        if (arr.size > 1) {
            val lastIdx = arr.size - 1
            for (i in 0 until Math.floorDiv(arr.size, 2)) {
                arr[i] *= arr[lastIdx - i]
                arr[lastIdx - i] = arr[i]
            }
        }
        return arr
    }

    /**
     * Create function or method to process array data below with even indices will be added with the
    index after it and odd index will be subtracted with the index after it, and so on
     */
    fun evenOddArray(arr: ArrayList<Int>): ArrayList<Int> {
        var newArray = ArrayList<Int>()

        // Loop until last second index
        for (i in 0 until (arr.size - 1)) {
            println("i $i")
            // even idx
            if (i % 2 == 0) {
                newArray.add(arr[i] + arr[i + 1])
            } else { // odd idx
                newArray.add(arr[i] - arr[i + 1])
            }
        }
        return newArray
    }
}