public class Mahasiswa12 {
    String nim;
    String nama;
    String prodi;
    
    public Mahasiswa12(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    public void tampilkan() {
        System.out.println("NIM: " + nim + " | Nama: " + nama + " | Prodi: " + prodi);
    }
}
