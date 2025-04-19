import java.util.Scanner;

public class MainSiakad12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Mahasiswa12[] mahasiswa = {
            new Mahasiswa12("22001", "Ali Rahman", "Informatika"),
            new Mahasiswa12("22002", "Budi Santoso", "Informatika"),
            new Mahasiswa12("22003", "Citra Dewi", "Sistem Informasi Bisnis")
        };

        MataKuliah12[] matkul = {
            new MataKuliah12("MK001", "Struktur Data", 3),
            new MataKuliah12("MK002", "Basis Data", 3),
            new MataKuliah12("MK003", "Desain Web", 3)
        };

        Nilai12[] nilai = {
            new Nilai12(mahasiswa[0], matkul[0], 80, 85, 90), 
            new Nilai12(mahasiswa[0], matkul[1], 60, 75, 70), 
            new Nilai12(mahasiswa[1], matkul[0], 75, 70, 80), 
            new Nilai12(mahasiswa[2], matkul[1], 85, 90, 95), 
            new Nilai12(mahasiswa[2], matkul[2], 80, 90, 65)  
        };

        int pilihan;
        do {
            System.out.println("\n=== MENU SISTEM AKADEMIK ===");
            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Data Penilaian");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    for (Mahasiswa12 m : mahasiswa) {
                        m.tampilkan();
                    }
                    break;

                case 2:
                    for (MataKuliah12 m : matkul) {
                        m.tampilkan();
                    }
                    break;

                case 3:
                    for (Nilai12 n : nilai) {
                        n.tampilkan();
                    }
                    break;

                case 4:
                    for (int i = 0; i < nilai.length - 1; i++) {
                        for (int j = 0; j < nilai.length - 1 - i; j++) {
                            if (nilai[j].nilaiAkhir < nilai[j + 1].nilaiAkhir) {
                                Nilai12 temp = nilai[j];
                                nilai[j] = nilai[j + 1];
                                nilai[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Data Penilaian : ");
                    for (Nilai12 n : nilai) {
                        n.tampilkan();
                    }
                    break;

                case 5:
                    System.out.print("Masukkan NIM mahasiswa yang dicari: ");
                    String cariNIM = sc.nextLine();
                    boolean ditemukan = false;
                    for (Mahasiswa12 n : mahasiswa) {
                        if (n.nim.equals(cariNIM)) {
                            System.out.print("Mahasiswa Ditemukan :");
                            n.tampilkan();
                            ditemukan = true;
                            break;
                        }
                    }
                    if (!ditemukan) {
                        System.out.println("Mahasiswa dengan NIM " + cariNIM + " tidak ditemukan.");
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih. Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}
