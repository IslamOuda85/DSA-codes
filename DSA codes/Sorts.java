
public class Sorts {
    // All sorting methods are implemented in arbitary Object type
    public static void main(String[] args) {
        int[] arr = {1,4,6,5,4,6,3};
        selectionSort(arr);
        System.out.println(arr.toString());        
    }

    public static void insertionSort(int[] list){
        for (int i = 1; i < list.length-1; i++){
            int j = i-1; 
            int pivot = list[i]; 
            while (j>=0 && list[j] > pivot ) {
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = pivot; //safety check: shallow assignment (no changes occuer!)
        }  
    }

    public static void selectionSort(int[] list){
        for(int i = 0; i < list.length-1;i++){
            int min = i;
            for (int j = i+1; j < list.length; j++){
                if (list[j] < list[i]) min = j;
            }
            swap(list,i,min); 
        }
    }

    private static void swap(int[] list, int a, int b){
        int temp = list[a];
        list[b] = list[a];
        list[a] = temp; 
    }

    public static void BubbleSort(int[] list){
        BubbleSort(list, list.length-1);
    }

    private static void BubbleSort(int[] list, int n){

        for(int i = 0; i < list.length-1; i++){
            for (int j = 0; j < list.length-i;j++){
                if(list[j] > list[j+1])
                    swap(list, list[j],list[j+1]);
            }
            
        }
    }

    public int[] mergeSort (int[] list){
        if(list.length>1){
            int mid = list.length/2;
            int[] firstHlf= partion(list, 0 ,mid-1);
            int[] secondHlf= partion(list, mid, list.length-1);
            firstHlf = mergeSort(firstHlf);
            secondHlf = mergeSort(secondHlf);
            list = merge(firstHlf, secondHlf);
        }
        return list;
    }


    private int[] merge (int[] A, int[]B){
        int[] C = new int[A.length+B.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k<C.length;k++){
            if (i==A.length || j==B.length){
                if (i==A.length){
                    C[k] = B[j];
                    j++;
                }
                else{
                    C[k] = A[i];
                    i++;
                }
            }else{
                if(A[i]>B[j]){
                    C[k]=B[j];
                    j++;
                }
                else{
                    C[k]=A[i];
                    i++;
                }
            } 
        }
        return C;
    }
    
    private int[] partion(int[] A, int i, int j){
        int len = j-i+1;
        int[] part = new int[len];
        for (int s = 0; s<len;s++){
            part[s] = A[i+s];
        }
        return part;
    }

}

