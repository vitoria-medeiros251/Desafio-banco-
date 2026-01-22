package com.picpaysimplificado.domain.user;
import com.picpaysimplificado.dtos.UserDto;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@Entity(name = "users")
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class
 User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDto data) {
        this.name = data.name();
        this.firstname = data.firstname();
        this.lastname = data.lastname();
        this.document = data.document();
        this.email = data.email();
        this.password = data.password();
        this.balance = data.balance();
        this.userType = data.userType();
    }


}

