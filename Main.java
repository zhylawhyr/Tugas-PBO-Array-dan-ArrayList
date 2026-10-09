public class Main {
    public static void main(String[] args) {
        // 1. Bikin objek Customer
        Customer cust1 = new Customer("Zhylalan", "Ramadhani");
        Customer cust2 = new Customer("Najmi", "Firdaus");

        // 2. Bikin Akun 1 & Akun 2
        Account acc1 = new Account(1008);
        Account acc2 = new Account(1729);

        // 3. Masukin saldo & transaksi
        acc1.deposit(500000);   
        acc1.withdraw(200000);  
        acc2.deposit(1000000); 
        acc2.withdraw(300000);  

        // Tambahkan akun ke masing-masing Customer
        cust1.addAccount(acc1);
        cust2.addAccount(acc2);

        // 4. Tampilan Informasi Nasabah & Rekening
        System.out.println("==========================================");
        System.out.println("            INFORMASI NASABAH             ");
        System.out.println("==========================================");

        // Detail Nasabah 1
        System.out.println("Nama Nasabah : " + cust1.getFirstName() + " " + cust1.getLastName());
        System.out.println("Jumlah Akun  : " + cust1.getNumOfAccounts());
        Account a1 = cust1.getAccount(0); // Indeks 0 untuk akun pertama customer1
        System.out.println("No. Rekening : " + a1.getAccountNumber());
        System.out.println("Saldo Akhir  : Rp " + (int) a1.getBalance());

        System.out.println("------------------------------------------");

        // Detail Nasabah 2
        System.out.println("Nama Nasabah : " + cust2.getFirstName() + " " + cust2.getLastName());
        System.out.println("Jumlah Akun  : " + cust2.getNumOfAccounts());
        Account a2 = cust2.getAccount(0); // Indeks 0 untuk akun pertama customer2 (Bukan 1!)
        System.out.println("No. Rekening : " + a2.getAccountNumber());
        System.out.println("Saldo Akhir  : Rp " + (int) a2.getBalance());

        System.out.println("==========================================");
    }
}