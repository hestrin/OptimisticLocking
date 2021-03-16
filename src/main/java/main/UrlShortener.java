package main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class UrlShortener {

    private static String shotPrefix = "http://short.com/";

    public static void main(String[] args) {
        UrlShortener s = new UrlShortener();
        System.out.println(s.randomShortenUrl("asdasd", "asda"));
    }

    public String randomShortenUrl(String inputUrl, String seoKeyword) {
        validateInputs(inputUrl, seoKeyword);
        Random random = new Random();
        char c1 = (char) random.nextInt(100);
        char c2 = (char) random.nextInt(100);
        char c3 = (char) random.nextInt(100);
        char c4 = (char) random.nextInt(100);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        return shotPrefix + c1 + c2 + c3 + c4;
    }

    public String shortenUrl(String inputUrl, String seoKeyword) {
        validateInputs(inputUrl, seoKeyword);
        return shotPrefix + seoKeyword;
    }

    private void validateInputs(String inputUrl, String seoKeyword) {
        if (inputUrl == null)
            throw new IllegalArgumentException();

        if (seoKeyword == null)
            throw new IllegalArgumentException();

        if (seoKeyword.length() > 20)
            throw new IllegalArgumentException();

        try {
            new URL(inputUrl);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
