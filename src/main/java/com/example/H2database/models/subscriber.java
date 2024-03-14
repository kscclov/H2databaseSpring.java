package com.example.H2database.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Entity
    @Table(name = "subscriber")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class subscriber {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "email")
        private String email;
        @Column(name = "jobTitlesub")
        private String jobTitlesub;
        @Column(name = "name")
        private String name;
        @Column(name = "city")
        private String city;
    }
