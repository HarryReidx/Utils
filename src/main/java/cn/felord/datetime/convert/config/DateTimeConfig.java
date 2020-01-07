package cn.felord.datetime.convert.config;

import com.fasterxml.jackson.datatype.jsr310.deser.JSR310DateTimeDeserializerBase;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
/**
 * 全局配置
 *
 * 可与注解进行相互测试 加深理解.
 *
 * @author Dax
 * @since 13 :52  2019/9/17
 */
@Configuration
public class DateTimeConfig {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    /**
     * 自定义转换器可被 {@link Formatter} 代替.
     *
     * @return the converter
     */
    @Bean
    public Converter<String, LocalDateTime> localDateConverter() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String source) {
                return LocalDateTime.parse(source, FORMATTER);
            }
        };
    }

    /**
     * 可代替 {@link Converter}.
     *
     * @return the formatter
     */
//     @Bean
    public Formatter<LocalDateTime> localDateFormatter() {
        return new Formatter<LocalDateTime>() {
            @Override
            public LocalDateTime parse(String text, Locale locale) throws ParseException {
                return LocalDateTime.parse(text, FORMATTER);
            }

            @Override
            public String print(LocalDateTime object, Locale locale) {
                return object.format(FORMATTER);
            }
        };
    }


    /**
     * 处理jackson 序列化/反序列化.
     *
     * @return the jackson 2 object mapper builder customizer
     * @see JSR310DateTimeDeserializerBase
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {

        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder
                .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(FORMATTER))
                .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(FORMATTER));
    }

}
