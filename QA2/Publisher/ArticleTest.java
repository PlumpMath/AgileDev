package AgileDevCourse.QA2.Publisher;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArticleTest {
	
	@Test
	public final void testTwitterAuthenticationToken() {
		String expectedAuth = "a";
		String expectedTweet = "b";
		Article sut = new Article(expectedAuth,expectedTweet);
		String actualAuth = sut.twitterAuthenticationToken();
		assertEquals(actualAuth, expectedAuth);
	}

	@Test
	public final void testTweetText() {
		String expectedAuth = "a";
		String expectedTweet = "b";
		Article sut = new Article(expectedAuth,expectedTweet);
		String actualTweet = sut.tweetText();
		assertEquals(actualTweet, expectedTweet);
	}

}
