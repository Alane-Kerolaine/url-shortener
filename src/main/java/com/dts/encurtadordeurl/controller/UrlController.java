package com.dts.encurtadordeurl.controller;

import com.dts.encurtadordeurl.dto.LongUrlDto;
import com.dts.encurtadordeurl.dto.ShortUrlDto;
import com.dts.encurtadordeurl.model.Url;
import com.dts.encurtadordeurl.service.UrlService;
import com.sun.jdi.ShortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urls")
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping("/new")
    public ShortUrlDto saveUrl(@RequestBody Url url){
        return urlService.saveUrl(url);
    }

    @GetMapping("/get-long-url")
    public LongUrlDto getUrl(@RequestParam String shortUrl){
        return urlService.getLongUrl(shortUrl);
    }

}
