class DataHash {
    public int nip;
    public String nama;

    public DataHash (int nip, String nama) {
        //(konstruktor)//
        this.nip = nip;
        this.nama = nama;
    }

}

class HashLinear {

    private DataHash [] data; // penyimpan data
    private int ukuranTabel;// ukuran data
    DataHash ptrTerhapus;// menunjuk ke data yang dihapus

    public HashLinear (int ukuran) {

        ukuranTabel = ukuran;
        data = new DataHash [ukuran]; //

        for (int i = 0; i < ukuran; i++) { // kosongin hash table//

            this.data[i] = null;
        }
        // tandai NIP dengan -1 untuk menyatakan terhapus
        ptrTerhapus = new DataHash (-1, " ");
    }

    // menghasilkan alamat hash berdasarkan key (NIP)
    public int hashFunction (int nip) {

        return nip % ukuranTabel;
    }
    // untuk menyisipkan data ke hash table
    public void insert(int nip, String nama) {

        int alamatHash = hashFunction (nip);
        int i = 0;
        while  ((data [alamatHash] != null) &&(data[alamatHash].nip != -1)) {

            if (i > ukuranTabel)
                break;// keluar jika penuh
            // memperoleh alamat berikutnya
            alamatHash = (alamatHash + 1) % ukuranTabel;
            i++;
        }

        if (i < ukuranTabel)
            data[alamatHash] = new DataHash (nip,nama);
    }
    // mencari data nilai balik berupa nama
    public String find (int nip) {
        int alamatHash = hashFunction (nip);
        int i = 1;

        while (data[alamatHash] != null) {

            if (i > ukuranTabel) // cek nilai field nip sama dengan nip
                break;

            if (data[alamatHash].nip == nip)// perolehan alamat berikutnya
                break;

            alamatHash = (alamatHash + 1) % ukuranTabel;
            i++;
        }

        if ((i <= ukuranTabel) &&(data [alamatHash] != null))
            return data [alamatHash].nama;

        else
            return "<Tidak Ditemukan>";

    }
    // menghasilkan false jika gagal hapus nip
    // true jika berhasil dihapus
    public boolean remove (int nip) {

        int alamatHash = hashFunction(nip);
        int i = 1;

        while (data [alamatHash] != null) {

            if (i > ukuranTabel)// cek nilai field nip sama dengan
                break;

            if (data[alamatHash].nip == nip) {
                // tandai sudah terhapus
                data[alamatHash] = ptrTerhapus;
                break;
            }
            // peroleh alamat berikutnya
            alamatHash = (alamatHash + 1) % ukuranTabel;
            i++;
        }

        if ((i < ukuranTabel) && (data[alamatHash] != null))
            return true;

        else
            return false;
    }
    // menampilkan isi hash table
    public void display() {

        for (int i = 0; i < ukuranTabel; i++) {

            if (data[i] == null)
                System.out.println (i+ ": Kosong");

            else
            if (data[i].nip == -1)
                System.out.println (i+ ":(Tehapus)");

            else
                System.out.println (i +": " +data[i].nip + "-" +data[i].nama);

        }
    }
}