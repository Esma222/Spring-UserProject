package com.esmabeydili.backend2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")//database ile iletişim için //h2 Console
public class User {

    @Id//jakarta persistencedan cekecek
    @GeneratedValue(strategy = GenerationType.IDENTITY)//otomatik artan Id değeri
    private Long id;

    @Column(name = "user_name",nullable = false,length = 50,unique = true)
    private String  username;

    @Column(name = "firstName", nullable = false,length = 50)
    private String firstName;

    @Column(name = "secondName", nullable = false,length = 50)
    private String secondName;

    public User(String username,String firstName, String secondName) {
        this.username=username;
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
