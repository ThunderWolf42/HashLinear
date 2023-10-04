public class ContohHashLinear {
    public static void main(String[] args) {

        HashLinear tabel = new HashLinear(11);

        tabel.insert(12, "Lila");
        tabel.insert(13, "Lala");
        tabel.insert(16, "Lulu");
        tabel.insert(17, "Lula");
        tabel.insert(20, "Lalu");

        System.out.println("Keadaan Awal: ");
        tabel.display();

        tabel.insert(23, "Didi");
        tabel.insert(45, "Dudi");
        tabel.insert(23, "Dadi");

        System.out.println("Setelah Ditambah: ");
        tabel.display();

        System.out.println("NIP 17: " + tabel.find(17));
        System.out.println("NIP 48: " + tabel.find(48));

        tabel.remove(17);
        System.out.println("Keadaan setelah NIP 17 dihapus: ");
        tabel.display();
    }
}

