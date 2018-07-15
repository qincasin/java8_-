package example.chapter3;

import base.Album;
import base.SampleData;
import base.Track;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 类说明： 重构遗留代码
 * 找出专辑中曲目的长度大于一分钟的歌曲名称
 *
 * @author: Casin
 * @Create: 2018-06-27 9:23
 * @HOME: https://qincasin.github.io/
 */

public class ReconsitutionTest {
    @Test
    public void test3_190(){
        System.out.println(SampleData.ALBUMS);
        /*测试遗留代码*/
        System.out.println(findLongTracks(SampleData.ALBUMS));

        /*测试重构第一步代码*/
        System.out.println(findLongTracks1(SampleData.ALBUMS));

        /*测试重构第二步代码*/
        System.out.println(findLongTracks2(SampleData.ALBUMS));

        /*测试重构第三步代码*/
        System.out.println(findLongTracks3(SampleData.ALBUMS));

        /*测试重构第四步代码*/
        System.out.println(findLongTracks4(SampleData.ALBUMS));
    }

    /**
     * 遗留代码 找出长度大于1分钟的曲目
     * @param albums
     * @return
     */
    public Set<String> findLongTracks(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        for(Album album:albums){
            for(Track track:album.getTrackList()){
                if(track.getLength()>60){
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }

    /**
     * 第一步
     * 将循环外面的和里面的for循环使用forEach替代
     * @param albums
     * @return
     */
    public Set<String> findLongTracks1(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album -> {
                    album.getTracks()
                            .forEach(track -> {
                                if(track.getLength()>60){
                                    String name = track.getName();
                                    trackNames.add(name);
                                }
                            });
                });
        return trackNames;
    }

    /**
     * 第二步
     * 最内层forEach有三个功能
     * 1.找出长度大于1分钟；       filter替换
     * 2.得到符合条件的曲目名称；   map替换
     * 3.将曲目名称加入到集合Set；  forEach加入到集合
     * @param albums
     * @return
     */
    public Set<String> findLongTracks2(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(album -> {
                    album.getTracks()
                            .filter(track -> track.getLength()>60)
                            .map(track -> track.getName())
                            .forEach(name->trackNames.add(name));
                });
        return trackNames;
    }

    /**
     * 第三步
     * 替换外层forEach
     * 使用flatMap或者map替换外层forEach,把多个stream合成为一个stream并返回
     *
     * @param albums
     * @return
     */
    public Set<String> findLongTracks3(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .flatMap(album -> album.getTracks())
                .filter(track -> track.getLength()>60)
                .map(track -> track.getName())
                .forEach(name->trackNames.add(name));

        return trackNames;
    }

    /**
     * 第四步
     * 消除set集合，删除forEach，替换为collect
     * 使用collection中的toSet集合自动转换为一个列表
     * @param albums
     * @return
     */
    public Set<String> findLongTracks4(List<Album> albums){
        return albums.stream()
                .flatMap(album -> album.getTracks())
                .filter(track -> track.getLength()>60)
                .map(track -> track.getName())
                .collect(Collectors.toSet());
    }

}
