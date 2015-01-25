public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        
        char[] array = {'a','b','c'};
        permute("", array, 0);
     }
     private static void permute(String constStr, char[] array, int start){
         
         if(array.length - start == 1){
             System.out.println(constStr+array[start]);
             return;
         }
         for(int i = start ; i< array.length; i++){
             char temp = array[start];
             array[start] = array[i];
             array[i] = temp;
             permute(constStr+array[start], array, start + 1);
             temp = array[start];
             array[start] = array[i];
             array[i] = temp;
         }
     }
}
