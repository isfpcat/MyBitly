import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybitly.myapp.util.Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UtilsTest {

	@Autowired
	Utils utils;
	
	@Test
	public void testUtils() {
		String result = utils.createUrl();
		System.out.println(result);
		assertTrue(result.matches("\\d[\\d|\\w]{7}"));
	}

}
