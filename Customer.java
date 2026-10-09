import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;

    // Constuctor
    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Menambahkan akun ke customer
    public void addAccount(Account acc) {
        this.accounts.add(acc);
    }

    // Mendapatkan akun berdasarkan indeks
    public Account getAccount(int index) {
        return this.accounts.get(index);
    }

    // Mendapatkan seluruh daftar akun
    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    // Mendapatkan jumlah akun yang dimiliki
    public int getNumOfAccounts() {
        return this.accounts.size();
    }
}


