package com.example.demo.controller;

import com.example.demo.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam String longUrl) {
        return urlShortenerService.shortenUrl(longUrl);
    }

    @GetMapping("/{shortUrl}")
    public String redirectToLongUrl(@PathVariable String shortUrl) {
        return urlShortenerService.getLongUrl(shortUrl);
    }
}

