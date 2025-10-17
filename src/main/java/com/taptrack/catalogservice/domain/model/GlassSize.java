package com.taptrack.catalogservice.domain.model;

import com.taptrack.catalogservice.domain.model.enums.GlassType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 17/10/2025
 */
@Table(name = "glass_size")
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GlassSize {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  private Integer version;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private GlassType name;

  /**
   * Mínimo 0
   * Valor default = 0
   */
  @Column(nullable = false)
  private Integer volumeMl;

  @Column(updatable = false)
  private LocalDateTime createdDate = LocalDateTime.now();

  private LocalDateTime updateDate = LocalDateTime.now();

}
