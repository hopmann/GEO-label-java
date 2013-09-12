/**
 * Copyright 2013 52°North Initiative for Geospatial Open Source Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.geolabel.commons;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "producerComments")
public class ProducerCommentsFacet extends LabelFacet {
	@XmlElement(name = "commentsText")
	private Set<String> producerComments;

	public Collection<String> getProducerComments() {
		if (producerComments == null)
			return Collections.emptySet();

		return producerComments;
	}

	public void addProducerComment(String producerComment) {
		if (producerComments == null) {
			producerComments = new HashSet<String>();
		}
		this.producerComments.add(producerComment);
	}
}