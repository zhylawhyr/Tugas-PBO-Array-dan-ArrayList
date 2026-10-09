public class Account{
   
private double balance;
private int accountNumber;

// constructor (Inisialisasi dengan nomer rekening (saldo awal : 0))
public Account(int accountNumber){
    this.balance = 0;
    this.accountNumber = accountNumber;
}

// Method 
// 1. Deposit (validasi if else)
public boolean deposit(double amount){
    if (amount > 0){
        this.balance += amount;
           return true;
    }else{
        System.out.println("Transaksi gagal: Jumlah deposit yang dimasukkan tidak valid");
        return false;
    }
}

// 2. Withdraw (validasi if-else) memastikan bahwa jumlah saldo > 0
public boolean withdraw(double amount){
    if (amount <= 0){
        System.out.println("Transaksi gagal: Jumlah penarikan dana tidak valid.");
        return false;
    }else if (amount <= this.balance){
        this.balance -= amount;
        return true;
    }else{
        System.out.println("Transaksi ditolak: Saldo anda tidak mencukupi");
        return false;
    }
}

// 3. Getter Account Number
public int getAccountNumber(){
    return this.accountNumber;
}

// 4. Getter Account Number
public double getBalance(){
    return this.balance;
}
}