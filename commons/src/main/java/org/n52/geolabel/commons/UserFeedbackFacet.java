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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "userFeedback")
class UserFeedbackFacet extends FeedbackFacet {
	@Override
	@XmlElement
	public int getTotalFeedbacks() {
		return super.getTotalFeedbacks();
	}

	@Override
	@XmlElement
	public int getTotalRatings() {
		return super.getTotalRatings();
	}

	@Override
	@XmlElement
	public Double getAverageRating() {
		return super.getAverageRating();
	}
}