package kono_fan.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Logger
{
	public static void log(String value)
	{
		try
		{
			FileWriter fileWriter = new FileWriter("logs/" + LocalDate.now(), true);
			fileWriter.write(LocalTime.now() + "\t" + value + "\n");
			fileWriter.close();
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}
}