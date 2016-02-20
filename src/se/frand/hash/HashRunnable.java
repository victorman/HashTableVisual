package se.frand.hash;

public class HashRunnable implements Runnable {
	private static final int DELAY = 1000;
	private static final int SIZE = 20;
	private HashTableComponent component;
	
	public HashRunnable(HashTableComponent component) {
		this.component = component;
	}

	@Override
	public void run() {
		AlgorithmStepper stepper = new AlgorithmStepper() {
			
			@Override
			public void step(String[] values, Integer selected, String key, boolean out) {
				component.setValues(values, selected, key, out);
				try {
					Thread.sleep(DELAY);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
			}
		};
		HashTable hashTable = new HashTable(SIZE, stepper);
		hashTable.insert("Hello");
		hashTable.insert("World!");
		hashTable.insert("Bomb");
		hashTable.insert("aloha");
		hashTable.insert("star trek");
		hashTable.insert("Robo Cop");
		hashTable.insert("Hardware");
		hashTable.insert("Johnny Mnemonic");
		hashTable.get("Hello");
		hashTable.get("Johnny Mnemonic");
		hashTable.get("pulse");
		hashTable.get("Johnny Mnemono");
		//component.setValues(new String[SIZE], null, null);
	}

}
