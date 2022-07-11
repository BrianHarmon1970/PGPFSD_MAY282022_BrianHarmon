package debug_exercises.chapter04;

public class fixDebugBox {

    private int width;
    private int length;
    private int height;
    public fixDebugBox()
    {
        length = 1;
        width = 1;
        height = 1;
    }
    //public fixDebugBox(int width, int length, height)
    public fixDebugBox(int width, int length, int height)
    {
        //width = width;
        this.width = width;
        //length = length;
        this.length = length;
        //height = height;
        this.height = height;
    }
    public void showData()
    {
        //System.out.println("Width:   + width + "  Length: " +
        System.out.println("Width: "   + width + "  Length: " +
        length + "  Height: "+ height);
    }
    public double getVolume()
    {
        //double vol = length + wdth + height;
        return length * width * height;
    }
}
