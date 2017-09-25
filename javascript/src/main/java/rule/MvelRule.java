package rule;


import org.apache.commons.lang3.StringUtils;

//@XStreamAlias("mvel-rule")
 public class MvelRule extends Rule{  
     //匹配条件  
    private String condition;  
     //后续操作  
    private String action;  

     public String getCondition() {  
         return condition;  
     }  

     public void setCondition(String condition) {  
         this.condition = condition;  
     }  

     public String getAction() {  
         return action;  
     }  

     public void setAction(String action) {  
         this.action = action;  
     }  

     public String getType(){  
         return "mvel";  
     }  

     /** 
      * 验证mvel规则的合法性 
     */  
     public boolean isVaild() {

         if(StringUtils.isEmpty(getCondition())){
             throw new RuntimeException(String.format("规则[%s]的匹配条件为空", getId()));  
         }  
         if(StringUtils.isEmpty(getAction())){
             throw new RuntimeException(String.format("规则[%s]的后续操作为空", getId()));  
         }  
         return true;  
     }

    @Override
    public int compareTo(Rule o) {
        return 0;
    }
}