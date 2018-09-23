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


		 //toString(o);




        /*
		byte[] encodedBytes = base64ObjectInput.getBytes();
		System.out.println("encodedBytes " + new String(encodedBytes));
		byte[] decodedBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encodedBytes);

		System.out.println("decodedBytes " + new String(decodedBytes));

		return "";

      */

	}

	private static Object fromString( String s, String field, int newValue ) throws IOException,ClassNotFoundException {
		byte [] data = Base64.getDecoder().decode( s );
		ObjectInputStream ois = new ObjectInputStream(
				new ByteArrayInputStream(  data ) );
		Object o  = ois.readObject();
		ois.close();
		try {
			o.getClass().getField("value").set(o, 100);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}




		return o;
	}


	private static String toString( Serializable o ) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream( baos );
		oos.writeObject( o );
		oos.close();
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}



	class Money implements Serializable {
		transient private static final long serialVersionUID = 9062282770556489963l;
		private  int value;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public void writeObject(ObjectOutputStream out) throws  IOException{
			out.defaultWriteObject();
			out.writeInt(this.value);
		}

		public void readObject(ObjectInputStream in) throws  IOException{
			this.value = in.readInt();
		}
	}


	class MoneyWithCurrency implements Serializable {
		static final long serialVersionUID = -1474896920071739101l;
	}

	class MoneyWithCurrencyAndSerial implements Serializable {
		static final long serialVersionUID = -4997187403367254147l;
	}


	
}
