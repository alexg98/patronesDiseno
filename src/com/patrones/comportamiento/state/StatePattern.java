package com.patrones.comportamiento.state;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

/**
 * El patrón de diseño State se utiliza cuando el comportamiento de un objeto cambia 
 * dependiendo del estado del mismo. Por ejemplo: una alarma puede tener diferentes estados, 
 * como desactivada, activada, en configuración. Definimos una interfaz Estado_Alarma, y luego 
 * definimos los diferentes estados.
 * 
 * State patter:We have a specific class(Context) that manages the state changes of a external class by creating different instance depending
 * on the state you want to adopt.
 * Every class that you create implements an interface(State) that define the method name that they have to implement
 * @author Pperez
 * https://es.wikipedia.org/wiki/State_(patr%C3%B3n_de_dise%C3%B1o)
 */

public class StatePattern {
	public void main(String args[]){
	 	try{
	 		State state;
	 		Context context = new Context();
	 		SocketChannel socketChannel = null;
	 		//-----------------------------\\
	 		//	 OPEN/LISTENING SOCKET	 \\
	 		//-----------------------------\\
	 		//First State:
	 		state = new ConnectSocketState(socketChannel);
	 		context.setState( state ); 
	 		socketChannel = context.request();
	 		//-----------------------------\\
	 		//		 CLOSE SOCKET 	 \\
	 		//-----------------------------\\
	 		//Second State:
	 		state = new CloseSocketState(socketChannel);
	 		context.setState( state ); 
	 		socketChannel = context.request();
	 	}catch( Exception e ) {
	 		e.printStackTrace();
	 	}
	 }

	 public class Context
	 {
	 	private State state;
	 
	 	public void setState( State state )
	 	{
	 		this.state = state;
	 	}
	 
	 	public State getState()
	 	{
	 		return state;
	 	}
	 
	 	public SocketChannel request()
	 	{
	 		return state.processState();
	 	}
	 }

	 public interface State
	 {
	 	SocketChannel processState();
	 }

	 public class ConnectSocketState implements State
	 {
		 SocketChannel socketChannel;
		public ConnectSocketState(SocketChannel socketChannel){
			this.socketChannel=socketChannel;
		}
	 	public SocketChannel processState()
	 	{
	 		try {
	 			int port = 21;
	 			InetAddress host = InetAddress.getByName("192.168.1.1");
	 			SocketAddress adress = new InetSocketAddress(host, port);
	 			socketChannel = SocketChannel.open(adress);
	 			socketChannel.configureBlocking(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return socketChannel;
	 	}
	 }
	 
	 public class CloseSocketState implements State
	 {
		 SocketChannel socketChannel;
		 public CloseSocketState(SocketChannel socketChannel){
			 this.socketChannel=socketChannel;
		 }
		 public SocketChannel processState(){
		 	try {
		 		socketChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			return socketChannel;
		 }
	 }
}
