package AgileDevCourse.QA2.Publisher;

public class Publisher {

	private Twitter twitter;
	private Blog blog;

	public void publish(Article article) {
		this.blog.post(article);
		this.twitter.tweet(article);
	}

	public void injectBlogPublisher(Blog blog) {
		this.blog = blog;
	}
	
	public void injectTwitterPublisher(Twitter twitter) {
		this.twitter = twitter;
	}

}
