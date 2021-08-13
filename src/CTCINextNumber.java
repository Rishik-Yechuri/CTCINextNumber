public class CTCINextNumber {
    public static void main(String[] args) {
        try{
            CTCINextNumber obj = new CTCINextNumber();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        //Finds the next smallest and next largest number for 255
        findNextNumbers(255);
    }
    public void findNextNumbers(int input){
        String numberAsBinary = Integer.toString(input,2);
        int smallestNumber = -1;
        int largestNumber = -1;
        boolean swapFound = false;
        for(int x=numberAsBinary.length()-1;x>=1;x--){
            numberAsBinary.charAt(x);
            if(numberAsBinary.charAt(x) == '0' && numberAsBinary.charAt(x-1) == '1' && !swapFound){
                swapFound = true;
                StringBuilder myString = new StringBuilder(numberAsBinary);
                myString.setCharAt(x, '1');
                myString.setCharAt(x-1,'0');
                String smallestNumBinary =  myString.toString();
                smallestNumber = Integer.parseInt(smallestNumBinary,2);
            }
        }
        swapFound = false;
        for(int x=numberAsBinary.length()-1;x>=1;x--){
            if(numberAsBinary.charAt(x) == '1' && numberAsBinary.charAt(x-1) == '0' && !swapFound){
                swapFound = true;
                StringBuilder myString = new StringBuilder(numberAsBinary);
                myString.setCharAt(x, '0');
                myString.setCharAt(x-1,'1');
                String smallestNumBinary =  myString.toString();
                largestNumber = Integer.parseInt(smallestNumBinary,2);
            }
        }
        if(!swapFound){
            StringBuilder myString = new StringBuilder(numberAsBinary);
            myString.insert(0,"1");
            myString.setCharAt(1, '0');
            String largestNumBinary =  myString.toString();
            largestNumber = Integer.parseInt(largestNumBinary,2);
        }
        if(smallestNumber == -1){
            System.out.println("No Smaller Number found");
        }else{
            System.out.println("Smallest Number: " + smallestNumber);
        }
        if(largestNumber == -1){
            System.out.println("No Larger Number Found");
        }else{
            System.out.println("Largest Number: " + largestNumber);
        }
    }
}