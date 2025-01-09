package com.example.relation.domain.tag;

import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.domain.tag.dto.TagResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TagService {
    private final TagRepository tagRepository;

    @Transactional
    public TagResponseDto createService(TagRequestDto requestDto) {
        return TagResponseDto.from(tagRepository.save(requestDto.toEntity()));
    }
}
