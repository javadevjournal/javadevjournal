package com.javadevjournal.core.user.jpa.data;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "principle_groups")
public class Group{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;
    private String name;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group userGroup = (Group) o;
        return Objects.equals(id, userGroup.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToMany(mappedBy = "userGroups")
    private Set<UserEntity> users;

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public void getId(Long id) {
        this.id = id;
    }
}
