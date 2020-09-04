/**
 * @author joshua warner
 * This program produces a convex hull using the Jarvis March algorithm
 */
package edu.metrostate.ics340.p5.jw2684;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.InputStreamReader;

public class SpillContainer {

	/**
	 * 
	 * @param sectorFile
	 * @return a string list of the names of sectors that make up the convex hull
	 */
	public static List<String> getBoundary(String sectorFile) {
		List<Point> allPoints = new ArrayList<>();
		List<String> output = new ArrayList<>();
		List<Point> colinear = new ArrayList<>();

		PriorityQueue<Point> minPoint = new PriorityQueue<>(new PointComparator());

		File file = new File(sectorFile);
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File Not Accessible");
		}
		Scanner input = new Scanner(new InputStreamReader(fstream));
		String pointName = null;
		double xIn = 0;
		double yIn = 0;
		input.useDelimiter("[\\|\\n\\r\\f]+");

		while (input.hasNext()) {

			pointName = input.next();

			xIn = Double.parseDouble(input.next());

			yIn = Double.parseDouble(input.next());

			allPoints.add(new Point(xIn, yIn, pointName));

			minPoint.offer(new Point(xIn, yIn, pointName));

		}
		input.close();

		Point start = minPoint.remove();
		output.add(start.getName());

		Point current = start;

		while (true) {

			Point next = allPoints.get(0);
			for (Point p : allPoints) {
				if (p.getName().equals(current.getName())) {
					continue;
				}
				double distance = findDirection(current, next, p);
				if (distance > 0) {
					next = p;
					colinear = new ArrayList<>();
				} else if (distance == 0) {
					if (findDistance(current, next, p) < 0) {
						//To Add Collinear points
						//colinear.add(next);
						next = p;
						
					} else {
						//To Add Collinear points
						//colinear.add(p);
					}
				}

			}
			for (Point p : colinear) {
				if (!output.contains(p.getName())) {
					output.add(p.getName());
				}

			}
			if (next.getName().equals(start.getName())) {
				break;
			}

			if (!output.contains(next.getName())) {
				output.add(next.getName());
			}

			current = next;

		}
	
		if(output.size() < 3) {
			return new ArrayList<String>();
		}

		return output;

	}

	private static double findDirection(Point a, Point b, Point c) {
		double y1 = a.y - b.y;
		double y2 = a.y - c.y;
		double x1 = a.x - b.x;
		double x2 = a.x - c.x;
		return y2 * x1 - y1 * x2;
	}

	private static double findDistance(Point first, Point second, Point third) {
		double y1 = first.y - second.y;
		double y2 = first.y - third.y;
		double x1 = first.x - second.x;
		double x2 = first.x - third.x;
		return Double.compare(y1 * y1 + x1 * x1, y2 * y2 + x2 * x2);
	}

	private static class Point {

		private double x;
		private double y;
		private String name;

		public Point(double xInput, double yInput, String nameInput) {
			this.setX(xInput);
			this.y = yInput;
			this.setName(nameInput);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setX(double x) {
			this.x = x;
		}

	}

	private static class PointComparator implements Comparator<Point> {
		public int compare(Point point1, Point comparePoint) {
			if (point1.x < comparePoint.x)
				return -1;
			if (point1.x > comparePoint.x)
				return 1;
			return 0;
		}
	}

}
