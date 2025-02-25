package com.example.demo.repository;

import com.example.demo.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping,Long> {

    UrlMapping findByShortUrl(String shortUrl);

    UrlMapping findByLongUrl(String longUrl);
}
