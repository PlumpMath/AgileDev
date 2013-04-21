package AgileDevCourse.QA2.Publisher;

public class Article {
	
	private String twitterAuthenticationToken;
	private String tweetableVersion;

	public Article(String authToken, String tweetText){
		this.twitterAuthenticationToken = authToken;
		this.tweetableVersion = tweetText;
	}
	
	public String twitterAuthenticationToken(){
		return this.twitterAuthenticationToken;
	}
	
	public String tweetText(){
		return this.tweetableVersion;
	}
}
