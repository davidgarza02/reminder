package com.bill.remind.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Getter
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String fullName;
    @NonNull
    private String username;
    @NonNull
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private Set<Bill> bills = new HashSet<>();

}
