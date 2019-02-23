package java8inaction;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FilteringApplesTest {
	
	private FilteringApples filteringApples;
	private List<Apple> apples;
	private Apple apple__80_green;
	private Apple apple_155_green;
	private Apple apple_120_red__;
	
	@Before
	public void setUp() {
		
		filteringApples = new FilteringApples();
		
		apple__80_green = new Apple(  80, "green" );
		apple_155_green = new Apple( 155, "green" );
		apple_120_red__ = new Apple( 120, "red" );
		apples = Arrays.asList( apple__80_green, apple_155_green, apple_120_red__ );
	}

	@Test
	public void test() {
		List<Apple> greenApples = FilteringApples.filterApples( apples, FilteringApples::isGreenApple );
		assertThat( greenApples ).isEqualTo( Arrays.asList( apple__80_green, apple_155_green ) );
	}

}
