class Account {

    BigDecimal balance = 0
    String type

    void deposit(def sum){
        this.balance += sum
    }

    void withdraw(def sum){
        this.balance -= sum
    }

    def plus(Account acc){
        this.balance + acc.balance
    }

    @Override
    String toString() {
        this.balance
    }
}

Account checking = new Account(type:"Checking")
checking.deposit(100.00)
Account savings = new Account(type:"Savings")
savings.deposit(50.00)

BigDecimal total = checking + savings
println total