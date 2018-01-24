package com.springwebapp.first.repositories;

import com.springwebapp.first.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
