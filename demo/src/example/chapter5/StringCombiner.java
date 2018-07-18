package example.chapter5;

/**
 * 类说明： 创建一个代理对象进行分装方法
 *
 * @author: Casin
 * @Create: 2018-07-15 18:29
 * @HOME: https://qincasin.github.io/
 */

public class StringCombiner {
    private final String prefix;
    private final String suffix;
    /**
     * 分隔符
     */
    private final String delim;
    private final StringBuilder builder;

    public StringCombiner(String delim, String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.delim = delim;
        this.builder=new StringBuilder();
    }

    /**
     * 返回连接新元素的结果
     * @param word
     * @return
     */
    public StringCombiner add(String word){
        //添加分解符
        if(!this.areAtStart()){
            this.builder.append(delim);
        }
        //否则添加传入的参数
        this.builder.append(word);
        return this;
    }

    /**
     * 连接两个StringBuilder对象
     * @param other
     * @return
     */
    public StringCombiner merge(StringCombiner other){
        if(!other.equals(this)){
            if(!other.areAtStart()&&!this.areAtStart()){
                other.builder.insert(0,this.delim);
            }
            this.builder.append(other.builder);
        }
        return this;
    }

    @Override
    public String toString() {
        return prefix+builder.toString()+suffix;
    }

    public boolean areAtStart(){
        return builder.length()==0;
    }

}
