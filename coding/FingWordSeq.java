import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class FingWordSeq{
     private static Map map = new HashMap();
     public static void main(String []args){
         map.put("This", "This");
         map.put("is", "is");
         map.put("ant", "ant");
         map.put("antenna", "antenna");
        //System.out.println("Hello World");
        findStringArray("Thisantennais");
     }
     private static void findStringArray(String input){
         ArrayList<String> list = new ArrayList<String>();
         int i = 0;
         
             while(i < input.length()){
                 i++;
                 String temp = input.substring(0,i);
                 if(map.get(temp)!=null){
                    list.add(temp);
                    input = input.substring(i,input.length() );
                    System.out.println("1:"+"temp:"+temp+":input:"+input);
                    i=0;
                 }else if( i == input.length()){
                     if(!list.isEmpty()){
                         String popped = list.remove(list.size() - 1);
                         input = popped + input;
                         i = popped.length();
                         System.out.println("2:"+"popped:"+popped+":input:"+input+":i:"+i);
                     }
                 }
             }
             if(list.isEmpty()){
                 System.out.println("Invalid input");
             }
             for(String s: list){
                 System.out.print(s +" ");
             }
         
     }
}
