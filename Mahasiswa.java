class Mahasiswa {
    private String NIM, nama, prodi;

    public Mahasiswa(String NIM, String nama, String prodi) {
        this.NIM = NIM;
        this.nama = nama;
        this.prodi = prodi;
    }

    public String getNIM() { return NIM; }
    public String getNama() { return nama; }
    public String getProdi() { return prodi; }
}