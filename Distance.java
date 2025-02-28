// Задание 1.3

public class Distance implements Comparable<Distance> {
    private int Dis;

    public int getDis() {
        return Dis;
    }

    public void setDis(int Dis) {
        this.Dis = Dis;
    }

    public Distance(int dis) {
        Dis = dis;
    }

    @Override
    public int Compare(Distance n) {
        return Integer.compare(this.Dis, n.getDis());
    }

    @Override
    public String toString() {
        return String.valueOf(this.Dis);
    }
}
