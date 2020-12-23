package com.things.project01.service;

import com.things.project01.domain.Post;
import com.things.project01.dto.PostRequestDto;
import com.things.project01.dto.PostResponseDto;
import com.things.project01.repository.PaginationRepository;
import com.things.project01.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PaginationRepository paginationRepository;


    @Override
    public void created(PostRequestDto createdDto) {
        postRepository.created(createdDto.toEntity());
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, pageable.getPageSize(), Sort.Direction.DESC, "id");
        return paginationRepository.findAll(pageable);
    }

    @Override
    public PostResponseDto findById(Long id) {
        return new PostResponseDto(postRepository.findById(id));
    }

    @Override
    public boolean checkPw(PostRequestDto requestDto) {
        Post post = postRepository.findById(requestDto.getId());
        boolean check = post.getPassword().equals(requestDto.getPassword()) ? true : false;
        return check;
    }

    @Override
    public void update(PostRequestDto requestDto) {
        Post post = requestDto.toEntity();
        postRepository.update(post);
    }

    @Override
    public void delete(Long id) {
        postRepository.delete(id);
    }
}
