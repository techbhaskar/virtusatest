import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

public class NumberToWordTest extends TestCase {

	NumberToWord obj = null;
	@Override
	protected void setUp() throws Exception {
		obj = new NumberToWord();
		super.setUp();
	}
	public void testConvertLessThanOneThousand() {
		String orgRes = obj.convertLessThanOneThousand(999);
		assertNotNull(orgRes);
		assertEquals(" nine hundred ninety nine", orgRes);
	}

	public void testConvertToWord() {
		String orgRes = obj.convertToWord(1254789);
		assertNotEquals("one million two hundred fifty four thousand seven hundred eighty nine ", orgRes);;
		assertEquals("one million two hundred fifty four thousand seven hundred eighty nine", orgRes);
	}

}
