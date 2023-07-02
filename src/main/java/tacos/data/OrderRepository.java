package tacos.data;

import tacos.TacoOrder;

public interface OrderRepository {
	TacoOrder save(TacoOrder order);
}
