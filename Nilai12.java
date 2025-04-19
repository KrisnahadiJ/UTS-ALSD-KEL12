public class Nilai12 {
    Mahasiswa12 mhs;
    MataKuliah12 mk;
    double tugas, uts, uas;
    double nilaiAkhir;

    public Nilai12(Mahasiswa12 mhs, MataKuliah12 mk, double tugas, double uts, double uas) {
        this.mhs = mhs;
        this.mk = mk;
        this.tugas = tugas;
        this.uts = uts;
        this.uas = uas;
        hitungNilaiAkhir();
    }

    void hitungNilaiAkhir() {
        nilaiAkhir = tugas * 0.3 + uts * 0.3 + uas * 0.4;
    }

    public void tampilkan() {
        System.out.println(" " + mhs.nama + " | " + mk.nama + " | Nilai Akhir: " + nilaiAkhir);
    }

}
