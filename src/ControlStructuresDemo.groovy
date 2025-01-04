import groovy.transform.ToString

@ToString

class BankAccount {
    BigDecimal balance = 0.0

    def deposit(def sum) {
        try {
            if (sum >= 0)
                this.balance += sum
            else
                throw new Exception()
        } catch (Exception) {
            println "Negative sum cannot be deposited!"
        }
    }

    def deposit(ArrayList sumArray) {
        for (i in sumArray) {
            deposit(i)
        }
    }
}

def a1 = new BankAccount()
a1.deposit([10, 20, 30, 40 ,45, -120, 50])
println a1