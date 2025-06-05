// Name : - Pavan Pandya
// Net ID: - pjpandya@syr.edu
// SU ID: - 340197894

package edu.syr.hw6;
public class Italic extends Element{
    Element formatting;
    Italic(String s){
        super(s);
        this.formatting = new Element(s);
    }
    Italic(Element fmt){
        super(formatting.s);
        this.formatting = fmt;
    }

    public String toHtml(){
        return "<i>" +  formatting.toHtml().trim() + "<i> ";
    }

    public String toString(){
        return formatting.toString();
    }

    public String toMarkdown(){
        return "*" +  formatting.toMarkdown().trim() + "* ";
    }
}
