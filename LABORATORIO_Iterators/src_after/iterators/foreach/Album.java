package iterators.foreach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
	
public class Album {
	 private String author;
	   private List<String> songs;
	   private int year;
	   private String title;
	    
	   public Album(String author, String title, int year, String... songs){
	      this.author = author;
	      this.year = year;
	      this.title = title;
	      this.songs = new ArrayList<>(Arrays.asList(songs));
	   }
	 
	   public String getAuthor() {
	      return author;
	   }
	 
	   public List<String> getSongs() {
	      return songs;
	   }
	 
	   public int getYear() {
	      return year;
	   }
	    
	   public String getTitle() {
	      return title;
	   }
	   
	   public void setYear(int newYear) {
		   year = newYear;
	   }
	   
	   public String toString() {
		   return getTitle();
	   }
}
