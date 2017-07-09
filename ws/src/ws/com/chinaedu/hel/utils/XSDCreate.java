package ws.com.chinaedu.hel.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import ws.com.chinaedu.hel.server.sei.imp.pojo.req.Message;

public class XSDCreate {

    public CustomSchemaOutputResolver resolver;

    public static void main(String[] args) {
        XSDCreate xsdCreate = new XSDCreate();
        xsdCreate.resolver = xsdCreate.new CustomSchemaOutputResolver("E:\\schema", "Message.xsd");

        Class<?>[] classes = { Message.class };
        xsdCreate.createXSD(classes);

        System.out.println("all done");
    }

    public void createXSD(Class<?>[] classes) {
        try {
            JAXBContext context = JAXBContext.newInstance(classes);
            context.generateSchema(resolver);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class CustomSchemaOutputResolver extends SchemaOutputResolver {

        private File file;

        public CustomSchemaOutputResolver(String dir, String fileName) {
            try {
                file = new File(dir, fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
            return new StreamResult(file);
        }

    }
}
