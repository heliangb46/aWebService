package ws.com.chinaedu.hel.client.pojo.req;


//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.13 at 09:56:06 ���� CST 
//



import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link Message.Head.SysHeader }
     * 
     */
    public Message.Head.SysHeader createMessageHeadSysHeader() {
        return new Message.Head.SysHeader();
    }

    /**
     * Create an instance of {@link Message.Head }
     * 
     */
    public Message.Head createMessageHead() {
        return new Message.Head();
    }

    /**
     * Create an instance of {@link Message.Body }
     * 
     */
    public Message.Body createMessageBody() {
        return new Message.Body();
    }

}
