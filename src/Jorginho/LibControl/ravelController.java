package Jorginho.LibControl;

public class ravelController {
    static {
        System.loadLibrary("ravelController");
    }

    public native static int connectRavel(String test);

    public native static int ravelSimulate(String src, String lib, int[] externRegs, byte[] externMem, int memSize, String stdout, boolean display);
}
