package com.lele.map;

public class Route {
	/**
	 * �����ؾ���
	 */
	private double originLatitude;
	/**
	 * ������γ��
	 */
	private double originLongitude;
	/**
	 * ����������
	 */
	private String originName;
	/**
	 * Ŀ�ĵؾ���
	 */
	private double destinationLatitude;
	/**
	 * Ŀ�ĵ�γ��
	 */
	private double destinationLongitude;
	/**
	 * Ŀ�ĵ�����
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
