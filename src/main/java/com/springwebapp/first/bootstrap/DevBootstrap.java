package com.springwebapp.first.bootstrap;

import com.springwebapp.first.models.Author;
import com.springwebapp.first.models.Book;
import com.springwebapp.first.repositories.AuthorRepository;
import com.springwebapp.first.repositories.BookRepository;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent>{
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
    }
    private void initData(){
        Author eric =new Author("eric","evans");
        Book  ddd=new Book("Domaine Driven Designe ","123","harper collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod =new Author("rod","johnson");
        Book  noEJB=new Book("j2E ","23444","Worx");
        eric.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }


}
