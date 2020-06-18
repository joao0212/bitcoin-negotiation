package br.com.alura;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.alura.model.User;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UserResourceTest {

	@Test
	public void testUserListAll() {
		PanacheMock.mock(User.class);
		List<PanacheEntityBase> ul = new ArrayList<>();
		Mockito.when(User.listAll()).thenReturn(ul);
		Assertions.assertEquals(ul, User.listAll());
	}

	@Test
	public void testUserFindById() {
		PanacheMock.mock(User.class);
		User u = new User();
		Mockito.when(User.findById(1)).thenReturn(u);
		Assertions.assertEquals(u, User.findById(1));
		
	}
}
