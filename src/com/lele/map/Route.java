package com.lele.map;

public class Route {
	/**
	 * 出发地经度
	 */
	private double originLatitude;
	/**
	 * 出发地纬度
	 */
	private double originLongitude;
	/**
	 * 出发地名字
	 */
	private String originName;
	/**
	 * 目的地经度
	 */
	private double destinationLatitude;
	/**
	 * 目的地纬度
	 */
	private double destinationLongitude;
	/**
	 * 目的地名字
	 */
	private String destinationName;
	
	public double getOriginLatitude() {
		return originLatitude;
	}
	public void setOriginLatitude(double originLatitude) {
		this.originLatitude = originLatitude;
	}
	public double getOriginLongitude() {
		return originLongitude;
	}
	public void setOriginLongitude(double originLongitude) {
		this.originLongitude = originLongitude;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public double getDestinationLatitude() {
		return destinationLatitude;
	}
	public void setDestinationLatitude(double destinationLatitude) {
		this.destinationLatitude = destinationLatitude;
	}
	public double getDestinationLongitude() {
		return destinationLongitude;
	}
	public void setDestinationLongitude(double destinationLongitude) {
		this.destinationLongitude = destinationLongitude;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	
}
