
import java.util.ArrayList;
import java.util.List;

public class RepositoryBook {
    private List<Author> authors;
    private List<Novelis> novelists;
    private List<Mangaka> mangakas;
    private List<EBook> ebooks;
    private List<Novel> novels;
    private List<Comic> comics;
    private List<Publisher> publishers;

    public RepositoryBook() {
        authors = new ArrayList<>();
        novelists = new ArrayList<>();
        mangakas = new ArrayList<>();
        ebooks = new ArrayList<>();
        novels = new ArrayList<>();
        comics = new ArrayList<>();
        publishers = new ArrayList<>();

        populateData();
    }

    private void populateData() {
        authors.add(new Author("Haidar", "Musyafa", "Indonesia", 30));
        authors.add(new Author("Bert", "Bates", "United States", 50));
        authors.add(new Author("Barry", "Burd", "United States", 52));
        authors.add(new Author("Mark", "Manson", "United States", 38));
        authors.add(new Author("Andi", "Susanto", "Indonesia", 32));
        authors.add(new Author("Adi", "Sutanto", "Indonesia", 27));

        novelists.add(new Novelis("J.K", "Rowling", "England", 57, true, "Best Seller"));
        novelists.add(new Novelis("Tere", "Liye", "Indonesia", 35, true, "Best Seller"));
        novelists.add(new Novelis("Dee", "Lestari", "Indonesia", 30, true, "Good"));
        novelists.add(new Novelis("Faisal", "Syahreza", "Indonesia", 40, true, "New Comer"));
        novelists.add(new Novelis("Julia", "Golding", "England", 41, false, "Best Seller"));

        mangakas.add(new Mangaka("Masashi", "Kisimoto", "Japan", 48, "Best Seller"));
        mangakas.add(new Mangaka("Yoshihiro", "Togashi", "Japan", 56, "Good"));
        mangakas.add(new Mangaka("Eiichiro", "Oda", "Japan", 57, "Best Seller"));
        mangakas.add(new Mangaka("Rizki", "Anwar", "Indonesia", 25, "New Comer"));
        mangakas.add(new Mangaka("Yusuf", "Fadli", "Indonesia", 32, "New Comer"));

        publishers.add(new Publisher("Bloomsbury", "United Kingdom", 30.0));
        publishers.add(new Publisher("Gramedia", "Indonesia", 50.0));
        publishers.add(new Publisher("Mizan", "Indonesia", 25.0));
        publishers.add(new Publisher("Shueisha", "Japan", 25.0));
        publishers.add(new Publisher("Elex Media Komputindo", "Indonesia", 12.0));
        publishers.add(new Publisher("Gramedia Pustaka Utama", "Indonesia", 15.0));
        publishers.add(new Publisher("Lion Hudson", "England", 15.0));
        publishers.add(new Publisher("O Reilly Media", "United States", 30.0));
        publishers.add(new Publisher("Harper One", "United States", 25.0));

        ebooks.add(new EBook("Book - 001", "Memahami Hamka", authors.get(0), publishers.get(2)));
        ebooks.add(new EBook("Book - 002", "Head First Java: Your Brain on Java - A Learner's Guide", authors.get(1), publishers.get(7)));
        ebooks.add(new EBook("Book - 003", "Java For Dummies", authors.get(2), publishers.get(7)));
        ebooks.add(new EBook("Book - 004", "Flutter For Dummies", authors.get(2), publishers.get(7)));
        ebooks.add(new EBook("Book - 005", "The Subtle Art of Not Giving", authors.get(3), publishers.get(8)));
        ebooks.add(new EBook("Book - 006", "Will", authors.get(3), publishers.get(8)));
        ebooks.add(new EBook("Book - 007", "Sejarah Indonesia", authors.get(4), publishers.get(5)));
        ebooks.add(new EBook("Book - 008", "Teknologi Baru", authors.get(5), publishers.get(4)));

        novels.add(new Novel("Novel - 001", "Harry Potter and the Philosopher's Stone", novelists.get(0), publishers.get(0), "Fantasy"));
        novels.add(new Novel("Novel - 002", "Harry Potter and the Chamber of Secrets", novelists.get(0), publishers.get(0), "Fantasy"));
        novels.add(new Novel("Novel - 003", "Harry Potter and the Prisoner of Azkaban", novelists.get(0), publishers.get(0), "Fantasy"));
        novels.add(new Novel("Novel - 004", "Ayah Aku Berbeda", novelists.get(1), publishers.get(1), "Drama"));
        novels.add(new Novel("Novel - 005", "Madre", novelists.get(2), publishers.get(1), "Drama"));
        novels.add(new Novel("Novel - 006", "Lagu untuk Renjana", novelists.get(3), publishers.get(2), "Drama"));
        novels.add(new Novel("Novel - 007", "Semoga Lekas Lega", novelists.get(3), publishers.get(2), "Drama"));
        novels.add(new Novel("Novel - 008", "The Abbey Mystery", novelists.get(4), publishers.get(6), "Fiction"));

        comics.add(new Comic("Comic - 001", "Uzumaki Naruto", mangakas.get(0), publishers.get(3), true));
        comics.add(new Comic("Comic - 002", "The Worst Client", mangakas.get(0), publishers.get(3), true));
        comics.add(new Comic("Comic - 003", "For the Sake of Dreams...!!", mangakas.get(0), publishers.get(3), true));
        comics.add(new Comic("Comic - 004", "Hunter X Hunter : The Day of Departure", mangakas.get(1), publishers.get(3), true));
        comics.add(new Comic("Comic - 005", "Hunter X Hunter : A Struggle in the Mist", mangakas.get(1), publishers.get(3), true));
        comics.add(new Comic("Comic - 006", "One Piece", mangakas.get(2), publishers.get(1), true));
        comics.add(new Comic("Comic - 007", "Petualangan di Indonesia", mangakas.get(3), publishers.get(5), false));
        comics.add(new Comic("Comic - 008", "Petualangan di Jakarta", mangakas.get(4), publishers.get(4), false));
    }

