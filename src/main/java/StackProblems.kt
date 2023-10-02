class StackProblems {
    fun balancedParentheses(s: String): Boolean {
        val customStack = CustomStack<Char>()
        for (element in s) {
            when (element) {
                '[', '(', '{' -> customStack.push(element)
                ']' -> if(customStack.isEmpty() || customStack.peek() != '[') return false else customStack.pop()
                '}' -> if(customStack.isEmpty() || customStack.peek() != '{') return false else customStack.pop()
                ')' -> if(customStack.isEmpty() || customStack.peek() != '(') return false else customStack.pop()
            }
        }
        return customStack.isEmpty()
    }
}

fun main() {
    val stackProblems = StackProblems()
    val string = "()"
    print(stackProblems.balancedParentheses(string))
}
