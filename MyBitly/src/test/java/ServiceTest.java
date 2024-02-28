import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybitly.myapp.entity.Link;
import com.mybitly.myapp.service.LinkService;
import com.mybitly.myapp.store.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ServiceTest {

	@Autowired
	LinkService service;
	
	@Autowired
	Store store;
	
	@Test
	public void testIsNotNull() {
		assertTrue(service != null);
		assertTrue(store != null);
	}
	
	@Test
	public void testAdd() {
		assertTrue(store.getLinkListSize() == 0);
		Link link = new Link("http://www.naver.com");
		service.add(link);
		assertTrue(store.getLinkListSize() > 0);
	}
	
	@Test
	public void testSearch() {
		Link link = new Link("http://www.naver.com");
		service.add(link);
		Link searchLink = service.search(link.getShortenUrl());
		assertTrue(searchLink.getDestUrl().matches("http://www.naver.com"));
	}

}
