import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Siakad {
    private ArrayList<Mahasiswa> mahasiswas;
    private ArrayList<MataKuliah> mataKuliahs;
    private ArrayList<Penilaian> penilaians;
    private Scanner scanner;

    public Siakad() {
        mahasiswas = new ArrayList<>();
        mataKuliahs = new ArrayList<>();
        penilaians = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void initialize() {
        tambahMahasiswa("22001", "Ali Rahman", "Informatika");
        tambahMahasiswa("22002", "Budi Santoso", "Informatika");
        tambahMahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis");

        tambahMataKuliah("MK001", "Struktur Data", 3);
        tambahMataKuliah("MK002", "Basis Data", 3);
        tambahMataKuliah("MK003", "Desain Web", 3);

        tambahPenilaian("22001", "MK001", 80, 85, 90);
        tambahPenilaian("22001", "MK002", 60, 75, 70);
        tambahPenilaian("22002", "MK001", 75, 70, 80);
        tambahPenilaian("22003", "MK002", 85, 90, 95);
        tambahPenilaian("22003", "MK003", 80, 90, 65);
    }

    public void run() {
        int pilihan;
        do {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1 -> tampilkanDaftarMahasiswa();
                case 2 -> tampilkanDaftarMataKuliah();
                case 3 -> tampilkanDataPenilaian();
                case 4 -> urutkanMahasiswaBerdasarkanNilaiAkhir();
                case 5 -> cariMahasiswaBerdasarkanNIM();
                case 0 -> System.out.println("Terima kasih telah menggunakan Sistem Akademik.");
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
    }

    private void tampilkanMenu() {
        System.out.println("""
                === MENU SISTEM AKADEMIK ===
                1. Tampilkan Daftar Mahasiswa
                2. Tampilkan Daftar Mata Kuliah
                3. Tampilkan Data Penilaian
                4. Urutkan Mahasiswa Berdasarkan Nilai Akhir
                5. Cari Mahasiswa Berdasarkan NIM
                0. Keluar
                """);
    }

    private void tambahMahasiswa(String nim, String nama, String prodi) {
        mahasiswas.add(new Mahasiswa(nim, nama, prodi));
    }

    private void tambahMataKuliah(String kodeMK, String namaMK, int sks) {
        mataKuliahs.add(new MataKuliah(kodeMK, namaMK, sks));
    }

    private void tambahPenilaian(String nim, String kodeMK, double tugas, double uts, double uas) {
        Mahasiswa mahasiswa = cariMahasiswaByNIM(nim);
        MataKuliah mataKuliah = cariMataKuliahByKode(kodeMK);
        if (mahasiswa != null && mataKuliah != null) {
            penilaians.add(new Penilaian(mahasiswa, mataKuliah, tugas, uts, uas));
        }
    }

    private void tampilkanDaftarMahasiswa() {
        System.out.println("Daftar Mahasiswa:");
        mahasiswas.forEach(m -> System.out.println("NIM: " + m.getNIM() + " | Nama: " + m.getNama() + " | Prodi: " + m.getProdi()));
    }

    private void tampilkanDaftarMataKuliah() {
        System.out.println("Daftar Mata Kuliah:");
        mataKuliahs.forEach(mk -> System.out.println("Kode MK: " + mk.getKodeMK() + " | Nama: " + mk.getNamaMK() + " | SKS: " + mk.getSks()));
    }

    private void tampilkanDataPenilaian() {
        System.out.println("Data Penilaian:");
        penilaians.forEach(p -> System.out.println(p.getMahasiswa().getNama() + " | " + p.getMataKuliah().getNamaMK() + " | Nilai Akhir: " + String.format("%.1f", p.getNilaiAkhir())));
    }

    // Sorting: Mengurutkan mahasiswa berdasarkan nilai akhir
    private void urutkanMahasiswaBerdasarkanNilaiAkhir() {
        System.out.println("Data Penilaian (diurutkan berdasarkan nilai akhir tertinggi):");
        penilaians.stream()
                .sorted(Comparator.comparingDouble(Penilaian::getNilaiAkhir).reversed())
                .forEach(p -> System.out.println(p.getMahasiswa().getNama() + " | " + p.getMataKuliah().getNamaMK() + " | Nilai Akhir: " + String.format("%.1f", p.getNilaiAkhir())));
    }

    // Searching: Mencari mahasiswa berdasarkan NIM
    private void cariMahasiswaBerdasarkanNIM() {
        System.out.print("Masukkan NIM mahasiswa yang dicari: ");
        String nim = scanner.next();
        Mahasiswa mhs = cariMahasiswaByNIM(nim);
        if (mhs != null) {
            System.out.println("Mahasiswa Ditemukan: NIM: " + mhs.getNIM() + " | Nama: " + mhs.getNama() + " | Prodi: " + mhs.getProdi());
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    private Mahasiswa cariMahasiswaByNIM(String nim) {
        return mahasiswas.stream().filter(m -> m.getNIM().equals(nim)).findFirst().orElse(null);
    }

    private MataKuliah cariMataKuliahByKode(String kodeMK) {
        return mataKuliahs.stream().filter(mk -> mk.getKodeMK().equals(kodeMK)).findFirst().orElse(null);
    }
}