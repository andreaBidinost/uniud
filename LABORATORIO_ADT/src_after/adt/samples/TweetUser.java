package adt.samples;

import java.util.Date;

public class TweetUser {
	
	/**
	 * Pick a tweet and retweet it setting actual time (eg. 1 hour later the previous one)
	 * @param t
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Tweet retweetLater(Tweet t) {
	    Date d = t.getTimestamp();
	    d.setHours(d.getHours()+1);//questa modifica ha effetto anche nel vecchio oggeto Tweet
	    return new Tweet("rbmllr", t.getText(), d);
	}
}
