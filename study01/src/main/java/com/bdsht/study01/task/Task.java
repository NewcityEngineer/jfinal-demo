package com.bdsht.study01.task;

import java.util.Date;

public class Task implements Runnable{

	public void run() {
		System.out.println("Task Runnable......："+new Date());
	}

}
