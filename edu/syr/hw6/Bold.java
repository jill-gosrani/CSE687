// Name : - Pavan Pandya
// Net ID: - pjpandya@syr.edu
// SU ID: - 340197894

package edu.syr.hw6;
public class Bold extends Element{
    Element formatting;
    Bold(String s){
        super(s);
        this.formatting = new Element(s);
    }
    Bold(Element formatting){
        super(formatting.s);
        this.formatting = formatting;
    }

    public String toHtml(){
        return "<b>" +  formatting.toHtml().trim() + "<b> ";
    }

    public String toString(){
        return formatting.toString();
    }

    public String toMarkdown(){
        return "**" +  formatting.toMarkdown().trim() + "** ";
    }
}