    public List<Author> getAuthors() {
        return new ArrayList<>(authors);
    }

    public List<Novelis> getNovelists() {
        return new ArrayList<>(novelists);
    }

    public List<Mangaka> getMangakas() {
        return new ArrayList<>(mangakas);
    }

    public List<EBook> getEbooks() {
        return new ArrayList<>(ebooks);
    }

    public List<Novel> getNovels() {
        return new ArrayList<>(novels);
    }

    public List<Comic> getComics() {
        return new ArrayList<>(comics);
    }

    public List<Publisher> getPublishers() {
        return new ArrayList<>(publishers);
    }

    public List<CommercialBook> getAllBooks() {
        List<CommercialBook> allBooks = new ArrayList<>();
        allBooks.addAll(ebooks);
        allBooks.addAll(novels);
        allBooks.addAll(comics);
        return allBooks;
    }
    
    public void displayAllBooks() {
        List<CommercialBook> allBooks = getAllBooks();

        for (CommercialBook book : allBooks) {
            System.out.println(book.toString());
        }
    }
    
    public List<Author> getAllAuthors() {
        List<Author> allAuthors = new ArrayList<>();
        allAuthors.addAll(authors);
        allAuthors.addAll(novelists);
        allAuthors.addAll(mangakas);
        return allAuthors;
    }
    
    public List<Author> getAuthorsByType(Class<? extends Author> type) {
        List<Author> filteredAuthors = new ArrayList<>();

        for (Author author : authors) {
            if (type.isInstance(author)) {
                filteredAuthors.add(author);
            }
        }

        return filteredAuthors;
    }

    public void displayAllAuthors() {
        List<Author> allAuthors = getAllAuthors();

        for (Author author : allAuthors) {
            System.out.println(author.toString());
        }
    }

    public Publisher getPublisherWithMaxProductionCost() {
        if (publishers == null || publishers.isEmpty()) {
            return null;
        }

        Publisher maxCostPublisher = publishers.get(0);

        for (Publisher publisher : publishers) {
            if (publisher.getProductionCost() > maxCostPublisher.getProductionCost()) {
                maxCostPublisher = publisher;
            }
        }

        return maxCostPublisher;
    }

    public Publisher getPublisherWithMinProductionCost() {
        if (publishers == null || publishers.isEmpty()) {
            return null;
        }

        Publisher minCostPublisher = publishers.get(0);

        for (Publisher publisher : publishers) {
            if (publisher.getProductionCost() < minCostPublisher.getProductionCost()) {
                minCostPublisher = publisher;
            }
        }

        return minCostPublisher;
    }
}