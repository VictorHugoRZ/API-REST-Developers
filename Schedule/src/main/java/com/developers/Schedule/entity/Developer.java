package com.developers.Schedule.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "developers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nickname;
    private String name;
    private String phone;
    private String email;
    private List<String> languages;
    private List<String> technologies;
}
