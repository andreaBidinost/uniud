package iterators.foreach;

import java.util.ArrayList;
import java.util.List;

/**
 * This class show how to use foreach and stream functionalities over a List.
 * Do not pay attention to contracts, exceptions or other "clean coding" stuffs.
 *
 */
public class AlbumQuery {
	
	static List<Album> albums;
	
	public static void main(String[] args) {
		albums = new ArrayList<>();
		albums.add(new Album("Pink Floyd", "The Division Bell", 1994,
		         "Cluster One",
		         "What Do You Want from Me",
		         "Poles Apart",
		         "Marooned",
		         "A Great Day for Freedom",
		         "Wearing the Inside Out",
		         "Take It Back",
		         "Coming Back to Life",
		         "Keep Talking",
		         "Lost for Words",
		         "High Hopes"));
		albums.add(new Album("AC DC", "Back in black", 1980,
				"Hells Bells",
				"Shoot to Thrill",
				"What Do You Do for Money Honey",
				"Given the Dog a Bone",
				"Let Me Put My Love Into You",
				"Back in Black",
				"You Shook Me All Night Long",
				"Have a Drink on Me",
				"Shake a Leg",
				"Rock and Roll Ain't Noise Pollution"));
		
	}
	
	//print all album names
	static void printAllAlbumNames() {
		
	}
	
	//Add years to all albums
	static void addYears(int years) {
	}
	
	//Add years to a specific album
	static void addYearsTo(String album, int years) {
	}
	
	//print All album titles of album produced after startYear
	static void printAlbumAfterYear(int startYear) {
	}
	
	//print All songs of the album
	static void printAllSongsOf(String albumName) {
	}
	
	//return a list of all album name
	static List<String> getAlbumNames() {
	}
	
	//return a list of all album names produced after startYear
	static List<String> getAlbumNamesAfter(int startYear) {
	}
}
