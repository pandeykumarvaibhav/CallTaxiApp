package com.cg.calltaxiapp.service;

public class DistanceCalculator {

	public static int calculateDistance(String source, String dest) {

		int kilometers = 0;
		int price = 0;

		if (source.equalsIgnoreCase("chennai") && dest.equalsIgnoreCase("erode")
				|| source.equalsIgnoreCase("erode") && dest.equalsIgnoreCase("chennai")) {
			kilometers = 150;
			price = kilometers * 15;
		} else if (source.equalsIgnoreCase("chennai") && dest.equalsIgnoreCase("salem")
				|| source.equalsIgnoreCase("salem") && dest.equalsIgnoreCase("chennai")) {
			kilometers = 175;
			price = kilometers * 15;
		} else if (source.equalsIgnoreCase("chennai") && dest.equalsIgnoreCase("trichy")
				|| source.equalsIgnoreCase("trichy") && dest.equalsIgnoreCase("chennai")) {
			kilometers = 234;
			price = kilometers * 15;
		} else if (source.equalsIgnoreCase("salem") && dest.equalsIgnoreCase("erode")
				|| source.equalsIgnoreCase("erode") && dest.equalsIgnoreCase("salem")) {
			kilometers = 90;
			price = kilometers * 15;
		} else if (source.equalsIgnoreCase("salem") && dest.equalsIgnoreCase("trichy")
				|| source.equalsIgnoreCase("trichy") && dest.equalsIgnoreCase("salem")) {
			kilometers = 330;
			price = kilometers * 15;
		} else if (source.equalsIgnoreCase("trichy") && dest.equalsIgnoreCase("erode")
				|| source.equalsIgnoreCase("erode") && dest.equalsIgnoreCase("trichy")) {
			kilometers = 73;
			price = kilometers * 15;
		} else {
			kilometers = 112;
			price = kilometers * 15;
		}

		return price;
	}
}
