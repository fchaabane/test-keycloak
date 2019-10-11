package test.keycloak.repository;

import java.util.List;

import test.keycloak.model.Book;

public interface BookRepository {

	List<Book> findAll();
}
