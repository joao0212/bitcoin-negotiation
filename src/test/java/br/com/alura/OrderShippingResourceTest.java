package br.com.alura;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.alura.model.OrderShipping;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class OrderShippingResourceTest {

	@Test
	public void testOrderShippingListAll() {
		PanacheMock.mock(OrderShipping.class);
		List<PanacheEntityBase> los = new ArrayList<>();
		Mockito.when(OrderShipping.listAll()).thenReturn(los);
		Assertions.assertEquals(los, OrderShipping.listAll());
	}
}
