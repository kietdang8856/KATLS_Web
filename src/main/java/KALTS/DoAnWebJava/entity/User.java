package KALTS.DoAnWebJava.entity;

import KALTS.DoAnWebJava.Validator.annotation.ValidUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50, unique = true, nullable = false)
    @NotBlank(message = "Username is required")
    @Size(min = 1, max = 50, message = "Username must be between 1 and 50 characters")
    @ValidUsername
    private String username;

    @Column(name = "password", length = 250, nullable = false)
    @NotBlank(message = "Password is required")
    private String password;

    @Column(name = "email", length = 50)
    @Size(max = 50, message = "Email must be less than 50 characters")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "name", length = 50, nullable = false)
    @NotBlank(message = "Your name is required")
    @Size(max = 50, message = "Your name must be less than 50 characters")
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();

}
