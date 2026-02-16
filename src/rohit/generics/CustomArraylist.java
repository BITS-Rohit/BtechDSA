package rohit.generics;

import java.util.Arrays;

public class CustomArraylist {
    private int[] data;
    private final int DEFAULT_SIZE= 2;
    private int size=0;
    private boolean isFull(){
        return size==data.length;
    }

    CustomArraylist(){
        this.data=new int[DEFAULT_SIZE];
    }
    public void add(int value){
        if (isFull()){
            resize();
        }
        data[size++]=value;
    }

    public int[] resize() {
        int[] temp =new int[data.length*2];
        System.arraycopy(data, 0, temp, 0, data.length);
        return data=temp;
//        System.out.println(Arrays.toString(data));
    }
    public int remove(){
        return data[--size];
    }
    public int get_data_Index(int index){
        return data[index];
    }


    public static void main(String[] args) {
        CustomArraylist c = new CustomArraylist();

        c.add(23);
        c.add(23);
        c.add(23);
        c.add(23);

        System.out.println(Arrays.toString(c.resize()));

    }
}
