package com.pard.server.seminar4th.book.controller;

import com.pard.server.seminar4th.book.dto.BookRequest;
import com.pard.server.seminar4th.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @PostMapping("/{userId}")
    public void CreateBook(@PathVariable Long userId,
                           @RequestBody BookRequest.BookCreateRequest req) {
        bookService.createBook(userId, req);
    }

}