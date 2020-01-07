package cn.felord.datetime.convert;


import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOM {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // 创建DOM解析器工厂
            DocumentBuilder db = dbf.newDocumentBuilder();
            // 调用DOM解析器工厂的newDocumentBuilder()方法得到DOM解析器对象
            Document doc = db.parse("G:\\xml\\name.xml");
            // 调用DOM解析器对象parse(String uri)方法得到Document对象
            NodeList nl = doc.getElementsByTagName("name");
            // 调用Document对象的getElementsByTagName(String tagname)方法得到NodeList对象
            /*
             * 遍历XML中的元素
             */
            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                // 通过NodeList的item(int index)方法得到NodeList中的Node对象
                Element element = (Element) node;
                // 通过Node对象强制转换的方法得到Element对象
                String id = element.getAttribute("id");
                // 通过Element对象的getgetAttribute(String name)方法得到id属性值
                System.out.println(id);
                // 打印id属性值
                String age = element.getElementsByTagName("age").item(0).getTextContent();
                // 通过Element对象的getElementsByTagName(String name)方法得到age的属性值
                System.out.println(age);
                // 打印age
            }
            /*
             * 添加元素到XML中
             */
            Element root = doc.getDocumentElement();
            // 通过Document对象的getDocumentElement()方法得到根节点
            Element newname = doc.createElement("name");
            // 通过Document对象的createElement(String tagName)方法得到新的name元素
            newname.setAttribute("id", "小明");
            // 通过调用Element对象的setAttribute(String name,String value)方法为id赋值
            Element newage = doc.createElement("age");
            // 通过Document对象的createElement(String tagName)方法得到新的age元素
            newage.setTextContent("18");
            // 通过调用Element对象的setTextContent(String textContent)方法为age赋值
            newname.appendChild(newage);
            // 添加age到name中
            root.appendChild(newname);
            // 添加name到根节点中
            /*
             * 修改XML中的元素
             */
            for (int i = 0; i < nl.getLength(); i++) {
                Element fixname = (Element) nl.item(i);
                // 得到要修改的Element对象
                String fixnewname = fixname.getAttribute("id");
                // 获取到要修改对象的id属性值
                /*
                 * 判断name是否为要修改的对象
                 */
                if (fixnewname.equals("小明")) {
                    Element sex = doc.createElement("sex");
                    // 创建新的Element对象
                    sex.setAttribute("sex", "男");
                    // 给新的Element对象的属性赋值
                    fixname.appendChild(sex);
                    // 添加新的Element(sex)对象到Element(fixname)对象中
                }
            }
            /*
             * 删除XML中的元素
             */
            root.removeChild(root.getChildNodes().item(7));
            // 首先通过根节点访问子节点，得到Node对象，然后调用根节点的removeChild(Node oldChild)方法删除元素
            /*
             * 将更改写入到XML文件中
             */
            TransformerFactory tf = TransformerFactory.newInstance();
            // 调用TransformerFactory的newInstance()方法得到TransformerFactory对象
            Transformer t = tf.newTransformer();
            // 调用TransformerFactory对象的newTransformer()方法得到Transformer对象
            t.transform(new DOMSource(doc), new StreamResult("src\\name.xml"));
            // 调用Transformer对象的transform(Source xmlSource,Result
            // outputTarget)方法将修改写入到name.xml文件中
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}