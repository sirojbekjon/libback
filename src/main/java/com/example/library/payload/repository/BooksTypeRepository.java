package com.example.library.payload.repository;

import com.example.library.entity.BooksType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksTypeRepository extends JpaRepository<BooksType, Long> {
    boolean existsByName(String name);
}
