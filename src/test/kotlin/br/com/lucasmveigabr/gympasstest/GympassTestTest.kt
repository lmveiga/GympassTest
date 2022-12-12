package br.com.lucasmveigabr.gympasstest

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.pow

class GympassTestTest {

    private val sut = GympassTest()

    @Test
    fun getSubsets_linearTest() {
        val input = setOf(1, 2, 3, 4)
        val expectedResult = listOf(
            setOf(), setOf(1), setOf(2), setOf(3), setOf(4),
            setOf(1, 2), setOf(1, 3), setOf(1, 4), setOf(2, 3), setOf(2, 4), setOf(3, 4),
            setOf(1, 2, 3), setOf(1, 3, 4), setOf(2, 3, 4), setOf(1, 2, 4),
            setOf(1, 2, 3, 4)
        )

        val result = sut.getSubsets(input)

        Assertions.assertTrue(expectedResult.containsAll(result))
    }

    @Test
    fun getSubsets_DifferentOrderTest() {
        val input = setOf(9, 21, 3, 412)
        val expectedResult = listOf(
            setOf(9, 21, 3), setOf(9, 3, 412), setOf(21, 3, 412), setOf(9, 21, 412),
            setOf(9, 21), setOf(9, 3), setOf(9, 412), setOf(21, 3), setOf(21, 412), setOf(3, 412),
            setOf(9, 21, 3, 412), setOf(), setOf(9), setOf(21), setOf(3), setOf(412)
        )

        val result = sut.getSubsets(input)

        Assertions.assertTrue(expectedResult.containsAll(result))
    }

    @Test
    fun getSubsets_CorrectCountForHugeInput() {
        val input = setOf(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190)
        val expectedResultCount = 2.0.pow(input.size.toDouble()).toInt()

        val result = sut.getSubsets(input)

        Assertions.assertEquals(expectedResultCount, result.size)
    }

    @Test
    fun getSubsets_CorrectlyReturnsEmptyForEmptyInput() {
        val input = setOf<Int>()
        val expected = listOf(setOf<Int>())

        val result = sut.getSubsets(input)

        Assertions.assertEquals(expected, result)
    }

}