//assignment 2 alon cohen 319039707

package race;

import java.util.Scanner;

public class Racer implements Runnable {
	public static int globalId = 1;
	private int id;
	private int speed;
	private Track track;

	public Racer(int speed, Track track) {
		this.id = globalId++;
		this.speed = validateSpeed(speed);
		this.track = track;
	}


	private int validateSpeed(int speed2) {
		if (speed2 >= 1 && speed2 <= 10) {
			return speed2;
		} else {
			throw new IllegalArgumentException("Speed must be between 1 and 10");
		}
	}

	public void go() {
		int distance = 0;
		while (distance < 100) {
			distance++;
			System.out.println("Runner " + id + " ran " + distance + " meters");
		}
		track.finishedRacers++;
		String place = getfinsh(track.finishedRacers);
		System.out.println("Runner " + id + " finished " + track.finishedRacers + place);

	}

	private String getfinsh(int place) {
		if (place >= 4) {
			return "th";
		} else {
			int lastDI = place % 10;
			return (lastDI == 1) ? "st" : (lastDI == 2) ? "nd" : (lastDI == 3) ? "rd" : "th";
		}
	}
    @Override
	public void run() {
        go();
       
    }

}
