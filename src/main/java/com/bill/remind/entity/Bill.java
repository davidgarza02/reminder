package com.bill.remind.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name = "bills")
@Getter
@Setter
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    @NonNull
    private String name;
    @NonNull
    private Double amount;
    @NonNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
    private LocalDate dueDate;
    @NonNull
    private Integer repeat;
    private String notes;
    @NonNull
    private boolean isDeleted = false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="member_id", referencedColumnName = "id")
    private Member member;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public void assignMember(Member member) {
        this.member = member;
    }
    public void assignCategory(Category category) {
        this.category = category;
    }
}
