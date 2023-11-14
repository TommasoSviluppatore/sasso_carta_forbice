package model;

import java.io.*; 
import java.net.*; 
import java.util.*;

import model.Client;
import view.Menu;

public class MainClient{
	public static void main(String[] args) {
		Client client = new Client();
		client.conversazione();
		//new Thread((Runnable) new view.Menu()).start();
		//new Thread((Runnable) new Client()).start();
	}

}
