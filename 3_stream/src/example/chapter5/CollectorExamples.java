package example.chapter5;

import base.Album;
import base.Artist;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类说明： 使用收集器
 *
 * @author: Casin
 * @Create: 2018-07-15 15:50
 * @HOME: https://qincasin.github.io/
 */

public class CollectorExamples {

    public void toCollectionTreeset(){
        Stream<Integer> stream = Stream.of(1,2,3);
        stream.collect(Collectors.toCollection(TreeSet::new));
    }

    /**
     * 转换成值
     * 找出成员最多的乐队   maxBy minBy
     * @param artistStream
     * @return
     */
    public Optional<Artist> biggestGroup(Stream<Artist> artistStream){
        Function<Artist,Long> getCount = artist -> artist.getMembers().count();
        return artistStream.collect(Collectors.maxBy(Comparator.comparing(getCount)));
    }

    /**
     * 找出一组专辑上的曲目的平均数
     * @param albums
     * @return
     */
    public double averageNumberOfTracks(List<Album> albums){
        return albums.stream()
                .collect(Collectors.averagingInt(album->album.getTrackList().size()));
    }

    /*数据分块 接收一个流，分成两部分 true 和false*/
    /**
     * 数据分块
     * 将艺术家组成的流分成乐队和独唱歌手两部分
     * @param artistStream
     * @return
     */
    public Map<Boolean , List<Artist>> bandsAndSolo(Stream<Artist> artistStream){
        return artistStream.collect(Collectors.partitioningBy(artist->artist.isSolo()));
    }

    /**
     * 使用方法引用
     * @param artistStream
     * @return
     */
    public Map<Boolean ,List<Artist>> bandsAndSoleRef(Stream<Artist> artistStream){
        return artistStream.collect(Collectors.partitioningBy(Artist::isSolo));
    }

    /*数据分组  传入一个收集器 按照分类函数，用来对数据进行分组 */

    /**
     * 按照主唱对专辑分组
     * @param albums
     * @return
     */
    public Map<Artist,List<Album>> albumsByArtist(Stream<Album> albums){
        return albums.collect(Collectors.groupingBy(album->album.getMainMusician()));
    }

    /*组合收集器*/
    /**
     * 计算每个艺术家专辑专辑数 简单方式
     */
    public Map<Artist,Integer> numberOfAlbumsDumb(Stream<Album> albums){

        //1.分组
        Map<Artist,List<Album>> albumsByArtist
                =albums.collect(Collectors.groupingBy(album->album.getMainMusician()));
        Map<Artist,Integer> numberOfAlbums = new HashMap<>();

        //2.计数
        for (Map.Entry<Artist,List<Album>> entry : albumsByArtist.entrySet()){
            numberOfAlbums.put(entry.getKey(),entry.getValue().size());
        }
        return numberOfAlbums;
    }

    /**
     * 使用收集器来计算每个艺术家的专辑数
     * @param albums
     * @return
     */
    public Map<Artist,Long> numberOfAlbums(Stream<Album> albums){
        //内部分组和计数同时进行
        return albums.collect(Collectors.groupingBy(album->album.getMainMusician(),
                Collectors.counting()));
    }

    /**
     * 求每个艺术家的专辑名
     * @param albums
     * @return
     */
    public Map<Artist,List<String>> nameOfAlbumsDumb(Stream<Album> albums){
        //1.分组(分块)
        Map<Artist,List<Album>> albumsByArtist =
                albums.collect(Collectors.groupingBy(Album::getMainMusician));
        Map<Artist,List<String>> nameOfAlbums = new HashMap<>();
        //2.map
        for (Map.Entry<Artist,List<Album>> entry : albumsByArtist.entrySet()){
            nameOfAlbums.put(entry.getKey(),entry.getValue().stream().map(Album::getName).collect(Collectors.toList()));
        }
        return nameOfAlbums;
    }

    /**
     * 使用收集器求每个艺术家的专辑名
     * 收集器是生成最终结果的，下游收集器生成部分结果的，主收集器会用到下游收集器
     * @param albums
     * @return
     */
    public Map<Artist,List<String>> nameOfAlbums(Stream<Album> albums){
        //1.分组
        //2.mapping(与map类似)
        return albums.collect(Collectors.groupingBy(Album::getMainMusician,
                Collectors.mapping(Album::getName,Collectors.toList())));
    }





}
