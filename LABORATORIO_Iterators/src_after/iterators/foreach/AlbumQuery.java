package iterators.foreach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		
		printAllAlbumNames();
		
	}
	
	//print all album names
	static void printAllAlbumNames() {
		albums.forEach(al -> System.out.println(al.getTitle()));
	}
	
	//Add years to all albums
	static void addYears(int years) {
		
//		for(Album al:albums) {
//			al.setYear(al.getYear() + years);
//		}
		
		albums.forEach(al -> al.setYear(al.getYear() + years));
	}
	
	//Add years to a specific album
	static void addYearsTo(String album, int years) {
		albums.forEach(al -> {
			if(al.getTitle().equals(album)) {
				al.setYear(al.getYear() + years);
			}
		});
	}
	
	//print All album titles of album produced after startYear
	static void printAlbumAfterYear(int startYear) {
		albums.stream().filter(al -> al.getYear() > startYear).forEach(al -> System.out.println(al));
		albums.stream().filter(al -> al.getYear() > startYear).forEach(System.out::println);//The same
	}
	
	
	//print All songs of the album
	static void printAllSongsOf(String albumName) {
		albums.stream().filter(al -> al.getTitle().equals(albumName)).forEach(al -> System.out.println(al.getSongs()));
	}
	
	//return a list of all album name
	static List<String> getAlbumNames() {
		return albums.stream().map(Album::getTitle).collect(Collectors.toList());
	}
	
	//return a list of all album names produced after startYear
	static List<String> getAlbumNamesAfter(int startYear) {
		return albums.stream().filter(al -> al.getYear() > startYear).map(Album::getTitle).collect(Collectors.toList());
	}
}