package com.jmh.utility;

public class CpuBurn {

	public static void burnCpu() {
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("Thread "
							+ Thread.currentThread().getName() + " started");
					double val = 10;
					for (;;) {
						Math.atan(Math.sqrt(Math.pow(val, 10)));
					}
				}
			}).start();
		}
	}
	
	public static void main(String[] args) {
		CpuBurn.burnCpu();
		System.out.println("done");
	}
}
