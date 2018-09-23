package com.nortal.testassignment;


import java.io.*;
import java.util.Base64;

public class Solution {
	
	public static String penetrate(String base64ObjectInput, String fieldName, int newValue) throws Exception {

		Object o = fromString(base64ObjectInput, fieldName, newValue);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream( baos );
		oos.writeObject( o );
		oos.close();
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}

	private static Object fromString( String s, String field, Object newValue ) throws IOException,ClassNotFoundException {
		byte [] data = Base64.getDecoder().decode( s );
		ObjectInputStream ois = new ObjectInputStream(
				new ByteArrayInputStream(  data ) );
		Object o  = ois.readObject();
		ois.close();
		try {
			o.getClass().getDeclaredField(field).setAccessible(true);
			o.getClass().getDeclaredField(field).set(o, newValue);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

		return o;
	}

	public static class Money implements Serializable {
		static final long serialVersionUID = 9062282770556489963l;
		public int value;
	}


	public static class MoneyWithCurrency implements Serializable {
		static final long serialVersionUID = -1474896920071739101l;
		public int amount;
		public String currency;
	}

	public static class  MoneyWithCurrencyAndSerial implements Serializable {
		static final long serialVersionUID = -4997187403367254147l;
		public int _amount;
		public String _currency;
		public String _serial;

	}
	
}
