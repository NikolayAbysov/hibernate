package com.dev.hibernate;

import com.dev.hibernate.lib.Injector;
import com.dev.hibernate.model.Author;
import com.dev.hibernate.model.Book;
import com.dev.hibernate.model.Genre;
import com.dev.hibernate.service.AuthorService;
import com.dev.hibernate.service.BookService;
import com.dev.hibernate.service.GenreService;

import java.util.List;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("com.dev.hibernate");
    private static final AuthorService authorService = (AuthorService) INJECTOR.getInstance(AuthorService.class);
    private static final BookService bookService = (BookService) INJECTOR.getInstance(BookService.class);
    private static final GenreService genreService = (GenreService) INJECTOR.getInstance(GenreService.class);

    public static void main(String[] args) {
        Author author = new Author();
        author.setName("Giovanni");
        author.setSurname("Rodari");
        authorService.add(author);

        Genre genre = new Genre();
        genre.setGenreName("Story");
        genreService.add(genre);

        Book book = new Book();
        book.setName("Cipollino");
        book.setAuthors(List.of(author));
        book.setGenre(genre);
        bookService.add(book);
    }
}
