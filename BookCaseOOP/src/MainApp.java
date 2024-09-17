import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp {
    private static RepositoryBook repositoryBook = new RepositoryBook();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<CommercialBook> commercialBookList = repositoryBook.getAllBooks();
        List<Author> authorsList = repositoryBook.getAllAuthors();
        List<Publisher> publisherList = repositoryBook.getPublishers();

        while (true) {
            tampilkanMenuUtama();
            int menuUtama = Integer.valueOf(scanner.nextLine());

            switch (menuUtama) {
                case 1:
                    handleMenuBuku(commercialBookList);
                    break;
                case 2:
                    handleMenuPenulis(authorsList);
                    break;
                case 3:
                    handleMenuPenerbit(publisherList);
                    break;
                case 0:
                    System.out.println("Keluar dari program. Sampai jumpa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Mohon masukkan opsi yang benar.");
            }
        }
    }

    private static void tampilkanMenuUtama() {
        System.out.println("\nMenu Utama");
        System.out.println("1. Buku");
        System.out.println("2. Penulis");
        System.out.println("3. Penerbit");
        System.out.println("0. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
    }

    private static void handleMenuBuku(List<CommercialBook> commercialBookList) {
        while (true) {
            tampilkanMenuBuku();
            int menuBuku = Integer.valueOf(scanner.nextLine());
            
            switch (menuBuku) {
                case 1:
                    cariBukuTermurah(commercialBookList);
                    break;
                case 2:
                    cariBukuTermahal(commercialBookList);
                    break;
                case 3:
                    cariBukuBerdasarkanRentangHarga(commercialBookList);
                    break;
                case 4:
                    cariKomikBerdasarkanRatingMangaka(commercialBookList);
                    break;
                case 5:
                    cariBukuBerdasarkanNegaraPublisher(commercialBookList);
                    break;
                case 6:
                    cariBukuBerdasarkanNegaraPenulis(commercialBookList);
                    break;
                case 7:
                    cariComicTermahal(commercialBookList);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Mohon masukkan opsi yang benar.");
            }
        }
    }

    private static void tampilkanMenuBuku() {
        System.out.println("\nMenu Pencarian Buku");
        System.out.println("1. Cari buku yang termurah");
        System.out.println("2. Cari buku yang termahal");
        System.out.println("3. Cari buku berdasarkan rentang harga");
        System.out.println("4. Cari komik berdasarkan rating mangaka");
        System.out.println("5. Cari buku berdasarkan negara penerbit");
        System.out.println("6. Cari buku berdasarkan negara penulis");
        System.out.println("7. Cari komik yang termahal");
        System.out.println("0. Kembali ke Menu Utama");
        System.out.print("Masukkan pilihan Anda: ");
    }

    private static void cariBukuTermurah(List<CommercialBook> commercialBookList) {
        if (commercialBookList.isEmpty()) {
            System.out.println("Tidak ada buku yang tersedia.");
            return;
        }

        CommercialBook bukuTermurah = commercialBookList.stream()
                .min(Comparator.comparingDouble(CommercialBook::getPrice))
                .orElse(null);

        if (bukuTermurah != null) {
            System.out.println("Buku Termurah: " + bukuTermurah);
        } else {
            System.out.println("Tidak ada buku yang tersedia.");
        }
    }

    private static void cariBukuTermahal(List<CommercialBook> commercialBookList) {
        if (commercialBookList.isEmpty()) {
            System.out.println("Tidak ada buku yang tersedia.");
            return;
        }

        CommercialBook bukuTermahal = commercialBookList.stream()
                .max(Comparator.comparingDouble(CommercialBook::getPrice))
                .orElse(null);

        if (bukuTermahal != null) {
            System.out.println("Buku Termahal: " + bukuTermahal);
        } else {
            System.out.println("Tidak ada buku yang tersedia.");
        }
    }

    private static void cariBukuBerdasarkanRentangHarga(List<CommercialBook> commercialBookList) {
        if (commercialBookList.isEmpty()) {
            System.out.println("Tidak ada buku yang tersedia.");
            return;
        }

        System.out.print("Masukkan harga minimum: ");
        double hargaMin = Double.valueOf(scanner.nextLine());

        System.out.print("Masukkan harga maksimum: ");
        double hargaMax = Double.valueOf(scanner.nextLine());

        List<CommercialBook> bukuDalamRentang = commercialBookList.stream()
                .filter(buku -> buku.getPrice() >= hargaMin && buku.getPrice() <= hargaMax)
                .toList();

        if (bukuDalamRentang.isEmpty()) {
            System.out.println("Tidak ada buku dalam rentang harga yang dimasukkan.");
        } else {
            System.out.println("Buku dalam rentang harga:");
            bukuDalamRentang.forEach(buku -> System.out.println(buku));
        }
    }

    private static void cariKomikBerdasarkanRatingMangaka(List<CommercialBook> commercialBookList) {
        if (commercialBookList.isEmpty()) {
            System.out.println("Tidak ada buku yang tersedia.");
            return;
        }

        System.out.print("Masukkan jenis rating mangaka (Best Seller/Good/New Comer): ");
        String ratingMangakaInput = scanner.nextLine().toLowerCase();

        List<CommercialBook> komikBerdasarkanRatingMangaka = commercialBookList.stream()
                .filter(buku -> buku.getAuthor() instanceof Mangaka &&
                        ((Mangaka) buku.getAuthor()).getRating().equalsIgnoreCase(ratingMangakaInput))
                .toList();

        if (komikBerdasarkanRatingMangaka.isEmpty()) {
            System.out.println("Tidak ada buku dengan rating Mangaka jenis " + ratingMangakaInput);
        } else {
            System.out.println("Buku dengan rating Mangaka jenis " + ratingMangakaInput + ":");
            komikBerdasarkanRatingMangaka.forEach(buku -> System.out.println(buku));
        }
    }

    private static void cariBukuBerdasarkanNegaraPublisher(List<CommercialBook> commercialBookList) {
        if (commercialBookList.isEmpty()) {
            System.out.println("Tidak ada buku yang tersedia.");
            return;
        }

        System.out.print("Masukkan negara penerbit: ");
        String negaraPenerbit = scanner.nextLine();

        List<CommercialBook> bukuBerdasarkanNegaraPenerbit = commercialBookList.stream()
                .filter(buku -> buku.getPublisher() != null &&
                        buku.getPublisher().getCountry().equalsIgnoreCase(negaraPenerbit))
                .toList();

        if (bukuBerdasarkanNegaraPenerbit.isEmpty()) {
            System.out.println("Tidak ada buku yang diterbitkan oleh penerbit dari negara tersebut.");
        } else {
            System.out.println("Buku diterbitkan oleh penerbit dari negara " + negaraPenerbit + ":");
            bukuBerdasarkanNegaraPenerbit.forEach(buku -> System.out.println(buku));
        }
    }

    private static void cariBukuBerdasarkanNegaraPenulis(List<CommercialBook> commercialBookList) {
        if (commercialBookList.isEmpty()) {
            System.out.println("Tidak ada buku yang tersedia.");
            return;
        }

        System.out.print("Masukkan negara penulis: ");
        String negaraPenulis = scanner.nextLine();

        List<CommercialBook> bukuBerdasarkanNegaraPenulis = commercialBookList.stream()
                .filter(buku -> buku.getAuthor() != null &&
                        buku.getAuthor().getCountry().equalsIgnoreCase(negaraPenulis))
                .toList();

        if (bukuBerdasarkanNegaraPenulis.isEmpty()) {
            System.out.println("Tidak ada buku yang ditulis oleh penulis dari negara tersebut.");
        } else {
            System.out.println("Buku oleh penulis dari negara " + negaraPenulis + ":");
            bukuBerdasarkanNegaraPenulis.forEach(buku -> System.out.println(buku));
        }
    }

    private static void cariComicTermahal(List<CommercialBook> commercialBookList) {
        List<Comic> comics = commercialBookList.stream()
                .filter(buku -> buku instanceof Comic)
                .map(buku -> (Comic) buku)
                .toList();

        if (comics.isEmpty()) {
            System.out.println("Tidak ada buku komik yang tersedia.");
            return;
        }

        Comic comicTermahal = comics.stream()
                .max(Comparator.comparingDouble(Comic::getPrice))
                .orElse(null);

        if (comicTermahal != null) {
            System.out.println("Komik Termahal: " + comicTermahal);
        } else {
            System.out.println("Tidak ada buku komik yang tersedia.");
        }
    }

    private static void handleMenuPenulis(List<Author> authorsList) {
        while (true) {
            tampilkanMenuPenulis();
            int menuPenulis = Integer.valueOf(scanner.nextLine());

            switch (menuPenulis) {
                case 1:
                    cariSemuaMangaka(authorsList);
                    break;
                case 2:
                    cariSemuaAuthor(authorsList);
                    break;
                case 3:
                    cariSemuaNovelis(authorsList);
                    break;
                case 4:
                    cariAuthorBerdasarkanRangeUmur(authorsList);
                    break;
                case 5:
                    cariAuthorBerdasarkanNegara(authorsList);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Mohon masukkan opsi yang benar.");
            }
        }
    }

    private static void tampilkanMenuPenulis() {
        System.out.println("\nMenu Pencarian Penulis");
        System.out.println("1. Cari semua Mangaka");
        System.out.println("2. Cari semua Author");
        System.out.println("3. Cari semua Novelis");
        System.out.println("4. Cari penulis berdasarkan range umur");
        System.out.println("5. Cari penulis berdasarkan negara");
        System.out.println("0. Kembali ke Menu Utama");
        System.out.print("Masukkan pilihan Anda: ");
    }

    private static void cariSemuaMangaka(List<Author> authorsList) {
        List<Author> mangakaList = getAuthorsByType(authorsList, Mangaka.class);
        tampilkanDaftarPenulis(mangakaList, "Mangaka");
    }

    private static void cariSemuaAuthor(List<Author> authorsList) {
        List<Author> filteredAuthors = authorsList.stream()
                .filter(author -> !(author instanceof Mangaka) && !(author instanceof Novelis))
                .collect(Collectors.toList());

        tampilkanDaftarPenulis(filteredAuthors, "Author");
    }

    private static void cariSemuaNovelis(List<Author> authorsList) {
        List<Author> novelisList = getAuthorsByType(authorsList, Novelis.class);
        tampilkanDaftarPenulis(novelisList, "Novelis");
    }

    private static void cariAuthorBerdasarkanRangeUmur(List<Author> authorsList) {
        System.out.print("Masukkan batas usia bawah: ");
        int batasBawah = Integer.valueOf(scanner.nextLine());

        System.out.print("Masukkan batas usia atas: ");
        int batasAtas = Integer.valueOf(scanner.nextLine());

        List<Author> authorList = getAuthorsByAgeRange(authorsList, batasBawah, batasAtas);
        tampilkanDaftarPenulis(authorList, "Author");
    }

    private static void cariAuthorBerdasarkanNegara(List<Author> authorsList) {
        System.out.print("Masukkan negara penulis: ");
        String country = scanner.nextLine();

        List<Author> authorList = getAuthorsByCountry(authorsList, country);
        tampilkanDaftarPenulis(authorList, "Author");
    }

    private static void tampilkanDaftarPenulis(List<Author> authorsList, String jenisPenulis) {
        if (authorsList.isEmpty()) {
            System.out.println("Tidak ada " + jenisPenulis + " yang tersedia.");
        } else {
            System.out.println("Daftar " + jenisPenulis + ":");
            authorsList.forEach(author -> System.out.println(author));
        }
    }

    private static <T extends Author> List<Author> getAuthorsByType(List<Author> authorsList, Class<T> type) {
        return authorsList.stream()
                .filter(type::isInstance)
                .toList();
    }

    private static List<Author> getAuthorsByAgeRange(List<Author> authorsList, int batasBawah, int batasAtas) {
        return authorsList.stream()
                .filter(author -> author.getAge() >= batasBawah && author.getAge() <= batasAtas)
                .toList();
    }

    private static List<Author> getAuthorsByCountry(List<Author> authorsList, String country) {
        return authorsList.stream()
                .filter(author -> author.getCountry().equalsIgnoreCase(country))
                .toList();
    }

    private static void handleMenuPenerbit(List<Publisher> publisherList) {
        while (true) {
            tampilkanMenuPublisher();
            int menuPublisher = Integer.valueOf(scanner.nextLine());

            switch (menuPublisher) {
                case 1:
                	cariPublisherTermahal(publisherList);
                    break;
                case 2:
                	cariPublisherTermurah(publisherList);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void cariPublisherTermurah(List<Publisher> publisherList) {
        if (publisherList.isEmpty()) {
            System.out.println("Tidak ada publisher yang tersedia.");
            return;
        }

        Publisher termurah = publisherList.stream()
                .min(Comparator.comparingDouble(Publisher::getProductionCost))
                .orElse(null);

        if (termurah != null) {
            System.out.println("Publisher Termurah: " + termurah);
        } else {
            System.out.println("Tidak ada data Publisher.");
        }
    }

    private static void cariPublisherTermahal(List<Publisher> publisherList) {
        if (publisherList.isEmpty()) {
            System.out.println("Tidak ada publisher yang tersedia.");
            return;
        }

        Publisher termahal = publisherList.stream()
                .max(Comparator.comparingDouble(Publisher::getProductionCost))
                .orElse(null);

        if (termahal != null) {
            System.out.println("Publisher Termahal: " + termahal);
        } else {
            System.out.println("Tidak ada data Publisher.");
        }
    }

	private static void tampilkanMenuPublisher() {
        System.out.println("\nPublisher Menu");
        System.out.println("1. Cari Publisher dengan productionCost paling mahal");
        System.out.println("2. Cari Publisher dengan productionCost paling murah");
        System.out.println("0. Back to Main Menu");
        System.out.print("Masukkan pilihan Anda: ");
    }


    public static RepositoryBook getRepositoryBook() {
        return repositoryBook;
    }

    public static void setRepositoryBook(RepositoryBook repositoryBook) {
        MainApp.repositoryBook = repositoryBook;
    }
}