package com.backend.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name ="post_id")
    @JsonIgnore
    private Post post;


}
