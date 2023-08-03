package com.dts.encurtadordeurl.repository;

import com.dts.encurtadordeurl.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {

    public Optional<Url> findByShortUrl(String shortUrl);

}
