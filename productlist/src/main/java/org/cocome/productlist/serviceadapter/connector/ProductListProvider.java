package org.cocome.productlist.serviceadapter.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import org.cocome.productlist.data.IProduct;
import org.cocome.productlist.data.Product;

@ManagedBean(name="product_list_provider")
@SessionScoped
public class ProductListProvider implements IProductListProvider, Serializable {
	
	private static final long serialVersionUID = 5151279706091153064L;

	private static final Logger LOG = Logger.getLogger(ProductListProvider.class);

	static final String CSV_SPLIT_BY = ";";

	public List<IProduct> getProducts() {
		IBackendQuery csvFromServiceAdapter = new GetXMLFromBackend();
		String csvProducs = csvFromServiceAdapter.getProducts("name=LIKE%20'*'");
		String line = "";
		List<IProduct> productList = new ArrayList<IProduct>();
		try (BufferedReader reader = new BufferedReader(new StringReader(csvProducs))) {
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] productString = line.split(CSV_SPLIT_BY);
				Long barcode = Long.parseLong(productString[0]);
				String name = productString[1];
				double price = Double.parseDouble(productString[2]);
				productList.add(new Product(barcode, barcode, name, price));
				LOG.trace(String.format("Found Product: %d %s %.2f", barcode, name, price));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return productList;
	}

}
