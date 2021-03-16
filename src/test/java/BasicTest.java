import main.UrlShortener;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicTest {

    private UrlShortener s = new UrlShortener();

//    URL: http://looooong.com/somepath
//    SEO keyword: MY-NEW-WS
//    Output:
//    URL: http://short.com/MY-NEW-WS
    @Test
    public void shortenUrl() {
        assertThat(s.shortenUrl("http://looooong.com/somepath", "MY-NEW-WS"))
                .isEqualTo("http://short.com/MY-NEW-WS");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullInputUrl() {
        s.shortenUrl(null, "MY-NEW-WS");
    }

    @Test(expected = IllegalArgumentException.class)
    public void malformedUrl() {
        s.shortenUrl("https//looooong.com/somepath", "MY-NEW-WS");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullSeoKeyword() {
        s.shortenUrl("http://looooong.com/somepath", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void seoKeywordLongerThan20Characters() {
        s.shortenUrl("http://looooong.com/somepath", "MY-NEW-WSMY-NEW-WS111");
    }

    @Test
    public void produceRandomShortenedUrl() {
        assertThat(s.randomShortenUrl("http://looooong.com/somepath", "MY-NEW-WSMY-NEW-WS"))
                .startsWith("http://short.com/")
                .hasSize(21);
    }
}
