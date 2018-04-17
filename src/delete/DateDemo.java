package delete;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d.toString());
		SimpleDateFormat s = new SimpleDateFormat("E,MMM dd,YYYY");
		String n = s.format(d);
		n = n.concat(" at ");
		n = n.concat(new SimpleDateFormat("HH:mm a").format(d));
		System.out.println(n);
	}

}
