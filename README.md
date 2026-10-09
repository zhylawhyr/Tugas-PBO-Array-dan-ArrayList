# 🏦 Tugas PBO – Array dan ArrayList

Repository ini berisi tugas mata kuliah **Pemrograman Berorientasi Objek (PBO)** berupa program Java sederhana yang memodelkan **sistem perbankan**: nasabah (`Customer`), rekening (`Account`), dan bank (`Bank`). Tugas ini memperlihatkan cara menyimpan sekumpulan objek menggunakan dua struktur data yang berbeda, yaitu **Array** dan **ArrayList**.

Setiap nasabah dapat memiliki rekening yang disimpan dalam sebuah `ArrayList`, sedangkan bank menyimpan daftar rekening dalam array berukuran tetap. Kelas `Account` menyediakan fitur setor (`deposit`) dan tarik tunai (`withdraw`) lengkap dengan validasi, sehingga transaksi dengan nominal tidak valid atau saldo tidak cukup akan ditolak.

Dokumen ini memuat struktur proyek, library yang digunakan, penjelasan kode setiap kelas, cara menjalankan program, serta tangkapan layar hasil eksekusinya.

## 👤 Identitas

| Data | Keterangan |
|---|---|
| 👤 **Nama** | Zhylalan Wahyu Ramadhani |
| 🆔 **NIM** | F1D02510137 |
| 🏫 **Kelas** | 3B |
| 📘 **Mata Kuliah** | Pemrograman Berorientasi Objek (PBO) |
| 👨‍🏫 **Dosen Pengampu** | Rovana Afwani, S.T., M.T. |

---

## 📑 Daftar Isi

