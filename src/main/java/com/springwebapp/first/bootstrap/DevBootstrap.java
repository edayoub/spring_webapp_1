package com.springwebapp.first.bootstrap;

import com.springwebapp.first.models.Author;
import com.springwebapp.first.models.Book;
import com.springwebapp.first.models.Publisher;
import com.springwebapp.first.repositories.AuthorRepository;
import com.springwebapp.first.repositories.BookRepository;
import com.springwebapp.first.repositories.PublisherRepository;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap  implements ApplicationListener<ContextRefreshedEvent>{
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
    }
    private void initData(){
        Author eric =new Author("eric","evans");
        Publisher publisher1= new Publisher("harper collins","publisher1@email.com");
        Book  ddd=new Book("Domaine Driven Designe ","123",publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        publisherRepository.save(publisher1);
        bookRepository.save(ddd);


        Author rod =new Author("rod","johnson");
        Publisher publisher2= new Publisher("Worx","publisher@email.com");
        Book  noEJB=new Book("j2E ","23444",publisher2);
        eric.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(publisher2);
        bookRepository.save(noEJB);

    }


}
