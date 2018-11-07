package com.demo.shortenurl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.shortenurl.common.shortener.Shortener;
import com.demo.shortenurl.mapper.ShortenUrlMapper;
import com.demo.shortenurl.model.ShortenUrl;
import com.demo.shortenurl.service.ShortenUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ShortenUrlServiceImpl implements ShortenUrlService {

    @Autowired
    private ShortenUrlMapper shortenUrlMapper;

    @Override
    public String restore(String shortUrl) {
        QueryWrapper<ShortenUrl> wrapper = new QueryWrapper<>();
        wrapper.eq("short_url", shortUrl);
        return shortenUrlMapper.selectOne(wrapper).getUrl();
    }

    @Override
    public String shorten(String url) {
        ShortenUrl shortenUrl = new ShortenUrl();
        shortenUrl.setUrl(url);
        shortenUrl.setShortUrl(Shortener.get(url));
        shortenUrlMapper.insert(shortenUrl);
        return shortenUrl.getShortUrl();
    }
}
