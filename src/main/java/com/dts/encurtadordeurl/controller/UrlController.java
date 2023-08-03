package com.dts.encurtadordeurl.controller;

import com.dts.encurtadordeurl.dto.LongUrlDto;
import com.dts.encurtadordeurl.dto.ShortUrlDto;
import com.dts.encurtadordeurl.model.Url;
import com.dts.encurtadordeurl.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urls")
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping("/new")
    public ResponseEntity<ShortUrlDto> saveUrl(@RequestBody Url url){
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.saveUrl(url));
    }

    @GetMapping("/get-long-url")
    public ResponseEntity<LongUrlDto> getUrl(@RequestParam String shortUrl){
        return ResponseEntity.ok(urlService.getLongUrl(shortUrl));
    }

    @GetMapping("get-access-url/{id}")
    public ResponseEntity<String> getAccessUrl(@PathVariable Integer id){
        return ResponseEntity.ok(urlService.getAccessUrl(id));
    }


}
