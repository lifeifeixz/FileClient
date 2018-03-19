package pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author flysLi
 * @date 2018/3/19
 */
public class PDFtest {
    public static void main(String[] args) throws IOException, DocumentException {
        // TODO: 2018/3/19 设置远东字体，以支持中文
        //BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

        /*建立一个文档*/
        Document document = new Document();
        /*建立一个书写器*/
        PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.PDF"));
        /*打开文档*/
        document.open();
        document.addLanguage("Zn");
        /*设置标题*/
        document.addTitle("Java （计算机编程语言）");
        /*设置主题*/
        document.addSubject("Download JDK 8, a development environment for building applications and components using the Java programming language.");
        /*作者*/
        document.addAuthor("zhamusi·gesilin");
        /*创建者*/
        document.addCreator("flys·Li");
        /*关键字*/
        document.addKeywords("Java");
        document.addKeywords("Sun");
        document.addKeywords("Oracle");
        document.addCreationDate();


        /*向文档中添加内容*/
        document.add(new Paragraph("Thank you for downloading this release of the Java™ Platform, Standard Edition Development Kit (JDK™). The JDK is a development environment for building applications, applets, and components using the Java programming language."));
        document.add(new Paragraph("The JDK includes tools useful for developing and testing programs written in the Java programming language and running on the Java platform."));
        document.add(new Paragraph("Java Magazine is a bimonthly deep dive into Java and the JVM. Every issue contains explanations about the language and the platform written by experts and members of the Java development team. Contents includes tutorials on new technologies, investigations of alternative JVM languages, explanations of important tools, and lots of advice on coding. We also have regular sections for beginners, quizzes based on the Oracle certification tests, book reviews that don't mince words, in addition to instruction on Java EE, JavaFX, cloud-based Java, and embedded Java. "));
        /*关闭文档*/
        document.close();

    }
}
