package com.sksamuel.gaia;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class City {

	private static List<City>	UK_CITIES;
	private static List<City>	UK_MAJOR_CITIES;

	public static List<City> getUkCities() {
		if (UK_CITIES == null)
			UK_CITIES = parse("/com/sksamuel/gaia/uktowns.txt");
		return UK_CITIES;
	}

	public static List<City> getUKMajorCities() {
		if (UK_MAJOR_CITIES == null)
			UK_MAJOR_CITIES = parse("/com/sksamuel/gaia/ukmajorcities.txt");
		return UK_MAJOR_CITIES;
	}

	static List<City> parse(String file) {
		InputStream is = City.class.getResourceAsStream(file);
		try {
			List<City> cities = new ArrayList<City>();
			List<String> lines = IOUtils.readLines(is);
			for (String line : lines) {
				City city = new City();
				city.setName(line);
				cities.add(city);
			}
			cities = Collections.unmodifiableList(cities);
			return cities;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String	name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
