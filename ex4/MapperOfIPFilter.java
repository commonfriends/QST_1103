package No4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class MapperOfIPFilter {
	public static void main(String[] args) throws ParseException, FileNotFoundException {
		String filePath = "./data.txt";
		FileInputStream inputStream = new FileInputStream(filePath);
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		HashSet hs = new HashSet<String>();
		Locale locale = Locale.ENGLISH;
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", locale);
		Date beginDate = regularFormat.parse(args[0]);
		Date endDate = regularFormat.parse(args[1]);
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] a = line.split(" ");
			String strIp = null;
			String strTime = null;
			strIp = a[0];
			strTime = a[3].replace("[", "");
			Date time = inputFormat.parse(strTime);
			if (time.after(beginDate) && time.before(endDate)) {
				hs.add(strIp);
			}
		}
		System.out.println(hs.size());
	}
}
