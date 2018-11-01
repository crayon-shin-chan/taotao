package czy.taotao.eurekacenter.codec;

import com.netflix.discovery.converters.wrappers.CodecWrappers;

public class CodecTest {

    public static void main(String[] args){
        String name = CodecWrappers.JacksonJson.class.getSimpleName();
        System.out.println(name);
    }


}
