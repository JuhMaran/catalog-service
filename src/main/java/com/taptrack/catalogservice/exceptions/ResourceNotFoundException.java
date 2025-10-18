package com.taptrack.catalogservice.exceptions;

/**
 * catalog-service
 *
 * @author Juliane Maran
 * @since 18/10/2025
 */
public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
