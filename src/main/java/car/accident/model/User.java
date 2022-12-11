package car.accident.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Не должно быть пустым")
    @Size(min = 6, max = 70, message = "Имя автора должно быть от 6 до 70")
    @Column(name = "username", unique = true)
    private String username;

    @NotEmpty(message = "Не должно быть пустым")
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;

    @Column(name = "enabled")
    private boolean enabled;
}
