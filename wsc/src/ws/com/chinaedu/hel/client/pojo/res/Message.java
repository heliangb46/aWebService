package ws.com.chinaedu.hel.client.pojo.res;


//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.13 at 09:56:53 ���� CST 
//



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="head">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="response">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="esbRespType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="esbRespCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="esbRespDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="transRefGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="transNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="relateRows" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="businessRespCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="businessRespText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="businessRespTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="body">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "head",
    "body"
})
@XmlRootElement(name = "message")
public class Message {

    @XmlElement(required = true)
    protected Message.Head head;
    @XmlElement(required = true)
    protected Message.Body body;

    /**
     * Gets the value of the head property.
     * 
     * @return
     *     possible object is
     *     {@link Message.Head }
     *     
     */
    public Message.Head getHead() {
        return head;
    }

    /**
     * Sets the value of the head property.
     * 
     * @param value
     *     allowed object is
     *     {@link Message.Head }
     *     
     */
    public void setHead(Message.Head value) {
        this.head = value;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link Message.Body }
     *     
     */
    public Message.Body getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link Message.Body }
     *     
     */
    public void setBody(Message.Body value) {
        this.body = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Body {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="response">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="esbRespType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="esbRespCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="esbRespDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="transRefGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="transNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="relateRows" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="businessRespCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="businessRespText" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="businessRespTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "response"
    })
    public static class Head {

        @XmlElement(required = true)
        protected Message.Head.Response response;

        /**
         * Gets the value of the response property.
         * 
         * @return
         *     possible object is
         *     {@link Message.Head.Response }
         *     
         */
        public Message.Head.Response getResponse() {
            return response;
        }

        /**
         * Sets the value of the response property.
         * 
         * @param value
         *     allowed object is
         *     {@link Message.Head.Response }
         *     
         */
        public void setResponse(Message.Head.Response value) {
            this.response = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="esbRespType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="esbRespCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="esbRespDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="transRefGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="transNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="relateRows" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="businessRespCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="businessRespText" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="businessRespTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "esbRespType",
            "esbRespCode",
            "esbRespDesc",
            "transRefGUID",
            "transNo",
            "relateRows",
            "businessRespCode",
            "businessRespText",
            "businessRespTime"
        })
        public static class Response {

            @XmlElement(required = true)
            protected String esbRespType;
            @XmlElement(required = true)
            protected String esbRespCode;
            @XmlElement(required = true)
            protected String esbRespDesc;
            @XmlElement(required = true)
            protected String transRefGUID;
            @XmlElement(required = true)
            protected String transNo;
            @XmlElement(required = true)
            protected String relateRows;
            @XmlElement(required = true)
            protected String businessRespCode;
            @XmlElement(required = true)
            protected String businessRespText;
            @XmlElement(required = true)
            protected String businessRespTime;

            /**
             * Gets the value of the esbRespType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEsbRespType() {
                return esbRespType;
            }

            /**
             * Sets the value of the esbRespType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEsbRespType(String value) {
                this.esbRespType = value;
            }

            /**
             * Gets the value of the esbRespCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEsbRespCode() {
                return esbRespCode;
            }

            /**
             * Sets the value of the esbRespCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEsbRespCode(String value) {
                this.esbRespCode = value;
            }

            /**
             * Gets the value of the esbRespDesc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEsbRespDesc() {
                return esbRespDesc;
            }

            /**
             * Sets the value of the esbRespDesc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEsbRespDesc(String value) {
                this.esbRespDesc = value;
            }

            /**
             * Gets the value of the transRefGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransRefGUID() {
                return transRefGUID;
            }

            /**
             * Sets the value of the transRefGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransRefGUID(String value) {
                this.transRefGUID = value;
            }

            /**
             * Gets the value of the transNo property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransNo() {
                return transNo;
            }

            /**
             * Sets the value of the transNo property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransNo(String value) {
                this.transNo = value;
            }

            /**
             * Gets the value of the relateRows property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRelateRows() {
                return relateRows;
            }

            /**
             * Sets the value of the relateRows property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRelateRows(String value) {
                this.relateRows = value;
            }

            /**
             * Gets the value of the businessRespCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBusinessRespCode() {
                return businessRespCode;
            }

            /**
             * Sets the value of the businessRespCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBusinessRespCode(String value) {
                this.businessRespCode = value;
            }

            /**
             * Gets the value of the businessRespText property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBusinessRespText() {
                return businessRespText;
            }

            /**
             * Sets the value of the businessRespText property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBusinessRespText(String value) {
                this.businessRespText = value;
            }

            /**
             * Gets the value of the businessRespTime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBusinessRespTime() {
                return businessRespTime;
            }

            /**
             * Sets the value of the businessRespTime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBusinessRespTime(String value) {
                this.businessRespTime = value;
            }

        }

    }

}