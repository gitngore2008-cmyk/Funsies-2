import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int ID;
    private String Title_and_Author;
    private boolean isAvailiable;

    public Book(int I, String TA) {
        this.ID = I;
        this.Title_and_Author = TA;
        this.isAvailiable = true;
    }

    public int getID() {
        return ID;
    }

    public String getTA() {
        return Title_and_Author;
    }

    public boolean getIA() {
        return isAvailiable;
    }

    public void setIA(boolean bool) {
        this.isAvailiable = bool;
    }

    @Override
    public String toString() {
        return "ID: " + getID() + " | Title: " + getTA() + " | Available: " + getIA();
    }
}

class Members {
    int Mid;
    String MN;
    private ArrayList<Book> Mbook = new ArrayList<>();

    public Members(int MID, String Mebname) {
        this.MN = Mebname;
        this.Mid = MID;
    }

    public String getMN() {
        return MN;
    }

    public int getID() {
        return Mid;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return Mbook;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Members> sewed = new ArrayList<>();

    private Members findMemID(int id) {
        return sewed.stream().filter(book -> book.getID() == id).findFirst().orElse(null);
    }

    private Book findID(int id) {
        return books.stream().filter(book -> book.getID() == id).findFirst().orElse(null);
    }

    public void rembook(int id) {
        if (findID(id) != null) {
            books.remove(findID(id));
            System.out.println("succesfully removed");
        } else {
            System.out.println("not availiable");
        }
    }

    public void addMember(int id, String name) {
        Members member = new Members(id, name);
        sewed.add(member);
        System.out.println("member added succesfully______");
    }

    public void Display() {
        books.forEach(System.out::println);
    }

    public void searchbook(String str) {
        System.out.println(books.stream().filter(book -> book.getTA().equalsIgnoreCase(str)).findFirst().orElse(null));
    }

    public void borrowedBook(int memberID, int bookID) {
        Book book = findID(bookID);
        Members members = findMemID(memberID);
        if (book == null || members == null) {
            System.out.println("member or book not found");
            return;

        }
        if (!book.getIA()) {
            System.out.println("already bowwowed");
            return;
        }
        book.setIA(false);
        members.getBorrowedBooks().add(book);
        System.out.println("book borrowed succesfully");

    }

    public void returnBook(int memberID, int bookID) {
        Book boo = findID(bookID);
        Members members = findMemID(memberID);
        if (boo == null || members == null) {
            System.out.println("member or book not found");
            return;
        }
        if (boo.getIA()) {
            System.out.println("not borrowed anytime");
            return;
        }
        boo.setIA(true);
        members.getBorrowedBooks().remove(boo);
        System.out.println("succesfully returned");
    }

    public void addbook(int id, String dtr) {
        Book prod = new Book(id, dtr);
        books.add(prod);
    }
}

public class main {

    public static void main(String[] args) {
        
        System.out.println("------------------hello there----------------");
        System.out.println("-----enter the number written beside the choice-----");
        System.out.println("1. Add Book\n" +
                "2. Remove Book\n" +
                "3. Display Books\n" +
                "4. Borrow Book\n" +
                "5. Return Book\n" +
                "6. Search Book\n" +
                 "7. Add member\n" +
                "8. Exit\n" +
                "Enter choice:");
                Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter the details such as id,author_title,follow the format for author and title");
                    
                    System.out.println("enter id");
                    int idfetcher = sc.nextInt();
                    sc.nextLine();
                    System.out.println("enter title_author like this");
                    String TAfetcher = sc.nextLine();
                    lib.addbook(idfetcher, TAfetcher);
                    System.out.println("bookd added alonwith id succesfully");
                    break;
                case 2:
                    System.out.println("enter the id first");
                    
                    int fetcher = sc.nextInt();
                    lib.rembook(fetcher);

                    break;
                case 3:
                    System.out.println("-----------query intaken-----------");
                    System.out.println("---fetching routes------");
                    
                    lib.Display();
                    break;
                case 4:
                    System.out.println("enter member id and book id first");
                    System.out.println("enter memberID");
                    int revert =  sc.nextInt();

                    System.out.println("enter bookid");
                    int usop = sc.nextInt();
                    
                    lib.borrowedBook(revert,usop);

                    break;
                case 5:
                    System.out.println("enter member id");
                    int coor = sc.nextInt();
                    System.out.println("enter bookid");
                    int reverter = sc.nextInt();
                    
                    lib.returnBook(coor, reverter);
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("enter your book title");
                    
                    String hfer = sc.nextLine();
                    lib.searchbook(hfer);
                    break;
                case 7:
                    System.out.println("enter member id");
                    int mid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("enter member name");
                    String mn = sc.nextLine();
                    lib.addMember(mid, mn);

                case 8:
    
                    System.out.println("Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}