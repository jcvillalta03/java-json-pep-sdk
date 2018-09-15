package com.axiomatics.xacml.json.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
public class JsonTest {

    private ObjectMapper mapper;

    @Before
    public void before() {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    @Test
    public void testRequestJsonFormat() throws JsonProcessingException {
        Request request = new Request();

        List<String> nickNames = new ArrayList<>();
        nickNames.add("Andy");
        nickNames.add("Dre");

        Category accessSubjectCategory = new Category();
        accessSubjectCategory.addAttribute("subject-id", "Andreas");
        accessSubjectCategory.addAttribute("location", "Gamla Stan");
        accessSubjectCategory.addAttribute("nicknames", nickNames);

        Category actionCategory = new Category();
        actionCategory.addAttribute("action-id", "http://example.com/buy", "anyURI");

        Category resourceCategory = new Category();
        resourceCategory.addAttribute("book-title", "Learn German in 90 days");
        resourceCategory.addAttribute("currency", "SEK");
        resourceCategory.addAttribute("price", 123.34);

        request.addAccessSubjectCategory(accessSubjectCategory);
        request.addActionCategory(actionCategory);
        request.addResourceCategory(resourceCategory);

        String jsonString = mapper.writeValueAsString(request);
        System.out.println(jsonString);
        assertTrue(true);
    }

    /**
     * From {@link http://docs.oasis-open.org/xacml/xacml-json-http/v1.0/xacml-json-http-v1.0.html} - Table 4
     * <p>
     * Tests that Attribute json matches the following:
     * <p>
     * {
     * "Attribute": {
     * "AttributeId"   :   "document-id",
     * "DataType"      :   "integer",
     * "Value"         :   123
     * }
     * }
     *
     * @throws JsonProcessingException
     */
    @Test
    public void testAttributeJsonFormat() throws JsonProcessingException {
        Attribute attribute = new Attribute("document-id", 123);

        String jsonString = mapper.writeValueAsString(attribute);
        System.out.println(jsonString);

        assertTrue(true);
    }

    /**
     * From {@link http://docs.oasis-open.org/xacml/xacml-json-http/v1.0/xacml-json-http-v1.0.html} - Table 4
     * <p>
     * Tests that Attribute json matches the following:
     * <p>
     * {
     * "Attribute":{
     * "AttributeId":"urn:oasis:names:tc:xacml:3.0:content-selector",
     * "DataType":"xpathExpression",
     * "Value":{
     * "XPathCategory":"urn:oasis:names:tc:xacml:3.0:attribute-category:resource",
     * "Namespaces":[{
     * "Namespace": "urn:oasis:names:tc:xacml:3.0:core:schema:wd-17"
     * },{
     * "Prefix":"md",
     * "Namespace":"urn:example:med:schemas:record"
     * }],
     * "XPath":"md:record/md:patient/md:patientDoB"
     * }
     * }
     * }
     *
     * @throws JsonProcessingException
     */
    @Test
    public void testAttributeJsonFormat_WithXpathExpression() throws JsonProcessingException {

        List<NamespaceDeclaration> namespaceDeclarations = new ArrayList<>();
        namespaceDeclarations.add(new NamespaceDeclaration("urn:oasis:names:tc:xacml:3.0:core:schema:wd-17"));
        namespaceDeclarations.add(new NamespaceDeclaration("md", "urn:example:med:schemas:record"));
        XPathExpression xPathExpression = new XPathExpression("urn:oasis:names:tc:xacml:3.0:attribute-category:resource", "md:record/md:patient/md:patientDoB");
        xPathExpression.addNamespaceDeclaration("urn:oasis:names:tc:xacml:3.0:core:schema:wd-17");
        xPathExpression.addNamespaceDeclaration("urn:example:med:schemas:record", "md");
        Attribute attribute = new Attribute("urn:oasis:names:tc:xacml:3.0:content-selector", xPathExpression, "xpathExpression");

        String jsonString = mapper.writeValueAsString(attribute);
        System.out.println(jsonString);

        assertTrue(true);
    }


}
