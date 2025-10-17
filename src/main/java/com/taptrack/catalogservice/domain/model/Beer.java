package com.taptrack.catalogservice.domain.model;

import com.taptrack.catalogservice.domain.model.enums.BeerStyle;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Table(name = "beer")
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

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
  private String beerName;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private BeerStyle beerStyle;

  /**
   * Mínimo 0
   * Valor default = 0
   */
  private Integer ibu;

  /**
   * Mínimo 0,0%
   * Valor default = 0,0%
   */
  private Double abv;

  @ManyToOne
  @JoinColumn(name = "brewery_id")
  private Brewery brewery;

  /**
   * valor default = true
   */
  private Boolean active = true;

  @Column(updatable = false)
  private LocalDateTime createdDate = LocalDateTime.now();

  private LocalDateTime updateDate = LocalDateTime.now();

}
