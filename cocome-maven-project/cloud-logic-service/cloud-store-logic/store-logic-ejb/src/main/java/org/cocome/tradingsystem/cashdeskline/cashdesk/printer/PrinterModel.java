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

package org.cocome.tradingsystem.cashdeskline.cashdesk.printer;

import java.io.Serializable;

import org.cocome.tradingsystem.util.mvc.AbstractModel;
import org.cocome.tradingsystem.util.scope.CashDeskSessionScoped;

/**
 * Implements the cash desk printer model.
 * 
 * @author Lubomir Bulej
 * @author Tobias Pöppke
 * @author Robert Heinrich
 */
@CashDeskSessionScoped
public class PrinterModel
		extends AbstractModel<PrinterModel> implements IPrinterModel, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1991953644599468232L;

	//

	private final StringBuilder output = new StringBuilder();

	//
	// Printer model methods
	//

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void tearOffPrintout() {
		this.clearOutput();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void printText(final String text) {
		this.appendOutput(text);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCurrentPrintout() {
		return this.output.toString();
	}

	//

	private void clearOutput() {
		this.output.setLength(0);
		this.changedContent();
	}

	private void appendOutput(final String text) {
		this.output.append(text);
		this.changedContent();
	}
}
