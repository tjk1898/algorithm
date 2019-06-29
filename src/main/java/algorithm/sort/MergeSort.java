package algorithm.sort;

/**
 *
 * 归并排序
 * @author jinkun.tian
 * @date 2019/6/29
 */
public class MergeSort {

    /**
     * 排序函数
     * @param array  待排数组
     */
    public static void mergeSort(int[] array){
        mergeSortInternally(array,0,array.length-1);
    }

    /**
     * 排序实现
     * @param array  待排数组
     * @param start 起始角标
     * @param end   终值角标
     */
    private static void mergeSortInternally(int[] array , int start,int end ){
        // 满足条件返回
        if(start>=end){
            return;
        }

        // 分合并字段
        int middle = start + (end-start)/2;

        // 拆分
        mergeSortInternally(array,start,middle);
        mergeSortInternally(array,middle+1,end);

        // 合并
        merge(array,start,middle,end);

    }

    /**
     * 合并函数
     * @param array 待合并数组
     * @param start 起始位置
     * @param middle    中间位置
     * @param end       结束位置
     */
    private static void merge(int[] array,int start,int middle,int end){
        // 初始化参数
        int partAStart=start;
        int partBStart=middle+1;
        int[] mergeArray=new int[end-start+1];
        int mergeArrayMark=0;

        // 合并
        while(partAStart<=middle && partBStart<=end){
            if(array[partAStart]<=array[partBStart]){
                mergeArray[mergeArrayMark]=array[partAStart];
                partAStart++;
            }else{
                mergeArray[mergeArrayMark]=array[partBStart];
                partBStart++;
            }
            mergeArrayMark++;
        }

        // 补全
        int remainStart;
        int remainEnd;
        if(partAStart<=middle){
            remainStart=partAStart;
            remainEnd=middle;
        }else{
            remainStart=partBStart;
            remainEnd=end;
        }

        while(remainStart<=remainEnd){
            mergeArray[mergeArrayMark]=array[remainStart];
            remainStart++;
            mergeArrayMark++;
        }

        // 拷贝回原数组
        System.arraycopy(mergeArray,0,array,start,mergeArray.length);
    }

    public static void main(String[] args){
        int[] array={1,4,3,5,9,5,3,3,1};

        MergeSort.mergeSort(array);
        for (int i:array
             ) {
            System.out.print(i+",");
        }

    }

}
