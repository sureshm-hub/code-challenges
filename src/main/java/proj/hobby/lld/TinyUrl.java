package proj.hobby.lld;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * https://leetcode.com/problems/encode-and-decode-tinyurl
 *
 * Code Space Size: 62 ^ 6 ~ 56 Billion Url's
 * URL Spae: > 10 ^ 100  -> vastly exceeds code space
 * It is ok that code space is tiny compared to the url space because we are not mapping all possible URL's at once
 *
 * Probability of Collision "Birthday Paradox": 1.25 * SQRT(62 ^6) ~ 300K  (50% probability of at least 1 collision)
 * It's ok as collisions are handled by retries
 *
 * https://chatgpt.com/g/g-p-67c12b389aec81918518492065db0483-dsa/c/692d02c7-bfa0-8333-bbd7-dae43a64f2ae
 *
 */
public class TinyUrl {

    final String alphas = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Map<String, String> urlToCode = new HashMap<>();
    Map<String, String> codeToUrl = new HashMap<>();
    Random rand = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while(!urlToCode.containsKey(longUrl)) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 6; i++) {
                char next = alphas.charAt(rand.nextInt(alphas.length()));
                sb.append(next);
            }
            String code = sb.toString();
            if(!codeToUrl.containsKey(code)) {
                codeToUrl.put(code, longUrl);
                urlToCode.put(longUrl, code);
                return "http://tinyurl.com/"+code;
            }
        }
        throw new IllegalArgumentException();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeToUrl.get(shortUrl.substring(19));
    }

}
