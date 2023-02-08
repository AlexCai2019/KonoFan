package kono_fan.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Logger
{
	public static void log(String value)
	{
		LocalTime now = LocalTime.now();
		String logString = String.format("%02d:%02d:%02d\t%s\n", now.getHour(), now.getMinute(), now.getSecond(), value);
		try
		{
			FileWriter fileWriter = new FileWriter("logs/" + LocalDate.now(), true);
			fileWriter.write(logString);
			fileWriter.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}