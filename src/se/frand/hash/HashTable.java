package se.frand.hash;

import java.util.*;

public class HashTable {
	
	private int length;
	private String[] table;
	private AlgorithmStepper stepper;
	
	public HashTable(int len, AlgorithmStepper stepper) {
		length = len;
		table = new String[length];
		this.stepper = stepper;
		stepper.step(table, null, null, false);
	}
	
	public void insert(String key) {
		int j = 0;
		stepper.step(table, null, key, false);
		for(int i=0; i<length; i++){
			j = hash(key, i);
			stepper.step(table, j, key, false);
			if(table[j] == null) {
				table[j] = key;
				stepper.step(table, j, key, false);
				return;
			}
		}
		System.err.println("Hash Table overflow");
	}
	
	public String get(String key) {
		int j = 0;
		stepper.step(table, null, key, false);
		for(int i=0; i<length; i++){
			j = hash(key, i);
			stepper.step(table, j, key, false);
			if(table[j] == null) {
				stepper.step(table, j, key, false);
				break;
			}
			if(table[j].equals(key)) {
				stepper.step(table, j, key, true);
				return table[j];
			}
		}
		stepper.step(table, j, key, true);
		return null;
	}

	private int hash(String k) {
		int hash = k.hashCode() % length;
		if (hash < 0)
			return -hash;
		return hash;
	}
	
	private int hash(String k, int i) {
		int hash = (hash(k) + i) % length;
		if(hash < 0)
			return -hash;
		return hash;
	}
	
	public String toString() {
		final String rc = "\n";
		final String nil = "null";
		StringBuilder res = new StringBuilder();
		for(int i=0; i<length; i++) {
			if(table[i] == null)
				res.append(nil);
			else
				res.append(table[i]);
			res.append(rc);
		}
		return res.toString();
	}
	
}
