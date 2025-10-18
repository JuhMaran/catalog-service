package com.taptrack.catalogservice.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Table(name = "brewery")
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brewery {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  private Integer version;

  /**
   * Mínimo 3 caracteres
   * Máximo 150 caracteres
   * Campo obrigatório
   */
  @Column(nullable = false, length = 150)
  private String name;

  private String city;

  private String state;

  /**
   * TEXT
   */
  private String description;

  @OneToMany(mappedBy = "brewery")
  private List<Beer> beers;

  @Column(updatable = false)
  private LocalDateTime createdDate;

  private LocalDateTime updateDate;

}
