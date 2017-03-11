/***************************************************************************
 * Copyright 2013 DFG SPP 1593 (http://dfg-spp1593.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************/

package org.cocome.tradingsystem.inventory.data.generator;

import java.io.File;
import java.io.IOException;

import javax.ejb.CreateException;
import javax.ejb.Singleton;

import org.cocome.tradingsystem.util.exception.NotInDatabaseException;


/**
 * Fills the database with entities representing a single enterprise with a
 * configurable number of stores. The counts of other entities are derived from
 * the number of stores to preserve realistic sizes of store inventories. Most
 * products sold by the enterprise are offered by all stores, but each store has
 * a set of products that are unique to the store.
 * 
 * @author Lubomir Bulej
 * @author Petr Tuma
 */
@Singleton
public class StorizedDatabaseFiller {

	/**
	 * Provides parameters for a store-centric configuration of the database.
	 */
	private static final class Configuration extends DatabaseConfiguration {

		private static final int __ENTERPRISE_COUNT__ = 1;

		private static final int __SHARED_PRODUCT_COUNT__ = 5000;
		private static final int __SHARED_PRODUCTS_PER_SUPPLIER_AVERAGE__ = 100;

		private static final int __UNIQUE_PRODUCTS_PER_STORE__ = 1000;
		private static final int __UNIQUE_PRODUCTS_PER_SUPPLIER_AVERAGE__ = 10;

		//

		/** Total number of stores in all enterprises. */
		private final int __storeCount;

		//

		Configuration(final int storeCount) {
			__storeCount = storeCount;
		}

		//

		@Override
		public int getEnterpriseCount() {
			return __ENTERPRISE_COUNT__;
		}

		@Override
		public int getStoreCount() {
			return __storeCount;
		}

		@Override
		public int getStockItemCount() {
			return __storeCount * getSharedProductCount() + getUniqueProductCount();
		}

		//

		@Override
		public int getSharedProductCount() {
			return __SHARED_PRODUCT_COUNT__;
		}

		@Override
		public int getUniqueProductCount() {
			return __storeCount * __UNIQUE_PRODUCTS_PER_STORE__;
		}

		@Override
		public int getSharedSupplierCount() {
			return getSharedProductCount() / __SHARED_PRODUCTS_PER_SUPPLIER_AVERAGE__;
		}

		@Override
		public int getUniqueSupplierCount() {
			return getUniqueProductCount() / __UNIQUE_PRODUCTS_PER_SUPPLIER_AVERAGE__;
		}

	}

	//

	public void fillDatabase(int storeCount, int cashDesksPerStore, String dirString)
			throws NotInDatabaseException, CreateException, IOException {
//		if (args.length < 1 || args.length > 3) {
//			DatabaseFiller.die("expected arguments: storeCount [cashDesksPerStore [outputDirectory]]\n");
//		}

		//

//		final int storeCount = Integer.parseInt(args[0]);
//		final int cashDesksPerStore = DatabaseFiller.getCashDesksPerStore(args, 1);
		final File outputDir = DatabaseFiller.getOutputDir(dirString);

		//

		DatabaseFiller.fillDatabase(
				new Configuration(storeCount), new DefaultEntityConfiguration(),
				cashDesksPerStore,
				outputDir
				);
	}

}
