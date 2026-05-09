package org.learning.hibernate;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Audited
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String city;

}
