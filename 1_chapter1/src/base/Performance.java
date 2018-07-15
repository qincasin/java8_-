package base;

import java.util.stream.Stream;

/**
 * 类说明：
 *
 * @author: Casin
 * @Create: 2018-05-13 13:22
 * @HOME: https://qincasin.github.io/
 */

public interface Performance {
    public String getName();
    public Stream<Artist> getMusicians();
    public default Stream<Artist> getAllMusicians(){
        return getMusicians().flatMap(artist -> {
            return Stream.concat(Stream.of(artist),artist.getMembers());
        });
    }

}
