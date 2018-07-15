package base;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类说明： 创作音乐的个人或者团队
 *
 * @author: Casin
 * @Create: 2018-05-13 13:06
 * @HOME: https://qincasin.github.io/
 */

public final class Artist {
    /**
     * 艺术家名字
     */
    private String name;
    /**
     * 乐队成员(例如“约翰。列侬”)，该字段可以为空
     */
    private List<Artist> members;
    /**
     * 来自哪里
     */
    private String nationality;

    /**
     *
     * @param name
     * @param nationality
     */
    public Artist(String name, String nationality) {
        this(name, Collections.emptyList(),nationality);
    }

    /**
     *
     * @param name
     * @param members
     * @param nationality
     */
    public Artist(String name, List<Artist> members, String nationality) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(nationality);
        this.name = name;
        this.members = new ArrayList<>(members);
        this.nationality = nationality;
    }


    public String getName(){
        return name;
    }

    public Stream<Artist> getMembers(){
        return members.stream();
    }

    public String getNationality(){
        return nationality;
    }

    public boolean isSolo(){
        return members.isEmpty();
    }

    public boolean isFrom(String nationality){
        return this.nationality.equals(nationality);
    }

    @Override
    public String toString(){
        return getName();
    }


//    @Override
//    public String toString() {
//        return "Artist{" +
//                "name='" + name + '\'' +
//                ", members=" + members +
//                ", nationality='" + nationality + '\'' +
//                '}';
//    }

    public Artist copy(){
        List<Artist> members =getMembers().map(Artist::copy).collect(Collectors.toList());
        return new Artist(name,members,nationality);
    }


}