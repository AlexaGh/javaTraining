package ex3;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class TestingLambda {

	
	
	public static void main(String[] args) {
		
		List<String> persons  = new ArrayList<>();
		persons.add("Alexa");
		persons.add("Marius");
		persons.add("Traian");
		
		//System.out.println(strings.stream().sorted().collect(Collectors.toList()));
		Collections.sort(persons, (p1, p2) -> p2.compareTo(p1));
		persons.forEach(p->System.out.println(p));
		
	}
	
	
}
