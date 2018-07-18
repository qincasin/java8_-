package example.chapter5;

import base.Artist;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类说明： 字符串
 *
 * @author: Casin
 * @Create: 2018-07-15 16:31
 * @HOME: https://qincasin.github.io/
 */

public class StringExamples {
    /**
     *
     * 使用流和收集器格式化艺术家名字
     * @param artists
     * @return
     */
    public static String formatArtists(List<Artist> artists){
        return artists.stream()
                .map(Artist::getName)
                .collect(Collectors.joining(", ","[","]"));
    }

    /**
     * 使用原始的for循环来
     * @param artists
     * @return
     */
    public static String formatArtistsForLoop(List<Artist> artists){
        StringBuilder builder = new StringBuilder("[");
        for (Artist artist:artists){
            if(builder.length()>1){
                builder.append(", ");
            }
            String name = artist.getName();
            builder.append(name);
        }
        builder.append("]");
        String result = builder.toString();
        return result;
    }

    /**
     * 使用forEach和StringBuilder格式化艺术家名字
     * @param artists
     * @return
     */
    public static String formatArtistsRefactor1(List<Artist> artists){
        StringBuilder sb = new StringBuilder("[");
        artists.stream()
                .map(Artist::getName)
                .forEach(name->{
                    if(name.length()>1){
                        sb.append(", ");
                    }
                    sb.append(name);
                });
        sb.append("]");
        return sb.toString();
    }

    /**
     * 使用reduce和StringBuilder格式化艺术家名字
     * @param artists
     * @return
     */
    public static String formatArtistsRefactor2(List<Artist> artists){
        StringBuilder reduecd =
                artists.stream()
//                        .parallel()
                .map(Artist::getName)
                        //reduce操作生成艺术家姓名列表，其中间使用，来分割
                        //reduce 三个参数中含义
                        //1.创建一个对象(也就是reduce的初始状态) 2.调用函数实现的功能 (也就是accumulate) 3.并发时合并每个线程执行的结果
                        //function for combining two values, which must be compatible with the accumulator function
                .reduce(new StringBuilder(),(builder,name)->{
                    if(builder.length()>0){
                        builder.append(", ");
                    }
                    builder.append(name);
                    return builder;
                    //function for incorporating an additional element into a result
                },(left,right)->left.append(right));
        reduecd.insert(0,"[");
        reduecd.append("]");
        return reduecd.toString();
    }

    /**
     * 使用reduce和StringCombiner类格式化艺术家名字
     * @param artists
     * @return
     */
    public static String formatArtistsRefactor3(List<Artist> artists){
        StringCombiner combined =
                artists.stream()
                .map(Artist::getName)
                .reduce(new StringCombiner(", ","[","]"),
                        StringCombiner::add,
                        StringCombiner::merge);
        return combined.toString();
    }

    /**
     * 使用reduce操作，将工作代理为StringCombiner对象
     * @param artists
     * @return
     */
    public static String formatArtistsRefactor4(List<Artist> artists){
        return artists.stream()
                .map(Artist::getName)
                .reduce(new StringCombiner(", ","[","]"),
                        //accumulate
                        StringCombiner::add,
                        //combiner
                        StringCombiner::merge)
                .toString();
    }

    /**
     * 使用定制的收集器StringCollector收集字符串
     * @param artists
     * @return
     */
    public static String formatArtistsRefactor5(List<Artist> artists){
        return artists.stream()
                .map(Artist::getName)
                .collect(new StringCollector(", ","[","]"));
    }



    @Test
    public void testReduce(){
        ArrayList<Integer> accResult_ = Stream.of(1, 2, 3, 4)
                .parallel()
                .reduce(new ArrayList<Integer>(),
                        /** @param <T> the type of the first argument to the function
                         * @param <U> the type of the second argument to the function
                         * @param <R> the type of the result of the function*/
                        new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer item) {

                                acc.add(item);
                                System.out.println("item: " + item);
                                System.out.println("acc+ : " + acc);
                                System.out.println("BiFunction");
                                return acc;
                            }
                            /**
                            * @param <T> the type of the operands and result of the operator  //操作数的类型和运算符的结果
                             * */
                        }, new BinaryOperator<ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> item) {
                                System.out.println("BinaryOperator");
                                acc.addAll(item);
                                System.out.println("item: " + item);
                                System.out.println("acc+ : " + acc);
                                System.out.println("--------");
                                return acc;
                            }
                        });
        System.out.println("accResult_: " + accResult_);

    }








}
