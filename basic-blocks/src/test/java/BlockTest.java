import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.divit.ngoc.model.Block;

public class BlockTest {
	
	@Test
	public void testBlock()
	{
		Block block1 = new Block("some data", "0");
		assertNotNull(block1);
		Block block2 = new Block("some data", block1.getHash());
		assertNotNull(block2);

		assertNotEquals(block1.getHash(), block2.getHash());
		assertEquals(block1.getHash(), block2.getPreviousHash());
	}
	
}
