
fun main(){
    fun isComposite(par : Int) {
        var result = false
        for (i in 2..par / 2) {
            if (par % i == 0) {
                result = true
                break
            }
        }

        if (!result)
            println("$par is a prime number")
        else
            println("$par is not a prime number")
    }
    isComposite(12)

}