package hello.typeconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TypeconverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TypeconverterApplication.class, args);
	}

}

/**
 * 컨버터를 사용하든, 포맷터를 사용하든 등록 방법은 다르지만, 사용할 때는 컨버전 서비스를 통해서 일관성 있게 사용할 수 있다.
 *
 * 주의 !
 * 메시지 컨버터(HttpMessageConverter)에는 컨버전 서비스가 적용되지 않는다.
 * 특히 객체를 JSON으로 변환할 때 메시지 컨버터를 사용하면서 이 부분을 많이 오해하는데, HttpMessageConverter의 역할은
 * HTTP 메시지 바디의 내용을 객체로 변환하거나 객체를 HTTP 메시디 바디에 입력하는 것이다. 예를 들어서 JSON으로 객체로 변환하는 메시지 컨버터는
 * 내부에서 Jackson 같은 라이브러리를 사용한다. 객체를 JSON으로 변환한다면 그 결과는 이 라이브러리에 달린 것이다.
 * 따라서 JSON 결과로 만들어지는 숫자나 날짜 포맷을 변경하고 싶으면 해당 라이브러리가 제공하는 설정을 통해서 포맷을 지정해야 한다.
 * 결과적으로 이것은 컨버전 서비스와 전혀 관계가 없다.
 *
 * 컨버전 서비스는 @RequestParam, @ModelAttribute, @PathVariable, 뷰 템플릿 등에서 사용할 수 있다.
 */