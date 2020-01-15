package lt.itmokymai.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/annotation-application-context.xml" })
public class AppTest {
	@Autowired
	private Printer printer;
	@Autowired
	private ServiceC serviceC;

	@Test
	@Autowired
	public void shouldReturnTrueIfPrinterIsCreated() {
		assertTrue(printer != null);
	}

	@Test
	public void shouldCountListSizeCorrectly() {
		assertEquals(3, serviceC.getItems().size());
	}

}
