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
package org.n52.geolabel.server.mapping.description;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.n52.geolabel.commons.Label;
import org.n52.geolabel.commons.QualityInformationFacet;
import org.w3c.dom.Document;

/**
 * Checks availability of quality information
 * 
 */
@XmlRootElement(name = "qualityInformation")
public class QualityInformationFacetDescription extends
		FacetTransformationDescription<QualityInformationFacet> {
	@XmlElement
	private String scopeLevelPath;

	private XPathExpression scopeLevelExpression;

	@Override
	public void initXPaths(XPath xPath) throws XPathExpressionException {
		if (scopeLevelPath != null) {
			scopeLevelExpression = xPath.compile(scopeLevelPath);
		}
		super.initXPaths(xPath);
	}

	@Override
	public QualityInformationFacet updateFacet(
			final QualityInformationFacet facet, Document metadataXml)
			throws XPathExpressionException {
		visitExpressionResultStrings(scopeLevelExpression, metadataXml,
				new ExpressionResultFunction() {
					@Override
					public boolean eval(String value) {
						facet.addScopeLevel(value);
						return true;
					}
				});

		return super.updateFacet(facet, metadataXml);
	}

	@Override
	public QualityInformationFacet getAffectedFacet(Label label) {
		return label.getQualityInformationFacet();
	}

}