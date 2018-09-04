package com.metacube.training;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Triangle {

	private List<Point> points;
	private Set<Point> setOfPoints;
	private Map<String, Point> mapOfPoints;
	
	public Triangle(){}

	public Set<Point> getSetOfPoints() {
		return setOfPoints;
	}

	public void setSetOfPoints(Set<Point> setOfPoints) {
		this.setOfPoints = setOfPoints;
	}

	public Map<String, Point> getMapOfPoints() {
		return mapOfPoints;
	}

	public void setMapOfPoints(Map<String, Point> mapOfPoints) {
		this.mapOfPoints = mapOfPoints;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void pointsList(){
		for(Point point : this.points){
			System.out.println("x: " + point.getX() + "    y: " + point.getY());
		}
	}
	
	public void pointsSet(){
		for(Point point : this.setOfPoints){
			System.out.println("x: " + point.getX() + "    y: " + point.getY());
		}
	}
	
	public void pointsMap(){
		for (Map.Entry<String,Point> entry : this.mapOfPoints.entrySet()) {
			System.out.println(entry.getKey() + " ->   X: "+ entry.getValue().getX() + ",  Y: " + entry.getValue().getY());
    	}
	}
}
