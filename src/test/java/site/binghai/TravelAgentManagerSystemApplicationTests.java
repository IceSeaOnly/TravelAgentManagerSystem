package site.binghai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TravelAgentManagerSystemApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void s(){
		String url = "http://www.mafengwo.cn/poi/";
		for (int i = 3474; i < 5000; i++) {
			System.out.println(url+i+".html");
		}
	}
}
