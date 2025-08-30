package btech.PRACTICE.StackNQueue;

public class DynamicStack extends CustomStack{
    int[] Array = new int[arr.length*2];
    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    boolean push(int item) {
        if ( super.isFull()){
            System.arraycopy(arr, 0, Array, 0, arr.length);
        }
        return super.push(item);
    }
    public static void main(String[] args) throws CustomException {
        CustomStack DS = new DynamicStack();
        DS.push(345);
        DS.push(4);
        DS.push(5);
        DS.push(76);
        DS.push(43);

        System.out.println(DS.pop());
        System.out.println(DS.pop());
        System.out.println(DS.pop());
        System.out.println(DS.pop());
        System.out.println(DS.pop());
        System.out.println(DS.pop());
        System.out.println(DS.pop());
        System.out.println(DS.pop());
    }
}
