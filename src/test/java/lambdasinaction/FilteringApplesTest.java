package lambdasinaction;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import lambdasinaction.Apple;
import lambdasinaction.FilteringApples;

public class FilteringApplesTest {
	
	private List<Apple> apples;
	private Apple apple__80_green;
	private Apple apple_155_green;
	private Apple apple_120_red__;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Before
	public void setUp() {
		
		apple__80_green = new Apple(  80, "green" );
		apple_155_green = new Apple( 155, "green" );
		apple_120_red__ = new Apple( 120, "red" );
		apples = Arrays.asList( apple__80_green, apple_155_green, apple_120_red__ );
	}

	@Test
	public void invalidInstance() {
		expectedException.expect( IllegalStateException.class );
		expectedException.expectMessage( "Invalid instance!" );
		new FilteringApples();
	}
	
	@Test
	public void filterGreenAppleTest() {
		List<Apple> greenApples = FilteringApples.filterApples( apples, FilteringApples::isGreenApple );
		assertThat( greenApples ).isEqualTo( Arrays.asList( apple__80_green, apple_155_green ) );
	}

	@Test
	public void filterHeavyAppleTest() {
		List<Apple> greenApples = FilteringApples.filterApples( apples, FilteringApples::isHeavyApple );
		assertThat( greenApples ).isEqualTo( Arrays.asList( apple_155_green ) );
	}

}
