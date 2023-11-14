package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class __NONUSARE__ThreadPartita implements Runnable{

	private Socket connection1;
	private Socket connection2;
	private ObjectInputStream inputClient1;
	private ObjectInputStream inputClient2;
	private ObjectOutputStream outputClient1;
	private ObjectOutputStream outputClient2;
	
	public __NONUSARE__ThreadPartita(Socket connection1, Socket connection2) {
		super();
		this.connection1 = connection1;
		this.connection2 = connection2;
	}

	@Override
	public void run() {
		try {
			this.inputClient1=new ObjectInputStream(this.connection1.getInputStream());
			this.inputClient2=new ObjectInputStream(this.connection2.getInputStream());
			this.outputClient1=new ObjectOutputStream(this.connection1.getOutputStream());
			this.outputClient2=new ObjectOutputStream(this.connection2.getOutputStream());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}	

}
