public class Bank{
    private Account[] accounts;
    private int NumOfAccounts;

// Constructor menentukan batas maksimal array
public Bank (int maxAccount){
    this.accounts = new Account[15];
    this.NumOfAccounts = 0;
}

// Menambah akun menngunakan array
public void addAccount (Account acc){
    this.accounts[this.NumOfAccounts] = acc;
    NumOfAccounts++;
}

// Mengambil akun berdasarkan indeks
public Account getAccount(int index){
    return this.accounts[index];
}

// Mengembalikan jumlah akun yang tersimpan
public int getNumOfAccounts(){
    return this.NumOfAccounts;
}
}

