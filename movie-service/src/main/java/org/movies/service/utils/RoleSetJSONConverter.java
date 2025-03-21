package org.movies.service.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.movies.service.models.people.Role;

import java.util.Set;

@Converter
public class RoleSetJSONConverter implements AttributeConverter<Set<Role>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Set<Role> roles) {
        try {
            return roles == null ? "[]" : objectMapper.writeValueAsString(roles);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert set of roles to JSON", e);
        }
    }

    @Override
    public Set<Role> convertToEntityAttribute(String dbData) {
        try {
            return dbData == null ? Set.of() : objectMapper.readValue(dbData, new TypeReference<Set<Role>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert JSON to set of roles", e);
        }
    }
}