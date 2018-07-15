package base;

/**
 * 类说明： 专辑中的一只曲目
 *
 * @author: Casin
 * @Create: 2018-05-13 13:19
 * @HOME: https://qincasin.github.io/
 */

public final class Track {
    private final String name;
    private final int length;


    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName(){
        return name;
    }

    public int getLength(){
        return length;
    }

    public Track copy(){
        return new Track(name,length);
    }
}
