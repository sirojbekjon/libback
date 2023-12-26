package com.example.library.entity.template;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
@Data
public abstract class AbstractEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @JsonIgnore
    @Column(nullable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;

}
