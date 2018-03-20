package com.example.demo.util;

import java.io.IOException;    
import java.io.StringReader;    
import java.io.StringWriter;    
    
import javax.xml.stream.XMLEventReader;    
import javax.xml.stream.XMLEventWriter;    
import javax.xml.stream.XMLInputFactory;    
import javax.xml.stream.XMLOutputFactory;

import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLInputFactory;
import de.odysseus.staxon.json.JsonXMLOutputFactory;
import de.odysseus.staxon.xml.util.PrettyXMLEventWriter;    
    

/**  
 * json and xml converter  
 * @author magic_yy  
 * @see https://github.com/beckchr/staxon  
 * @see https://github.com/beckchr/staxon/wiki  
 * 
 *  Copyright [2011,2012] [Odysseus Software]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */    

public class StaxonUtils {

	//xml->json 변환
    public static String xml2json(String xml){    
        StringReader xml_input = new StringReader(xml);    
        StringWriter json_output = new StringWriter();    
        //staxon 라이브러리 xmlconfig
        JsonXMLConfig config = new JsonXMLConfigBuilder().autoArray(true).autoPrimitive(true).prettyPrint(true).build();    
        try {    
        	//staxon 라이브러리 Input, Output
            XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(xml_input);    
            XMLEventWriter writer = new JsonXMLOutputFactory(config).createXMLEventWriter(json_output);    
            writer.add(reader);    
            reader.close();    
            writer.close();    
        } catch( Exception e){    
            e.printStackTrace();    
        } finally {    
            try {    
            	xml_input.close();    
            	json_output.close();    
            } catch (IOException e) {    
                e.printStackTrace();    
            }    
        }    
        return json_output.toString();    
    }    

    //json->xml 변환
    public static String json2xml(String json){    
        StringReader json_input = new StringReader(json);    
        StringWriter xml_output = new StringWriter();    
        JsonXMLConfig config = new JsonXMLConfigBuilder().multiplePI(false).repairingNamespaces(false).build();    
        try {    
            XMLEventReader reader = new JsonXMLInputFactory(config).createXMLEventReader(json_input);    
            XMLEventWriter writer = XMLOutputFactory.newInstance().createXMLEventWriter(xml_output);    
            writer = new PrettyXMLEventWriter(writer);    
            writer.add(reader);    
            reader.close();    
            writer.close();    
        } catch( Exception e){    
            e.printStackTrace();    
        } finally {    
            try {    
            	xml_output.close();    
                json_input.close();    
            } catch (IOException e) {    
                e.printStackTrace();    
            }    
        }    
        if(xml_output.toString().length()>=38){//remove <?xml version="1.0" encoding="UTF-8"?>    
            return xml_output.toString().substring(39);    
        }    
        return xml_output.toString();    
    }    
        
}
