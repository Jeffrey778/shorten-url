package com.demo.shortenurl.controller;

import com.demo.shortenurl.service.ShortenUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private ShortenUrlService shortenUrlService;

    @GetMapping("/api")
    public ResponseEntity<Object> shorten(@RequestParam("url") String url) {
        // TODO url格式校验
        try {
            return ResponseEntity.ok("http://域名.com/" + shortenUrlService.shorten(url));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Object> restore(@PathVariable("shortUrl") String shortUrl) {
        String url = shortenUrlService.restore(shortUrl);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                .header("location", url)
                .build();
    }
}
