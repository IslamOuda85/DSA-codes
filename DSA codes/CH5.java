import java.io.File;

public class CH5 {
    public static void main(String[] args) {
        CircularlyLinkedList<Integer> cll = new CircularlyLinkedList<>();
        cll.addFirst(1);
        cll.addFirst(2);
        cll.addFirst(3);
        System.out.println(cll.first()); // 3
        System.out.println(cll.last()); // 1
    }


//Factorial
public int Factorial(int n){
    if (n==0){return 1;}
    else {
        return n * Factorial(n-1);
    }
}

public int tailFactorial(int n, int acc){
    if(n==0)return acc;
    return tailFactorial(n - 1, n * acc);
}


//Binary Search 
public int BinarySearch(int x, int[] data){
    return binsrch(x, data, 0, data.length - 1);
}

private int binsrch(int x, int[] data, int low, int high){
    if (low>high) return -1;
    int mid = (low + high) / 2;
    if (data[mid] == x)
         return mid;
    else if (x < data[mid]) 
        return binsrch(x, data, low, mid - 1);
    else
         return binsrch(x, data, mid + 1, high);
}

//reverse array


//English Ruler (4 methods) 
public void drawRuler(int len, int interval){
    drawline(len,interval);
    for (int i =1; i<= len;i++){
        drawInterval(interval-1);
        drawline(len,interval);
    }
}

private void drawline(int len, int interval){
    for (int i = 0; i < len; i++){
        System.out.print("-");
    }
    if(len>0){
        System.out.print(" " + len);
    }
    System.out.println();
}

private void drawInterval(int interval){
    if (interval >= 0){
        drawInterval(interval - 1);
        drawline(interval);
        drawInterval(interval - 1);
    }
}
private void drawline(int interval){
    drawline(interval,-1);
}



//Disk Usage
public long diskUsage(File f){
    long total = f.length();
    if (f.isDirectory()){
        for(String child: f.list()){
            File root = new File(f, child);
            total += diskUsage(root);
        }
    }
    return total;
}
//Fibonacci (exponential)
public int  FibonacciExp(int n){
    if (n<=0) return 0;
    if (n==1) return 1;
    return FibonacciExp(n-1) + FibonacciExp(n-2);
}

//power (linear)
public int pow(int x, int n){
    if (n==0) return 1;
    return x * pow(x, n-1); 
}
//power (logarithmic - 2 slightly different ways)
public int powLog(int x, int n){
    if (n==0) return 1;
    else{
        if(n%2==0){
            int y = powLog(x, n/2);
            return y * y;
        } else {
            int y = powLog(x, (n-1)/2);
            return x * y * y; 
        }
    }
}

//Binary sum
public int BinarySum(int[] x){
    if (x.length == 0) return 0;
    return BinSum(x,(x.length)/2);
}

private int BinSum(int[] x, int mid){
    if (x.length ==1) return x[0];
    else{
        int[] left = new int[mid];
        int[] right = new int[x.length - mid];
        for (int i = 0; i < mid; i++){
            left[i] = x[i];
        }
        for (int i = 0; i < x.length - mid; i++){
            right[i] = x[mid + i];
        }
        return BinSum(left, left.length/2) + BinSum(right, right.length/2);
    }
}

//Fibonacci (linear)
public int FibonacciLin (int n){
    if (n<=0) return 0;
    if (n==1) return 1;
    else{
        int x = FibonacciLin(n-1); 
        int y = FibonacciLin(n-2); 
        return x + y;
    }
}

//Fibonacci (linear with tail recursion)
public int FibonacciTail(int n, int a, int b){
    if (n==0) return a;
    if (n==1) return b;
    return FibonacciTail(n-1, b, a+b);
}

//reverse array (tail recursion)
public int[] reverseArrMain(int[] x){
    return reverseArrTail(x,0,x.length-1);
}


private int[] reverseArrTail (int[] x, int i, int j){
    if (i>=j){
        return x;
    } else {
        int temp = x[i];
        x[i]=x[j];
        x[j]=temp;
        return reverseArrTail(x, i+1, j-1);
    }
}
}