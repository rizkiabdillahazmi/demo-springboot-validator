package com.rizkiaazmi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Rizki Abdillah Azmi on 20-Jan-23
 */

@Entity
@Table(name = "tbl_members")
@Data
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number", length = 5, nullable = false, unique = true)
    private String memberNumber;
    @Column(name = "name", length = 150, nullable = false)
    private String memberName;
    @Column(name = "email", length = 150, nullable = false, unique = true)
    private String memberEmail;
    @Column(name = "password", length = 100, nullable = false)
    private String memberPassword;
}
