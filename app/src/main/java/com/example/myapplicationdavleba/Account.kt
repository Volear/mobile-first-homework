package com.example.myapplicationdavleba

open class Account(val accountNumber: String, val ownerName: String) {
    private var balance: Double = 0.0
    
    fun getBalance(): Double = balance
    
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposit successful. New balance: $balance")
        }
    }
    
    open fun withdraw(amount: Double) {
        if (amount > 0 && balance >= amount) {
            balance -= amount
        } else {
            println("Insufficient funds")
        }
    }
    
    fun printInfo() {
        println("Account: $accountNumber, Owner: $ownerName, Balance: $balance")
    }
}

class SavingsAccount(accountNumber: String, ownerName: String) : Account(accountNumber, ownerName) {
    override fun withdraw(amount: Double) {
        if (amount > 500) {
            println("Transaction limit exceeded. Maximum withdrawal is 500 per transaction.")
        } else {
            super.withdraw(amount)
        }
    }
}

class VIPAccount(accountNumber: String, ownerName: String, val transactionFee: Double = 2.0) : Account(accountNumber, ownerName) {
    override fun withdraw(amount: Double) {
        val totalAmount = amount + transactionFee
        if (getBalance() >= totalAmount) {
            super.withdraw(totalAmount)
        } else {
            println("Insufficient funds")
        }
    }
}

fun main() {
    val savings = SavingsAccount("S101", "Saba K.")
    val vip = VIPAccount("V202", "Tiko S.")
    
    savings.deposit(1000.0)
    vip.deposit(1000.0)
    
    savings.withdraw(500.0)
    savings.withdraw(600.0)
    
    vip.withdraw(100.0)
    
    savings.printInfo()
    vip.printInfo()
}