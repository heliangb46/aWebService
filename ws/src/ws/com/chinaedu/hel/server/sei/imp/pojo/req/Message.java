package ws.com.chinaedu.hel.server.sei.imp.pojo.req;


//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.13 at 09:56:06 ���� CST 
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
 *                   &lt;element name="sysHeader">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="esbSystemId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="esbServiceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="esbOpName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="esbVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="esbMsgTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="esbVerifiCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="esbRefGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="transRefGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="transNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="businessCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="businessType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="domHeader" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="bizHeader" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="body">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="cardNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
     *       &lt;sequence>
     *         &lt;element name="cardNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "cardNo",
        "password"
    })
    public static class Body {

        @XmlElement(required = true)
        protected String cardNo;
        @XmlElement(required = true)
        protected String password;

        /**
         * Gets the value of the cardNo property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCardNo() {
            return cardNo;
        }

        /**
         * Sets the value of the cardNo property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCardNo(String value) {
            this.cardNo = value;
        }

        /**
         * Gets the value of the password property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPassword() {
            return password;
        }

        /**
         * Sets the value of the password property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPassword(String value) {
            this.password = value;
        }

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
     *         &lt;element name="sysHeader">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="esbSystemId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="esbServiceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="esbOpName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="esbVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="esbMsgTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="esbVerifiCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="esbRefGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="transRefGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="transNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="businessCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="businessType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="domHeader" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="bizHeader" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "sysHeader",
        "domHeader",
        "bizHeader"
    })
    public static class Head {

        @XmlElement(required = true)
        protected Message.Head.SysHeader sysHeader;
        @XmlElement(required = true)
        protected String domHeader;
        @XmlElement(required = true)
        protected String bizHeader;

        /**
         * Gets the value of the sysHeader property.
         * 
         * @return
         *     possible object is
         *     {@link Message.Head.SysHeader }
         *     
         */
        public Message.Head.SysHeader getSysHeader() {
            return sysHeader;
        }

        /**
         * Sets the value of the sysHeader property.
         * 
         * @param value
         *     allowed object is
         *     {@link Message.Head.SysHeader }
         *     
         */
        public void setSysHeader(Message.Head.SysHeader value) {
            this.sysHeader = value;
        }

        /**
         * Gets the value of the domHeader property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDomHeader() {
            return domHeader;
        }

        /**
         * Sets the value of the domHeader property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDomHeader(String value) {
            this.domHeader = value;
        }

        /**
         * Gets the value of the bizHeader property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBizHeader() {
            return bizHeader;
        }

        /**
         * Sets the value of the bizHeader property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBizHeader(String value) {
            this.bizHeader = value;
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
         *         &lt;element name="esbSystemId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="esbServiceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="esbOpName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="esbVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="esbMsgTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="esbVerifiCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="esbRefGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="transRefGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="transNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="businessCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="businessType" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "esbSystemId",
            "esbServiceId",
            "esbOpName",
            "esbVersion",
            "esbMsgTime",
            "esbVerifiCode",
            "esbRefGUID",
            "transRefGUID",
            "transNo",
            "businessCode",
            "businessType"
        })
        public static class SysHeader {

            @XmlElement(required = true)
            protected String esbSystemId;
            @XmlElement(required = true)
            protected String esbServiceId;
            @XmlElement(required = true)
            protected String esbOpName;
            @XmlElement(required = true)
            protected String esbVersion;
            @XmlElement(required = true)
            protected String esbMsgTime;
            @XmlElement(required = true)
            protected String esbVerifiCode;
            @XmlElement(required = true)
            protected String esbRefGUID;
            @XmlElement(required = true)
            protected String transRefGUID;
            @XmlElement(required = true)
            protected String transNo;
            @XmlElement(required = true)
            protected String businessCode;
            @XmlElement(required = true)
            protected String businessType;

            /**
             * Gets the value of the esbSystemId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEsbSystemId() {
                return esbSystemId;
            }

            /**
             * Sets the value of the esbSystemId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEsbSystemId(String value) {
                this.esbSystemId = value;
            }

            /**
             * Gets the value of the esbServiceId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEsbServiceId() {
                return esbServiceId;
            }

            /**
             * Sets the value of the esbServiceId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEsbServiceId(String value) {
                this.esbServiceId = value;
            }

            /**
             * Gets the value of the esbOpName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEsbOpName() {
                return esbOpName;
            }

            /**
             * Sets the value of the esbOpName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEsbOpName(String value) {
                this.esbOpName = value;
            }

            /**
             * Gets the value of the esbVersion property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEsbVersion() {
                return esbVersion;
            }

            /**
             * Sets the value of the esbVersion property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEsbVersion(String value) {
                this.esbVersion = value;
            }

            /**
             * Gets the value of the esbMsgTime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEsbMsgTime() {
                return esbMsgTime;
            }

            /**
             * Sets the value of the esbMsgTime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEsbMsgTime(String value) {
                this.esbMsgTime = value;
            }

            /**
             * Gets the value of the esbVerifiCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEsbVerifiCode() {
                return esbVerifiCode;
            }

            /**
             * Sets the value of the esbVerifiCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEsbVerifiCode(String value) {
                this.esbVerifiCode = value;
            }

            /**
             * Gets the value of the esbRefGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEsbRefGUID() {
                return esbRefGUID;
            }

            /**
             * Sets the value of the esbRefGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEsbRefGUID(String value) {
                this.esbRefGUID = value;
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
             * Gets the value of the businessCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBusinessCode() {
                return businessCode;
            }

            /**
             * Sets the value of the businessCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBusinessCode(String value) {
                this.businessCode = value;
            }

            /**
             * Gets the value of the businessType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBusinessType() {
                return businessType;
            }

            /**
             * Sets the value of the businessType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBusinessType(String value) {
                this.businessType = value;
            }

        }

    }

}
