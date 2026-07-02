package JAVA;

interface Document{
    String Open();
}
class WordDocument implements Document {
    @Override
    public String Open(){
        return "Opening WordDocument....";
    }
}

class ExcelDocument implements Document {
    @Override
    public String Open(){
        return "Opening ExcelDocument....";
    }
}

class PdfDocument implements Document {
    @Override
    public String Open() {
        return "Opening PDF Document....";
    }
}

interface DocumentFactory{
    Document CreateDocument();
}
class WordDocumentFactory implements DocumentFactory{
    @Override
    public Document CreateDocument(){
        return new WordDocument();
    }
}
class ExcelDocumentFactory implements DocumentFactory{
    @Override
    public Document CreateDocument(){
        return new ExcelDocument();
    }
}
class PDFDocumentFactory implements DocumentFactory{
    @Override
    public Document CreateDocument(){
        return new PdfDocument();
    }
}

public class Factory_method_Example {
    public static void main(String[] args){
        DocumentFactory factory;
        Document doc;

        factory=new WordDocumentFactory();
        doc=factory.CreateDocument();
        System.out.println(doc.Open());

        factory=new ExcelDocumentFactory();
        doc=factory.CreateDocument();
        System.out.println(doc.Open());

    }
}
