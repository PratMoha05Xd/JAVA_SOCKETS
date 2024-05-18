package mohamed.jellal.dam.mp09.uf03.a01.view;

import java.util.Scanner;
import mohamed.jellal.dam.mp09.uf03.a01.domain.Book;

public class BookView {

	public Book getBook() {

		System.out.println("Demanant dades del llibre ...");
		Book book = new Book();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Title:");
		book.setTitle(scanner.nextLine());

		System.out.println("Author:");
		book.setAuthor(scanner.nextLine());

		scanner.close();
		return book;

	}

}
