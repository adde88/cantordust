import java.awt.Color;
public class Color32bpp extends ColorSource { /* see binvis - ColorHilbert class */
    Hilbert map;
    double step;
    public Color32bpp(Cantordust cantordust, byte[] data) {
        super(cantordust, data);
        this.type = "32bpp";
    }

    @Override
    public Rgb getPoint(int x) {
        if(x>=data.length-3){x = data.length-4;}
        int pixel = ((data[x+3] << 24) + (data[x+2] << 16) + (data[x+1] << 8) + data[x]) & 0xFFFFFFFF;
        Color r = new Color(pixel, true);
        Rgb rgb = new Rgb(r.getRed(), r.getGreen(), r.getBlue());
        return rgb;
    }
}