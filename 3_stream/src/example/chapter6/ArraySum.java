package example.chapter6;

import base.Album;
import base.SampleData;
import base.Track;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

/**
 * @author casin
 * @create 2018-07-16 20:36
 **/
@BenchmarkMode(Mode.AverageTime)//基准测试类型
@State(Scope.Benchmark) //该状态为每线程独享
public class ArraySum {

    public static void main(String[] ignore) throws IOException,RunnerException {
        final String[] args={
                ".*ArraySum.*",
                "-wi",
                "5",
                "-i",
                "5"
        };
        Main.main(args);
    }

    public List<Album> albums;

    /**
     * 初始化数据
     */
    @Setup//标记状态类的方法
    public void initAlbums(){
        int n = Integer.getInteger("arraysum.size",100);
        albums=IntStream.range(0,n)
                .mapToObj(i->SampleData.aLoveSupreme.copy())
                .collect(Collectors.toList());
    }

    /**
     * 串行化计算专辑曲目长度
     * @return
     */
    @GenerateMicroBenchmark  //类似于junit中的test
    public int serialArraySum(){
        return albums.stream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }

    /**
     * 并行化计算专辑曲目长度
     * @return
     */
    @GenerateMicroBenchmark
    public int parallelArraySum(){
        return albums.parallelStream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }


}
