package rule;

import java.util.ArrayList;
import java.util.List;

//@XStreamAlias("rule-set")
 public class RuleSet {  
     /** 
      * 同种名称的规则集会自动合并 
     */  
     //@XStreamAsAttribute
     private String name;  

   // @XStreamImplicit
     private List<Rule> rules;

     public String getName() {  
         return name;  
     }  

     public void setName(String name) {  
         this.name = name;  
     }  

     public List<Rule> getRules() {  
         if(rules==null){  
             rules = new ArrayList<Rule>();
         }  
         return rules;  
     }  

     public void setRules(List<Rule> rules) {  
         this.rules = rules;  
     }  
 }  