package com.things.project01.controller;

import com.things.project01.domain.Post;
import com.things.project01.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
        Page<Post> postList = postService.findAll(pageable);
        model.addAttribute("post", postList);

        long startBlock = (pageable.getPageNumber() - 1) / postList.getSize() * postList.getSize() + 1;
        long blockCount = (postList.getTotalElements() + postList.getSize() - 1) / postList.getSize();
        long finishBlock = startBlock + postList.getTotalElements() - 1;
        finishBlock = blockCount < finishBlock ? blockCount : finishBlock;

        List<Long> block = new ArrayList<>();
        for (long i = startBlock; i <= finishBlock; i++) block.add(i);
        model.addAttribute("block", block);
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
