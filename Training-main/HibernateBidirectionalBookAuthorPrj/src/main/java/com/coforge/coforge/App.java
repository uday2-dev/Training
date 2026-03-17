package com.coforge.coforge;

import com.coforg.dao.AuthorDao;
import com.coforg.dao.BookDao;
import com.coforg.entities.Author;
import com.coforg.entities.Book;
import com.coforge.Util.HibernateUtil;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthorDao authorDao = new AuthorDao();
        BookDao bookDao = new BookDao();

        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Create author");
            System.out.println("2. List authors");
            System.out.println("3. List books");
            System.out.println("4. Remove book from author");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String line = scanner.nextLine().trim();
            int choice = -1;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Author name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Author city: ");
                    String city = scanner.nextLine().trim();
                    Author author = new Author(name, city);

                    System.out.print("How many books to add (0 for none): ");
                    String nb = scanner.nextLine().trim();
                    int n = 0;
                    try {
                        n = Integer.parseInt(nb);
                    } catch (NumberFormatException e) {
                        n = 0;
                    }
                    for (int i = 0; i < n; i++) {
                        System.out.print("Book title: ");
                        String title = scanner.nextLine().trim();
                        System.out.print("Book price (integer): ");
                        int price = 0;
                        try {
                            price = Integer.parseInt(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            price = 0;
                        }
                        author.addBook(new Book(title, price));
                    }

                    authorDao.saveAuthor(author);
                    System.out.println("Author saved.");
                    break;

                case 2:
                    System.out.println("Authors INFO");
                    authorDao.getAllAuthors();
                    break;

                case 3:
                    System.out.println("Book info");
                    bookDao.getAll();
                    break;

                case 4:
                    System.out.print("Author id: ");
                    int authorId = 0;
                    try {
                        authorId = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid author id.");
                        break;
                    }
                    System.out.print("Book id to remove: ");
                    int bookId = 0;
                    try {
                        bookId = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid book id.");
                        break;
                    }
                    authorDao.removeBookFromAuthor(authorId, bookId);
                    System.out.println("Removal attempted (check logs/output).");
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Unknown option.");
            }
        }

        scanner.close();

        // Close Hibernate SessionFactory and cleanup MySQL abandoned-connection threads
        try {
            if (HibernateUtil.getSessionFactory() != null) {
                HibernateUtil.getSessionFactory().close();
            }
        } catch (Exception e) {
            // ignore
        }

        try {
            // This ensures MySQL's abandoned-connection-cleanup thread is stopped (connector/j)
            com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (Throwable t) {
            // ignore if not present or already shutdown
        }
    }
}
