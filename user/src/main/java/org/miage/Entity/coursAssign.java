package org.miage.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "coursAssign",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "idcours"),
                @UniqueConstraint(columnNames = "email")
        })
public class coursAssign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idcours;
    private String email;

    private long state;
}
