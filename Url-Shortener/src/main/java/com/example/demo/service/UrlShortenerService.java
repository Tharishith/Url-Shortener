package com.example.demo.service;

public interface UrlShortenerService {

    String shortenUrl(String longUrl);

    String getLongUrl(String shortUrl);
}
