package debug_exercises.chapter04;

public class fixDebugFour3
{
    public static void main(String args[])
    {
        //int width = 12,
        //        length = 10,
        //        height = 8;
        int width = 12, length = 10, height = 8 ;
        fixDebugBox box1 = new fixDebugBox();
        //fixdebugBox box2 = new fixDebugBox(width, length, height);
        fixDebugBox box2 = new fixDebugBox(width, length, height);
        System.out.println("The dimensions of the first box are");
        //box1.showData;
        box1.showData();
        System.out.print("  The volume of the first box is ");
        showVolume(box1);
        //System.out.println(The dimensions of the second box are");
        System.out.println("The dimensions of the second box are ");
                box2.showData();
        System.out.print("  The volume of the second box is ");
        showVolume(box2);
    }
    public static void showVolume(fixDebugBox aBox)
    {
        //double vol = aBox.getVolume();
        double volume = aBox.getVolume();
        System.out.println(volume);

    }
}