package br.com.lucasmveigabr.gympasstest

class GympassTest {

    // [1, 2, 3, 4]

    // [1, 2, 3] [1, 3, 4] [2, 3, 4] [1, 2, 4]

    // [1, 2] [1, 3] [1, 4] [2, 3] [2, 4] [3, 4]

    // [1] [2] [3] [4]

    // []


    // [1,2,3]

    // [1,2] [1,3] [2,3]

    // [1] [2] [3]

    // []

    fun getSubsets(set: Set<Int>): List<Set<Int>> {
        val result = mutableListOf<Set<Int>>()
        result.add(mutableSetOf())

        set.forEach { n ->
            result
                .map {
                    it.toMutableSet().apply { add(n) }
                }
                .forEach { result.add(it) }
        }

        return result
    }

}