1. [📖 Deskripsi Program](#-1-deskripsi-program)
2. [📁 Struktur Proyek](#-2-struktur-proyek)
3. [📚 Library yang Digunakan](#-3-library-yang-digunakan)
4. [💻 Penjelasan Kode](#-4-penjelasan-kode)
5. [▶️ Cara Menjalankan](#️-5-cara-menjalankan)
6. [📸 Hasil Program (Screenshot)](#-6-hasil-program-screenshot)
7. [📌 Catatan](#-7-catatan)
8. [✅ Kesimpulan](#-8-kesimpulan)

---

## 📖 1. Deskripsi Program

Program ini dibuat untuk memperlihatkan penggunaan **Array** dan **ArrayList** dalam menyimpan kumpulan objek, serta penerapan **enkapsulasi** dan **validasi** pada transaksi perbankan sederhana.

**🧩 Rancangan kelas**

- **`Account`** merepresentasikan satu rekening. Menyimpan `accountNumber` dan `balance` (saldo awal 0), serta menyediakan `deposit()` dan `withdraw()` dengan validasi `if-else`.
- **`Customer`** merepresentasikan nasabah. Menyimpan nama depan, nama belakang, dan daftar rekening milik nasabah tersebut dalam sebuah **`ArrayList<Account>`**.
- **`Bank`** merepresentasikan bank. Menyimpan daftar rekening dalam sebuah **array** `Account[]` berukuran tetap (15).
- **`Main`** adalah kelas utama yang membuat nasabah dan rekening, melakukan transaksi, lalu menampilkan informasinya.

**🔄 Alur program**

1. `Main` membuat dua nasabah: *Zhylalan Ramadhani* dan *Najmi Firdaus*.
2. Dibuat dua rekening: nomor **1008** dan **1729**.
3. Rekening 1008 menyetor **Rp 500.000** lalu menarik **Rp 200.000**. Rekening 1729 menyetor **Rp 1.000.000** lalu menarik **Rp 300.000**.
4. Masing-masing rekening ditambahkan ke nasabah pemiliknya.
5. Program menampilkan nama nasabah, jumlah akun, nomor rekening, dan saldo akhir.

**⚖️ Perbandingan Array dan ArrayList**

| Aspek | Array (`Bank`) | ArrayList (`Customer`) |
|---|---|---|
| Ukuran | Tetap, ditentukan saat dibuat (15) | Dinamis, bertambah otomatis |
| Menambah data | Manual lewat indeks (`accounts[n] = acc`) | `add()` |
| Mengambil data | `accounts[index]` | `get(index)` |
| Jumlah data | Dihitung sendiri (`NumOfAccounts`) | `size()` |

---

## 📁 2. Struktur Proyek

```
.
├── Account.java
├── Bank.java
├── Customer.java
├── Main.java
├── screenshots/
│   ├── repository.png
│   └── hasil-1.png
└── README.md
```

### 🔗 Hubungan Antar Kelas

```
Main
├── membuat → Customer ── menyimpan (ArrayList) ──▶ Account
├── membuat → Account
└── (Bank ── menyimpan (Array) ──▶ Account)
```

---

## 📚 3. Library yang Digunakan

| Library | Dipakai di | Kegunaan |
|---|---|---|
| `java.util.ArrayList` | `Customer.java` | Menyimpan daftar rekening milik nasabah dalam list yang ukurannya dinamis. |
| `java.lang.*` | Semua kelas | Bawaan Java yang otomatis tersedia (`String`, `System.out.println()`), tidak perlu di-`import`. |

**Library tambahan (eksternal):** tidak ada. `ArrayList` berasal dari library standar Java (JDK), jadi tidak perlu instalasi apa pun.

Cara memakainya di `Customer.java`:

```java
import java.util.ArrayList;
```

---

## 💻 4. Penjelasan Kode

### 🟦 4.1 `Account.java`

```java
public class Account {

    private double balance;
    private int accountNumber;

    // constructor (inisialisasi dengan nomor rekening, saldo awal: 0)
    public Account(int accountNumber){
        this.balance = 0;
        this.accountNumber = accountNumber;
    }

    // 1. Deposit (validasi if-else)
    public boolean deposit(double amount){
        if (amount > 0){
            this.balance += amount;
            return true;
        } else {
            System.out.println("Transaksi gagal: Jumlah deposit yang dimasukkan tidak valid");
            return false;
        }
    }

    // 2. Withdraw (validasi if-else)
    public boolean withdraw(double amount){
        if (amount <= 0){
            System.out.println("Transaksi gagal: Jumlah penarikan dana tidak valid.");
            return false;
        } else if (amount <= this.balance){
            this.balance -= amount;
            return true;
        } else {
            System.out.println("Transaksi ditolak: Saldo anda tidak mencukupi");
            return false;
        }
    }

    // 3. Getter nomor rekening
    public int getAccountNumber(){
        return this.accountNumber;
    }

    // 4. Getter saldo
    public double getBalance(){
        return this.balance;
    }
}
```

**📝 Penjelasan:**
- `balance` dan `accountNumber` bersifat `private` (**enkapsulasi**), sehingga hanya bisa diakses lewat method, tidak langsung dari luar kelas.
- Constructor menerima nomor rekening dan mengatur saldo awal menjadi `0`.
- `deposit()` hanya menerima nominal **lebih dari 0**. Jika valid, saldo bertambah dan mengembalikan `true`. Jika tidak, tampil pesan gagal dan mengembalikan `false`.
- `withdraw()` memiliki tiga kondisi: nominal tidak valid (≤ 0) ditolak, saldo tidak cukup ditolak, dan jika cukup saldo dikurangi.
- Nilai kembalian `boolean` memberi tahu pemanggil apakah transaksi berhasil.
- `getAccountNumber()` dan `getBalance()` adalah *getter* untuk membaca data rekening.

---

### 🟩 4.2 `Customer.java`

```java
import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;

    // Constructor
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
```

**📝 Penjelasan:**
- `import java.util.ArrayList;` dibutuhkan karena `ArrayList` tidak termasuk paket `java.lang`.
- `ArrayList<Account>` adalah list yang hanya boleh berisi objek `Account` (*generics*).
- Constructor mengisi nama depan dan belakang, lalu membuat `ArrayList` kosong.
- `addAccount()` memakai `add()` untuk menambah rekening, tanpa perlu menentukan ukuran di awal.
- `getAccount(index)` memakai `get()` untuk mengambil rekening berdasarkan urutan (indeks mulai dari 0).
- `getNumOfAccounts()` memakai `size()` untuk mengetahui jumlah rekening.

---

### 🟧 4.3 `Bank.java`

```java
public class Bank {
    private Account[] accounts;
    private int NumOfAccounts;

    // Constructor menentukan batas maksimal array
    public Bank(int maxAccount){
        this.accounts = new Account[15];
        this.NumOfAccounts = 0;
    }

    // Menambah akun menggunakan array
    public void addAccount(Account acc){
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
```

**📝 Penjelasan:**
- `Account[] accounts` adalah **array** biasa yang ukurannya tetap setelah dibuat. Di sini dibuat berkapasitas 15 rekening.
- `NumOfAccounts` mencatat berapa slot array yang sudah terisi, karena array tidak punya fungsi `size()` seperti `ArrayList`.
- `addAccount()` memasukkan rekening ke posisi kosong berikutnya, lalu menaikkan `NumOfAccounts`.
- `getAccount(index)` mengambil rekening berdasarkan indeks array.
- `getNumOfAccounts()` mengembalikan jumlah rekening yang tersimpan.

---

### 🚀 4.4 `Main.java`

```java
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
        Account a2 = cust2.getAccount(0); // Indeks 0 untuk akun pertama customer2
        System.out.println("No. Rekening : " + a2.getAccountNumber());
        System.out.println("Saldo Akhir  : Rp " + (int) a2.getBalance());

        System.out.println("==========================================");
    }
}
```

**📝 Penjelasan:**
- Dibuat dua objek `Customer` dan dua objek `Account` dengan nomor rekening berbeda.
- Transaksi dilakukan lewat `deposit()` dan `withdraw()`. Semua nominalnya valid, sehingga tidak ada pesan gagal.
- `cust1.addAccount(acc1)` memasukkan rekening ke `ArrayList` milik nasabah.
- `cust1.getAccount(0)` mengambil rekening pertama (indeks `0`) milik nasabah tersebut.
- `(int) a1.getBalance()` mengubah saldo `double` menjadi bilangan bulat agar tampil tanpa desimal.

---

## ▶️ 5. Cara Menjalankan

**⚙️ Prasyarat:** JDK sudah terpasang (cek dengan `java -version`).

```bash
# 1. Clone repository
git clone https://github.com/zhylawhyr/Tugas-PBO-Array-dan-ArrayList.git
cd Tugas-PBO-Array-dan-ArrayList

# 2. Compile semua file
javac *.java

# 3. Jalankan program
java Main
```

Atau lewat VS Code: buka `Main.java`, lalu klik **Run** di atas method `main`.

---

## 📸 6. Hasil Program (Screenshot)

### 🗂️ Struktur Repository

<img width="1917" height="862" alt="image" src="https://github.com/user-attachments/assets/6bcb5589-1090-4e79-abd0-ade228975669" />


*Gambar 1. Isi repository di GitHub.*

### 🖥️ Output Program

!

*Gambar 2. Output program saat dijalankan.*

<img width="407" height="281" alt="image" src="https://github.com/user-attachments/assets/1829c4a6-935f-4f43-9073-c9ab8c871d78" />




**🧮 Perhitungan saldo:**

| Rekening | Transaksi | Saldo akhir |
|---|---|---|
| 1008 | 0 + 500.000 − 200.000 | Rp 300.000 |
| 1729 | 0 + 1.000.000 − 300.000 | Rp 700.000 |

---

## 📌 7. Catatan

- Kelas `Bank` sudah dibuat sebagai contoh penggunaan **array**, tetapi belum dipakai (belum dibuat objeknya) di `Main`.
- Parameter `maxAccount` pada constructor `Bank` belum dipakai. Ukuran array saat ini tetap 15.
- `addAccount()` pada `Bank` tidak memeriksa batas kapasitas, sehingga menambah lebih dari 15 rekening akan menyebabkan error. Hal ini sekaligus menunjukkan kelemahan array dibanding `ArrayList`.

---

## ✅ 8. Kesimpulan

- **Array** berukuran tetap dan perlu pencatatan jumlah data secara manual, sedangkan **ArrayList** bersifat dinamis dan menyediakan method siap pakai seperti `add()`, `get()`, dan `size()`.
- **Enkapsulasi** pada `Account` melindungi saldo dari perubahan langsung, karena perubahan hanya lewat `deposit()` dan `withdraw()` yang sudah divalidasi.
- Satu-satunya library tambahan yang digunakan adalah `java.util.ArrayList` dari JDK, tanpa library eksternal.
