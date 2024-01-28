package com.ecomerce.ecomerce.dto;

import com.ecomerce.ecomerce.model.user.UserRole;

public record RegisterDTO(String nome, String login, String password, UserRole role) {
}
