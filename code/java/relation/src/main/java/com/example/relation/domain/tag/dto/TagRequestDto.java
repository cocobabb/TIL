package com.example.relation.domain.tag.dto;

import com.example.relation.domain.tag.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagRequestDto {
    @NotBlank
    private String name;

    public Tag toEntity() {
        return Tag.builder()
                .name(this.name)
                .build();
    }
}
