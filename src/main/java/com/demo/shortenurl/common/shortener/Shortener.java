package com.demo.shortenurl.common.shortener;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * url缩短器
 */
public class Shortener {

    /**
     * 用户生成的url的字符集
     */
    private static String[] chars = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"
    };

    /**
     * 缩短url
     *
     * @param originalUrl 原来url
     * @return 算短后的url
     */
    public static String get(String originalUrl) {
        String md5 = DigestUtils.md5Hex(originalUrl + Math.random());
        int hexLen = md5.length() / 8;
        String[] shortUrls = new String[4];
        for (int i = 0; i < hexLen; i++) {
            String outChars = "";
            String hex = md5.substring(i * 8, i * 8 + 8);
            int idx = (int) Long.parseLong(hex, 16) & 0x3FFFFFFF;
            for (int k = 0; k < 6; k++) {
                outChars += chars[idx & 0x3D];
                idx = idx >> 5;
            }
            shortUrls[i] = outChars;
        }
        return shortUrls[(int) (Math.random() * 4)];
    }
}
