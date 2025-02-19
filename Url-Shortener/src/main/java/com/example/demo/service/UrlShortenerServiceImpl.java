package com.example.demo.service;

import com.example.demo.entity.UrlMapping;
import com.example.demo.repository.UrlMappingRepository;
import com.example.demo.util.Base62Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService{

    @Autowired
    private UrlMappingRepository urlMappingRepository;

    @Autowired
    private Base62Encoder base62Encoder;

    public String shortenUrl(String longUrl) {
        UrlMapping existingMapping = urlMappingRepository.findByLongUrl(longUrl);
        if (existingMapping != null) {
            return existingMapping.getShortUrl();
        }

        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setLongUrl(longUrl);

        urlMapping = urlMappingRepository.save(urlMapping);
        String shortUrl = base62Encoder.encode(urlMapping.getId());

        urlMapping.setShortUrl(shortUrl);
        urlMappingRepository.save(urlMapping);
        return shortUrl;
    }

    public String getLongUrl(String shortUrl) {
        UrlMapping mapping = urlMappingRepository.findByShortUrl(shortUrl);
        return mapping != null ? mapping.getLongUrl() : null;
    }
}
