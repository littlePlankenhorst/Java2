public class Eskuvo {
    private String[] par= new String[2];
    private int asztal;
    private int kapacitas;

    public Eskuvo(String[] par, int asztal, int kapacitas) {
        this.par = par;
        this.asztal = asztal;
        this.kapacitas = kapacitas;
    }

    public String getPar() {
        return par[0] + " es " + par[1];
    }

    public void setPar(String[] par) {
        this.par = par;
    }

    public int getAsztal() {
        return asztal;
    }

    public void setAsztal(int asztal) {
        this.asztal = asztal;
    }

    public int getKapacitas() {
        return kapacitas;
    }

    public void setKapacitas(int kapacitas) {
        this.kapacitas = kapacitas;
    }
}
