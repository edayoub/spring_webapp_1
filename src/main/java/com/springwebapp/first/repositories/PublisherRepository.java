package com.springwebapp.first.repositories;

import com.springwebapp.first.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
