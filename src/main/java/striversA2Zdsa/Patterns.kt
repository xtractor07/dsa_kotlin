package striversA2Zdsa

class Patterns {
    fun normalPattern(n: Int) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                print("* ")
            }
            print("\n")
        }
    }

    fun rightTriangle(n: Int) {
        for (i in 0..n) {
            for (j in 0 until i) {
                print("* ")
            }
            print("\n")
        }
    }

    fun intRightTriangleOne(n: Int) {
        for (i in 1..n) {
            for (j in 1..i) {
                print("$j ")
            }
            print("\n")
        }
    }

    fun intRightTriangleTwo(n: Int) {
        for (i in 1..n) {
            for (j in 1..i) {
                print("$i ")
            }
            print("\n")
        }
    }

    fun invertedRightTriangleOne(n: Int) {
        for (i in n downTo 1) {
            for (j in i downTo 1) {
                print("* ")
            }
            print("\n")
        }
    }

    fun invertedRightTriangleTwo(n: Int) {
        for (i in n downTo 1) {
            for (j in 1..i) {
                print("$j ")
            }
            print("\n")
        }
    }

    fun isoscelesTriangle(n: Int) {
        for(i in n downTo 1) {
            for (j in 1..n) {
                if(j >= i) print('*') else print(' ')
            }
            for(k in 1 until n - i + 1) {
                print("*")
            }
            print("\n")
        }
    }

    fun invertedIsosceles(n: Int) {
        for (i in 1..n) {
            for (j in 1..n) {
                if(j >= i) print("*") else print(" ")
            }
            for (k in 1 until n - i + 1){
                print("*")
            }
            println()
        }
    }

    fun isoscelesPlusInvertedIsosceles(n: Int) {
        isoscelesTriangle(n)
        invertedIsosceles(n)
    }

    fun diamondRightHalf(n: Int) {
        for (i in 0 until n) {
            for (j in 0 until i + 1) {
                print("*")
            }
            println()
        }
        for(i in 1 until n) {
            for (j in n - 1 downTo i) {
                print("*")
            }
            println()
        }
    }

    fun binaryMatrixIsosceles(n: Int) {
        for (i in 1..n) {
            for (j in 1..i) {
                if(i % 2 == 0) print((j + 1) % 2) else print(j % 2)
            }
            println()
        }
    }

    fun isoscelesIntPlusMirrorIsoscelesInt(n: Int) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (j <= i) print(j) else print(" ")
            }
            for (k in n downTo 1) {
                if (k <= i) print(k) else print(" ")
            }
            println()
        }
    }

    fun linearIntCountRightTriangle(n: Int) {
        var count = 1
        for (i in 0 until n) {
            for (j in 0 until i + 1) {
                print("$count ")
                count++
            }
            println()
        }
    }

    fun alphabetRightTriangle(n: Int) {
        for (i in 0 until n) {
            for (j in 65 until 65 + 1 + i){
                print(j.toChar())
            }
            println()
        }
    }

    fun invertedAlphabetRightTriangle(n: Int) {
        for (i in 0 until n) {
            for (j in n downTo i + 1){
                print((65 + (n - j)).toChar())
            }
            println()
        }
    }

    fun alphabetRightTriangleTwo(n: Int) {
        for (i in 0 until n) {
            for (j in 0 until i + 1) {
                print((65 + i).toChar())
            }
            println()
        }
    }

    fun alphabetIsoscelesTriangle(n: Int) {
        for(i in 0 until n) {
            for (j in 65 - (n - 1 - i) .. 65 + i) {
                if (j >= 65) print(j.toChar()) else print(" ")
            }
            for (k in 64 + i downTo 65) {
                print(k.toChar())
            }
            println()
        }
    }

    fun reverseAlphabetRightTriangle(n: Int) {
        for (i in 0 until n) {
            for (j in (n - i) until n + 1) {
                print((64 + j).toChar())
            }
            println()
        }
    }

    fun hollowDiamond(n: Int) {
        for (i in 0 until n) {
            for (j in 0 until n) {
               if (j < n - i) print("*") else print(" ")
            }
            for (k in n downTo 1) {
                if (k > n - i) print(" ") else print("*")
            }
            println()
        }
        for (i in 0 until n) {
            for (j in 0 until n) {
                if(j <= i) print("*") else print(" ")
             }
            for (k in n downTo 1) {
                if (k <= i + 1) print("*") else print(" ")
            }
            println()
        }
    }
}

fun main() {
    val patterns = Patterns()
    val n = readln().toInt()
    patterns.hollowDiamond(n)
}
