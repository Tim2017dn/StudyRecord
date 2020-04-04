package learnAlgorithm;

public class Heap {

	public static void main(String[] args) {
		
		int[] arr= {11,3,5,76,8,9,4,3,44,66,88,34,3,33,42};
		
		Heap h=new Heap();
		h.heapSort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	
	public void heapSort(int[] arr) {
		for(int length=arr.length;length>0;length--) {
			adjustHeap(arr,0,length);
			//swap
			swap(arr, 0, length-1);
		}
		
	}
	public void swap(int[] arr,int a,int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	public void adjustHeap(int[] arr,int start,int length) {
		//大根堆
		//从最底下找到从第一个含有子节点（叶子节点）的节点开始
		//当前节点与子节点进行比较，三个（也可能是两个）中的最大值作为当前节点
		//依次往上进行该操作
		//直到根节点 也就是数组的第一个位置
				
		for(int i=length/2-1;i>=0;i--) {
			int cur=arr[i];
			
			int left=2*i+1;
			int right=2*i+2;
			int site=left;
			if((right<length)&&(arr[left]<arr[right])) {
				site=right;
			}
			
			if(cur<arr[site]) {
				arr[i]=arr[site];
				arr[site]=cur;
			}			
		}		
	}
		
}
