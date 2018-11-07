package com.demo.shortenurl.service;

public interface ShortenUrlService {

    /**
     * 还原段连接
     *
     * @param shortUrl 短链接
     * @return 原连接
     */
    String restore(String shortUrl);

    /**
     * 缩短连接
     *
     * @param url 原连接
     * @return 短链接
     */
    String shorten(String url);
}
