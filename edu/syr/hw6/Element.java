// Name : - Pavan Pandya
// Net ID: - pjpandya@syr.edu
// SU ID: - 340197894

package edu.syr.hw6;
public class Element{
    String s;   
    Element(String str){
        if(str != null) {
            s = str;
        }
        else{
            s = "";
        }
    }

    public String toHtml(){
        return s + " ";
    }

    public String toString(){
        return s + " ";
    }
    public String toMarkdown(){
        return s + " ";
    }
}