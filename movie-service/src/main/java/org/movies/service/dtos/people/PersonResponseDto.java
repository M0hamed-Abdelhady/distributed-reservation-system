package org.movies.service.dtos.people;

import lombok.*;

import java.util.Map;
import java.util.Set;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonResponseDto {
    private String id;
    private String name;
    private String biography;
    private String birthDate;
    private String deathDate;
    private Set<String> roles;
    private Map<String, String> socialMediaLinks;
}
