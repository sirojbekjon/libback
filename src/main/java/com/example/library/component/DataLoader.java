package com.example.library.component;

import com.example.library.entity.Books;
import com.example.library.entity.BooksType;
import com.example.library.entity.Library;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BooksTypeRepository;
import com.example.library.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {



    @Value("${spring.datasource.initalization-mode}")
    public String initializate;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BooksTypeRepository booksTypeRepository;

    @Autowired
    LibraryRepository libraryRepository;


    @Override
    public void run(String... args){
        if (initializate.equals("always")){

            Library library1 = new Library();
            Library library2 = new Library();
            Library library3 = new Library();

            library1.setName("Alisher Navoiy");
            library2.setName("Beruniy Nomidagi");
            library3.setName("Hamza Nomidagi");

            Library library01 = libraryRepository.save(library1);
            Library library02 = libraryRepository.save(library2);
            Library library03 = libraryRepository.save(library3);

            BooksType booksType1 = new BooksType("Milliy kitoblar", library01);
            BooksType booksType2 = new BooksType("Tarixiy kitoblar", library02);
            BooksType booksType3 = new BooksType("Zamonaviy kitoblar", library03);

            BooksType booksType01 = booksTypeRepository.save(booksType1);
            BooksType booksType02 = booksTypeRepository.save(booksType2);
            BooksType booksType03 = booksTypeRepository.save(booksType3);

            Books books1 = new Books("Hamsa","Alisher Navoiy",1457,501,booksType01);
            Books books2 = new Books("Yoshlik","Shavqiddin Muxtorof",1997,300,booksType01);
            Books books3 = new Books("Nimadir","Berdaq",2003,432,booksType02);
            Books books4 = new Books("Urush kunlari","Cho'lpon",1887,234,booksType02);
            Books books5 = new Books("Devops kursi","Abdulqodir Yusupov",2022,1234,booksType03);
            Books books6 = new Books("IT sohasi","Kimdir",1887,234,booksType03);

            bookRepository.save(books1);
            bookRepository.save(books2);
            bookRepository.save(books3);
            bookRepository.save(books4);
            bookRepository.save(books5);
            bookRepository.save(books6);
        }
    }
}




