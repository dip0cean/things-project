package com.things.project01.controller;

import com.things.project01.domain.Post;
import com.things.project01.dto.PostResponseDto;
import com.things.project01.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post/{page}")
    public String index(@PathVariable int page, Model model) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<PostResponseDto> postList = postService.findAll(pageable).map(post -> new PostResponseDto(post));
        model.addAttribute("post", postList);

        long startBlock = (page - 1) / postList.getSize() * postList.getSize() + 1; // (현재 페이지 번호 - 1) / 페이지블럭 기준 * 페이지블럭 기준 + 1
        long finishBlock = startBlock + postList.getSize() - 1;
        long blockCount = (postList.getTotalElements() + postList.getSize() - 1) / postList.getSize();
        finishBlock = blockCount < finishBlock ? blockCount : finishBlock;

        List<Long> block = new ArrayList<>();
        for (long i = startBlock; i <= finishBlock; i++) block.add(i);
        model.addAttribute("block", block);
        model.addAttribute("blockCount", blockCount);
        return "list";
    }

    @GetMapping("/post/created")
    public String created() {
        return "save";
    }

    @GetMapping("/post/detail/{id}")
    public String page(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post";
    }

    @GetMapping("/post/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "save";
    }
}
