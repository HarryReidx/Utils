package cn.felord.datetime.convert;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class DOM4j {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            // 遍历
            SAXReader sr = new SAXReader();
            Document doc = sr.read("G:\\xml\\name.xml");
            Element root = doc.getRootElement();
            List<Element> name = root.elements("name");
            for (Element names : name) {
                System.out.println(names.attributeValue("id"));
                List<Element> age = names.elements("age");
                for (Element ages : age) {
                    System.out.println(ages.getText());
                }
            }
            // 添加
            Element newname = root.addElement("name");
            newname.addAttribute("id", "小明");
            Element newage = newname.addElement("age");
            newage.setText("18");
            //删除
            root.remove(name.get(3));
            // 写入
            XMLWriter xw = new XMLWriter(new FileOutputStream("src\\name.xml"));
            xw.write(doc);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}