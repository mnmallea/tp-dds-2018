package dominio;

import controllers.PasswordUtil;

import javax.persistence.*;

@Entity(name = "Usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;
    private String hashedPassword;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String password) {
        this.hashedPassword = PasswordUtil.hashPassword(password);
    }
}
