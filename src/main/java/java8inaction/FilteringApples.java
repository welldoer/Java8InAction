package java8inaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {

	public static List<Apple> filterApples( List<Apple> apples, Predicate<Apple> p ) {
		List<Apple> result = new ArrayList<>();
		for( Apple apple : apples ) {
			if( p.test( apple ) ) {
				result.add( apple );
			}
		}
		return result;
	}
	
	public static boolean isGreenApple( Apple apple ) {
		return apple.getColor().equals( "green" );
	}

}
