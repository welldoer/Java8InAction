package lambdasinaction.chapter03;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import lambdasinaction.Apple;

public class SortingTest {

	private List<Apple> apples;
	private Apple apple__80_green;
	private Apple apple_155_green;
	private Apple apple_120_red__;

	@Before
	public void setUp() throws Exception {
		apple__80_green = new Apple(  80, "green" );
		apple_155_green = new Apple( 155, "green" );
		apple_120_red__ = new Apple( 120, "red" );
		apples = Arrays.asList( apple__80_green, apple_155_green, apple_120_red__ );
	}

	@Test
	public void testComparator() {
		apples.sort( new AppleComparator() );
		assertThat( apples ).isEqualTo( Arrays.asList( apple__80_green, apple_120_red__, apple_155_green ) );
	}

}
