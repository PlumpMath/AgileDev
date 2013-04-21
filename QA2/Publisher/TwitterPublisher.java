package AgileDevCourse.QA2.Publisher;

public class TwitterPublisher implements Twitter {

	TwitterAPI twitterAPI;
	
	@Override
	public void tweet(Article article) {
		String authenticationToken = article.twitterAuthenticationToken();
		String tweet = article.tweetText();
		this.twitterAPI.publishTweet(authenticationToken, tweet);
	}

	public void injectTwitterAPI(TwitterAPI api){
		this.twitterAPI = api;
	}
}
