package com.practice.codility.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

import net.iakovlev.timeshape.TimeZoneEngine;

public class ReadLatitudeAndLongitude {

	public static void main(String[] args) {

		String[] stringLine = null;
		String line = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(
					new File("C:\\Users\\sayhe\\eclipse-workspace\\practice\\src\\main\\resources\\sample.csv"));

			bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				stringLine = line.split(",");

			}
		} catch (IOException e) {

		}

		finally {
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		TimeZoneEngine engine = TimeZoneEngine.initialize();
		Optional<ZoneId> id = engine.query(Double.valueOf(stringLine[0]), Double.valueOf(stringLine[1]));
		if(id.isPresent())
		{
			System.out.println(id.get());
			ZonedDateTime date = LocalDateTime.now().atZone(id.get());
			System.out.println(date.now());
		}
		
		
		

	}
}
