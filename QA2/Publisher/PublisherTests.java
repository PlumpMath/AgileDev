package AgileDevCourse.QA2.Publisher;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class PublisherTests {

	@Test
	public final void testArticleIsSentToTwitter() {
		Twitter twitterMock = mock(Twitter.class);
		Publisher publisher = new Publisher();
		Article article = new Article("xx","yy");
		Blog blogStub = mock(Blog.class);
		
		publisher.injectTwitterPublisher(twitterMock);
		publisher.injectBlogPublisher(blogStub);
		publisher.publish(article);
		
		verify(twitterMock).tweet(article);
	}
	
	@Test 
	public final void testTwitterInvokesTwitterAPIWhenTweeting(){
		Article article = new Article("xx","yy");
	
		String twitterAuthenticationValue = article.twitterAuthenticationToken();
		String tweetText = article.tweetText();
		
		TwitterAPI apiMock = mock(TwitterAPI.class);
		when(apiMock.publishTweet(twitterAuthenticationValue, tweetText)).thenReturn(true);
		
		TwitterPublisher sut = new TwitterPublisher();
		sut.injectTwitterAPI(apiMock);
		
		sut.tweet(article);
		
		verify(apiMock).publishTweet(twitterAuthenticationValue, tweetText);
	}
	
	@Test
	public final void testArticleIsPostedToTheBlog(){
		Article article = new Article("","");
		Blog blogMock = mock(Blog.class);
		TwitterPublisher twitterMock = mock(TwitterPublisher.class);
		Publisher sut = new Publisher();
		sut.injectBlogPublisher(blogMock);
		sut.injectTwitterPublisher(twitterMock);
		
		sut.publish(article);
		
		verify(blogMock).post(article);
	}

}
