package com.patrones.comportamiento.ChainOfResponsibility;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

class Request {
	public Request session() {return null;}
	public Request securityCheck() {return null;}
	public Request cookies() {return null;}
	public Request getParameters() {return null;}
}

@FunctionalInterface
interface Handler extends Function<Request, Request>{
	
} 

public class ChainOfResponsabilityJ8 {

	public static void main() {
		List<Handler> chain = new LinkedList<>();
		chain.add(Request::session);
		chain.add(Request::securityCheck);
		chain.add(Request::cookies);
		chain.add(Request::getParameters);
		
		Request req = new Request();
		
		Request processed = chain.stream().
				reduce(req, 
						(old, handler) -> handler.apply(old));
		
		Handler filterChain = chain.stream().reduce((r) -> r, 
				(f1,f2) -> f1.andThen(f2));
		
		
	}
}
