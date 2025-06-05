// Name : - Pavan Pandya
// Net ID: - pjpandya@syr.edu
// SU ID: - 340197894

package edu.syr.hw6;

public class Strikethru extends Element{
    Element formatting;
    Strikethru(String s){
        super(s);
        this.formatting = new Element(s);
    }
    Strikethru(Element fmt){
        super(formatting.s);
        this.formatting = formatting;
    }

    public String toHtml(){
        return "<s>" +  formatting.toHtml().trim() + "<s> ";
    }

    public String toString(){
        return formatting.toString();
    }

    public String toMarkdown(){
        return "--" +  formatting.toMarkdown().trim() + "--";
    }
}

