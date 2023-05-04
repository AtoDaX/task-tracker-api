package edu.pet.tasktrackerapi.api.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tt_user")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private final String username;
    @Column
    private final  String password;
    @Column
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private final List<Task> tasks = new ArrayList<>();
    @Column
    @Enumerated(EnumType.STRING)
    private final Role role;


    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Transient
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
