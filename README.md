# project-manager

## Deskripsi
Tetap Semangat
1. Jauhari (Hadir)
2. Fikri (HADIR)
3. Zidan (HADIR)
4. Isyanda (HADIR)
5. Ababil (HADIR)

## Prasyarat
Sebelum memulai, pastikan memiliki hal-hal berikut:
1. download mysql-connector-j-9.3.0 pada browser  https://dev.mysql.com/downloads/connector/j/9.3.html setelah masuk pilih "Select Operating System:" yang "platform independent" 
2. download apache NetBeans IDE untuk menjalankan program java
link download https://netbeans.apache.org/front/main/download/ 
- lalu download yang "(mysql-connector-j-9.3.0.zip)"
3. **XAMPP**: Gunakan XAMPP sebagai lingkungan pengembangan.

## Instalasi

### 1. Clone Repository
Pertama, klon repositori ini ke direktori lokal:
```bash
git clone https://github.com/Jauhari007/project-manager.git
```


## Menjalankan Aplikasi

1. download apache NetBeans IDE untuk menjalankan program java
link download https://netbeans.apache.org/front/main/download/ 
2. download yang "netbeans-26-bin.zip (SHA-512, PGP ASC)
3. Instal aplikasi di folder C:\Users\Jauhari Achmad P\Downloads\netbeans-26-bin\netbeans\bin
4. Ketika di folder \bin klik aplikasi yang bernama 
- netbeans64 (untuk windows 64 bit) instal disini
- kalau yang netbeans (untuk windows 32 bit)
5. instal sampai ke menu home Netbeans
6. Klik file dan klik new project
7. pilih di toolbar categories folder bernama java with ant dan di toolbar project pilih yang "java project with existing source" lalu next
8. Isi Project name misal  "ProjectManager" dan sebelum klik di browser pada "project location" copy dulu file project java kalian seperti file ini yang letaknya di C:\xampp\htdocs\project-manager copy folder /peoject-manager nya saja
9. Tempelkan folder \project-manager ke dalam file C:\Users\Jauhari Achmad P\Documents\NetBeansProjects nah tempel di dalam folder "NetBeansProjects"
10. Klik browse pada "project locations" dan cari folder \erc project ini yang letakknya di C:\Users\Jauhari Achmad P\Documents\NetBeansProjects\erc 
11. Klik folder \erc lalu open
12. langsung kalian next 
13. Ketika masuk di steps "existing sources" kalian klik add folder pada "source package folders" 
14. Langsung kalian cari folder C:\Users\Jauhari Achmad P\Documents\NetBeansProjects\project-manager\src 
15. setelah itu klik finish
16. Folder yang kalian kerjakan akan tampil di halaman Netbeans 
17. Jangan lupa klik kanan folder libraries yang letaknya dibawah folder project kalian, lalu klik "Add JAR/Folder"
maka kalian masukkan file jar kalian "mysql-connector-j-9.3.0" yang letaknya di folder mysql-connector yang sudah kalian download lalu open
18. Setelah itu run program java ini caranya
19. klik kanan folder project kalian "ProjectManager"
20. lalu klik "run" maka program akan menampilkan output tampilannya
   ```

   ```

## Struktur Folder
```
Project-manager/
│
├── src/
│   ├── model/
│   │   ├── User.java
│   │   ├── Project.java
│   │
│   ├── controller/
|   |   |__BaseManager.java
|   |   |
│   │   ├── UserManager.java
│   │   ├── ProjectManager.java
│   │
│   ├── db/
│   │   └── Database.java
│   │
│   ├── ui/
│   │   ├── LoginForm.java
│   │   ├── RegisterForm.java
│   │   ├── ProjectForm.java
│   │
│   └── Main.java
│
├── lib/  (untuk JDBC jar)
│
├── sql/
│   └── schema.sql
│
└── README.md
```

## Kontribusi
1. Clone repositori ini.
2. Buat branch baru:
   ```bash
   git checkout -b namaanda
   ```
3. Lakukan perubahan pada fitur yang ingin ditambahkan atau diperbaiki.
4. Simpan semua perubahan:
   ```bash
   git add .
   ```
5. Commit perubahan:
   ```bash
   git commit -m 'Menambahkan fitur ABC'
   ```
6. Push ke branch kamu:
   ```bash
   git push origin namaanda
   ```
7. Minta pemilik repositori untuk menggabungkan perubahan kamu.

> **Note**: Selalu tarik perubahan terbaru dari branch utama sebelum memulai:
> ```bash
> git pull origin main
> ```


