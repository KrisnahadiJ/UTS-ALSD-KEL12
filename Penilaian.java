class Penilaian {
    private Mahasiswa mahasiswa;
    private MataKuliah mataKuliah;
    private double nilaiTugas, nilaiUTS, nilaiUAS, nilaiAkhir;

    public Penilaian(Mahasiswa mahasiswa, MataKuliah mataKuliah, double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
        hitungNilaiAkhir();
    }

    public Mahasiswa getMahasiswa() { return mahasiswa; }
    public MataKuliah getMataKuliah() { return mataKuliah; }
    public double getNilaiAkhir() { return nilaiAkhir; }

    private void hitungNilaiAkhir() {
        nilaiAkhir = (nilaiTugas * 0.3) + (nilaiUTS * 0.3) + (nilaiUAS * 0.4);
    }
}