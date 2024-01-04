package com.example.library.repository;

import com.example.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Long> {


    boolean existsByName(String name);
}
