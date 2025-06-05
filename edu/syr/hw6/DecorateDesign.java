package edu.syr.hw6;
public class DecorateDesign {
    public static void main(String[] args) {
        Element[] pangram = new Element[9];
        pangram[0] = new Element("The");
        pangram[1] = new Italic("quick");
        pangram[2] = new Bold(pangram[1]);
        pangram[3] = new Element("fox");
        pangram[4] = new Element("jumps");
        pangram[5] = new Element("over");
        pangram[6] = new Element("the");
        pangram[7] = new Strikethru(new Bold(new Italic("Dog")));
        pangram[8] = new Element("");

        StringBuffer justText = new StringBuffer();
        StringBuffer markdown = new StringBuffer();
        StringBuffer htmlDown = new StringBuffer();
        for (Element e: pangram) {
            justText.append(e.toString());
            markdown.append(e.toMarkdown());
            htmlDown.append(e.toHtml());
        }
        System.out.println(justText.toString().trim());
        System.out.println(markdown.toString().trim());
        System.out.println(htmlDown.toString().trim());
        
    }
}
