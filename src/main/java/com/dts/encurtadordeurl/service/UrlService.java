package com.dts.encurtadordeurl.service;

import com.dts.encurtadordeurl.dto.LongUrlDto;
import com.dts.encurtadordeurl.dto.ShortUrlDto;
import com.dts.encurtadordeurl.model.Url;
import com.dts.encurtadordeurl.repository.UrlRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlService {

    @Autowired
    UrlRepository urlRepository;

    public ShortUrlDto saveUrl(Url receivedUrl){
        receivedUrl.setShortUrl(shortenURL(receivedUrl.toString()));
        ShortUrlDto shortUrlDto = new ShortUrlDto();
        shortUrlDto.setShortenedUrl(receivedUrl.getShortUrl());
        urlRepository.save(receivedUrl);
        return shortUrlDto;
    }

    private String generateShortCode() {
        StringBuilder sb = new StringBuilder();
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    private final Map<String, String> urlMap = new HashMap<>();
    private final String BASE_URL = "https://tds.co/";

    public String shortenURL(String longURL) {
        String shortCode = generateShortCode();
        String shortURL = BASE_URL + shortCode;
        urlMap.put(shortCode, longURL);
        return shortURL;
    }

        public LongUrlDto getLongUrl(String shortUrl){
        Url urlRegistrada = urlRepository.findByShortUrl(shortUrl).get();
        LongUrlDto originalUrl = new LongUrlDto();
        BeanUtils.copyProperties(urlRegistrada, originalUrl);

        return originalUrl;
    }


}
