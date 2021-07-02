package com.porter.jUnitTests;

import org.junit.Assert;
import org.junit.Test;

import com.porter.daos.AuthorDAO;
import com.porter.daos.AuthorDAOImpl;
import com.porter.models.Author;
import com.porter.services.AuthorServices;
import com.porter.services.AuthorServicesImpl;


public class AuthorDAOTest {

	private AuthorDAO adao = new AuthorDAOImpl();
	private AuthorServices as = new AuthorServicesImpl();

	@Test
	public void getAuthorTest() {
		Author a = new Author();
		a.setId(17);
		a.setAuthorName("Sydney Porter");
		a.setUsername("syd");
		a.setPassword("port");
		a.setPoints(100);
		
		Assert.assertEquals(a, adao.getAuthorById(17));
	}
}
