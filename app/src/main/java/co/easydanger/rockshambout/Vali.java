package co.easydanger.rockshambout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Vali {

	public static int enumInArray(Enum ar[], Enum num) {
		int index = -1;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == num) {
				index = i;
			}
		}
		return index;
	}
}