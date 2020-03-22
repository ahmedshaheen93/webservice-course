
package com.shaheen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.shaheen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SubNumbersResponse_QNAME = new QName("http://shaheen.com/", "subNumbersResponse");
    private final static QName _SubNumbers_QNAME = new QName("http://shaheen.com/", "subNumbers");
    private final static QName _DivNumbersResponse_QNAME = new QName("http://shaheen.com/", "divNumbersResponse");
    private final static QName _DivNumbers_QNAME = new QName("http://shaheen.com/", "divNumbers");
    private final static QName _MulNumbersResponse_QNAME = new QName("http://shaheen.com/", "mulNumbersResponse");
    private final static QName _MulNumbers_QNAME = new QName("http://shaheen.com/", "mulNumbers");
    private final static QName _AddNumbers_QNAME = new QName("http://shaheen.com/", "addNumbers");
    private final static QName _AddNumbersResponse_QNAME = new QName("http://shaheen.com/", "addNumbersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.shaheen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MulNumbers }
     * 
     */
    public MulNumbers createMulNumbers() {
        return new MulNumbers();
    }

    /**
     * Create an instance of {@link AddNumbers }
     * 
     */
    public AddNumbers createAddNumbers() {
        return new AddNumbers();
    }

    /**
     * Create an instance of {@link AddNumbersResponse }
     * 
     */
    public AddNumbersResponse createAddNumbersResponse() {
        return new AddNumbersResponse();
    }

    /**
     * Create an instance of {@link SubNumbers }
     * 
     */
    public SubNumbers createSubNumbers() {
        return new SubNumbers();
    }

    /**
     * Create an instance of {@link SubNumbersResponse }
     * 
     */
    public SubNumbersResponse createSubNumbersResponse() {
        return new SubNumbersResponse();
    }

    /**
     * Create an instance of {@link MulNumbersResponse }
     * 
     */
    public MulNumbersResponse createMulNumbersResponse() {
        return new MulNumbersResponse();
    }

    /**
     * Create an instance of {@link DivNumbers }
     * 
     */
    public DivNumbers createDivNumbers() {
        return new DivNumbers();
    }

    /**
     * Create an instance of {@link DivNumbersResponse }
     * 
     */
    public DivNumbersResponse createDivNumbersResponse() {
        return new DivNumbersResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubNumbersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shaheen.com/", name = "subNumbersResponse")
    public JAXBElement<SubNumbersResponse> createSubNumbersResponse(SubNumbersResponse value) {
        return new JAXBElement<SubNumbersResponse>(_SubNumbersResponse_QNAME, SubNumbersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubNumbers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shaheen.com/", name = "subNumbers")
    public JAXBElement<SubNumbers> createSubNumbers(SubNumbers value) {
        return new JAXBElement<SubNumbers>(_SubNumbers_QNAME, SubNumbers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivNumbersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shaheen.com/", name = "divNumbersResponse")
    public JAXBElement<DivNumbersResponse> createDivNumbersResponse(DivNumbersResponse value) {
        return new JAXBElement<DivNumbersResponse>(_DivNumbersResponse_QNAME, DivNumbersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivNumbers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shaheen.com/", name = "divNumbers")
    public JAXBElement<DivNumbers> createDivNumbers(DivNumbers value) {
        return new JAXBElement<DivNumbers>(_DivNumbers_QNAME, DivNumbers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MulNumbersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shaheen.com/", name = "mulNumbersResponse")
    public JAXBElement<MulNumbersResponse> createMulNumbersResponse(MulNumbersResponse value) {
        return new JAXBElement<MulNumbersResponse>(_MulNumbersResponse_QNAME, MulNumbersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MulNumbers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shaheen.com/", name = "mulNumbers")
    public JAXBElement<MulNumbers> createMulNumbers(MulNumbers value) {
        return new JAXBElement<MulNumbers>(_MulNumbers_QNAME, MulNumbers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNumbers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shaheen.com/", name = "addNumbers")
    public JAXBElement<AddNumbers> createAddNumbers(AddNumbers value) {
        return new JAXBElement<AddNumbers>(_AddNumbers_QNAME, AddNumbers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNumbersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shaheen.com/", name = "addNumbersResponse")
    public JAXBElement<AddNumbersResponse> createAddNumbersResponse(AddNumbersResponse value) {
        return new JAXBElement<AddNumbersResponse>(_AddNumbersResponse_QNAME, AddNumbersResponse.class, null, value);
    }

}
