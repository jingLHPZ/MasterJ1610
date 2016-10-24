package com.sxt.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@SuppressWarnings("unchecked")
public class SerializeUtil {
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				if(oos != null) oos.close();
				if(baos != null) baos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}

	public static <T> T unserialize(byte[] bytes) {
		ObjectInputStream ois = null;
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			
			return (T)ois.readObject();
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			try {
				if(ois != null) ois.close();
				if(bais != null) bais.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}
}
