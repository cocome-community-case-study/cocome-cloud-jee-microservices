package org.cocome.productlist.serviceadapter.connector;

import java.util.List;

import org.cocome.productlist.data.IProduct;

public interface IProductListProvider {

	List<IProduct> getProducts();

}
