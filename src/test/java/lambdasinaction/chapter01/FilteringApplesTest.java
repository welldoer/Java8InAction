package lambdasinaction.chapter01;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import lambdasinaction.Apple;
import lambdasinaction.chapter01.FilteringApples;

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
	public void rapidlyFilterGreenAppleTest() {
		List<Apple> greenApples = FilteringApples.filterApples( apples, ( Apple apple ) -> apple.getColor().equals( "green" ) );
		assertThat( greenApples ).isEqualTo( Arrays.asList( apple__80_green, apple_155_green ) );
	}

	@Test
	public void filterHeavyAppleTest() {
		List<Apple> greenApples = FilteringApples.filterApples( apples, FilteringApples::isHeavyApple );
		assertThat( greenApples ).isEqualTo( Arrays.asList( apple_155_green ) );
	}

	@Test
	public void rapidlyFilterHeavyAppleTest() {
		List<Apple> greenApples = FilteringApples.filterApples( apples, ( Apple apple ) -> apple.getWeight() > 150 );
		assertThat( greenApples ).isEqualTo( Arrays.asList( apple_155_green ) );
	}

	@Test
	public void filterSpecialAppleTest() {
		List<Apple> greenApples = FilteringApples.filterApples( apples, ( Apple apple ) -> apple.getWeight() < 80 || apple.getColor().equals( "brown" ) );
		assertThat( greenApples ).isEqualTo( Arrays.asList( ) );
	}

}
