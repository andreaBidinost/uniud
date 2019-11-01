package uniud.javalog;

import java.io.IOException;
import java.util.logging.Logger;

public class Post {
	private String message;
	private String postId;
	private Logger logger;
	
	public static void main(String[] args) throws SecurityException, IOException {
		Post p = new Post("uniud", "id552");
	}
	
	public Post(String m, String pid) throws SecurityException, IOException {
		this.message = m;
		this.postId = pid;
		logger = Logger.getLogger(Post.class.getName());
		
		LogInitializer.setup();
		logger.setUseParentHandlers(false);
		
		
		logger.severe("Ricevuto un post di messaggio " + m + " e pid " + pid );
		
		
	}

}
