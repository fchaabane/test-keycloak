package test.keycloak.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import test.keycloak.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {

	@Override
	public List<Book> findAll() {
		return Arrays.asList(new Book("1", "Spring basics", "FCH"), new Book("2", "Keycloak basics", "FCH"));
	}

}
