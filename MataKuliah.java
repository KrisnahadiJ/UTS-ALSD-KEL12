class MataKuliah {
    private String kodeMK, namaMK;
    private int sks;

    public MataKuliah(String kodeMK, String namaMK, int sks) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
    }

    public String getKodeMK() { return kodeMK; }
    public String getNamaMK() { return namaMK; }
    public int getSks() { return sks; }
}