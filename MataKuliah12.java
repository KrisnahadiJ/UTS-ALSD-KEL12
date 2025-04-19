public class MataKuliah12 {
    String kode;
    String nama;
    int sks;
    
    public MataKuliah12(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }
    
    public void tampilkan() {
        System.out.println("Kode MK: " + kode + " | Nama MK: " + nama + " | SKS: " + sks);
    }
}
