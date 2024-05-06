package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record PlantErrorResponse(HttpStatus status, String message, LocalDateTime timestamp) {
}
