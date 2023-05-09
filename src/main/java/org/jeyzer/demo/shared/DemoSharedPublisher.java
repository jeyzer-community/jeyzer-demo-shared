package org.jeyzer.demo.shared;

/*-
 * ---------------------------LICENSE_START---------------------------
 * Jeyzer Demo Shared Library
 * --
 * Copyright (C) 2020 - 2023 Jeyzer
 * --
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 * ----------------------------LICENSE_END----------------------------
 */

import org.jeyzer.annotations.Function;

public class DemoSharedPublisher {

	private DemoSharedListener listener;
	
	public DemoSharedPublisher(DemoSharedListener listener) {
		this.listener = listener;
	}

	@Function
	public void publish() {
		listener.callback();
	}
}
