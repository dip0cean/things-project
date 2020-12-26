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

import javax.transaction.Transactional;

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
    public Page<Post> findAll(int page) {
        int pageSize = 10;
        page = (page == 0) ? 0 : (page - 1);
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.DESC, "id");
        return paginationRepository.findAll(pageable);
    }

    @Override
    public PostResponseDto findById(Long id) {
        return new PostResponseDto(postRepository.findById(id));
    }

    @Override
    public boolean checkPw(PostRequestDto requestDto) {
        Post post = postRepository.findById(requestDto.getId());
        return post.getPassword() == requestDto.getPassword() ? true : false;
    }

    @Override
    public void update(PostRequestDto requestDto) {
        postRepository.update(requestDto.toEntity());
    }

    @Override
    public void delete(Long id) {
        postRepository.delete(id);
    }
}
