package com.origamisoftware.teach.advanced.app;

import com.origamisoftware.teach.advanced.xml.Stocks;
import com.origamisoftware.teach.advanced.*;
import com.origamisoftware.teach.advanced.services.APIStockService;
import com.origamisoftware.teach.advanced.services.DatabaseStockService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.util.Calendar;

/**
 * A basic app that shows how to marshall and unmarshal XML instances.
 * We take xml data of stocks and store it into our database
 * @author Farhan S
 */
public class BasicJAXBExample {
    
        private static String xmlInstance = "";

    
    public static void main(String[] args) throws JAXBException, FileNotFoundException, IOException {
          //"/Users/mainUser/Desktop/UML/Summer/AdvJava/Week7/Week7/src/main/resources/xml/family.xml"
        File f=new File("./src/main/resources/xml/stock_info.xml");
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);

        String line;
        while((line=br.readLine())!=null)
        {   
            xmlInstance += line;
        }
        
        // here is how to go from XML to Java
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stocks stocks = (Stocks) unmarshaller.unmarshal(new StringReader(xmlInstance));
        System.out.println(stocks.toString());
        //System.out.println(stocks.getStock().get(0).getSymbol());
        
        
        DatabaseStockService dbstockservice = new DatabaseStockService();
        dbstockservice.addStock(stocks.getStock().get(0));
        dbstockservice.addAllStock(stocks);
        
        // here is how to go from Java to XML
        JAXBContext context = JAXBContext.newInstance(Stocks.class);
        Marshaller marshaller = context.createMarshaller();
        //for pretty-print XML in JAXB
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(stocks, System.out);
          

    }
}
