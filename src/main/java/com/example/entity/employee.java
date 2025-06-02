package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String email;
    private String phone;
    private String status;

    public employee() {
    }

    public employee( String fullName, String email, String phone,String status ) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.status=status;
    }
}
