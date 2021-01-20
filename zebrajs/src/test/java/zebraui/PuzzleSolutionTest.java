package zebraui;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.teavm.junit.TeaVMTestRunner;

import zebra4j.AtHouse;
import zebra4j.Clothes;
import zebra4j.PersonName;
import zebra4j.PuzzleSolution;
import zebra4j.PuzzleSolutionBuilder;

@RunWith(TeaVMTestRunner.class)
public class PuzzleSolutionTest {

	/**
	 * Equals and hashCode test is needed for TeaVM as their implementation for map
	 * and set may be broken
	 */
	@Test
	public void testEqualsHashcode() {
		PuzzleSolution sol = PuzzleGeneratorTest.sampleSolution();
		Assert.assertEquals(sol, new PuzzleSolution(sol.getPeople(), new HashMap<>(sol.getAttributeSets())));
		Assert.assertEquals(sol, otherSolution());
		Assert.assertEquals(sol.hashCode(), otherSolution().hashCode());
	}

	public static PuzzleSolution otherSolution() {
		PuzzleSolutionBuilder builder = new PuzzleSolutionBuilder();
		builder.add(PersonName.ГЕОРГИ, Clothes.ЖЪЛТИ, new AtHouse(2));
		builder.add(PersonName.ПЕТЪР, Clothes.СИНИ, new AtHouse(1));
		builder.add(PersonName.ИВАН, Clothes.ЗЕЛЕНИ, new AtHouse(3));
		PuzzleSolution solution = builder.build();
		return solution;
	}

}
