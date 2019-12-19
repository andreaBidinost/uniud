package designpattern.observer.elearning;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Observable {
	private String news;
	private List<Observer> observers = new ArrayList<>();

	@Override
	public void addObserver(Observer obs) {
		this.observers.add(obs);
	}

	public void setNews(String news) {
		this.news = news;
		updateObservers();
	}

	private void updateObservers() {
		for (Observer obs : this.observers) {
			obs.update(this.news);
		}
	}
}
