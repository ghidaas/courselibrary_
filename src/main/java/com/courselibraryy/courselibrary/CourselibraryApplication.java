package com.courselibraryy.courselibrary;

import com.courselibraryy.courselibrary.entity.Author;
import com.courselibraryy.courselibrary.entity.Book;
import com.courselibraryy.courselibrary.entity.Category;
import com.courselibraryy.courselibrary.entity.Publishers;
import com.courselibraryy.courselibrary.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Flow;
@SpringBootApplication
public class CourselibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourselibraryApplication.class, args);
	}
	@Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return (args) -> {
			Book book1 = new Book("ABC", "Book name", "My first book");
			Author author1 = new Author("Test name1", "Test description");
			Category category1 = new Category("Business books");
			Publishers publisher1 = new Publishers("First Publisher");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("ABC1", "Book name", "My first book");
			Author author2 = new Author("Test name2", "Test description");
			Category category2 = new Category("Science books");
			Publishers publisher2 = new Publishers("Second Publisher");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);

			Book book3 = new Book("ABC21", "Book name", "My first book");
			Author author3 = new Author("Test name3", "Test description");
			Category category3 = new Category("Fiction books");
			Publishers publisher3 = new Publishers("Third Publisher");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);
		};
   }
}
